package com.meterial.demo.commonActivity.Panorama;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.meterial.demo.R;

/**
 * TODO
 *
 * @author zenghao
 * @since 2017/6/14 下午6:00
 */
public class PanorMainActiivty extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actiivty_panor_main);
    }

    public void openRecyclerViewSample(View view) {
        startActivity(new Intent(this, RecyclerViewSampleActivity.class));
    }

    public void openVerticalSample(View view) {
        startActivity(new Intent(this, VerticalSampleActivity.class));
    }

    public void openHorizontalSample(View view) {
        startActivity(new Intent(this, HorizontalSampleActivity.class));
    }
}