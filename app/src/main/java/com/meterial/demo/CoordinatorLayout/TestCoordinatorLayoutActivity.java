package com.meterial.demo.CoordinatorLayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import com.meterial.demo.R;

/**
 *CoordinatorLayout各种用法
 * @author zenghao
 * @since 16/12/15 下午9:21
 */
public class TestCoordinatorLayoutActivity extends AppCompatActivity {

    private Button mButton1;
    private Button mButton2;
    private Button mButton3;
    private Button mButton4;
    private Button mButton5;
    private Button mButton6;
    private Button mButton7;
    private Button mButton8;
    private Button mButton9;
    private Button mButton10;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_coordinator);
        initViews();
    }

    private void initViews(){
        mButton1 = ((Button) findViewById(R.id.btn_1));
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TestCoordinatorLayoutActivity.this,TestActivity1.class));
            }
        });

        mButton2 = ((Button) findViewById(R.id.btn_2));
        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TestCoordinatorLayoutActivity.this,TestActivity2.class));
            }
        });

        mButton3 = ((Button) findViewById(R.id.btn_3));
        mButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TestCoordinatorLayoutActivity.this,TestActivity3.class));
            }
        });

        mButton4 = ((Button) findViewById(R.id.btn_4));
        mButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TestCoordinatorLayoutActivity.this,TestActivity4.class));
            }
        });

        mButton5 = ((Button) findViewById(R.id.btn_5));
        mButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TestCoordinatorLayoutActivity.this,TestActivity5.class));
            }
        });

        mButton6 = ((Button) findViewById(R.id.btn_6));
        mButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TestCoordinatorLayoutActivity.this,TestActivity6.class));
            }
        });

        mButton7 = ((Button) findViewById(R.id.btn_7));
        mButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TestCoordinatorLayoutActivity.this,TestActivity7.class));
            }
        });


        mButton8 = ((Button) findViewById(R.id.btn_8));
        mButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TestCoordinatorLayoutActivity.this,TestActivity8.class));
            }
        });


        mButton9 = ((Button) findViewById(R.id.btn_9));
        mButton9.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(TestCoordinatorLayoutActivity.this,TestActivity9.class));
                    }
                });


        mButton10 = ((Button) findViewById(R.id.btn_10));
        mButton10.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(TestCoordinatorLayoutActivity.this,TestActivity10.class));
                    }
                });

    }
}
