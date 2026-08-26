package dev.mutwakil.androidide.layouteditor.editor.palette.text;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.TextView;

import dev.mutwakil.androidide.layouteditor.utils.Constants;
import dev.mutwakil.androidide.layouteditor.utils.Utils;

public class TextViewDesign extends TextView {
  
  private boolean drawStrokeEnabled;
  private boolean isBlueprint;

  public TextViewDesign(Context context) {
    super(context);
  }

  @Override
  protected void dispatchDraw(Canvas canvas) {
    super.dispatchDraw(canvas);

    if (drawStrokeEnabled)
      Utils.drawDashPathStroke(
          this, canvas, isBlueprint ? Constants.BLUEPRINT_DASH_COLOR : Constants.DESIGN_DASH_COLOR);
  }

  public void setStrokeEnabled(boolean enabled) {
    drawStrokeEnabled = enabled;
    invalidate();
  }
  
  @Override
  public void draw(Canvas canvas) {
    if (isBlueprint) Utils.drawDashPathStroke(this, canvas, Constants.BLUEPRINT_DASH_COLOR);
    else super.draw(canvas);
  }

  public void setBlueprint(boolean isBlueprint) {
    this.isBlueprint = isBlueprint;
    invalidate();
  }
}
