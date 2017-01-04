package com.meterial.demo.CoordinatorLayout.Behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

/**
 * TODO
 * 某个view监听另一个view的状态变化，例如大小、位置、显示状态等
 * layoutDependsOn和onDependentViewChanged方法，
 *
 * 某个view监听CoordinatorLayout里的滑动状态
 * onStartNestedScroll和onNestedPreScroll方法。
 *
 * @author zenghao
 * @since 16/12/30 下午2:55
 */
public class MyBehavior extends CoordinatorLayout.Behavior {

    public MyBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return dependency instanceof TextView;
    }

    /**第一个参数布局父类CoordinatorLayout 第二个参数 设置了这个behavior到view  第三个是我们关心的那个View也就是我们需要处理什么样到viewl ayoutDependsOn的返回值决定了一切*/
    /**第三个参数就是我们依赖的条件的view 也就是点击的那个view*/
    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        //ViewCompat.offsetLeftAndRight();
        int offset = dependency.getTop() - child.getTop();
        ViewCompat.offsetTopAndBottom(child, offset);
        return true;
    }
}
