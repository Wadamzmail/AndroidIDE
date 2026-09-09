/*
 * This file is part of AndroidIDE.
 *
 * AndroidIDE is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * AndroidIDE is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with AndroidIDE.  If not, see <https://www.gnu.org/licenses/>.
 *
 */

package dev.mutwakil.androidide.app

import android.content.Intent
import android.net.Uri
import android.os.StrictMode
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat
import androidx.lifecycle.Observer
import androidx.work.Constraints
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.NetworkType
import androidx.work.Operation
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.blankj.utilcode.util.ThrowableUtils.getFullStackTrace
import com.google.android.material.color.DynamicColors
import com.itsaky.androidide.treesitter.TreeSitter
import com.termux.app.TermuxApplication
import com.termux.shared.reflection.ReflectionUtils
import dev.mutwakil.androidide.BuildConfig
import dev.mutwakil.androidide.activities.CrashHandlerActivity
import dev.mutwakil.androidide.activities.editor.IDELogcatReader
import dev.mutwakil.androidide.buildinfo.BuildInfo
import dev.mutwakil.androidide.di.coreModule
import dev.mutwakil.androidide.editor.schemes.IDEColorSchemeProvider
import dev.mutwakil.androidide.eventbus.events.preferences.PreferenceChangeEvent
import dev.mutwakil.androidide.events.AppEventsIndex
import dev.mutwakil.androidide.events.EditorEventsIndex
import dev.mutwakil.androidide.events.LspApiEventsIndex
import dev.mutwakil.androidide.events.LspJavaEventsIndex
import dev.mutwakil.androidide.preferences.internal.DevOpsPreferences
import dev.mutwakil.androidide.preferences.internal.GeneralPreferences
import dev.mutwakil.androidide.preferences.internal.StatPreferences
import dev.mutwakil.androidide.resources.localization.LocaleProvider
import dev.mutwakil.androidide.stats.AndroidIDEStats
import dev.mutwakil.androidide.stats.StatUploadWorker
import dev.mutwakil.androidide.syntax.colorschemes.SchemeAndroidIDE
import dev.mutwakil.androidide.ui.themes.IDETheme
import dev.mutwakil.androidide.ui.themes.IThemeManager
import dev.mutwakil.androidide.utils.RecyclableObjectPool
import dev.mutwakil.androidide.utils.VMUtils
import dev.mutwakil.androidide.utils.flashError
import io.github.rosemoe.sora.widget.schemes.EditorColorScheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.plus
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext
import org.koin.core.context.startKoin
import org.slf4j.LoggerFactory
import java.lang.Thread.UncaughtExceptionHandler
import java.time.Duration
import kotlin.system.exitProcess

class IDEApplication : TermuxApplication() {

  val coroutineScope = MainScope() + CoroutineName("ApplicationScope")

  private var uncaughtExceptionHandler: UncaughtExceptionHandler? = null
  private var ideLogcatReader: IDELogcatReader? = null

  init {
    if (!VMUtils.isJvm()) {
      TreeSitter.loadLibrary()
    }

    RecyclableObjectPool.DEBUG = BuildConfig.DEBUG
  }

  @OptIn(DelicateCoroutinesApi::class)
  override fun onCreate() {
    instance = this
    uncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler()
    Thread.setDefaultUncaughtExceptionHandler { thread, th -> handleCrash(thread, th) }

    super.onCreate()
    
    ensureKoinStarted()

//    SentryAndroid.init(this) { options: SentryAndroidOptions ->
//      // Reduce replay quality to LOW to prevent OOM
//      // This reduces screenshot compression to 10 and bitrate to 50kbps
//      // (defaults to MEDIUM quality)
//      options.sessionReplay.quality = SentryReplayOptions.SentryReplayQuality.LOW
//      options.environment = if (BuildConfig.DEBUG) "development" else "production"
//    }

    if (BuildConfig.DEBUG) {
      StrictMode.setVmPolicy(
        StrictMode.VmPolicy.Builder(StrictMode.getVmPolicy()).penaltyLog().detectAll().build()
      )
      if (DevOpsPreferences.dumpLogs) {
        startLogcatReader()
      }
    }

    EventBus.builder()
      .addIndex(AppEventsIndex())
      .addIndex(EditorEventsIndex())
      .addIndex(LspApiEventsIndex())
      .addIndex(LspJavaEventsIndex())
      .installDefaultEventBus(true)

    EventBus.getDefault().register(this)

    CoroutineScope(Dispatchers.Main).launch {
      withContext(Dispatchers.Main) {
        AppCompatDelegate.setDefaultNightMode(GeneralPreferences.uiMode)

        if (IThemeManager.getInstance().getCurrentTheme() == IDETheme.MATERIAL_YOU) {
          DynamicColors.applyToActivitiesIfAvailable(instance)
        }
      }
    }

    EditorColorScheme.setDefault(SchemeAndroidIDE.newInstance(null))

    ReflectionUtils.bypassHiddenAPIReflectionRestrictions()
    GlobalScope.launch {
      IDEColorSchemeProvider.init()
    }
  }
  
  private fun ensureKoinStarted() {
		runCatching { GlobalContext.get() }.getOrNull()?.let { return }
		startKoin {
			androidContext(this@IDEApplication)
			modules(coreModule)
		}
  }

  fun showChangelog() {
    val intent = Intent(Intent.ACTION_VIEW)
    var version = BuildInfo.VERSION_NAME_SIMPLE
    if (!version.startsWith('v')) {
      version = "v${version}"
    }
    intent.data = Uri.parse("${BuildInfo.REPO_URL}/releases/tag/${version}")
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    try {
      startActivity(intent)
    } catch (th: Throwable) {
      log.error("Unable to start activity to show changelog", th)
      flashError("Unable to start activity")
    }
  }

  fun reportStatsIfNecessary() {

    if (!StatPreferences.statOptIn) {
      log.info("Stat collection is disabled.")
      return
    }

    val constraints = Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()
    val request = PeriodicWorkRequestBuilder<StatUploadWorker>(Duration.ofHours(24)).setInputData(
      AndroidIDEStats.statData.toInputData()
    ).setConstraints(constraints)
      .addTag(StatUploadWorker.WORKER_WORK_NAME).build()

    val workManager = WorkManager.getInstance(this)

    log.info("reportStatsIfNecessary: Enqueuing StatUploadWorker...")
    val operation = workManager.enqueueUniquePeriodicWork(
      StatUploadWorker.WORKER_WORK_NAME,
      ExistingPeriodicWorkPolicy.UPDATE, request
    )

    operation.state.observeForever(object : Observer<Operation.State> {
      override fun onChanged(value: Operation.State) {
        operation.state.removeObserver(this)
        log.debug("reportStatsIfNecessary: WorkManager enqueue result: {}", value)
      }
    })
  }

  @Subscribe(threadMode = ThreadMode.MAIN)
  fun onPrefChanged(event: PreferenceChangeEvent) {
    val enabled = event.value as? Boolean?
    if (event.key == StatPreferences.STAT_OPT_IN) {
      if (enabled == true) {
        reportStatsIfNecessary()
      } else {
        cancelStatUploadWorker()
      }
    } else if (event.key == DevOpsPreferences.KEY_DEVOPTS_DEBUGGING_DUMPLOGS) {
      if (enabled == true) {
        startLogcatReader()
      } else {
        stopLogcatReader()
      }
    } else if (event.key == GeneralPreferences.UI_MODE && GeneralPreferences.uiMode != AppCompatDelegate.getDefaultNightMode()) {
      AppCompatDelegate.setDefaultNightMode(GeneralPreferences.uiMode)
    } else if (event.key == GeneralPreferences.SELECTED_LOCALE) {

      // Use empty locale list if the locale has been reset to 'System Default'
      val selectedLocale = GeneralPreferences.selectedLocale
      val localeListCompat = selectedLocale?.let {
        LocaleListCompat.create(LocaleProvider.getLocale(selectedLocale))
      } ?: LocaleListCompat.getEmptyLocaleList()

      AppCompatDelegate.setApplicationLocales(localeListCompat)
    }
  }

  private fun handleCrash(thread: Thread, th: Throwable) {
    writeException(th)

    try {

      val intent = Intent()
      intent.action = CrashHandlerActivity.REPORT_ACTION
      intent.putExtra(CrashHandlerActivity.TRACE_KEY, getFullStackTrace(th))
      intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
      startActivity(intent)
      if (uncaughtExceptionHandler != null) {
        uncaughtExceptionHandler!!.uncaughtException(thread, th)
      }

      exitProcess(1)
    } catch (error: Throwable) {
      log.error("Unable to show crash handler activity", error)
    }
  }

  private fun cancelStatUploadWorker() {
    log.info("Opted-out of stat collection. Cancelling StatUploadWorker if enqueued...")
    val operation = WorkManager.getInstance(this)
      .cancelUniqueWork(StatUploadWorker.WORKER_WORK_NAME)
    operation.state.observeForever(object : Observer<Operation.State> {
      override fun onChanged(value: Operation.State) {
        operation.state.removeObserver(this)
        log.info("StatUploadWorker: Cancellation result state: {}", value)
      }
    })
  }

  private fun startLogcatReader() {
    if (ideLogcatReader != null) {
      // already started
      return
    }

    log.info("Starting logcat reader...")
    ideLogcatReader = IDELogcatReader().also { it.start() }
  }

  private fun stopLogcatReader() {
    log.info("Stopping logcat reader...")
    ideLogcatReader?.stop()
    ideLogcatReader = null
  }

  companion object {

    private val log = LoggerFactory.getLogger(IDEApplication::class.java)

    @JvmStatic
    lateinit var instance: IDEApplication
      private set
  }
}
