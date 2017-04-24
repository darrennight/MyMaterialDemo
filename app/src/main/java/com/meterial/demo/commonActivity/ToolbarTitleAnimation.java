package com.meterial.demo.commonActivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.meterial.demo.R;

/**
 * https://github.com/pjambo/ToolbarTitleAnimation
 *
 * @author zenghao
 * @since 17/2/28 下午3:07
 */
public class ToolbarTitleAnimation extends AppCompatActivity {


    private TextSwitcher mSwitcher;

    private Toolbar toolbar;
    private Button mSwitch;
    private boolean flag;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar_title);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        final ActionBar ab = getSupportActionBar();
        assert ab != null;
        ab.setDisplayHomeAsUpEnabled(true);

        mSwitch = ((Button) findViewById(R.id.btn_switch));

        mSwitcher = (TextSwitcher) findViewById(R.id.textSwitcher);

        mSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            public View makeView() {
                TextView myText = new TextView(ToolbarTitleAnimation.this);
                myText.setGravity(Gravity.START);
                myText.setTextAppearance(ToolbarTitleAnimation.this, R.style.TitleTextApperance);
                return myText;
            }
        });


        mSwitcher.setText("toolBar");
        final Animation IN_SWIPE_BACKWARD = AnimationUtils.loadAnimation(this, R.anim.tb_slide_in_top);
        final Animation OUT_SWIPE_BACKWARD = AnimationUtils.loadAnimation(this, R.anim.tb_out_bottom);

        final Animation IN_SWIPE_FORWARD = AnimationUtils.loadAnimation(this, R.anim.tb_slide_in_bottom);
        final Animation OUT_SWIPE_FORWARD = AnimationUtils.loadAnimation(this, R.anim.tb_out_top);


        mSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag) {
                    mSwitcher.setInAnimation(IN_SWIPE_FORWARD);
                    mSwitcher.setOutAnimation(OUT_SWIPE_FORWARD);
                    flag = false;
                } else {
                    mSwitcher.setInAnimation(IN_SWIPE_BACKWARD);
                    mSwitcher.setOutAnimation(OUT_SWIPE_BACKWARD);
                    flag = true;
                }
                mSwitcher.setText("toolBar");
            }
        });

    }
}
