package com.meterial.demo.test;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

/**
 * TODO
 *
 * @author zenghao
 * @since 2018/3/19 下午4:00
 */
public class TestScanImage extends AppCompatImageView {

    private Paint mPaint = null;
    private Paint arcPaint = null;
    public TestScanImage(Context context) {
        this(context,null);
    }

    public TestScanImage(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TestScanImage(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init(){
        mPaint = new Paint();
        mPaint.setColor(Color.YELLOW);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);

        arcPaint = new Paint();
        arcPaint.setColor(Color.BLUE);
        arcPaint.setStyle(Paint.Style.FILL);
        arcPaint.setAntiAlias(true);
        //arcPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //设置背景色
        canvas.drawARGB(255, 139, 197, 186);

        int canvasWidth = canvas.getWidth();
        int canvasHeight = canvas.getHeight();
        int layerId = canvas.saveLayer(0, 0, canvasWidth, canvasHeight, null, Canvas.ALL_SAVE_FLAG);

        //setLayerType(LAYER_TYPE_HARDWARE, null);
        //canvas.drawCircle(getWidth()/2,getHeight()/2,getWidth()/2,mPaint);
        arcPaint.setColor(Color.TRANSPARENT);
        //arcPaint.setColor(Color.YELLOW);
        canvas.drawCircle(getWidth()/2,getHeight()/2,getWidth()/2,arcPaint);

        arcPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
        arcPaint.setColor(Color.BLUE);
        /*RectF rf = new RectF(0,0,getWidth(),getHeight());
        canvas.drawArc(rf,0,180,false,arcPaint);*/


        RectF rf2 = new RectF(50,0,getWidth()-50,50);
        canvas.drawRect(rf2,arcPaint);

        arcPaint.setXfermode(null);
        canvas.restoreToCount(layerId);
    }

    /*@Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //设置背景色
        canvas.drawARGB(255, 139, 197, 186);

        int canvasWidth = canvas.getWidth();
        int canvasHeight = canvas.getHeight();
        int layerId = canvas.saveLayer(0, 0, canvasWidth, canvasHeight, null, Canvas.ALL_SAVE_FLAG);

        //setLayerType(LAYER_TYPE_HARDWARE, null);
        //canvas.drawCircle(getWidth()/2,getHeight()/2,getWidth()/2,mPaint);
        arcPaint.setColor(Color.TRANSPARENT);
        //arcPaint.setColor(Color.YELLOW);
        canvas.drawCircle(getWidth()/2,getHeight()/2,getWidth()/2,arcPaint);

        arcPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
        arcPaint.setColor(Color.BLUE);
        *//*RectF rf = new RectF(0,0,getWidth(),getHeight());
        canvas.drawArc(rf,0,180,false,arcPaint);*//*


        RectF rf2 = new RectF(50,0,getWidth()-50,50);
        canvas.drawRect(rf2,arcPaint);

        arcPaint.setXfermode(null);
        canvas.restoreToCount(layerId);
    }*/


   private Paint paint = null;
    private Bitmap dst = null;
    private Bitmap src = null;

    private void init2() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.FILL);

        //初始化2张大小一样的图片,因为只有一样大的图片src才会影响dst的整个区域
        dst = Bitmap.createBitmap(250, 250, Bitmap.Config.ARGB_8888);
        src = Bitmap.createBitmap(250, 250, Bitmap.Config.ARGB_8888);

        initSrc();
        initDst();
    }

    private void initDst() {
        Canvas canvas = new Canvas(dst);
        paint.setColor(Color.TRANSPARENT);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        canvas.drawPaint(paint);//清空Bitmap内容
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        paint.setColor(Color.YELLOW);
        canvas.drawCircle(100, 100, 100, paint);//绘制黄色的圆
    }

    private void initSrc() {
        Canvas canvas = new Canvas(src);
        paint.setColor(Color.TRANSPARENT);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        canvas.drawPaint(paint);//清空Bitmap内容
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        paint.setColor(Color.BLUE);
        canvas.drawRect(100, 100, 250, 250, paint);//绘制蓝色的矩形
    }

    /*@Override
    protected void onDraw(Canvas canvas) {
        //初始化一张dst图片(黄色的圆)
        initDst();
        //初始化一张src图片（蓝色的矩形）
        initSrc();

        //在dst图片的基础上绘制src图片
        Canvas c = new Canvas(dst);
        paint.setXfermode(xmode);
        c.drawBitmap(src, 0, 0, paint);

        //将最终结果图绘制到canvas
        paint.setXfermode(null);
        canvas.drawBitmap(dst, 0, 0, paint);
    }*/
}

