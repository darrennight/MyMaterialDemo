package com.meterial.demo.MDesign;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.meterial.demo.MDesign.demo.MainActivity;
import com.meterial.demo.R;

/**
 * Created by zenghao on 16/8/2.
 */
public class BehaviorMainActivity extends AppCompatActivity{

    private Button btn1;
    private Button btn2;
    private Button btn3;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_behavior_main);
        btn1 = ((Button) findViewById(R.id.btn_bh_1));
        btn2 = ((Button) findViewById(R.id.btn_bh_2));
        btn3 = ((Button) findViewById(R.id.btn_bh_3));
        setListener();
    }
    private void setListener(){
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BehaviorMainActivity.this,BehaviorActivity.class));
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BehaviorMainActivity.this,BehaviorActivity1.class));
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BehaviorMainActivity.this,MainActivity.class));
            }
        });
    }
}
