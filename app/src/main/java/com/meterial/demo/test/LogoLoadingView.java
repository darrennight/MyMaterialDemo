package com.meterial.demo.test;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.meterial.demo.R;

public class LogoLoadingView extends View {

    private int width, height;
    private Paint paint;
    private Bitmap bitmap;
    private int currentTop;
    private RectF rectF;
    private PorterDuffXfermode porterDuffXfermode;

    public LogoLoadingView(Context context) {
        this(context, null);
    }

    public LogoLoadingView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LogoLoadingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

        paint = new Paint();
        //设置抗锯齿
        paint.setAntiAlias(true);
        //设置填充样式
        paint.setStyle(Paint.Style.FILL);
        //设定是否使用图像抖动处理，会使绘制出来的图片颜色更加平滑和饱满，图像更加清晰
        paint.setDither(true);
        //加快显示速度，本设置项依赖于dither和xfermode的设置
        paint.setFilterBitmap(true);
        //从资源文件中解析获取Bitmap
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);

        width = 200;
        height = 200;

        bitmap = Bitmap.createScaledBitmap(bitmap, width, height, true);

        porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);

        /**
         * 设置当前矩形的高度为0
         */
        currentTop = bitmap.getHeight();
        rectF = new RectF(0, currentTop, bitmap.getWidth(), bitmap.getHeight());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        rectF.top = currentTop;

        /*
         * 将绘制操作保存到新的图层（更官方的说法应该是离屏缓存）
         */
        int sc = canvas.saveLayer(0, 0, width, height, paint, Canvas.ALL_SAVE_FLAG);

        //绘制目标图像（设置的安卓图标）
        canvas.drawBitmap(bitmap, 0, 0, null);

        paint.setXfermode(porterDuffXfermode);
        paint.setColor(Color.BLUE);

        //绘制
        canvas.drawRect(rectF, paint);
        paint.setXfermode(null);
        /**
         * 还原画布，与canvas.saveLayer配套使用
         */
        canvas.restoreToCount(sc);
        if (currentTop > 0) {
            currentTop -= 2;
            postInvalidate();
        }
    }
}