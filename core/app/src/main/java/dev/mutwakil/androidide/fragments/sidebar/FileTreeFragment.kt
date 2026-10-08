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
package dev.mutwakil.androidide.fragments.sidebar

import android.content.Context
import android.os.Bundle
import android.text.TextUtils
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.core.view.WindowInsetsCompat.Type.statusBars
import androidx.core.view.isVisible
import androidx.core.view.updatePadding
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.transition.ChangeBounds
import androidx.transition.TransitionManager
import com.blankj.utilcode.util.SizeUtils
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dev.mutwakil.androidide.adapters.viewholders.FileTreeViewHolder
import dev.mutwakil.androidide.databinding.LayoutEditorFileTreeBinding
import dev.mutwakil.androidide.eventbus.events.filetree.FileClickEvent
import dev.mutwakil.androidide.eventbus.events.filetree.FileLongClickEvent
import dev.mutwakil.androidide.projects.IProjectManager
import dev.mutwakil.androidide.resources.R.drawable
import dev.mutwakil.androidide.tasks.TaskExecutor.executeAsync
import dev.mutwakil.androidide.tasks.callables.FileTreeCallable
import dev.mutwakil.androidide.tasks.callables.FileTreeCallable.SortFileName
import dev.mutwakil.androidide.tasks.callables.FileTreeCallable.SortFolder
import dev.mutwakil.androidide.utils.doOnApplyWindowInsets
import dev.mutwakil.androidide.viewmodel.FileTreeViewModel
import com.unnamed.b.atv.model.TreeNode
import com.unnamed.b.atv.model.TreeNode.TreeNodeClickListener
import com.unnamed.b.atv.model.TreeNode.TreeNodeLongClickListener
import com.unnamed.b.atv.view.AndroidTreeView
import dev.mutwakil.androidide.adapters.FileSearchAdapter
import dev.mutwakil.androidide.events.ExpandTreeNodeRequestEvent
import dev.mutwakil.androidide.events.ListProjectFilesRequestEvent
import dev.mutwakil.androidide.resources.R
import dev.mutwakil.androidide.utils.FileMatch
import dev.mutwakil.androidide.utils.KeyboardUtils
import dev.mutwakil.androidide.viewmodel.FileSearchUiState
import dev.mutwakil.androidide.viewmodel.FileSearchViewModel
import kotlinx.coroutines.launch
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode.MAIN
import java.io.File
import java.util.Arrays

class FileTreeFragment : BottomSheetDialogFragment(), TreeNodeClickListener,
  TreeNodeLongClickListener {

  private var binding: LayoutEditorFileTreeBinding? = null
  private var fileTreeView: AndroidTreeView? = null

  private val viewModel by viewModels<FileTreeViewModel>(ownerProducer = { requireActivity() })
  private val searchViewModel by viewModels<FileSearchViewModel>()
  private var searchAdapter: FileSearchAdapter? = null

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    if (!EventBus.getDefault().isRegistered(this)) {
      EventBus.getDefault().register(this)
    }

    binding = LayoutEditorFileTreeBinding.inflate(inflater, container, false)
    binding?.root?.doOnApplyWindowInsets { view, insets, _, _ ->
      insets.getInsets(statusBars()).apply { view.updatePadding(top = top + SizeUtils.dp2px(8f)) }
    }
    return binding!!.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    setupSearch()
    listProjectFiles()
  }

  override fun onDestroyView() {
    super.onDestroyView()
    EventBus.getDefault().unregister(this)

    saveTreeState()

    binding = null
    searchAdapter = null
    fileTreeView = null
  }

  private fun setupSearch() {
    val binding = binding!!
    val adapter = FileSearchAdapter(::openSearchMatch)
    searchAdapter = adapter
    binding.searchResultsList.adapter = adapter
    binding.searchInput.doAfterTextChanged { searchViewModel.onQueryChanged(it?.toString().orEmpty()) }
    binding.searchInput.setOnEditorActionListener { _, actionId, event ->
      val isEnter = actionId == EditorInfo.IME_ACTION_GO || event?.keyCode == KeyEvent.KEYCODE_ENTER
      if (isEnter && event?.action != KeyEvent.ACTION_UP) {
        openFilesForEnter()
      }
      isEnter
    }

    viewLifecycleOwner.lifecycleScope.launch {
      viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
        launch { searchViewModel.isSearchOpen.collect { binding.searchLayout.isVisible = it } }
        searchViewModel.uiState.collect(::renderSearch)
      }
    }
  }

  fun toggleSearch() {
    val searchInput = binding?.searchInput ?: return
    searchViewModel.toggleSearch()
    if (searchViewModel.isSearchOpen.value) {
      searchInput.post {
        searchInput.requestFocus()
        KeyboardUtils.showSoftInput(searchInput)
      }
    } else {
      searchInput.text?.clear()
      KeyboardUtils.hideSoftInput(searchInput)
    }
  }

  private fun renderSearch(state: FileSearchUiState) {
    val binding = binding ?: return
    val isSearching = state !is FileSearchUiState.Inactive
    binding.treeContainer.isVisible = !isSearching
    binding.searchResults.isVisible = isSearching

    when (state) {
      FileSearchUiState.Inactive -> {
        searchAdapter?.submitList(emptyList())
      }

      is FileSearchUiState.InvalidPattern -> {
        binding.searchStatus.text = getString(R.string.msg_file_search_invalid_pattern, state.reason)
        searchAdapter?.submitList(emptyList())
      }

      is FileSearchUiState.Results -> {
        binding.searchStatus.text = searchStatus(state)
        searchAdapter?.submitList(state.matches) { binding.searchResultsList.scrollToPosition(0) }
      }
    }
  }

  private fun searchStatus(state: FileSearchUiState.Results): String =
    when {
      state.matches.isEmpty() -> {
        getString(R.string.msg_file_search_no_matches)
      }

      !state.isGlob -> {
        getString(R.string.msg_file_search_enter_opens, state.filesOpenedByEnter.single().name)
      }

      state.exceedsOpenLimit -> {
        getString(
          R.string.msg_file_search_too_many,
          state.matches.size,
          FileSearchUiState.Results.MAX_FILES_OPENED_AT_ONCE,
        )
      }

      else -> {
        resources.getQuantityString(R.plurals.msg_file_search_enter_opens_all, state.matches.size, state.matches.size)
      }
    }

  private fun openFilesForEnter() {
    val state = searchViewModel.uiState.value as? FileSearchUiState.Results ?: return
    openFiles(state.filesOpenedByEnter)
  }

  private fun openSearchMatch(match: FileMatch) {
    val state = searchViewModel.uiState.value as? FileSearchUiState.Results ?: return
    openFiles(listOf(state.fileOf(match)))
  }

  private fun openFiles(files: List<File>) {
    if (files.isEmpty()) {
      return
    }
    KeyboardUtils.hideSoftInput(binding!!.searchInput)
    files.forEach(::postFileClick)
  }

  private fun postFileClick(file: File) {
    val event = FileClickEvent(file)
    event.put(Context::class.java, requireContext())
    EventBus.getDefault().post(event)
  }

  fun saveTreeState() {
    viewModel.saveState(fileTreeView)
  }

  override fun onClick(node: TreeNode, p2: Any) {
    val file = p2 as File
    if (!file.exists()) {
      return
    }
    if (file.isDirectory) {
      if (node.isExpanded) {
        collapseNode(node)
      } else {
        setLoading(node)
        listNode(node) { expandNode(node) }
      }
    }
    postFileClick(file)
  }

  private fun updateChevron(node: TreeNode) {
    if (node.viewHolder is FileTreeViewHolder) {
      (node.viewHolder as FileTreeViewHolder).updateChevron(node.isExpanded)
    }
  }

  private fun expandNode(node: TreeNode, animate: Boolean = true) {
    if (fileTreeView == null) {
      return
    }
    if (animate) {
      TransitionManager.beginDelayedTransition(binding!!.root, ChangeBounds())
    }
    fileTreeView!!.expandNode(node)
    updateChevron(node)
  }

  private fun collapseNode(node: TreeNode, animate: Boolean = true) {
    if (fileTreeView == null) {
      return
    }
    if (animate) {
      TransitionManager.beginDelayedTransition(binding!!.root, ChangeBounds())
    }
    fileTreeView!!.collapseNode(node)
    updateChevron(node)
  }

  private fun setLoading(node: TreeNode) {
    if (node.viewHolder is FileTreeViewHolder) {
      (node.viewHolder as FileTreeViewHolder).setLoading(true)
    }
  }

  private fun listNode(node: TreeNode, whenDone: Runnable) {
    node.children.clear()
    node.isExpanded = false
    executeAsync({
      listFilesForNode(node.value.listFiles() ?: return@executeAsync null, node)
      var temp = node
      while (temp.size() == 1) {
        temp = temp.childAt(0)
        if (!temp.value.isDirectory) {
          break
        }
        listFilesForNode(temp.value.listFiles() ?: continue, temp)
        temp.isExpanded = true
      }
      null
    }) {
      whenDone.run()
    }
  }

  private fun listFilesForNode(files: Array<File>, parent: TreeNode) {
    Arrays.sort(files, SortFileName())
    Arrays.sort(files, SortFolder())
    for (file in files) {
      val node = TreeNode(file)
      node.viewHolder = FileTreeViewHolder(context)
      parent.addChild(node, false)
    }
  }

  override fun onLongClick(node: TreeNode, value: Any): Boolean {
    val event = FileLongClickEvent((value as File))
    event.put(Context::class.java, requireContext())
    event.put(TreeNode::class.java, node)
    EventBus.getDefault().post(event)
    return true
  }

  @Suppress("unused", "UNUSED_PARAMETER")
  @Subscribe(threadMode = MAIN)
  fun onGetListFilesRequested(event: ListProjectFilesRequestEvent?) {
    if (!isVisible || context == null) {
      return
    }
    listProjectFiles()
  }

  @Suppress("unused")
  @Subscribe(threadMode = MAIN)
  fun onGetExpandTreeNodeRequest(event: ExpandTreeNodeRequestEvent) {
    if (!isVisible || context == null) {
      return
    } else {
      event.node
    }
    expandNode(event.node)
  }

  fun listProjectFiles() {
    if (binding == null) {
      // Fragment has been destroyed
      return
    }
    val projectDirPath = IProjectManager.getInstance().projectDirPath
    val projectDir = File(projectDirPath)
    val rootNode = TreeNode(File(""))
    rootNode.viewHolder = FileTreeViewHolder(requireContext())

    val projectRoot = TreeNode.root(projectDir)
    projectRoot.viewHolder = FileTreeViewHolder(context)
    rootNode.addChild(projectRoot, false)

    binding!!.horizontalCroll.visibility = View.GONE
    binding!!.horizontalCroll.visibility = View.VISIBLE
    executeAsync(FileTreeCallable(context, projectRoot, projectDir)) {
      if (binding == null) {
        // Fragment has been destroyed
        return@executeAsync
      }
      binding!!.horizontalCroll.visibility = View.VISIBLE
      binding!!.loading.visibility = View.GONE
      val tree = createTreeView(rootNode)
      if (tree != null) {
        tree.setUseAutoToggle(false)
        tree.setDefaultNodeClickListener(this@FileTreeFragment)
        tree.setDefaultNodeLongClickListener(this@FileTreeFragment)
        binding!!.horizontalCroll.removeAllViews()
        val view = tree.view
        binding!!.horizontalCroll.addView(view)
        view.post { tryRestoreState(rootNode) }
      }
    }
  }

  private fun createTreeView(node: TreeNode): AndroidTreeView? {
    return if (context == null) {
      null
    } else AndroidTreeView(context, node, drawable.bg_ripple).also { fileTreeView = it }
  }

  private fun tryRestoreState(rootNode: TreeNode, state: String? = viewModel.savedState) {
    if (!TextUtils.isEmpty(state) && fileTreeView != null) {
      fileTreeView!!.collapseAll()
      val openNodes =
        state!!.split(AndroidTreeView.NODES_PATH_SEPARATOR.toRegex()).dropLastWhile { it.isEmpty() }
      restoreNodeState(rootNode, HashSet(openNodes))
    }

    if (rootNode.children.isNotEmpty()) {
      rootNode.childAt(0)?.let { projectRoot -> expandNode(projectRoot, false) }
    }
  }

  private fun restoreNodeState(root: TreeNode, openNodes: Set<String>) {
    val children = root.children
    var i = 0
    val childrenSize = children.size
    while (i < childrenSize) {
      val node = children[i]
      if (openNodes.contains(node.path)) {
        listNode(node) {
          expandNode(node, false)
          restoreNodeState(node, openNodes)
        }
      }
      i++
    }
  }

  companion object {

    // Should be same as defined in layout/activity_editor.xml
    const val TAG = "editor.fileTree"

    @JvmStatic
    fun newInstance(): FileTreeFragment {
      return FileTreeFragment()
    }
  }
}
