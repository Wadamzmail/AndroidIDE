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

package dev.mutwakil.androidide.fragments.output;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import dev.mutwakil.androidide.R;
import dev.mutwakil.androidide.databinding.FragmentNonEditableEditorBinding;
import dev.mutwakil.androidide.editor.ui.IDEEditor;
import dev.mutwakil.androidide.fragments.EmptyStateFragment;
import dev.mutwakil.androidide.syntax.colorschemes.SchemeAndroidIDE;
import dev.mutwakil.androidide.utils.BuildInfoUtils;
import dev.mutwakil.androidide.utils.TypefaceUtilsKt;
import io.github.rosemoe.sora.lang.EmptyLanguage;

public abstract class NonEditableEditorFragment extends
        EmptyStateFragment<FragmentNonEditableEditorBinding>
        implements ShareableOutputFragment {

  public NonEditableEditorFragment() {
    super(R.layout.fragment_non_editable_editor, FragmentNonEditableEditorBinding::bind);
  }

  @Override
  public void clearOutput() {
    final var editor = getEditor();
    if (editor == null) {
      return;
    }

    // Editing CodeEditor's content is a synchronized operation
    editor.getText().delete(0, editor.getText().length());
    getEmptyStateViewModel().setEmpty(true);
  }

  @Nullable
  public IDEEditor getEditor() {
    final var binding = get_binding();
    if (binding == null) {
      return null;
    }
    return binding.editor;
  }

  @NonNull
  @Override
  public String getShareableContent() {
    final var editor = getEditor();
    if (editor == null) {
      return "";
    }

    final var editorText = editor.getText().toString();
    return BuildInfoUtils.BASIC_INFO + System.lineSeparator() + editorText;
  }

  @NonNull
  @Override
  public String getShareableFilename() {
    return "build_output";
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    getEmptyStateViewModel().setEmptyMessage(createEmptyStateMessage());
    final var editor = getBinding().getRoot();
    editor.setEditable(false);
    editor.setDividerWidth(0);
    editor.setEditorLanguage(new EmptyLanguage());
    editor.setWordwrap(false);
    editor.setUndoEnabled(false);
    editor.setTypefaceLineNumber(TypefaceUtilsKt.jetbrainsMono());
    editor.setTypefaceText(TypefaceUtilsKt.jetbrainsMono());
    editor.setTextSize(12);
    editor.setColorScheme(SchemeAndroidIDE.newInstance(requireContext()));
  }

  @NonNull
  private CharSequence createEmptyStateMessage() {
    return "";
  }
}