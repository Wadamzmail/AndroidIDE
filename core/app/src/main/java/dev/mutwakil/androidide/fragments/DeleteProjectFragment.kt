package dev.mutwakil.androidide.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import org.koin.androidx.viewmodel.ext.android.activityViewModel
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import dev.mutwakil.androidide.R
import dev.mutwakil.androidide.adapters.DeleteProjectListAdapter
import dev.mutwakil.androidide.databinding.FragmentDeleteProjectBinding
import dev.mutwakil.androidide.models.Checkable
import dev.mutwakil.androidide.ui.CustomDividerItemDecoration
import dev.mutwakil.androidide.utils.flashError
import dev.mutwakil.androidide.utils.flashSuccess
import dev.mutwakil.androidide.viewmodel.MainViewModel
import dev.mutwakil.androidide.viewmodel.RecentProjectsViewModel
import kotlinx.coroutines.launch

class DeleteProjectFragment : BaseFragment() {

    private var _binding: FragmentDeleteProjectBinding? = null
    private val binding get() = _binding!!

    private val recentProjectsViewModel: RecentProjectsViewModel by activityViewModels()
    private val mainViewModel: MainViewModel by activityViewModel()
    private var adapter: DeleteProjectListAdapter? = null
    private var isDeleteButtonClickable = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDeleteProjectBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        observeProjects()
        observeDeletionStatus()
        setupClickListeners()
    }

    private fun setupRecyclerView() = with(binding) {
        listProjects.layoutManager = LinearLayoutManager(requireContext())
        listProjects.addItemDecoration(
            CustomDividerItemDecoration(requireContext(), R.drawable.custom_list_divider)
        )
    }

    private fun observeProjects() {
        recentProjectsViewModel.projects.observe(viewLifecycleOwner) { projects ->
            val selectedPaths = adapter
                ?.getSelectedProjects()
                ?.map { it.path }
                ?.toSet()
                .orEmpty()

            val checkableProjects = projects.map { project ->
                Checkable(project.path in selectedPaths, project)
            }

            if (adapter == null) {
                // Create adapter and pass a callback to update delete button state on selection change
                adapter = DeleteProjectListAdapter(
                    checkableProjects,
                    { enableBtn ->
                        updateDeleteButtonState(enableBtn)
                    },
                    onCheckboxLongPress = {true}

                )
                binding.listProjects.adapter = adapter
            } else {
                adapter?.updateProjects(checkableProjects)
            }

            binding.recentProjectsTxt.isVisible = projects.isNotEmpty()
            binding.noProjectsView.isVisible = projects.isEmpty()

            // Change button text and state based on whether projects exist
            if (projects.isEmpty()) {
                binding.delete.text = getString(R.string.new_project)
                binding.delete.isEnabled = true
            } else {
                binding.delete.text = getString(R.string.delete_project)
                updateDeleteButtonState(adapter?.getSelectedProjects()?.isNotEmpty() == true)
            }
        }
    }

    private fun observeDeletionStatus() {
        viewLifecycleOwner.lifecycleScope.launch {
            recentProjectsViewModel.deletionStatus.collect { status ->
                if (status) {
                    flashSuccess(R.string.deleted)
                } else {
                    flashError(R.string.delete_failed)
                }
            }
        }
    }

    private fun updateDeleteButtonState(hasSelection: Boolean) {
        isDeleteButtonClickable = hasSelection
        binding.delete.isEnabled = true
        binding.delete.alpha = if (hasSelection) 1.0f else 0.5f
    }

    private fun setupClickListeners() {
        binding.delete.setOnClickListener {
            // If no projects exist, navigate to the create project screen.
            val projects = recentProjectsViewModel.projects.value
            if (projects.isNullOrEmpty()) {
                mainViewModel.setScreen(MainViewModel.SCREEN_TEMPLATE_LIST)
            } else if (isDeleteButtonClickable) {
                showDeleteDialog()
            }
        }

        binding.exitButton.setOnClickListener { mainViewModel.setScreen(MainViewModel.SCREEN_MAIN) }

    }

    private fun showDeleteDialog() {
        val dialog = MaterialAlertDialogBuilder(requireContext())
            .setTitle(R.string.delete_project)
            .setMessage(R.string.msg_delete_selected_project)
            .setNegativeButton(R.string.no) { dialog, _ -> dialog.dismiss() }
            .setPositiveButton(R.string.yes) { _, _ ->
                    adapter?.getSelectedProjects().let { projectFiles ->
                        recentProjectsViewModel.deleteSelectedProjects(
                            projectFiles?.map { it.name } ?: emptyList()
                        )
                    }
            }
            .show()
    }

    override fun onResume() {
        super.onResume()
        recentProjectsViewModel.loadProjects()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
