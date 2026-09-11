package dev.mutwakil.androidide.utils

import dev.mutwakil.androidide.app.BaseApplication
import dev.mutwakil.androidide.managers.PreferenceManager

/** * @Author Tom */
class IBuildSystemUtils {
  companion object {
    fun getNdkVersion(): String? {
      val prefManager: PreferenceManager = BaseApplication.baseInstance.prefManager
      return prefManager.getString("bs_native_kit_version", null)
    }

    fun setNdkVersion(version: String) {
      val prefManager = BaseApplication.baseInstance.prefManager
      prefManager.putString("bs_native_kit_version", version)
    }

    fun getCMakeVersion(): String? {
      val prefManager: PreferenceManager = BaseApplication.baseInstance.prefManager
      return prefManager.getString("bs_cmake_version", null)
    }

    fun setCMakeVersion(version: String) {
      val prefManager = BaseApplication.baseInstance.prefManager
      prefManager.putString("bs_cmake_version", version)
    }
  }
}