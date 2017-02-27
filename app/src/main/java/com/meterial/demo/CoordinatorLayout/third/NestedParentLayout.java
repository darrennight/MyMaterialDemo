package com.meterial.demo.CoordinatorLayout.third;

import android.content.Context;
import android.support.v4.view.NestedScrollingParent; 
import android.support.v4.view.NestedScrollingParentHelper; 
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
 
 
public class NestedParentLayout extends FrameLayout implements NestedScrollingParent {
 
 
    private NestedScrollingParentHelper nestedScrollingParentHelper;
 
 
    public NestedParentLayout(Context context) {
        super(context);
        init(); 
    } 
 
    public NestedParentLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(); 
    } 
 
    public NestedParentLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(); 
    } 
 
    private void init() { 
        nestedScrollingParentHelper = new NestedScrollingParentHelper(this);
    } 
 
 
    /** 
     * 父View是否允许嵌套滑动 
     * 
     * @param child            包含嵌套滑动父类的子View 
     * @param target           实现嵌套滑动的子View 
     * @param nestedScrollAxes 嵌套滑动方向，水平竖直或都支持 
     */ 
    @Override 
    public boolean onStartNestedScroll(View child, View target, int nestedScrollAxes) {
        return true; 
    } 
 
    /** 
     * onStartNestedScroll()方法返回true会调用该函数 
     * 参数与onStartNestedScroll一致 
     */ 
    @Override 
    public void onNestedScrollAccepted(View child, View target, int axes) {
        nestedScrollingParentHelper.onNestedScrollAccepted(child, target, axes);
    } 
 
    /** 
     * 嵌套滑动结束时调用 
     * 
     * @param target 实现嵌套滑动的子View 
     */ 
    @Override 
    public void onStopNestedScroll(View target) {
        nestedScrollingParentHelper.onStopNestedScroll(target);
    } 
 
    /** 
     * 嵌套滑动子View的滑动情况(进度) 
     * 
     * @param target       实现嵌套滑动的子View 
     * @param dxConsumed   水平方向上嵌套滑动的子View消耗(滑动)的距离 
     * @param dyConsumed   竖直方向上嵌套滑动的子View消耗(滑动)的距离 
     * @param dxUnconsumed 水平方向上嵌套滑动的子View未消耗(未滑动)的距离 
     * @param dyUnconsumed 竖直方向上嵌套滑动的子View未消耗(未滑动)的距离 
     */ 
    @Override 
    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        super.onNestedScroll(target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
    } 
 
    /** 
     * 嵌套滑动子View滑动之前的准备工作 
     * 
     * @param target   实现嵌套滑动的子View 
     * @param dx       水平方向上嵌套滑动的子View滑动的总距离 
     * @param dy       竖直方向上嵌套滑动的子View滑动的总距离 
     * @param consumed consumed[0]水平方向与consumed[1]竖直方向上父View消耗(滑动)的距离 
     */ 
    @Override 
    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed) {
        super.onNestedPreScroll(target, dx, dy, consumed);
 
 
        //向右滑动 
        if (dx > 0) {
            //滑动到边界 
            if (target.getRight() + dx > getWidth()) {
                dx = target.getRight() + dx - getWidth();
                //父View消耗 
                offsetLeftAndRight(dx);
                consumed[0] += dx;
            } 
        } 
        //向左滑动 
        else { 
            if (target.getLeft() + dx < 0) {
                dx = dx + target.getLeft();
                //父View消耗 
                offsetLeftAndRight(dx);
                consumed[0] += dx;
            } 
        } 
        //向下滑动 
        if (dy > 0) {
            if (target.getBottom() + dy > getHeight()) {
                dy = target.getBottom() + dy - getHeight();
                //父View消耗 
                offsetTopAndBottom(dy);
                consumed[1] += dy;
            } 
        } 
        //向上滑动 
        else { 
            if (target.getTop() + dy < 0) {
                dy = dy + target.getTop();
                //父View消耗 
                offsetTopAndBottom(dy);
                consumed[1] += dy;
            } 
        } 
 
    } 
 
    /** 
     * 嵌套滑动子View的fling(滑行)情况 
     * 
     * @param target    实现嵌套滑动的子View 
     * @param velocityX 水平方向上的速度 
     * @param velocityY 竖直方向上的速度 
     * @param consumed  子View是否消耗fling 
     * @return true 父View是否消耗了fling 
     */ 
    @Override 
    public boolean onNestedFling(View target, float velocityX, float velocityY, boolean consumed) {
        return super.onNestedFling(target, velocityX, velocityY, consumed);
    } 
 
 
    /** 
     * 嵌套滑动子View fling(滑行)前的准备工作 
     * 
     * @param target    实现嵌套滑动的子View 
     * @param velocityX 水平方向上的速度 
     * @param velocityY 竖直方向上的速度 
     * @return true 父View是否消耗了fling 
     */ 
    @Override 
    public boolean onNestedPreFling(View target, float velocityX, float velocityY) {
        return super.onNestedPreFling(target, velocityX, velocityY);
    } 
 
    /** 
     * 嵌套滑动方向 
     * 
     * @return 水平竖直或都支持 
     */ 
    @Override 
    public int getNestedScrollAxes() { 
        return nestedScrollingParentHelper.getNestedScrollAxes();
    } 
} 