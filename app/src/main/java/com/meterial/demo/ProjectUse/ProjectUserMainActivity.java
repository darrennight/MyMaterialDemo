package com.meterial.demo.ProjectUse;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
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

import com.meterial.demo.ProjectUse.ArcMotion.ArcMotionActivity;
import com.meterial.demo.ProjectUse.sceneLayout.TestSceneActivity;
import com.meterial.demo.ProjectUse.seneFragment.TestSceneFragmentActivity;
import com.meterial.demo.R;

/**
 * Created by zenghao on 16/9/6.
 */
public class ProjectUserMainActivity extends AppCompatActivity implements View.OnClickListener{

    private FloatingActionButton mFab;
    private FrameLayout mFragmentContainer;
    private RevealedFragment mFragment;
    private Animator mCircularReveal;
    private Animator mCircularRevealSmall;
    private Interpolator mInterpolator;
    private boolean flag;
    private Button mOne;
    private Button mTwo;
    private Button mThree;
    private Button mFourth;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_use);
        mInterpolator = new FastOutSlowInInterpolator();
        initView();
        setListener();
    }

    private void initView(){
        mOne = ((Button) findViewById(R.id.btn_one));
        mTwo = ((Button) findViewById(R.id.btn_two));
        mThree = ((Button) findViewById(R.id.btn_three));
        mFourth = ((Button) findViewById(R.id.btn_fourth));
        mFab = ((FloatingActionButton) findViewById(R.id.fab_reveal));
        mFragmentContainer = ((FrameLayout) findViewById(R.id.frame_container));
    }

    private void setListener(){
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFragment = new RevealedFragment();
                getFragmentManager().beginTransaction().replace(mFragmentContainer.getId(), mFragment).commit();
                revealFragmentContainer(v, mFragmentContainer);
            }
        });
        mOne.setOnClickListener(this);
        mTwo.setOnClickListener(this);
        mThree.setOnClickListener(this);
        mFourth.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_one:
                startActivity(new Intent(this,OneActivity.class));
                break;
            case R.id.btn_two:
                startActivity(new Intent(this, ArcMotionActivity.class));
                break;
            case R.id.btn_three:
                startActivity(new Intent(this, TestSceneActivity.class));
                break;
            case R.id.btn_fourth:
                startActivity(new Intent(this, TestSceneFragmentActivity.class));
                break;
            default:
                break;
        }
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
    private void revealFragmentContainerLollipop(final View clickedView,final View fragmentContainer) {
        if(flag){
            prepareCircularRevealSmall(fragmentContainer);
        }else{
            prepareCircularReveal(clickedView, fragmentContainer);
        }

        clickedView.animate()
                .scaleX(1f)
                .scaleY(1f)
                .setInterpolator(mInterpolator)
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) { }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        if(flag){
                            flag = false;
                            mCircularRevealSmall.start();
                        }else{
                            fragmentContainer.setVisibility(View.VISIBLE);
                            mCircularReveal.start();
                            flag = true;
                        }

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


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void prepareCircularRevealSmall( View targetView) {
        int x = mFragmentContainer.getWidth();
        int y = mFragmentContainer.getHeight();
        int radius = mFragmentContainer.getWidth();


//        float finalRadius = (float) Math.hypot((double) centerX, (double) centerY);

        mCircularRevealSmall = ViewAnimationUtils.createCircularReveal(targetView, x, y, radius,0);

        mCircularRevealSmall.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                mCircularRevealSmall.removeListener(this);
                mFragmentContainer.setVisibility(View.INVISIBLE);
            }
        });
    }


}
