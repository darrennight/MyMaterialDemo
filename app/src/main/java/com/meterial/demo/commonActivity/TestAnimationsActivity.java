package com.meterial.demo.commonActivity;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import com.meterial.demo.Animations.FlipAnimation;
import com.meterial.demo.Animations.PulseAnimation;
import com.meterial.demo.Animations.RotateAnimation;
import com.meterial.demo.Animations.ShakeAnimation;
import com.meterial.demo.R;

/**
 *
 * @author zenghao
 * @since 2017/5/1 下午2:32
 */
public class TestAnimationsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_test);

        initRotation();
        initFlip();
        initPulse();
        initShake();
        initTest1();
    }

    private void initShake(){

        final ImageView shakeImage = (ImageView)findViewById(R.id.shake);

        ShakeAnimation.create().with(shakeImage)
                .setDuration(1000)
                //.setRepeatMode(ShakeAnimation.RESTART)
                //.setRepeatCount(ShakeAnimation.INFINITE)
                .start();
    }

    private void initRotation(){

        final ImageView rotationImage = (ImageView)findViewById(R.id.rotation);

        RotateAnimation.create().with(rotationImage)
                .setRepeatCount(RotateAnimation.INFINITE)
                .setRepeatMode(RotateAnimation.RESTART)
                .setDuration(2000)
                .start();
    }

    private void initPulse(){

        final ImageView pulseImage = (ImageView)findViewById(R.id.pulse);

        PulseAnimation.create().with(pulseImage)
                .setDuration(310)
                .setRepeatCount(PulseAnimation.INFINITE)
                .setRepeatMode(PulseAnimation.REVERSE)
                .start();
    }

    private void initFlip(){

        final ImageView flipImage = (ImageView)findViewById(R.id.flip);

        FlipAnimation.create().with(flipImage)
                .setDuration(3600)
                .setRepeatCount(FlipAnimation.INFINITE)
                .start();

    }

    private void initTest1(){
        final ImageView test1 = (ImageView)findViewById(R.id.testAni1);
        tada(test1).start();
    }

    public static ObjectAnimator tada(View view) {
        return tada(view, 10f);
    }
    public static ObjectAnimator tada(View view, float shakeFactor) {

        PropertyValuesHolder pvhScaleX = PropertyValuesHolder.ofKeyframe(View.SCALE_X,
                Keyframe.ofFloat(0f, 1f),
                Keyframe.ofFloat(.1f, .8f),
                Keyframe.ofFloat(.2f, .9f),
                Keyframe.ofFloat(.3f, 1.0f),
                Keyframe.ofFloat(.4f, 1.1f),
                Keyframe.ofFloat(.5f, 1.2f),
                Keyframe.ofFloat(.6f, 1.3f),
                Keyframe.ofFloat(.7f, 1.4f),
                Keyframe.ofFloat(.8f, 1.4f),
                Keyframe.ofFloat(.9f, 1.4f),
                Keyframe.ofFloat(1f, 1f)
        );

        PropertyValuesHolder pvhScaleY = PropertyValuesHolder.ofKeyframe(View.SCALE_Y,
                Keyframe.ofFloat(0f, 1f),
                Keyframe.ofFloat(.1f, .8f),
                Keyframe.ofFloat(.2f, .9f),
                Keyframe.ofFloat(.3f, 1.0f),
                Keyframe.ofFloat(.4f, 1.1f),
                Keyframe.ofFloat(.5f, 1.2f),
                Keyframe.ofFloat(.6f, 1.3f),
                Keyframe.ofFloat(.7f, 1.4f),
                Keyframe.ofFloat(.8f, 1.4f),
                Keyframe.ofFloat(.9f, 1.4f),
                Keyframe.ofFloat(1f, 1f)
        );

        PropertyValuesHolder pvhRotate = PropertyValuesHolder.ofKeyframe(View.ROTATION,
                Keyframe.ofFloat(0f, 0f),
                Keyframe.ofFloat(.1f, -3f * shakeFactor),
                Keyframe.ofFloat(.2f, -3f * shakeFactor),
                Keyframe.ofFloat(.3f, 3f * shakeFactor),
                Keyframe.ofFloat(.4f, -3f * shakeFactor),
                Keyframe.ofFloat(.5f, 3f * shakeFactor),
                Keyframe.ofFloat(.6f, -3f * shakeFactor),
                Keyframe.ofFloat(.7f, 3f * shakeFactor),
                Keyframe.ofFloat(.8f, -3f * shakeFactor),
                Keyframe.ofFloat(.9f, 3f * shakeFactor),
                Keyframe.ofFloat(1f, 0)

        );


        return ObjectAnimator.ofPropertyValuesHolder(view, pvhScaleX, pvhScaleY, pvhRotate).
                setDuration(2000);
    }

    public static ObjectAnimator nope(View view) {
        int delta = view.getResources().getDimensionPixelOffset(R.dimen.spacing_medium);

        PropertyValuesHolder pvhTranslateX = PropertyValuesHolder.ofKeyframe(View.TRANSLATION_X,
                Keyframe.ofFloat(0f, 0),
                Keyframe.ofFloat(.10f, -delta),
                Keyframe.ofFloat(.26f, delta),
                Keyframe.ofFloat(.42f, -delta),
                Keyframe.ofFloat(.58f, delta),
                Keyframe.ofFloat(.74f, -delta),
                Keyframe.ofFloat(.90f, delta),
                Keyframe.ofFloat(1f, 0f)
        );

        return ObjectAnimator.ofPropertyValuesHolder(view, pvhTranslateX).
                setDuration(1000);
    }
}