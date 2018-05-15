package com.meterial.demo.ObjectAnim.customAnim;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.meterial.demo.R;

/**
 *测试自定义动画
 * @author zenghao
 * @since 2018/5/10 下午4:55
 */
public class TestCustomAnimation extends AppCompatActivity {

    private RelativeLayout mRelativeLayout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_custom_anim);
        Button btn = ( findViewById(R.id.btn_test_anim));
        mRelativeLayout = (RelativeLayout) findViewById(R.id.layout_root);

        CustomAnimation customAnimation = new CustomAnimation();
        customAnimation.setDuration(2000);
        customAnimation.setInterpolator(new LinearInterpolator());
        btn.startAnimation(customAnimation);


        final CustomShakeAnimation ca = new CustomShakeAnimation();
        ca.setDuration(1000);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRelativeLayout.startAnimation(ca);
            }
        });


        final Button btnSwing = findViewById(R.id.btn_swing);
        final CustomSwingAnimation csa = new CustomSwingAnimation();
        csa.setDuration(1000);
        btnSwing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnSwing.startAnimation(csa);

            }
        });

    }
}
