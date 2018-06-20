package com.meterial.demo.wheel.w1;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.meterial.demo.R;

/**
 * @author cncoderx
 */
public class SimpleTestActivity extends AppCompatActivity {

    private Wheel3DView test = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wheel_view_test);
        test = findViewById(R.id.wheel3d);
        test.setEntries("A","B","C","D");
    }
}