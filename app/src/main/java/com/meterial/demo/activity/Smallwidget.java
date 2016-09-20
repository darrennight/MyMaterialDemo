package com.meterial.demo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.SwitchCompat;

import com.meterial.demo.R;


/**
 * Created by zenghao on 16/5/18.
 *
 * app:showDividers="beginning|middle|end"属性。
 beginning，middle，end属性值分别指明将在何处添加分割线。
 beginning表示从该LinearLayoutCompat布局的最顶一个子view的顶部开始。
 middle表示在此LinearLayoutCompat布局内的子view之间添加。
 end表示在此LinearLayoutCompat最后一个子view的底部添加分割线
 */
public class Smallwidget extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_small_widget);
        CardView cardView = ((CardView) findViewById(R.id.cv_card));
        SwitchCompat switchCompat = ((SwitchCompat) findViewById(R.id.sc_SwitchCompat));

//        switchCompat.setChecked(true);
//        switchCompat.setEnabled(false);

    }
}
