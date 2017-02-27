package com.meterial.demo.CoordinatorLayout.third;
 
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.ScrollView;
 
/** 
 * Created by tangyangkai on 16/9/23. 
 */ 
 
//public class MyParentView extends LinearLayout { 
// 
//    private int mMove; 
//    private int yDown, yMove; 
//    private boolean isIntercept; 
//    private int i = 0; 
//    private MyScrollView myScrollView; 
//    private boolean isOnTop; 
// 
// 
//    public MyParentView(Context context, AttributeSet attrs) { 
//        super(context, attrs); 
//    } 
// 
//    @Override 
//    protected void onFinishInflate() { 
//        super.onFinishInflate(); 
//        myScrollView = (MyScrollView) getChildAt(0); 
//        myScrollView.setListener(new MyScrollView.scrollTopListener() { 
//            @Override 
//            public void scrollTop() { 
//                isOnTop = true; 
//            } 
//        }); 
//    } 
// 
//    @Override 
//    public boolean onInterceptTouchEvent(MotionEvent event) { 
// 
//        int y = (int) event.getY(); 
// 
//        switch (event.getAction()) { 
//            case MotionEvent.ACTION_DOWN: 
//                yDown = y; 
//                break; 
//            case MotionEvent.ACTION_MOVE: 
//                yMove = y; 
//                //上滑 
//                if (yMove - yDown < 0) { 
//                    isIntercept = false; 
//                    //下滑 
//                } else if (yMove - yDown > 0) { 
//                    isIntercept = true; 
//                } 
//                break; 
//            case MotionEvent.ACTION_UP: 
//                break; 
// 
//        } 
//        return isIntercept; 
//    } 
// 
// 
//    @Override 
//    public boolean onTouchEvent(MotionEvent event) { 
//        int y = (int) event.getY(); 
//        switch (event.getAction()) { 
// 
//            case MotionEvent.ACTION_DOWN: 
//                yDown = y; 
//                break; 
//            case MotionEvent.ACTION_MOVE: 
//                yMove = y; 
//                if (isOnTop) { 
//                    yDown = y; 
//                    isOnTop = false; 
//                } 
//                if (isIntercept && (yMove - yDown) > 0) { 
//                    mMove = yMove - yDown; 
//                    i += mMove; 
//                    layout(getLeft(), getTop() + mMove, getRight(), getBottom() + mMove); 
//                } 
//                break; 
//            case MotionEvent.ACTION_UP: 
//                layout(getLeft(), getTop() - i, getRight(), getBottom() - i); 
//                i = 0; 
//                isIntercept = false; 
//                break; 
//        } 
// 
//        return true; 
//    } 
// 
// 
//} 
 
public class MyParentView extends LinearLayout {
 
    private int mMove;
    private int yDown, yMove;
    private int i = 0;
    private boolean isIntercept = false;
 
    public MyParentView(Context context) {
        super(context);
    } 
 
    public MyParentView(Context context, AttributeSet attrs) {
        super(context, attrs);
    } 
 
    public MyParentView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    } 
 
    private ScrollView scrollView;
 
    @Override 
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        scrollView = (ScrollView) getChildAt(0);
    } 
 
    @Override 
    public boolean dispatchTouchEvent(MotionEvent ev) {
        onInterceptTouchEvent(ev);
        return super.dispatchTouchEvent(ev);
    } 
 
    @Override 
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int y = (int) ev.getY();
        int mScrollY = scrollView.getScrollY();
 
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                yDown = y;
                break; 
            case MotionEvent.ACTION_MOVE:
                yMove = y;
                if (yMove - yDown > 0 && mScrollY == 0) {
                    if (!isIntercept) {
                        yDown = (int) ev.getY();
                        isIntercept = true;
                    } 
                } 
                break; 
            case MotionEvent.ACTION_UP:
                layout(getLeft(), getTop() - i, getRight(), getBottom() - i);
                i = 0;
                isIntercept = false;
                break; 
        } 
        if (isIntercept) {
            mMove = yMove - yDown;
            i += mMove;
            layout(getLeft(), getTop() + mMove, getRight(), getBottom() + mMove);
        } 
        return isIntercept;
    } 
} 