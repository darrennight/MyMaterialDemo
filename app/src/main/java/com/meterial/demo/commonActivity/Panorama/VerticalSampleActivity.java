package com.meterial.demo.commonActivity.Panorama;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.meterial.demo.R;

public class VerticalSampleActivity extends AppCompatActivity { 
 
    private GyroscopeObserver gyroscopeObserver;
 
    @Override 
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vertical_sample);
 
        gyroscopeObserver = new GyroscopeObserver();
 
        PanoramaImageView panoramaImageView = (PanoramaImageView) findViewById(R.id.panorama_image_view);
        panoramaImageView.setGyroscopeObserver(gyroscopeObserver);
    } 
 
    @Override 
    protected void onResume() { 
        super.onResume(); 
        gyroscopeObserver.register(this);
    } 
 
    @Override 
    protected void onPause() { 
        super.onPause(); 
        gyroscopeObserver.unregister();
    } 
} 