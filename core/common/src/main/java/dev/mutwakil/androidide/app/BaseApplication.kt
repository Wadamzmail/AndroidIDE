/*
 *  This file is part of AndroidIDE.
 *
 *  AndroidIDE is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  AndroidIDE is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *   along with AndroidIDE.  If not, see <https://www.gnu.org/licenses/>.
 */
package dev.mutwakil.androidide.app

import android.app.Application
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import com.blankj.utilcode.util.ThrowableUtils
import dev.mutwakil.androidide.buildinfo.BuildInfo
import dev.mutwakil.androidide.common.R
import dev.mutwakil.androidide.managers.PreferenceManager
import dev.mutwakil.androidide.managers.ToolsManager
import dev.mutwakil.androidide.utils.Environment
import dev.mutwakil.androidide.utils.FileUtil
import dev.mutwakil.androidide.utils.JavaCharacter
import dev.mutwakil.androidide.utils.VMUtils
import dev.mutwakil.androidide.utils.flashError
import java.io.File

open class BaseApplication : Application() {
    private var _prefManager: PreferenceManager? = null

    val prefManager : PreferenceManager
        get() = checkNotNull(_prefManager){
            "PreferencesManager is not initialized"
        }

    init {
        _baseInstance = this
    }

    override fun onCreate() {
        Environment.init(this)
        super.onCreate()

        _prefManager = PreferenceManager(this)
        JavaCharacter.initMap()

        if (!VMUtils.isJvm()) {
            ToolsManager.init(this, null)
        }
    }

    fun writeException(th: Throwable?) {
        FileUtil.writeFile(
            File(FileUtil.getExternalStorageDir(), "idelog.txt").absolutePath,
            ThrowableUtils.getFullStackTrace(th)
        )
    }

    val projectsDir: File?
        get() = Environment.PROJECTS_DIR

    fun openTelegramGroup() {
        openTelegram(TELEGRAM_GROUP_URL)
    }

    fun openTelegramChannel() {
        openTelegram(TELEGRAM_CHANNEL_URL)
    }

    fun openGitHub() {
        openUrl(BuildInfo.REPO_URL)
    }

    fun openWebsite() {
        openUrl(BuildInfo.PROJECT_SITE)
    }

    fun openDonationsPage() {
        openUrl(SPONSOR_URL)
    }

    fun openDocs() {
        openUrl(DOCS_URL)
    }

    fun emailUs() {
        openUrl("mailto:" + EMAIL)
    }

    fun openTelegram(url: String?) {
        openUrl(url, "org.telegram.messenger")
    }

    @JvmOverloads
    fun openUrl(url: String?, pkg: String? = null) {
        try {
            val open = Intent()
            open.setAction(Intent.ACTION_VIEW)
            open.setData(Uri.parse(url))
            open.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            if (pkg != null) {
                open.setPackage(pkg)
            }
            startActivity(open)
        } catch (th: Throwable) {
            if (pkg != null) {
                openUrl(url)
            } else if (th is ActivityNotFoundException) {
                flashError(R.string.msg_app_unavailable_for_intent)
            } else {
                flashError(th.message)
            }
        }
    }

    companion object {
        const val NOTIFICATION_GRADLE_BUILD_SERVICE: String = "17571"
        const val TELEGRAM_GROUP_URL: String = "https://t.me/androidide_discussions"
        const val TELEGRAM_CHANNEL_URL: String = "https://t.me/AndroidIDEOfficial"
        val SPONSOR_URL: String = BuildInfo.PROJECT_SITE + "/donate"
        const val DOCS_URL: String = "https://docs.androidide.com"
        val CONTRIBUTOR_GUIDE_URL: String = BuildInfo.REPO_URL + "/blob/dev/CONTRIBUTING.md"
        const val EMAIL: String = "contact@androidide.com"
        private var _baseInstance : BaseApplication? = null
        @JvmStatic
        val baseInstance: BaseApplication
            get() = checkNotNull(_baseInstance){
                "baseInstance is not set"
            }
    }
}