package com.meterial.demo.chart.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import java.util.Arrays;

public class PinChart extends View {

	static Canvas c;
    private Paint[] mPaints;
	private Paint mTextPaint;
	private RectF mBigOval;
	public float[] mSweep = { 0, 0, 0, 0, 0,0 };
	private static final float SWEEP_INC = 1;

	public static float[] humidity = { 110, 40, 50, 60, 50, 50 };

	public PinChart(Context context) {
		this(context,null);

	}

	public PinChart(Context context, AttributeSet atr) {
		this(context, atr,0);
	}

	public PinChart(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);

		mPaints = new Paint[humidity.length];
		for (int i = 0; i < humidity.length; i++) {
			mPaints[i] = new Paint();
			mPaints[i].setAntiAlias(true);
			mPaints[i].setStyle(Paint.Style.FILL);
			mPaints[i].setColor(0x880FF000 + i * 0x019e8860);
		}

		mBigOval = new RectF(40, 30, 220, 200);// 饼图的四周边界-->左，上，右，下

		mTextPaint = new Paint();// 绘制文本
		mTextPaint.setAntiAlias(true);
		mTextPaint.setColor(Color.BLACK);
		mTextPaint.setTextSize(16F);// 设置温度值的字体大小
	}

	@SuppressLint("DrawAllocation")
	@Override
	protected void onDraw(Canvas canvas) {
		canvas.drawColor(Color.TRANSPARENT);// 设置背景颜色(透明)


		float start = 0;
		for (int i = 0; i < humidity.length; i++) {
			canvas.drawArc(mBigOval, start, mSweep[i], true, mPaints[i]);
			start += humidity[i];
			if (mSweep[i] < humidity[i]) {
				mSweep[i] += SWEEP_INC;

				//SWEEP_INC 设置大一点速度快 下面方式更好
				/*mSweep[i] += SWEEP_INC;
				if (mSweep[i] > humidity[i]){
					mSweep[i] = humidity[i];
				}*/
			}
			canvas.drawRect(new RectF(300, 30 + 15 * i, 312, 42 + 15 * i),
					mPaints[i]);
			canvas.drawText("测试模块" + i, 320, 40 + 15 * i, mTextPaint);

		}
		if (!Arrays.equals(mSweep,humidity)){
			invalidate();
			Log.e("====","===onDraw");
		}


	}

}