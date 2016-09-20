package com.meterial.demo.scene;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Fade;
import android.transition.Scene;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.meterial.demo.R;

/**
 * transition = new AutoTransition(); // 或者使用new Fade()
 transition.setDuration(2000);
 transition.setInterpolator(new AccelerateDecelerateInterpolator());


 系统自带transition AutoTransition Fade ChangeBounds
 */
public class TransitionActivity extends Activity {
    private TransitionManager mTransitionManager;
    private Scene mScene1;
    private Scene mScene2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition_scene);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new TransitionFragment())
                    .commit();
        }

        initScene();
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    private void initScene(){
        ViewGroup container = (ViewGroup)findViewById(R.id.container);
        TransitionInflater transitionInflater = TransitionInflater.from(this);
        mTransitionManager = transitionInflater.inflateTransitionManager(R.transition.transition_manager, container);
        mScene1 = Scene.getSceneForLayout(container, R.layout.fragment_transition_scene_1, this);
        mScene2 = Scene.getSceneForLayout(container, R.layout.fragment_transition_scene_2, this);

//        Transition mFadeTransition = new Fade();
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public void goToScene1(View view) {
        mTransitionManager.transitionTo(mScene1);
    }


    @TargetApi(Build.VERSION_CODES.KITKAT)
    public void goToScene2(View view) {
        mTransitionManager.transitionTo(mScene2);
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    private void goToScene(Scene scene) {
        ChangeBounds changeBounds = new ChangeBounds();
        Fade fadeOut = new Fade(Fade.OUT);
        Fade fadeIn = new Fade(Fade.IN);
        TransitionSet transition = new TransitionSet();
        transition.setOrdering(TransitionSet.ORDERING_SEQUENTIAL);
        transition
                .addTransition(fadeOut)
                .addTransition(changeBounds)
                .addTransition(fadeIn);
        TransitionManager.go(scene, transition);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.transition, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}