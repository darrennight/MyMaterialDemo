package com.meterial.demo.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import com.meterial.demo.MDTransition.TestActivity;
import com.meterial.demo.R;

/**
 * Created by zenghao on 16/2/18.
 */
public class TransitionMainActivity extends Activity {
    //    Fade替换成Slide或者Explode

    /*enter：用于决定第一次打开当前Activity时的动画
    exit : 用于决定退出当前Activity时的动画
    reenter: 用于决定如果当前Activity已经打开过，并且再次打开该Activity时的动画
    shared elements:用于决定在两个Activity之间切换时，指定两个Activity中对应的View的过渡效果
    */

    private ImageView shareimg;
    private Button mAll;
    private Button mFirst;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);
        mFirst = ((Button) findViewById(R.id.myView));
        shareimg = (ImageView) findViewById(R.id.iv_shareIMG);
        shareimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareImg();
            }
        });
        mAll = ((Button) findViewById(R.id.btn_clic3));
        mAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareAll();
            }
        });

    }
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void ceshi(View view) {
        Intent intent = new Intent(TransitionMainActivity.this, TestActivity.class);
        startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(this, mFirst, "tanck").toBundle());
    }


    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void shareImg() {
        Intent intent = new Intent(TransitionMainActivity.this, TestActivity.class);
        startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(this, shareimg, "shareimg").toBundle());
    }


    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void shareAll() {
        Pair pair1 = new Pair(mFirst, "tanck");
        Pair pair2 = new Pair(shareimg, "shareimg");
        Pair pair3 = new Pair(mAll,"things");
//        Pair.create(view1, "agreedName1")
        Intent intent = new Intent(TransitionMainActivity.this, TestActivity.class);

        ActivityOptionsCompat transitionActivityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(this,pair1,pair2,pair3);

        ActivityCompat.startActivity(this,intent, transitionActivityOptions.toBundle());

    }

}
