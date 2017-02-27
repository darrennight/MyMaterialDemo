package com.meterial.demo.CoordinatorLayout.third;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v4.view.NestedScrollingChild; 
import android.support.v4.view.NestedScrollingChildHelper; 
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
 
/** 
 * Created by tangyangkai on 2017/2/7. 
 */ 
 
public class NestedChildLayout extends View implements NestedScrollingChild {
 
    private NestedScrollingChildHelper nestedScrollingChildHelper;
    private int mRadius;
    private Paint mPaint;
    private int mDownX, mDownY;
    private int[] consumed = new int[2];//消耗的距离
    private int[] offsetInWindow = new int[2];//窗口偏移
 
    public NestedChildLayout(Context context) {
        super(context);
        init(); 
    } 
 
    public NestedChildLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(); 
    } 
 
    public NestedChildLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(); 
    } 
 
    private void init() { 
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.GREEN);
        nestedScrollingChildHelper = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true); 
    } 
 
 
    @Override 
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                mDownX = x;
                mDownY = y;
                //通知父View开始嵌套滑动，并设置滑动方向 
                startNestedScroll(ViewCompat.SCROLL_AXIS_HORIZONTAL | ViewCompat.SCROLL_AXIS_VERTICAL);
                break; 
            } 
            case MotionEvent.ACTION_MOVE: {
                int dx = x - mDownX;
                int dy = y - mDownY;
 
                //如果父View处理滑动事件 
                if (dispatchNestedPreScroll(dx, dy, consumed, offsetInWindow)) {
                    //减去父View消耗的距离 
                    dx -= consumed[0];
                    dy -= consumed[1];
                } 
                offsetLeftAndRight(dx);
                offsetTopAndBottom(dy);
 
                break; 
            } 
 
            case MotionEvent.ACTION_UP: {
                //结束嵌套滑动 
                stopNestedScroll(); 
                break; 
            } 
        } 
 
        return true; 
    } 
 
 
    @Override 
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        mRadius = getWidth() / 2;
    } 
 
    @Override 
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
 
        canvas.translate(mRadius, mRadius);
        canvas.drawCircle(0, 0, mRadius, mPaint);
    } 
 
    /** 
     * 设置是否支持嵌套滑动 
     * 
     * @param enabled true与false表示支持与不支持 
     */ 
    @Override 
    public void setNestedScrollingEnabled(boolean enabled) {
        nestedScrollingChildHelper.setNestedScrollingEnabled(enabled);
    } 
 
    /** 
     * 判断嵌套滑动是否可用 
     * 
     * @return true表示支持嵌套滑动 
     */ 
    @Override 
    public boolean isNestedScrollingEnabled() { 
        return nestedScrollingChildHelper.isNestedScrollingEnabled();
    } 
 
    /** 
     * 开始嵌套滑动 
     * 
     * @param axes 方向轴，水平方向与竖直方向 
     * @return 
     */ 
    @Override 
    public boolean startNestedScroll(int axes) {
        return nestedScrollingChildHelper.startNestedScroll(axes);
    } 
 
    /** 
     * 停止嵌套滑动 
     */ 
    @Override 
    public void stopNestedScroll() { 
        nestedScrollingChildHelper.stopNestedScroll();
    } 
 
    /** 
     * 判断父View是否支持嵌套滑动 
     * 
     * @return true与false表示支持与不支持 
     */ 
    @Override 
    public boolean hasNestedScrollingParent() { 
        return nestedScrollingChildHelper.hasNestedScrollingParent();
    } 
 
    /** 
     * 处理滑动事件 
     * 
     * @param dxConsumed     水平方向上消耗(滑动)的距离 
     * @param dyConsumed     竖直方向上消耗(滑动)的距离 
     * @param dxUnconsumed   水平方向上未消耗(未滑动)的距离 
     * @param dyUnconsumed   竖直方向上未消耗(未滑动)的距离 
     * @param offsetInWindow 窗体偏移量 
     * @return true表示事件已经分发，false表示没有分发 
     */ 
    @Override 
    public boolean dispatchNestedScroll(int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int[] offsetInWindow) {
        return nestedScrollingChildHelper.dispatchNestedScroll(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow);
    } 
 
    /** 
     * 处理滑动事件前的准备工作 
     * 
     * @param dx             水平方向上滑动的距离 
     * @param dy             竖直方向上滑动的距离 
     * @param consumed       父view消耗的距离 
     * @param offsetInWindow 窗体偏移量 
     * @return 父View是否处理了嵌套滑动 
     */ 
    @Override 
    public boolean dispatchNestedPreScroll(int dx, int dy, int[] consumed, int[] offsetInWindow) {
        return nestedScrollingChildHelper.dispatchNestedPreScroll(dx, dy, consumed, offsetInWindow);
    } 
 
    /** 
     * fling(滑行)时调用 
     * 
     * @param velocityX 水平方向上的速度 
     * @param velocityY 竖直方向上的速度 
     * @param consumed  是否被消耗 
     * @return true表示被消耗，false反之 
     */ 
    @Override 
    public boolean dispatchNestedFling(float velocityX, float velocityY, boolean consumed) {
        return nestedScrollingChildHelper.dispatchNestedFling(velocityX, velocityY, consumed);
    } 
 
    /** 
     * fling(滑行)前的准备工作 
     * 
     * @param velocityX 水平方向上的速度 
     * @param velocityY 竖直方向上的速度 
     * @return true表示被消耗，false反之 
     */ 
    @Override 
    public boolean dispatchNestedPreFling(float velocityX, float velocityY) {
        return nestedScrollingChildHelper.dispatchNestedPreFling(velocityX, velocityY);
    } 
} 