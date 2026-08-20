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

package dev.mutwakil.androidide.fragments

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.transition.TransitionManager
import dev.mutwakil.androidide.R
import dev.mutwakil.androidide.R.string
import dev.mutwakil.androidide.activities.MainActivity
import dev.mutwakil.androidide.adapters.TemplateWidgetsListAdapter
import dev.mutwakil.androidide.databinding.FragmentTemplateDetailsBinding
import dev.mutwakil.androidide.tasks.executeAsyncProvideError
import dev.mutwakil.androidide.templates.ProjectTemplateRecipeResult
import dev.mutwakil.androidide.templates.StringParameter
import dev.mutwakil.androidide.templates.Template
import dev.mutwakil.androidide.templates.impl.ConstraintVerifier
import dev.mutwakil.androidide.utils.TemplateRecipeExecutor
import dev.mutwakil.androidide.utils.flashError
import dev.mutwakil.androidide.utils.flashSuccess
import dev.mutwakil.androidide.viewmodel.MainViewModel
import org.slf4j.LoggerFactory
import androidx.fragment.app.activityViewModels
import dev.mutwakil.androidide.roomData.recentproject.RecentProject
import dev.mutwakil.androidide.viewmodel.RecentProjectsViewModel
import java.util.Date
import org.koin.androidx.viewmodel.ext.android.activityViewModel

/**
 * A fragment which shows a wizard-like interface for creating templates.
 *
 * @author Akash Yadav
 */
class TemplateDetailsFragment :
  FragmentWithBinding<FragmentTemplateDetailsBinding>(
    R.layout.fragment_template_details, FragmentTemplateDetailsBinding::bind) {

  private val viewModel by activityViewModel<MainViewModel>()
  companion object {

    private val log = LoggerFactory.getLogger(TemplateDetailsFragment::class.java)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    viewModel.template.observe(viewLifecycleOwner) {
      binding.widgets.adapter = null
      viewModel.postTransition(viewLifecycleOwner) { bindWithTemplate(it) }
    }

    viewModel.creatingProject.observe(viewLifecycleOwner) {
      TransitionManager.beginDelayedTransition(binding.root)
      binding.progress.isVisible = it
      binding.finish.isEnabled = !it
      binding.previous.isEnabled = !it
    }

    binding.previous.setOnClickListener {
      viewModel.setScreen(MainViewModel.SCREEN_TEMPLATE_LIST)
    }

    binding.finish.setOnClickListener {
      viewModel.creatingProject.value = true
      val template = viewModel.template.value ?: run {
        viewModel.setScreen(MainViewModel.SCREEN_MAIN)
        return@setOnClickListener
      }

      val isValid = template.parameters.fold(true) { isValid, param ->
        if (param is StringParameter) {
          return@fold isValid && ConstraintVerifier.isValid(param.value,
            param.constraints)
        } else isValid
      }

      if (!isValid) {
        viewModel.creatingProject.value = false
        flashError(string.msg_invalid_project_details)
        return@setOnClickListener
      }

      viewModel.creatingProject.value = true
      executeAsyncProvideError({
        template.recipe.execute(TemplateRecipeExecutor())
      }) { result, err ->

        viewModel.creatingProject.value = false
        if (result == null || err != null || result !is ProjectTemplateRecipeResult) {
          err?.printStackTrace()
          log.error("Failed to create project. result={}, err={}", result, err?.message)
          if (err != null) {
            flashError(err.cause?.message ?: err.message)
          } else {
            flashError(string.project_creation_failed)
          }
          return@executeAsyncProvideError
        }

        viewModel.setScreen(MainViewModel.SCREEN_MAIN)
        flashSuccess(string.project_created_successfully)
        
        val now = System.currentTimeMillis().toString()
        
        val project = RecentProject(
                    location = result.data.projectDir.path,
                    name = result.data.name,
                    createdAt = now,
                    lastModified = now,
                    templateName = getString(template.templateName),
                    language = result.data.language?.name ?: "unknown"
         )         

        viewModel.postTransition(viewLifecycleOwner) {
          // open the project
          ((requireActivity() as MainActivity).openProject(
                        result.data.projectDir,
                        project = project
          ))
        }
      }
    }

    binding.widgets.layoutManager = LinearLayoutManager(requireContext())
  }

  private fun bindWithTemplate(template: Template<*>?) {
    template ?: return

    binding.widgets.adapter = TemplateWidgetsListAdapter(template.widgets)
    binding.title.setText(template.templateName)
  }
}