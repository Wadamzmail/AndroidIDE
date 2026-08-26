package dev.mutwakil.androidide.layouteditor.adapters.models

import android.graphics.drawable.Drawable
import dev.mutwakil.androidide.layouteditor.utils.FileUtil

data class DrawableFile(var versions: Int, var drawable: Drawable, var path: String) {
  var name: String = FileUtil.getLastSegmentFromPath(path)
}
