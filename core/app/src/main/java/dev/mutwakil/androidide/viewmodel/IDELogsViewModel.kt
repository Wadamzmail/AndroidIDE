package dev.mutwakil.androidide.viewmodel

import dev.mutwakil.androidide.app.BaseApplication
import dev.mutwakil.androidide.logging.provider.IdeGlobalLogBuffer
import dev.mutwakil.androidide.preferences.internal.DevOpsPreferences
import dev.mutwakil.androidide.utils.ILogger
import org.slf4j.event.Level

/**
 * Consumes IDE logs from [IdeGlobalLogBuffer]. The ViewModel (not the fragment) is the
 * consumer so that the appender's buffer replay happens exactly once per ViewModel lifetime --
 * registering on every fragment view recreation would re-submit the replayed lines into the
 * retained log history and duplicate them.
 *
 * @author Akash Yadav
 */
class IDELogsViewModel :
    LogViewModel(),
    IdeGlobalLogBuffer.Consumer {
    override val logLevel: Level
        get() = if (BaseApplication.baseInstance.prefManager.getBoolean(
                DevOpsPreferences.KEY_DEVOPTS_IDE_LOGS_DEBUGGING,
                false
            )
        ) Level.DEBUG else Level.INFO

    init {
        IdeGlobalLogBuffer.registerConsumer(this)
    }

    override fun consume(
        level: Level,
        message: String,
    ) = submit(level.toILoggerLevel(), message)

    override fun onCleared() {
        IdeGlobalLogBuffer.unregisterConsumer(this)
        super.onCleared()
    }
}

private fun Level.toILoggerLevel(): ILogger.Level =
    when (this) {
        Level.ERROR -> ILogger.Level.ERROR
        Level.WARN -> ILogger.Level.WARNING
        Level.INFO -> ILogger.Level.INFO
        Level.DEBUG -> ILogger.Level.DEBUG
        Level.TRACE -> ILogger.Level.VERBOSE
    }