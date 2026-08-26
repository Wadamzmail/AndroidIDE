package dev.mutwakil.androidide.layouteditor.activities

import android.os.Bundle
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams
import androidx.appcompat.app.AlertDialog
import dev.mutwakil.androidide.layouteditor.BaseActivity
import dev.mutwakil.androidide.layouteditor.LayoutFile
import dev.mutwakil.androidide.layouteditor.R
import dev.mutwakil.androidide.resources.R.string
import dev.mutwakil.androidide.layouteditor.databinding.ActivityPreviewLayoutBinding
import dev.mutwakil.androidide.layouteditor.tools.XmlLayoutParser
import dev.mutwakil.androidide.layouteditor.utils.Constants
import dev.mutwakil.androidide.ui.themes.IThemeManager

class PreviewLayoutActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityPreviewLayoutBinding.inflate(layoutInflater)
        setContentView(binding.getRoot())
        IThemeManager.getInstance().applyTheme(this)
        @Suppress("DEPRECATION")
        val layoutFile = intent.extras?.getParcelable<LayoutFile>(Constants.EXTRA_KEY_LAYOUT)
        val basePath = layoutFile?.path?.let { java.io.File(it).parent }
        val parser = XmlLayoutParser(this, basePath)
        layoutFile?.readDesignFile()?.let { parser.processXml(it, this) }

        val previewContainer = binding.root.findViewById<ViewGroup>(R.id.preview_container)

        val layoutParams = LayoutParams(
            LayoutParams.MATCH_PARENT,
            LayoutParams.MATCH_PARENT
        )

        parser.root?.let { rootView ->
            (rootView.parent as? ViewGroup)?.removeView(rootView)
            previewContainer.addView(rootView, layoutParams)
        } ?: run {
            showErrorDialog()
        }
    }

    private fun showErrorDialog() {
        AlertDialog.Builder(this)
            .setTitle(getString(string.preview_render_error_title))
            .setMessage(getString(string.preview_render_error_message))
            .setPositiveButton(getString(string.msg_ok)) { dialog, _ ->
                dialog.dismiss()
                finish()
            }
            .setCancelable(false)
            .show()
    }
}