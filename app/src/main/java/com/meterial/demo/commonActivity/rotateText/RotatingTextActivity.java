package com.meterial.demo.commonActivity.rotateText;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import com.meterial.demo.R;

/**
 * https://github.com/sdsmdg/RotatingText
 *
 * @author zenghao
 * @since 2018/2/12 上午11:25
 */
public class RotatingTextActivity extends AppCompatActivity {
    RotatingTextWrapper rotatingTextWrapper;
    Rotatable rotatable, rotatable2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotating_text);


        rotatingTextWrapper = findViewById(R.id.custom_switcher);
        rotatingTextWrapper.setSize(30);

        rotatable = new Rotatable(Color.parseColor("#FFA036"), 1000, "Word00", "Word01", "Word02");
        rotatable.setSize(25);
        rotatable.setInterpolator(new AccelerateInterpolator());
        rotatable.setAnimationDuration(500);

        rotatable2 = new Rotatable(Color.parseColor("#123456"), 1000, "Word03", "Word04", "Word05");
        rotatable2.setSize(25);
        rotatable2.setInterpolator(new DecelerateInterpolator());
        rotatable2.setAnimationDuration(500);

        rotatingTextWrapper.setContent("? ?", rotatable, rotatable2);

    }
}