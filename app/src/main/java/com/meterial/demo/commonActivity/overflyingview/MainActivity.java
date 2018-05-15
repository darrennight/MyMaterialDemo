package com.meterial.demo.commonActivity.overflyingview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.meterial.demo.R;

/**
 * https://github.com/renjianan/OverFlyingView
 */
public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_over);

    }


    /**
     * 显示底部Dialog
     */
    public void showBottomDialog(View view) {
        FragmentManager fm = getSupportFragmentManager();
        BottomDialogFragment bottomDialogFragment = new BottomDialogFragment();
        bottomDialogFragment.show(fm, "fragment_bottom_dialog");
    }

    public void goVer(View view) {
        startActivity(new Intent(MainActivity.this, VertialActivity.class));
    }

    public void goHor(View view) {
        startActivity(new Intent(MainActivity.this, HorizontalActivity.class));
    }

    public void goVerSingle(View view) {
        startActivity(new Intent(MainActivity.this, Vertial2Activity.class));
    }
}