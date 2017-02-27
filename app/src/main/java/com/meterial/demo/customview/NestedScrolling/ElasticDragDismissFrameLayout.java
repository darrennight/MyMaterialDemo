package com.meterial.demo.customview.NestedScrolling;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.NestedScrollingParent; 
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.meterial.demo.R;

/** 
 * A {@link FrameLayout} which responds to nested scrolls to create drag-dismissable layouts. 
 * Applies an elasticity factor to reduce movement as you approach the given dismiss distance. 
 * Optionally also scales down content during drag. 
 */ 
public class ElasticDragDismissFrameLayout extends FrameLayout implements NestedScrollingParent {
 
    private ElasticDragDismissDelegate mDelegate;
 
    public ElasticDragDismissFrameLayout(Context context) {
        this(context, null, 0);
    } 
 
    public ElasticDragDismissFrameLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    } 
 
    public ElasticDragDismissFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    } 
 
    @TargetApi(21) 
    public ElasticDragDismissFrameLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    } 
 
    private void init(Context context, AttributeSet attrs) {
        final TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.ElasticDragDismissFrameLayout, 0, 0);
        mDelegate = new ElasticDragDismissDelegate(this);
        mDelegate.init(context, a);
        a.recycle();
    } 
 
    @Override 
    public boolean onStartNestedScroll(View child, View target, int nestedScrollAxes) {
        return mDelegate.onStartNestedScroll(child, target, nestedScrollAxes);
    } 
 
    @Override 
    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed) {
        mDelegate.onNestedPreScroll(target, dx, dy, consumed);
    } 
 
    @Override 
    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        mDelegate.onNestedScroll(target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
    } 
 
    @Override 
    public void onStopNestedScroll(View child) {
        mDelegate.onStopNestedScroll(child);
    } 
 
    @Override 
    public void onNestedScrollAccepted(View child, View target, int nestedScrollAxes) {
    } 
 
    @Override 
    public boolean onNestedFling(View target, float velocityX, float velocityY, boolean consumed) {
        return false; 
    } 
 
    @Override 
    public boolean onNestedPreFling(View target, float velocityX, float velocityY) {
        return false; 
    } 
 
    @Override 
    public int getNestedScrollAxes() { 
        return 0; 
    } 
 
    @Override 
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mDelegate.onSizeChanged(w, h, oldw, oldh);
    } 
 
    public void addListener(ElasticDragDismissCallback listener) {
        mDelegate.addListener(listener);
    } 
 
    public void removeListener(ElasticDragDismissCallback listener) {
        mDelegate.removeListener(listener);
    } 
} 