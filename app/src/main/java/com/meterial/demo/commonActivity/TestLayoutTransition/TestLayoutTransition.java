package com.meterial.demo.commonActivity.TestLayoutTransition;

import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import com.meterial.demo.R;

/***
 * LayoutTransition 动态添加元素使用动画 可以所有元素整体动画
 * layoutAnimation 进入动画一次性
 *
 * CHANGE_APPEARING：当ViewGroup中一个新的控件显示时其他控件所执行的动画标志；
 CHANGE_DISAPPEARING：当ViewGroup中一个控件消失时其他控件所执行的动画标志；
 APPEARING：当ViewGroup中一个新的控件显示时所执行的动画标志；
 DISAPPEARING：当ViewGroup中一个控件消失时所执行的动画标志；
 CHANGING：子View在容器中位置改变时的过渡动画，不涉及删除或者添加操作，这个暂时不做介绍了，默认是不开启的。
 */
public class TestLayoutTransition extends AppCompatActivity {

    private LinearLayout mLinearLayout;
    private int num = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_layout_transition);

        mLinearLayout = (LinearLayout) findViewById(R.id.linearLayout);

        LayoutTransition transition = new LayoutTransition();

        //appearing动画
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(null, "translationX", 0f, 100f);
        //disappearing动画
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(null, "rotation", 0f, 90f, 0f);
        /* 这里得额外注意！使用change_appearing和change_disappearing时必须使用PropertyValuesHolder来构建,
        并且必须使用以下4个中的两个，如果相关属性不想变动的话，那么就都设置一样的值，比如（0，0）,另外，如果想要
        动画生效，必须保证开始和结尾的值相同，比如(0,1,0)就是有效的，(100,100)是无效的*/
        PropertyValuesHolder pvhLeft = PropertyValuesHolder.ofInt("left", 0, 0);
        PropertyValuesHolder pvhTop = PropertyValuesHolder.ofInt("top", 0, 0);
        PropertyValuesHolder pvhRight = PropertyValuesHolder.ofInt("right", 0, 0);
        PropertyValuesHolder pvhBottom = PropertyValuesHolder.ofInt("bottom", 0, 0);

        //change_appearing动画
        PropertyValuesHolder animatorA = PropertyValuesHolder.ofFloat("scaleX", 1f, 2f, 1f);
        ObjectAnimator animator3 = ObjectAnimator.ofPropertyValuesHolder(mLinearLayout, pvhLeft,
                pvhTop, pvhRight, pvhBottom, animatorA);

        //change_disappearing动画
        PropertyValuesHolder animatorD = PropertyValuesHolder.ofFloat("scaleX", 1f, 0.5f, 1f);
        ObjectAnimator animator4 = ObjectAnimator.ofPropertyValuesHolder(mLinearLayout, pvhLeft,
                pvhTop, pvhRight, pvhBottom, animatorD);

        //设置各个阶段的动画
        transition.setAnimator(LayoutTransition.APPEARING, animator1);
        transition.setAnimator(LayoutTransition.DISAPPEARING, animator2);
        transition.setAnimator(LayoutTransition.CHANGE_APPEARING, animator3);
        transition.setAnimator(LayoutTransition.CHANGE_DISAPPEARING, animator4);

        //分别设置各类型动画的执行时间，不设置也没关系，系统默认是300ms
        transition.setDuration(LayoutTransition.APPEARING, 500);
        transition.setDuration(LayoutTransition.DISAPPEARING, 500);
        transition.setDuration(LayoutTransition.CHANGE_APPEARING, 1000);
        transition.setDuration(LayoutTransition.CHANGE_DISAPPEARING, 1000);

        //设置change_appearing和change_disappearing时各个子item执行动画的延迟时间
        transition.setStagger(LayoutTransition.CHANGE_APPEARING, 100);
        transition.setStagger(LayoutTransition.CHANGE_DISAPPEARING, 100);

        mLinearLayout.setLayoutTransition(transition);
    }

    public void AddButton(View v) {
        num++;
        Button button = new Button(this);
        button.setText("Button" + num);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams
                .WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        button.setLayoutParams(params);
        mLinearLayout.addView(button, 1);
    }

    public void DeleteButton(View v) {
        if (num > 0) {
            mLinearLayout.removeViewAt(1);
            num--;
        }
    }
}