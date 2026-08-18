package dev.mutwakil.androidide.actions.build

import android.content.Context
import androidx.activity.viewModels
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import dev.mutwakil.androidide.actions.ActionData
import dev.mutwakil.androidide.actions.openApplicationModuleChooser
import dev.mutwakil.androidide.project.AndroidModels
import dev.mutwakil.androidide.projects.api.AndroidModule
import dev.mutwakil.androidide.resources.R
import dev.mutwakil.androidide.utils.flashError
import dev.mutwakil.androidide.viewmodel.BuildViewModel
import kotlinx.coroutines.launch

/**
 * @author Akash Yadav
 */
abstract class AbstractModuleAssemblerAction(
    context: Context,
    @StringRes private val labelRes: Int,
    @DrawableRes private val iconRes: Int,
) : AbstractCancellableRunAction(context, labelRes, iconRes) {
    override fun doExec(data: ActionData): Boolean {
        openApplicationModuleChooser(data) { module ->
            val activity = data.requireActivity()

            val variant =
                module.getSelectedVariant() ?: run {
                    activity.flashError(
                        activity.getString(R.string.err_selected_variant_not_found),
                    )
                    return@openApplicationModuleChooser
                }

            onModuleSelected(data, module, variant)
        }
        return true
    }

    private fun onModuleSelected(
        data: ActionData,
        module: AndroidModule,
        variant: AndroidModels.AndroidVariant,
    ) {
        val activity = data.requireActivity()
        val buildViewModel: BuildViewModel by activity.viewModels()
        actionScope.launch {
            activity.saveAllResult()
        }
        buildViewModel.runQuickBuild(module, variant, launchInDebugMode = false)
    }
}