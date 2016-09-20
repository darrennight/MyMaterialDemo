package com.meterial.demo.ProjectUse.ArcMotion;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.meterial.demo.R;

/**
 * Created by zenghao on 16/9/6.
 */
public class ArcMotionActivity extends Activity {

    private LinearLayout mRightLayout;
    private ImageView mRightLaun;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arcmotion);
        mRightLayout = ((LinearLayout) findViewById(R.id.layout_right));
        mRightLaun = ((ImageView) findViewById(R.id.iv_launcher));
        mRightLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startOtherActivity();
            }
        });
    }


    public void startOtherActivity() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this, mRightLaun, mRightLaun.getTransitionName());
            startActivity(new Intent(this, ArcMotionSecondActivity.class), options.toBundle());

//            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this, mRightLayout, mRightLayout.getTransitionName());
//            startActivity(new Intent(this, ArcMotionSecondActivity.class), options.toBundle());



//            Pair pair2 = new Pair(mRightLayout, mRightLayout.getTransitionName());
//            Pair pair1 = new Pair(mRightLaun, mRightLaun.getTransitionName());
//            Intent intent = new Intent(ArcMotionActivity.this, ArcMotionSecondActivity.class);
//
//            ActivityOptionsCompat transitionActivityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(this,pair1,pair2);
//
//            ActivityCompat.startActivity(this,intent, transitionActivityOptions.toBundle());

        } else {
            startActivity(new Intent(this, ArcMotionSecondActivity.class));
        }
    }
}
