package com.meterial.demo.ProjectUse.seneFragment;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
 * Created by zenghao on 16/9/7.
 */
public class TestSceneFragmentActivity extends AppCompatActivity {

    private TransitionManager mTransitionManager;
    private Scene mScene1;
    private Scene mScene2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scene_fragment);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction().add(R.id.container, new TestSceneFragment()).commit();
        }

        initScene();
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    private void initScene(){
        ViewGroup container = (ViewGroup)findViewById(R.id.container);
        TransitionInflater transitionInflater = TransitionInflater.from(this);
        mTransitionManager = transitionInflater.inflateTransitionManager(R.transition.transition_manager, container);

        mScene1 = Scene.getSceneForLayout(container, R.layout.fragment_test_scene1, this);
        mScene2 = Scene.getSceneForLayout(container, R.layout.fragment_test_scene2, this);

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
