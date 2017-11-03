package com.meterial.demo.CoordinatorLayout.easeBehavior.ui;

import android.content.Context;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.view.MotionEvent;

/** 
 * Created by gjm on 2017/5/26. 
 * Func: 
 */ 
 
public class DisInterceptNestedScrollViewTest16 extends NestedScrollView {
    public DisInterceptNestedScrollViewTest16(Context context) {
        super(context);
        requestDisallowInterceptTouchEvent(true);
    }

    public DisInterceptNestedScrollViewTest16(Context context, AttributeSet attrs) {
        super(context, attrs);
        requestDisallowInterceptTouchEvent(true);
    }

    public DisInterceptNestedScrollViewTest16(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        requestDisallowInterceptTouchEvent(true); 
    } 
 
    @Override 
    public boolean startNestedScroll(int axes) {
        return super.startNestedScroll(axes);
    } 
 
    public boolean dispatchTouchEvent(MotionEvent ev) {
        getParent().requestDisallowInterceptTouchEvent(true); 
        return super.dispatchTouchEvent(ev);
    } 
 
    @Override 
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
                requestDisallowInterceptTouchEvent(true); 
                break; 
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                requestDisallowInterceptTouchEvent(false); 
                break; 
        } 
        return super.onTouchEvent(event);
    } 
 
} 
