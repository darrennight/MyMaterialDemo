package com.meterial.demo.commonActivity.finger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import com.meterial.demo.R;

/**
 * @author EdisonChang
 */
public class MainActivity extends AppCompatActivity {

    private Button mBtnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finger_main);
        mBtnStart = (Button) findViewById(R.id.button);
        mBtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ScannerActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });
    }


}