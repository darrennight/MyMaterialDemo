package com.meterial.demo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.transition.Slide;
import android.view.Gravity;
import android.view.Window;

import com.meterial.demo.R;

/**
 * Created by zenghao on 16/2/18.
 * explode(分解)
 * slide(滑动)
 * fade(淡出)
 */
public class TransitionActivity2 extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setupWindowAnimations();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition2);

    }

    private void setupWindowAnimations() {

//        Explode explode = new Explode();
//        explode.setDuration(2000);
        //退出
//        getWindow().setExitTransition(explode);

//        getWindow().setEnterTransition(explode);
//
//        Fade fade = new Fade();
//        fade.setDuration(2000);
//        getWindow().setReturnTransition(fade);


        Slide slideTransition = new Slide();
        slideTransition.setSlideEdge(Gravity.BOTTOM);
        slideTransition.setDuration(2000);
        //进入
        getWindow().setEnterTransition(slideTransition);

        getWindow().setReenterTransition(slideTransition);
        getWindow().setExitTransition(slideTransition);
    }
}
