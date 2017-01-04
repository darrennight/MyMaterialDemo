package com.meterial.demo.CoordinatorLayout.Behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 *
 *某个view监听另一个view的 状态变化，例如大小、位置、显示状态等
 * layoutDependsOn和onDependentViewChanged方法，
 *
 * 某个view监听CoordinatorLayout里的 滑动状态
 * onStartNestedScroll和onNestedPreScroll方法。
 * @author zenghao
 * @since 16/12/30 下午4:27
 */
public class MyScrollBeHavior extends CoordinatorLayout.Behavior {



    public MyScrollBeHavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**这里的返回值表明这次滑动我们要不要关心，我们要关心什么样的滑动？当然是y轴方向上的。*/
    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int nestedScrollAxes) {
        return (nestedScrollAxes & ViewCompat.SCROLL_AXIS_VERTICAL) != 0;
        //返回true才能有效
        //nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL
    }

    /**第一个参数布局父类CoordinatorLayout 第二个参数 设置了这个behavior到view*/
    /**第三个参数就是我们依赖的条件的view 也就是点击的那个view*/
    // 参数dx:表示target本次滚动产生的x方向的滚动总距离
    // 参数dy:表示target本次滚动产生的y方向的滚动总距离
    // 参数consumed:表示父布局要消费的滚动距离,consumed[0]和consumed[1]分别表示父布局在x和y方向上消费的距离.
    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dx, int dy, int[] consumed) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed);




    }


    // 参数dxConsumed:表示target已经消费的x方向的距离
    // 参数dyConsumed:表示target已经消费的x方向的距离
    // 参数dxUnconsumed:表示x方向剩下的滑动距离
    // 参数dyUnconsumed:表示y方向剩下的滑动距离
    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, View child, View target,int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed,
                dyUnconsumed);
        Log.e("====dx",dxConsumed+"=="+dxUnconsumed);
        int leftScrolled = target.getScrollY();
        child.setScrollY(leftScrolled);


        /*
        if (dyConsumed > 0 && dyUnconsumed == 0) {
            System.out.println("上滑中。。。");
        }
        if (dyConsumed == 0 && dyUnconsumed > 0) {
            System.out.println("到边界了还在上滑。。。");
        }
        if (dyConsumed < 0 && dyUnconsumed == 0) {
            System.out.println("下滑中。。。");
        }
        if (dyConsumed == 0 && dyUnconsumed < 0) {
            System.out.println("到边界了，还在下滑。。。");
        }*/
    }

    @Override
    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, View child, View target,
            float velocityX, float velocityY) {
        return super.onNestedPreFling(coordinatorLayout, child, target, velocityX, velocityY);
    }

    @Override
    public boolean onNestedFling(CoordinatorLayout coordinatorLayout, View child, View target,
            float velocityX, float velocityY, boolean consumed) {
        ((NestedScrollView) child).fling((int)velocityY);
        return true;
        //return super.onNestedFling(coordinatorLayout, child, target, velocityX, velocityY,
        //        consumed);
    }
}
