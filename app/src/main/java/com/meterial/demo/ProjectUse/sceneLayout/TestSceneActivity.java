package com.meterial.demo.ProjectUse.sceneLayout;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

import com.meterial.demo.R;

/**
 * Created by zenghao on 16/9/7.
 */
public class TestSceneActivity extends AppCompatActivity {

    private FrameLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scene_layout);
        container = (FrameLayout) findViewById(R.id.container);

        setupToolbar();
        setLollipopAnimator();
    }

    private void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.app_name);
        }
    }

    private void setLollipopAnimator() {
        LollipopSceneAnimator.newInstance(this, container, R.layout.scene1, R.layout.scene2, R.transition.arc1);
    }
}
