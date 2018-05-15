package com.meterial.demo.test.DiDi;

import android.os.Bundle;
import android.support.animation.DynamicAnimation;
import android.support.animation.FlingAnimation;
import android.support.animation.FloatPropertyCompat;
import android.support.animation.SpringAnimation;
import android.support.animation.SpringForce;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import com.meterial.demo.R;

/**
 *
 * @author zenghao
 * @since 2018/4/16 下午5:18
 */
public class DiDiAnimationActivity extends AppCompatActivity {

    private LinearLayout mIcon = null;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_di_di_anim);
        mIcon = findViewById(R.id.layout_icon);

        //test1();
        test2();
        //test3();
        //test4();
        //test5();
        //test6();
    }

    private void test1(){
        Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake_didi);
        mIcon.startAnimation(shake);
    }

    /***
     * 自己设置系数 效果可以
     */
    private void test2(){
        ShakeAnimation.create().with(mIcon)
                .setDuration(2000)
                .start();
    }
    /**
     * 滑动
     * */
    private void test3(){
        final FlingAnimation flingAnimation = new FlingAnimation(mIcon, DynamicAnimation.Y);
        flingAnimation.setStartVelocity(500f);//设置初速度
        flingAnimation.setFriction(0.5f);//设置摩擦力
        flingAnimation.start();
    }

    /**
     * SpringAnimation.TRANSLATION_Y 等价 DynamicAnimation.Y
     */
    private void test4(){
        final SpringAnimation springAnimation = new SpringAnimation(mIcon, DynamicAnimation.TRANSLATION_Y,mIcon.getY());


        final SpringForce springForce = new SpringForce();
        //dampingRatio越大，摆动次数越少
        springForce.setDampingRatio(SpringForce.DAMPING_RATIO_HIGH_BOUNCY);
        //stiffness值越小，弹簧越容易摆动，摆动的时间越长
        //springForce.setStiffness(SpringForce.STIFFNESS_VERY_LOW);
        springForce.setStiffness(100);
        //最终位置
        //指定最后静止时的位置
        springForce.setFinalPosition(mIcon.getY());




        springAnimation.setSpring(springForce);

        //初始速度
        springAnimation.setStartVelocity(2000);

        springAnimation.start();
    }

    private void test5(){
        SpringAnimation springAnimation = new SpringAnimation(mIcon, DynamicAnimation.Y);

        SpringForce springForce = new SpringForce();

        springForce.setDampingRatio(SpringForce.DAMPING_RATIO_HIGH_BOUNCY);
        springForce.setStiffness(SpringForce.STIFFNESS_LOW);
        springForce.setFinalPosition(mIcon.getY());

        springAnimation.setSpring(springForce);
        springAnimation.setStartVelocity(2000);
        springAnimation.start();

        //img.setImageResource(R.drawable.ic_sentiment_very_satisfied_black_56dp);
        /*springAnimation.addEndListener(new DynamicAnimation.OnAnimationEndListener() {
            @Override
            public void onAnimationEnd(DynamicAnimation animation, boolean canceled, float value, float velocity) {
                img.setImageResource(R.drawable.ic_sentiment_neutral_black_56dp);
            }
        });*/
    }


    private void test6(){
        FloatPropertyCompat<View> scale = new FloatPropertyCompat<View>("scale") {

            @Override
            public float getValue(View view) {
                return view.getScaleX();
            }

            @Override
            public void setValue(View view, float value) {
                view.setScaleX(value);
                view.setScaleY(value);
            }
        };

        SpringAnimation stretchAnimation =
                new SpringAnimation(mIcon, scale);
        stretchAnimation.setMinimumVisibleChange(
                DynamicAnimation.MIN_VISIBLE_CHANGE_SCALE);

        SpringForce force = new SpringForce(1);
        force.setDampingRatio(SpringForce.DAMPING_RATIO_HIGH_BOUNCY)
                .setStiffness(SpringForce.STIFFNESS_VERY_LOW);

        stretchAnimation.setSpring(force)
                .setStartVelocity(100);

        stretchAnimation.start();
    }

}
