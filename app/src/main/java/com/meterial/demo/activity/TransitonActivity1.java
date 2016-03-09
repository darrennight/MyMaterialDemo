package com.meterial.demo.activity;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.meterial.demo.R;

/**
 * Created by zenghao on 16/2/18.
 */
public class TransitonActivity1 extends Activity {

    private TextView red;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setupWindowAnimations();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition1);
        red = ((TextView) findViewById(R.id.tv_red));
        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                getWindow().setExitTransition( new Explode() );
//                startActivity(new Intent(TransitionMainActivity.this,TransitionActivity2.class));
                startActivity(new Intent(TransitonActivity1.this,TransitionActivity2.class), ActivityOptions.makeSceneTransitionAnimation(TransitonActivity1.this).toBundle());
            }
        });
//        setActionBar();
    }

    private void setupWindowAnimations() {
//        Fade fade = new Fade();
//        fade.setDuration(2000);
//        getWindow().setReenterTransition(fade);

        Slide slideTransition = new Slide();
        slideTransition.setSlideEdge(Gravity.LEFT);
        slideTransition.setDuration(2000);

        getWindow().setEnterTransition(slideTransition);

        Explode explode = new Explode();
        explode.setDuration(2000);
        getWindow().setExitTransition(explode);


        getWindow().setReenterTransition(slideTransition);

        Fade fade = new Fade();
        fade.setDuration(2000);
       getWindow().setReturnTransition(fade);
    }
}
