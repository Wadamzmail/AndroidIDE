package dev.mutwakil.androidide.templates

import android.content.Context
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.google.android.material.color.MaterialColors
import dev.mutwakil.androidide.resources.R
import dev.mutwakil.androidide.templates.android.Template
import dev.mutwakil.androidide.templates.android.TemplateRegistry
import dev.mutwakil.androidide.roomData.recentproject.RecentProject

class AtcInterface {

  interface TemplateCreationListener {
    fun onTemplateSelected(templateName: String)

    fun onCreationCancelled()

    fun onTemplateCreated(success: Boolean, message: String)

    fun onTemplateCreated(success: Boolean, message: String, projectDir: java.io.File?, projectModel: RecentProject) {}
  }

  fun create(ctx: Context, listener: TemplateCreationListener? = null) {
    val templates = TemplateRegistry.getAllTemplates()

    // Directly show the wizard bottom sheet (templates grid -> options)
    if (ctx is FragmentActivity) {
      val wizard = AtcWizardDialog()
      wizard.init(listener)
      wizard.show(ctx.supportFragmentManager, "atc_wizard")
    }
  }

  private fun Int.dpToPx(context: Context): Int {
    return (this * context.resources.displayMetrics.density).toInt()
  }
}

class TemplateGridAdapter(
    private val templates: List<Template>,
    private val context: Context,
    private val onItemClick: (Template) -> Unit,
) : RecyclerView.Adapter<TemplateGridAdapter.TemplateViewHolder>() {

  inner class TemplateViewHolder(
      val cardView: MaterialCardView,
      val templateName: TextView,
      val previewImage: ImageView,
  ) : RecyclerView.ViewHolder(cardView)

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TemplateViewHolder {
    val cardView =
        MaterialCardView(context).apply {
          layoutParams =
              ViewGroup.MarginLayoutParams(
                      ViewGroup.LayoutParams.MATCH_PARENT,
                      ViewGroup.LayoutParams.WRAP_CONTENT,
                  )
                  .apply {
                    setMargins(
                        8.dpToPx(context),
                        8.dpToPx(context),
                        8.dpToPx(context),
                        8.dpToPx(context),
                    )
                  }
          radius = 16.dpToPx(context).toFloat()
          isClickable = true
          isFocusable = true
          strokeWidth = 0

          val surfaceContainer =
              MaterialColors.getColor(
                  this,
                  com.google.android.material.R.attr.colorSurfaceContainerLow,
              )
          setCardBackgroundColor(surfaceContainer)

          val outValue = android.util.TypedValue()
          context.theme.resolveAttribute(android.R.attr.selectableItemBackground, outValue, true)
          foreground = context.getDrawable(outValue.resourceId)
        }

    val container =
        LinearLayout(context).apply {
          orientation = LinearLayout.VERTICAL
          layoutParams =
              ViewGroup.LayoutParams(
                  ViewGroup.LayoutParams.MATCH_PARENT,
                  ViewGroup.LayoutParams.WRAP_CONTENT,
              )
        }

    val nameText =
        TextView(context).apply {
          textSize = 14f

          val onSurfaceColor =
              MaterialColors.getColor(this, com.google.android.material.R.attr.colorOnSurface)
          setTextColor(onSurfaceColor)

          gravity = android.view.Gravity.CENTER
          setPadding(12.dpToPx(context), 12.dpToPx(context), 12.dpToPx(context), 8.dpToPx(context))
          layoutParams =
              LinearLayout.LayoutParams(
                  ViewGroup.LayoutParams.MATCH_PARENT,
                  ViewGroup.LayoutParams.WRAP_CONTENT,
              )
        }

    val imageView =
        ImageView(context).apply {
          scaleType = ImageView.ScaleType.CENTER_CROP
          layoutParams =
              LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 200.dpToPx(context))

          val surfaceContainerColor =
              MaterialColors.getColor(
                  this,
                  com.google.android.material.R.attr.colorSurfaceContainer,
              )
          setBackgroundColor(surfaceContainerColor)
        }

    container.addView(nameText)
    container.addView(imageView)
    cardView.addView(container)

    return TemplateViewHolder(cardView, nameText, imageView)
  }

  override fun onBindViewHolder(holder: TemplateViewHolder, position: Int) {
    val template = templates[position]
    holder.templateName.text = template.displayName

    // Get image resource by template class name (e.g., basic_activity.png)
    val imageResId =
        context.resources.getIdentifier(
            template.javaClass.simpleName.replace(Regex("([a-z])([A-Z])"), "$1_$2").lowercase(),
            "drawable",
            context.packageName,
        )

    if (imageResId != 0) {
      holder.previewImage.setImageResource(imageResId)
    } else {
      // Set placeholder if preview not available
      holder.previewImage.setImageResource(android.R.drawable.ic_menu_gallery)
    }

    holder.cardView.setOnClickListener { onItemClick(template) }
  }

  override fun getItemCount() = templates.size

  private fun Int.dpToPx(context: Context): Int {
    return (this * context.resources.displayMetrics.density).toInt()
  }
}
