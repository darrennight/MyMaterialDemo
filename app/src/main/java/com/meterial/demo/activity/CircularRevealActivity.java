package com.meterial.demo.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.meterial.demo.R;
import com.meterial.demo.fragment.CircularRevealedFragment;

/**
 * Created by zenghao on 16/2/18.
 */
public class CircularRevealActivity extends AppCompatActivity {

    private ImageView launcher = null;
    private Button small;
    private Button big;
    private FloatingActionButton mFab;
    private FrameLayout mFragmentContainer;
    private Fragment mFragment;
    private Animator mCircularReveal;
    private Interpolator mInterpolator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circular);
        mInterpolator = new FastOutSlowInInterpolator();
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
        mFragmentContainer = ((FrameLayout) findViewById(R.id.frame_container));
        mFab = ((FloatingActionButton) findViewById(R.id.fab_reveal));
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFragment = new CircularRevealedFragment();
                getFragmentManager().beginTransaction()
                        .replace(mFragmentContainer.getId(), mFragment).commit();
                revealFragmentContainer(v, mFragmentContainer);
            }
        });
    }


    private void revealFragmentContainer(final View clickedView, final View fragmentContainer) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            revealFragmentContainerLollipop(clickedView, fragmentContainer);
        } else {
            fragmentContainer.setVisibility(View.VISIBLE);
            clickedView.setVisibility(View.GONE);
        }
    }


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void revealFragmentContainerLollipop(final View clickedView,
                                                 final View fragmentContainer) {
        prepareCircularReveal(clickedView, fragmentContainer);
        clickedView.animate()
                .scaleX(0f)
                .scaleY(0f)
                .setInterpolator(mInterpolator)
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) { }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        fragmentContainer.setVisibility(View.VISIBLE);
                        mCircularReveal.start();
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) { }

                    @Override
                    public void onAnimationRepeat(Animator animation) { }
                })
                .start();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void prepareCircularReveal(View startView, View targetView) {
        int centerX = (startView.getLeft() + startView.getRight()) / 2;
        int centerY = (startView.getTop() + startView.getBottom()) / 2;
        float finalRadius = (float) Math.hypot((double) centerX, (double) centerY);

        mCircularReveal = ViewAnimationUtils.createCircularReveal(targetView, centerX, centerY, 0, finalRadius);

        mCircularReveal.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                mCircularReveal.removeListener(this);
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
