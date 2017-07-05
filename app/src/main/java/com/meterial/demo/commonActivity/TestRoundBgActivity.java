package com.meterial.demo.commonActivity;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import com.meterial.demo.R;
import com.meterial.demo.Util.MyUtils;

/**
 *
 * @author zenghao
 * @since 2017/4/27 下午5:23
 */
public class TestRoundBgActivity extends AppCompatActivity {

    private TextView mRound;
    private TextView mRound1;
    private TextView mRound2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round_bg);
        mRound = ((TextView) findViewById(R.id.tv_test_round));
        mRound1 = ((TextView) findViewById(R.id.tv_test_round1));
        mRound2 = ((TextView) findViewById(R.id.tv_test_round2));

        Pure();
        Gradient();
        Stroke();
    }


    private void Stroke(){


        GradientDrawable press = new GradientDrawable();
        press.setCornerRadius(MyUtils.dip2px(this,25));
        press.setStroke(MyUtils.dip2px(this,2),Color.parseColor("#67C388"));

        GradientDrawable normal = new GradientDrawable();
        normal.setCornerRadius(MyUtils.dip2px(this,25));
        normal.setStroke(MyUtils.dip2px(this,2),Color.parseColor("#4BBBC8"));


        normal.setColor(Color.YELLOW);

        //#4BBBC8
        //#67C388


        StateListDrawable drawable = new StateListDrawable();


        drawable.addState(new int[]{android.R.attr.state_pressed}, press);
        drawable.addState(new int[0], normal);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            mRound2.setBackground(drawable);
        } else {
            mRound2.setBackgroundDrawable(drawable);
        }

        mRound2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


    private void Gradient(){
        GradientDrawable press = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM
                ,new int[]{Color.parseColor("#4BBBC8")
                ,Color.parseColor("#67C388")
                });
        press.setCornerRadius(MyUtils.dip2px(this,25));


        GradientDrawable normal = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM
                ,new int[]{Color.parseColor("#56cbd8")
                ,Color.parseColor("#7ad199")
                });
        normal.setCornerRadius(MyUtils.dip2px(this,25));
        //normal.setStroke();

        StateListDrawable drawable = new StateListDrawable();


        drawable.addState(new int[]{android.R.attr.state_pressed}, press);
        drawable.addState(new int[0], normal);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            mRound1.setBackground(drawable);
        } else {
            mRound1.setBackgroundDrawable(drawable);
        }

        mRound1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }


    /***
     * 纯颜色 selector
     */
    private void Pure(){
        PaintDrawable normal = new PaintDrawable(Color.parseColor("#FFC107"));
        normal.setCornerRadius(MyUtils.dip2px(this,25));


        PaintDrawable press = new PaintDrawable(Color.parseColor("#ffe65100"));
        press.setCornerRadius(MyUtils.dip2px(this,25));


        StateListDrawable drawable = new StateListDrawable();


        drawable.addState(new int[]{android.R.attr.state_pressed}, press);
        drawable.addState(new int[0], normal);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            mRound.setBackground(drawable);
        } else {
            mRound.setBackgroundDrawable(drawable);
        }

        mRound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
