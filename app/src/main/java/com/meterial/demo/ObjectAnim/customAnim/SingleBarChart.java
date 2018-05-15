package com.meterial.demo.ObjectAnim.customAnim;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.meterial.demo.R;

/**
 * TODO
 *
 * @author zenghao
 * @since 2018/5/10 下午8:26
 */
public class SingleBarChart extends View {


    private Paint mPaint;
    private int mBarColor;
    private int percentTotal;
    private boolean canAnimate = false;
    BarAnimation anim;
    private float per=0;
    private int iDisplayWidth, iDisplayHeight;
    private String mText = "";


    public SingleBarChart(Context context) {
        this(context, null, 0);
    }
    public SingleBarChart(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }
    public SingleBarChart(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.SingleBarChart);
        mBarColor = a.getColor(R.styleable.SingleBarChart_barColor ,0xFF409be4);
        percentTotal = a.getInteger(R.styleable.SingleBarChart_percent, 0);
        CharSequence sequence  = a.getText(R.styleable.SingleBarChart_bartext);
        sequence = "hahah";
        if(sequence != null){
            mText = sequence.toString();
        }

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(mBarColor);
        anim = new BarAnimation();
        anim.setDuration(1000);
        if( percentTotal !=0 ){
            if(canAnimate){
                this.startAnimation(anim);
            }else{
                per = 1.0f;
            }
        }

    }


    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        super.onDraw(canvas);
        mPaint.setColor(mBarColor);
        canvas.drawRect(0, 0, iDisplayWidth* ((float) percentTotal /100)* per, iDisplayHeight, mPaint);
        mPaint.setColor(0xFFE6E6E6);
        canvas.drawRect(iDisplayWidth* ((float) percentTotal /100)* per, 0, iDisplayWidth, iDisplayHeight, mPaint);

        canvas.drawText(mText, 0,(iDisplayHeight+iDisplayHeight/10 *7)/2, mPaint);

    }



    public class BarAnimation extends Animation {

        public BarAnimation() {
        }
        @Override
        protected void applyTransformation(float interpolatedTime, Transformation t) {
            super.applyTransformation(interpolatedTime, t);
            if (interpolatedTime < 1.0f) {
                per =  interpolatedTime;

                postInvalidate();

            } else {
                per = 1.0f;

            }
        }
    }
}
