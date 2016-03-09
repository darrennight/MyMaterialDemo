package com.meterial.demo.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.meterial.demo.R;

/**
 * Created by zenghao on 16/2/18.
 */
public class CircularRevealActivity extends AppCompatActivity {

    private ImageView launcher = null;
    private Button small;
    private Button big;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circular);
        launcher = ((ImageView) findViewById(R.id.iv_launcher));
        small = ((Button) findViewById(R.id.btn_small));
        big = ((Button) findViewById(R.id.btn_big));

        small.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideImageCircular(launcher);
            }
        });

        big.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                revealImageCircular();
//                animatorBit();
            }
        });
    }

    private void hideImageCircular(final ImageView launcher) {
        int x = launcher.getWidth()/2;
        int y = launcher.getHeight()/2;
        int radius = launcher.getWidth();

//        view 操作的视图
//        centerX 动画开始的中心点X
//        centerY 动画开始的中心点Y
//        startRadius 动画开始半径
//        startRadius 动画结束半径

//        rect,
//                0,
//                0,
//                0,
//                (float) Math.hypot(rect.getWidth(), rect.getHeight()));

        Animator anim =  ViewAnimationUtils.createCircularReveal(launcher,x,y,radius,0);

        anim.addListener(new AnimatorListenerAdapter() {

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                launcher.setVisibility( View.INVISIBLE );
            }
        });

        anim.start();
    }

    private void revealImageCircular() {
        launcher.setVisibility( View.VISIBLE );
        int x = launcher.getWidth()/2;
        int y = launcher.getHeight()/2;
        int radius = launcher.getWidth();

        Animator anim =  ViewAnimationUtils.createCircularReveal(launcher,x,y,0,radius);

        anim.addListener(new AnimatorListenerAdapter() {

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                launcher.setVisibility( View.VISIBLE );
            }
        });

        anim.start();
    }

    /**
     * 属性动画使用
     */
    private void animatorBit(){
        ObjectAnimator revealAnimator = ObjectAnimator.ofFloat( //缩放X 轴的
                                        launcher, "scaleX", 0, 2);
                      ObjectAnimator revealAnimator1 = ObjectAnimator.ofFloat(//缩放Y 轴的
                launcher, "scaleY", 0, 2);
        AnimatorSet set = new AnimatorSet();
                        set.setDuration(500);
        //设置播放时间set.setInterpolator(new LinearInterpolator());//设置播放模式，这里是平常模式
                        set.playTogether(revealAnimator, revealAnimator1);//设置一起播放
                       set.start();
    }
}
