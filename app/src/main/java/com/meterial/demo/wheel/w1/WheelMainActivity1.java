package com.meterial.demo.wheel.w1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.meterial.demo.R;

/**
 * https://github.com/CNCoderX/WheelView
 */
public class WheelMainActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wheel_w1);

        findViewById(R.id.btn_SimpleTestActivity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WheelMainActivity1.this, SimpleTestActivity.class));
            }
        });

        findViewById(R.id.btn_DatePickerTestActivity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WheelMainActivity1.this, DatePickerTestActivity.class));
            }
        });
    }

}