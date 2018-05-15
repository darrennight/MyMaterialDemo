package com.meterial.demo.commonActivity.TestLayoutTransition;

import android.animation.Animator;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.meterial.demo.R;

/**
 * https://www.jianshu.com/p/c0581c8202e6
 *
 * @author zenghao
 * @since 2018/5/10 下午5:51
 */
public class TestLayoutTransition2 extends AppCompatActivity {
    private int num = 0;
    private LinearLayout iconGroup = null;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_tran2);
        iconGroup = findViewById(R.id.layout_content);

        initAnim();


        findViewById(R.id.btn_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddButton();
            }
        });

        findViewById(R.id.btn_del).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DeleteButton();
            }
        });

    }

    public void AddButton() {
        num++;
        ImageView button = new ImageView(this);
        button.setImageResource(R.mipmap.ic_launcher);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams
                .WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        button.setLayoutParams(params);
        //iconGroup.addView(button, 1);
        iconGroup.addView(button);
    }

    public void DeleteButton() {
        if (num > 0) {
            iconGroup.removeViewAt(num-1);
            num--;
        }
    }


    private void initAnim() {
        LayoutTransition mTransition = new LayoutTransition();
        mTransition.setDuration(LayoutTransition.CHANGE_APPEARING,100);
        mTransition.setDuration(LayoutTransition.CHANGE_DISAPPEARING,200);
        mTransition.setDuration(LayoutTransition.APPEARING,200);
        mTransition.setDuration(LayoutTransition.DISAPPEARING,100);
        //-----------------------设置动画--------------------
        mTransition.setAnimator(LayoutTransition.APPEARING,getInAnim());
        mTransition.setAnimator(LayoutTransition.DISAPPEARING,getOutAnim());
        //---------------------------------------------------
        mTransition.setStartDelay(LayoutTransition.CHANGE_APPEARING,0);
        mTransition.setStartDelay(LayoutTransition.APPEARING,0);
        mTransition.setStartDelay(LayoutTransition.DISAPPEARING,0);
        mTransition.setStartDelay(LayoutTransition.CHANGE_DISAPPEARING,50);
        //----viewgroup绑定----
        iconGroup.setLayoutTransition(mTransition);
    }


    private Animator getInAnim() {

        PropertyValuesHolder trX = PropertyValuesHolder.ofFloat(View.TRANSLATION_X,100f, 0f);
        PropertyValuesHolder trY = PropertyValuesHolder.ofFloat(View.TRANSLATION_Y,0f, 0f);
        PropertyValuesHolder trAlpha = PropertyValuesHolder.ofFloat(View.ALPHA, 0f,1f);
        return ObjectAnimator.ofPropertyValuesHolder(this,trY,trAlpha,trX);
    }


    private Animator getOutAnim() {
        PropertyValuesHolder trY2 = PropertyValuesHolder.ofFloat(View.TRANSLATION_Y,0f, -100f);
        PropertyValuesHolder trX = PropertyValuesHolder.ofFloat(View.TRANSLATION_X,0f, 0f);
        PropertyValuesHolder trAlpha2 = PropertyValuesHolder.ofFloat(View.ALPHA,1f, 0f);
        return ObjectAnimator.ofPropertyValuesHolder(this,trY2,trAlpha2,trX);
    }


}
