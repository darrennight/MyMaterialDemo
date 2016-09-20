package com.meterial.demo.svg;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.meterial.demo.R;

/**
 * Created by zenghao on 16/5/18.
 */
public class SvgActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_svg);

        ImageView mImageView = (ImageView) findViewById(R.id.imageView);
        //得到对应的AnimatedVectorDrawable对象
//        AnimatedVectorDrawable mAnimatedVectorDrawable =  (AnimatedVectorDrawable) getResources().getDrawable(R.drawable.heart_animator);
        Drawable mAnimatedVectorDrawable =getResources().getDrawable(R.drawable.heart_animator);
        mImageView.setImageDrawable(mAnimatedVectorDrawable);
        if(mAnimatedVectorDrawable!=null){
            //mAnimatedVectorDrawable.start();
            ((Animatable) mAnimatedVectorDrawable).start();
        }

        ImageView androidImageView = (ImageView) findViewById(R.id.android);
        Drawable drawable = androidImageView.getDrawable();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        }


        ImageView iv_one_start = (ImageView) findViewById(R.id.iv_one_start);
        Drawable drawable1 = iv_one_start.getDrawable();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable1).start();
        }
    }
}
