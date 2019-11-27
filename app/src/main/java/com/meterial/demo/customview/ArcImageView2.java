package com.meterial.demo.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import com.meterial.demo.R;

public class ArcImageView2 extends AppCompatImageView {
    /*
     *弧形高度
     */
    private int mArcHeight;
    private static final String TAG = "ArcImageView";

    private int mWidth;
    private int mHeight;

    public ArcImageView2(Context context) {
        this(context, null);
    }

    public ArcImageView2(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ArcImageView2(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ArcImageView);
        mArcHeight = typedArray.getDimensionPixelSize(R.styleable.ArcImageView_arcHeight, 0);
        typedArray.recycle();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        /*Path path = new Path();
        path.moveTo(0, 0);
        path.lineTo(0, getHeight());
        path.quadTo(getWidth() / 2, getHeight() - 2 * mArcHeight, getWidth(), getHeight());
        path.lineTo(getWidth(), 0);
        path.close();
        canvas.clipPath(path);*/
        super.onDraw(canvas);
        Paint mPaint = new Paint();
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.RED);
        mPaint.setXfermode( new PorterDuffXfermode(PorterDuff.Mode.DST_IN));

        Path path = new Path();
        path.moveTo(0, 0);
        path.lineTo(0, getHeight()-mArcHeight*3);

        path.quadTo(getWidth() / 2 , getHeight() , getWidth(), getHeight()-mArcHeight/2);
        path.lineTo(getWidth(), 0);

        path.close();
        canvas.drawPath(path,mPaint);


        Paint testPaint = new Paint();
        testPaint.setColor(Color.WHITE);
        testPaint.setStyle(Paint.Style.FILL);
        testPaint.setAntiAlias(true);
        testPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        Rect recttet = new Rect(0,0,getWidth(),getHeight());
        canvas.drawRect(recttet,testPaint);

    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        if (widthMode == MeasureSpec.EXACTLY) {
            mWidth = widthSize;
        }
        if (heightMode == MeasureSpec.EXACTLY) {
            mHeight = heightSize;
        }
        setMeasuredDimension(mWidth, mHeight);
    }

}