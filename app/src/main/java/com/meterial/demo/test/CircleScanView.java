package com.meterial.demo.test;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.meterial.demo.R;

public class CircleScanView extends View {

    int width, heigth;//控件宽高
    float radius;//最小圆半径
    float ringWidth;//圆边框宽度
    int centerColor;
    float circlePointX, circlePointY;//圆心x,y

    public CircleScanView(Context context) {
        super(context);
    }

    public CircleScanView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        getAttr(context, attrs);
    }

    public CircleScanView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        getAttr(context, attrs);
    }

    private void getAttr(Context context, AttributeSet attrs) {
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.RoundScanView);
        try {
            ringWidth = array.getDimension(R.styleable.RoundScanView_ringWidth, 20);
            centerColor = array.getColor(R.styleable.RoundScanView_centerColor, Color.parseColor("#00000000"));
        } finally {
            array.recycle();
        }
    }

    private Handler mHandler = new Handler();
    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            if (percent == 100) {
                percent = 0;
            } else {
                percent = percent + 2.5f;
            }
            invalidate();
        }
    };

    float rectH = 0;
    float percent = 0;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        rectH = 2 * radius * percent / 100;
        width = getWidth();
        heigth = getHeight();
        radius = (width - 6 * ringWidth) / 2;
        circlePointX = width / 2;
        circlePointY = heigth / 2;
        drawOutCircle1(canvas);
        drawOutCircle2(canvas);
        drawRectCircle(canvas);
        mHandler.postDelayed(mRunnable, 60);
    }


    /**
     * 画最外面的圈
     *
     * @param canvas
     */
    private void drawOutCircle1(Canvas canvas) {
        Paint ringPaint = new Paint();
        ringPaint.setColor(Color.parseColor("#1900e1ff"));
        ringPaint.setStyle(Paint.Style.STROKE);
        ringPaint.setAntiAlias(true);
        ringPaint.setStrokeWidth(ringWidth);
        canvas.drawCircle(circlePointX, circlePointY, radius + 2 * ringWidth, ringPaint);
    }

    /**
     * 画圆的边
     *
     * @param canvas
     */
    private void drawOutCircle2(Canvas canvas) {
        Paint ringPaint = new Paint();
        ringPaint.setColor(Color.parseColor("#9900e1ff"));
        ringPaint.setStyle(Paint.Style.STROKE);
        ringPaint.setAntiAlias(true);
        ringPaint.setStrokeWidth(ringWidth);
        canvas.drawCircle(circlePointX, circlePointY, radius, ringPaint);
    }

    /**
     * 画里面的圆效果
     *
     * @param canvas
     */
    private void drawRectCircle(Canvas canvas) {
        
        Paint circlePaint = new Paint();
        //渐变效果
        LinearGradient
                lg = new LinearGradient(radius + ringWidth * 3, ringWidth * 3, radius + ringWidth * 3, ringWidth * 3 + rectH, Color.parseColor("#00000000"), Color.parseColor("#9900e1ff"), Shader.TileMode.MIRROR);
        circlePaint.setShader(lg);

        circlePaint.setAntiAlias(true);
        if (percent <= 50) {
            float horiAngle = (float) (Math.asin((radius - rectH) / radius) * 180 / Math.PI);
            float startAngle = 180F + horiAngle;
            float sweepAngle = 180F - 2 * horiAngle;
            float left = 3 * ringWidth;
            float top = 3 * ringWidth;
            float right = 3 * ringWidth + 2 * radius;
            float bottom = 3 * ringWidth + 2 * radius;
            RectF rect = new RectF(left, top, right, bottom);
            canvas.drawArc(rect, //弧线所使用的矩形区域大小
                    startAngle,  //开始角度
                    sweepAngle, //扫过的角度
                    false, //是否使用中心
                    circlePaint);
        } else {
            float horiAngle = (float) (Math.asin((rectH - radius) / radius) * 180 / Math.PI);
            float startAngle = 180F - horiAngle;
            float sweepAngle = 180F + 2 * horiAngle;
            float left = 3 * ringWidth;
            float top = 3 * ringWidth;
            float right = 3 * ringWidth + 2 * radius;
            float bottom = 3 * ringWidth + 2 * radius;
            RectF rect = new RectF(left, top, right, bottom);
            canvas.drawArc(rect, //弧线所使用的矩形区域大小
                    startAngle,  //开始角度
                    sweepAngle, //扫过的角度
                    false, //是否使用中心
                    circlePaint);
        }
    }
}