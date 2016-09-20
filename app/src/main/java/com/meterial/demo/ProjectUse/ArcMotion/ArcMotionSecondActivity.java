package com.meterial.demo.ProjectUse.ArcMotion;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.animation.PathInterpolatorCompat;
import android.transition.ArcMotion;
import android.transition.ChangeBounds;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.meterial.demo.R;

/**
 * Created by zenghao on 16/9/6.
 */
public class ArcMotionSecondActivity extends Activity {

    private TextView mClock;
    private ImageView mLau;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
//        getWindow().setEnterTransition( new Fade() );

        setContentView(R.layout.activity_arcmotion_second);
        mLau = ((ImageView) findViewById(R.id.iv_sec_lau));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setupEnterAnimation(); // 入场动画
//            setupExitAnimation(); // 退场动画
        } else {
//            initViews();
        }
    }





    // 入场动画
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void setupEnterAnimation() {

        ArcMotion arcMotion = new ArcMotion()/*{
            @Override
            public Path getPath(float startX, float startY, float endX, float endY) {
                return super.getPath(endX, startY, startX, endY);
            }
        }*/;
        arcMotion.setMaximumAngle(90);
        arcMotion.setMinimumHorizontalAngle(90f);
        arcMotion.setMinimumVerticalAngle(0f);

        Interpolator interpolatorCompat = PathInterpolatorCompat.create(0.4f, 0, 0.2f,1);

//        Path path = new Path();
//        path.lineTo(0.0f, 0.0f);
//        path.lineTo(0.4f, 0.8f);
//        path.lineTo(0.6f, 0.0f);
//        path.lineTo(1f, 1f);//必须从0,0开始，1,1结束
//        PathInterpolator interpolatorCompat = new PathInterpolator(path);

        ChangeBounds customChangeBounds = new ChangeBounds();
        customChangeBounds.setPathMotion(arcMotion);
        customChangeBounds.setInterpolator(interpolatorCompat);
        customChangeBounds.addTarget(mLau);

        getWindow().setSharedElementEnterTransition(customChangeBounds);


        /*Transition transition = TransitionInflater.from(this).inflateTransition(R.transition.arc1);

        getWindow().setSharedElementEnterTransition(transition);

        *//*transition.addListener(new Transition.TransitionListener() {
            @Override public void onTransitionStart(Transition transition) {

            }

            @Override public void onTransitionEnd(Transition transition) {
                transition.removeListener(this);
//                animateRevealShow();
            }

            @Override public void onTransitionCancel(Transition transition) {

            }

            @Override public void onTransitionPause(Transition transition) {

            }

            @Override public void onTransitionResume(Transition transition) {

            }
        });*/
    }


    // 退出动画
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void setupExitAnimation() {
        /*Fade fade = new Fade();
        getWindow().setReturnTransition(fade);
        fade.setDuration(300);*/

        Transition transition = TransitionInflater.from(this).inflateTransition(R.transition.arc2);

        getWindow().setSharedElementReturnTransition(transition);
    }


    /*// 动画展示
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void animateRevealShow() {
        GuiUtils.animateRevealShow(
                this, mRlContainer,
                mFabCircle.getWidth() / 2, R.color.colorAccent,
                new GuiUtils.OnRevealAnimationListener() {
                    @Override public void onRevealHide() {

                    }

                    @Override public void onRevealShow() {
                        initViews();
                    }
                });
    }



    // 初始化视图
    private void initViews() {
        new Handler(Looper.getMainLooper()).post(() -> {
            Animation animation = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
            animation.setDuration(300);
            mTVContainer.startAnimation(animation);
            mIvClose.setAnimation(animation);
            mTVContainer.setVisibility(View.VISIBLE);
            mIvClose.setVisibility(View.VISIBLE);
        });
    }

    // 退出按钮
    public void backActivity(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            onBackPressed();
        } else {
            defaultBackPressed();
        }
    }

    // 退出事件
    @Override public void onBackPressed() {
        GuiUtils.animateRevealHide(
                this, mRlContainer,
                mFabCircle.getWidth() / 2, R.color.colorAccent,
                new GuiUtils.OnRevealAnimationListener() {
                    @Override
                    public void onRevealHide() {
                        defaultBackPressed();
                    }

                    @Override
                    public void onRevealShow() {

                    }
                });
    }

    // 默认回退
    private void defaultBackPressed() {
        super.onBackPressed();
    }*/

}
