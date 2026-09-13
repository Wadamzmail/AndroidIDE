package dev.mutwakil.androidide.activities

import android.view.View
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import dev.mutwakil.androidide.app.EdgeToEdgeIDEActivity

abstract class InsetActivity : EdgeToEdgeIDEActivity() {

  private var insetView: View? = null
  private var initialPaddingBottom = 0

  protected fun setInsetForView(view: View) {
    insetView = view
    initialPaddingBottom = view.paddingBottom

    ViewCompat.requestApplyInsets(view)
  }

  override fun onApplyWindowInsets(insets: WindowInsetsCompat) {
    super.onApplyWindowInsets(insets)

    val view = insetView ?: return

    val navigationBarBottom = insets.getInsets(
      WindowInsetsCompat.Type.navigationBars()
    ).bottom

    view.updatePadding(
      bottom = initialPaddingBottom + navigationBarBottom
    )
  }

  override fun onDestroy() {
    insetView = null
    initialPaddingBottom = 0
    super.onDestroy()
  }
}