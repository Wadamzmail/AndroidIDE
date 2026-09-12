package dev.mutwakil.androidide.templates

import android.view.View
import android.view.ViewGroup
import androidx.transition.TransitionManager
import com.google.android.material.transition.MaterialSharedAxis

object SheetTransitions {

  fun slide(
      parent: ViewGroup,
      exiting: View,
      entering: View,
      axis: Int = MaterialSharedAxis.X,
      forward: Boolean = true,
  ) {
    val transition = MaterialSharedAxis(axis, forward)
    TransitionManager.beginDelayedTransition(parent, transition)
    exiting.visibility = View.GONE
    entering.visibility = View.VISIBLE
  }
}
