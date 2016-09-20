package com.meterial.demo.MDesign;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.SwipeDismissBehavior;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.LinearLayout;

import com.meterial.demo.R;

/**
 * Created by zenghao on 16/8/2.
 */
public class BehaviorActivity1 extends AppCompatActivity {

    private Button btn;
    private LinearLayout tabLayout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_behavior1);
        btn = ((Button) findViewById(R.id.btn_bottom_sheet_control));


        SwipeDismissBehavior swipeDismissBehavior = new SwipeDismissBehavior();
        swipeDismissBehavior.setSwipeDirection(SwipeDismissBehavior.SWIPE_DIRECTION_ANY);
        CoordinatorLayout.LayoutParams coordinatorParams = (CoordinatorLayout.LayoutParams) findViewById(R.id.btn_bottom_sheet_control).getLayoutParams();
        coordinatorParams.setBehavior(swipeDismissBehavior);

        /*// 告诉如果一个视图设置阈值一直拖到足以被关闭。
        swipeDismissBehavior.setDragDismissDistance(0.5F);

        // 最小滑动距离时view的透明度。
        swipeDismissBehavior.setStartAlphaSwipeDistance(0F);

        // 最大滑动距离时biew的透明度。
        swipeDismissBehavior.setEndAlphaSwipeDistance(0.5F);

        // 阀值，也就是敏感度。
        swipeDismissBehavior.setSensitivity(0);

        // 滑动方向。
        swipeDismissBehavior.setSwipeDirection(SwipeDismissBehavior.SWIPE_DIRECTION_START_TO_END);*/


        tabLayout = ((LinearLayout) findViewById(R.id.tab_layout));
    }
}
