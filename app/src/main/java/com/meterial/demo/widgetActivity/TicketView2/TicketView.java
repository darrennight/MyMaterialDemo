package com.meterial.demo.widgetActivity.TicketView2;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;
import android.support.annotation.IntDef;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.RelativeLayout;
import com.meterial.demo.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by santalu on 06/09/2017.
 */

public class TicketView extends RelativeLayout {

  private static final int DEFAULT_RADIUS = 50;
  private static final int NO_VALUE = -1;
  private static final int HORIZONTAL = 0;
  private static final int VERTICAL = 1;

  private Paint eraser = new Paint(Paint.ANTI_ALIAS_FLAG);
  private Paint dashPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
  private Paint borderPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
  private Path dashPath = new Path();
  private RectF borderRect;
  private int orientation;
  private int anchorViewId;
  private float holePosition;
  private float holeRadius;

  public TicketView(Context context) {
    super(context);
    init(null);
  }

  public TicketView(Context context, AttributeSet attrs) {
    super(context, attrs);
    init(attrs);
  }

  public TicketView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init(attrs);
  }

  private void init(AttributeSet attrs) {
    eraser.setXfermode(new PorterDuffXfermode(Mode.CLEAR));

    dashPaint.setARGB(255, 200, 200, 200);
    dashPaint.setStyle(Style.STROKE);
    dashPaint.setStrokeWidth(4);
    dashPaint.setPathEffect(new DashPathEffect(new float[] { 4, 8 }, 0));

    borderPaint.setARGB(255, 200, 200, 200);
    borderPaint.setStyle(Style.STROKE);
    borderPaint.setStrokeWidth(4);

    setLayerType(LAYER_TYPE_HARDWARE, null);

    TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.TicketView2);
    try {
      orientation = a.getInt(R.styleable.TicketView2_tv_orientation, VERTICAL);
      holeRadius = a.getFloat(R.styleable.TicketView2_tv_holeRadius, DEFAULT_RADIUS);
      anchorViewId = a.getResourceId(R.styleable.TicketView2_tv_anchor, NO_VALUE);
    } finally {
      a.recycle();
    }
  }

  public void setRadius(float radius) {
    this.holeRadius = radius;
    postInvalidate();
  }

  public void setOrientation(@Orientation int orientation) {
    this.orientation = orientation;
    postInvalidate();
  }

  //set dashes location
  public void setAnchor(View view) {
    Rect rect = new Rect();
    //get view's visible bounds
    view.getDrawingRect(rect);
    //calculate the relative coordinates to parent
    offsetDescendantRectToMyCoords(view, rect);
    if (orientation == HORIZONTAL) {
      holePosition = rect.left - holeRadius;
    } else {
      holePosition = rect.bottom + holeRadius;
    }
    postInvalidate();
  }

  @Override
  protected void onFinishInflate() {
    super.onFinishInflate();
    if (anchorViewId != NO_VALUE) {
      final View anchorView = findViewById(anchorViewId);

      getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
        @Override
        public void onGlobalLayout() {
          if (VERSION.SDK_INT >= VERSION_CODES.JELLY_BEAN) {
            getViewTreeObserver().removeOnGlobalLayoutListener(this);
          } else {
            getViewTreeObserver().removeGlobalOnLayoutListener(this);
          }
          setAnchor(anchorView);
        }
      });
    }
  }

  @Override
  protected void onSizeChanged(int w, int h, int oldw, int oldh) {
    if (w != oldw || h != oldh) {
      borderRect = new RectF(0, 0, w, h);
    }
    super.onSizeChanged(w, h, oldw, oldh);
  }

  @Override
  protected void onDraw(Canvas canvas) {
    int w = getWidth();
    int h = getHeight();

    canvas.drawRect(borderRect, borderPaint);

    // add holes to corners
    canvas.drawCircle(0, 0, holeRadius, eraser); // top-left corner
    canvas.drawCircle(w, 0, holeRadius, eraser); // top-right corner
    canvas.drawCircle(0, h, holeRadius, eraser); // bottom-left corner
    canvas.drawCircle(w, h, holeRadius, eraser); // bottom-right corner

    // add corner borders
    canvas.drawCircle(0, 0, holeRadius, borderPaint); // top-left corner
    canvas.drawCircle(w, 0, holeRadius, borderPaint); // top-right corner
    canvas.drawCircle(0, h, holeRadius, borderPaint); // bottom-left corner
    canvas.drawCircle(w, h, holeRadius, borderPaint); // bottom-right corner

    if (orientation == HORIZONTAL) {

      // add holes on the ticket by erasing them
      canvas.drawCircle(holePosition, 0, holeRadius, eraser); // right-top hole
      canvas.drawCircle(holePosition, h, holeRadius, eraser); // right-bottom hole

      // add hole borders
      canvas.drawCircle(holePosition, 0, holeRadius, borderPaint); // right-top hole
      canvas.drawCircle(holePosition, h, holeRadius, borderPaint); // right-bottom hole

      // dashes at the end
      dashPath.moveTo(holePosition, holeRadius);
      dashPath.quadTo(holePosition, h - holeRadius, holePosition, h - holeRadius);
    } else {
      // add holes on the ticket by erasing them
      canvas.drawCircle(0, holePosition, holeRadius, eraser); // bottom-left hole
      canvas.drawCircle(w, holePosition, holeRadius, eraser); // bottom-right hole

      // add hole borders
      canvas.drawCircle(0, holePosition, holeRadius, borderPaint); // bottom-left hole
      canvas.drawCircle(w, holePosition, holeRadius, borderPaint); // bottom-right hole

      // dashes at the bottom
      dashPath.moveTo(holeRadius, holePosition);
      dashPath.quadTo(w - holeRadius, holePosition, w - holeRadius, holePosition);
    }

    canvas.drawPath(dashPath, dashPaint);

    super.onDraw(canvas);
  }

  @Retention(RetentionPolicy.SOURCE)
  @IntDef({ HORIZONTAL, VERTICAL })
  public @interface Orientation {
  }
}