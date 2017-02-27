package com.meterial.demo.CoordinatorLayout.third;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity; 
import android.os.Bundle;
 
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.meterial.demo.R;

public class SecondActivity extends AppCompatActivity { 
 
 
    private Button testBtn, fourBtn, fiveBtn, thirdBtn, sixBtn, sevenBtn;
    private TextView textView;
 
    @Override 
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        init(); 
    } 
 
    private void init() { 
        testBtn = (Button) findViewById(R.id.second_btn);
        textView = (TextView) findViewById(R.id.second_txt);
        testBtn.setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
 
 
                //textView.layout(textView.getLeft() + 50, textView.getTop() + 50, textView.getRight() + 50, textView.getBottom() + 50); 
 
//                textView.offsetTopAndBottom(50); 
//                textView.offsetLeftAndRight(50); 
 
 
//                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams(); 
//                layoutParams.leftMargin = textView.getLeft() + 50; 
//                layoutParams.topMargin = textView.getTop() + 50; 
//                textView.setLayoutParams(layoutParams); 
 
//                linearLayout.scrollBy(-50, -50); 
 
// 
//                TranslateAnimation translateAnimation = new TranslateAnimation(0, 200, 0, 200); 
//                translateAnimation.setDuration(1000); 
//                translateAnimation.setFillAfter(true); 
//                textView.startAnimation(translateAnimation); 
 
 
//                AnimatorSet set = new AnimatorSet(); 
//                set.playTogether( 
//                        ObjectAnimator.ofFloat(textView, "translationX", 0, 100), 
//                        ObjectAnimator.ofFloat(textView, "translationY", 0, 100) 
// 
//                ); 
//                set.start(); 
 
 
                Log.e("log", "测试文字的getTop():" + textView.getTop());
                Log.e("log", "测试文字的getBottom():" + textView.getBottom());
                Log.e("log", "测试文字的getLeft():" + textView.getLeft());
                Log.e("log", "测试文字的getRight():" + textView.getRight());
            } 
        }); 
 
        textView.setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "测试文字的点击事件", Toast.LENGTH_SHORT).show();
            } 
        }); 
 
        thirdBtn = (Button) findViewById(R.id.third_btn);
        thirdBtn.setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ThirdActivity.class));
            } 
        }); 
 
        fourBtn = (Button) findViewById(R.id.four_btn);
        fourBtn.setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), FourActivity.class));
            } 
        }); 
 
        fiveBtn = (Button) findViewById(R.id.five_btn);
        fiveBtn.setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), FiveActivity.class));
            } 
        }); 
 
        sixBtn = (Button) findViewById(R.id.six_btn);
        sixBtn.setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SixActivity.class));
            } 
        }); 
 
        sevenBtn = (Button) findViewById(R.id.seven_btn);
        sevenBtn.setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SevenActivity.class));
            } 
        }); 
    } 
 
 
} 