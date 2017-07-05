package com.meterial.demo.commonActivity.KenBurns;

import android.os.Bundle;
import com.meterial.demo.R;
import com.meterial.demo.commonActivity.KenBurns.view.KenBurnsView;

public class SingleImageActivity extends KenBurnsActivity {
 
    private KenBurnsView mImg;
 
 
    @Override 
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_image);
        mImg = (KenBurnsView) findViewById(R.id.img);
 
 
    } 
 
 
    @Override 
    protected void onPlayClick() { 
        mImg.resume();
    } 
 
 
    @Override 
    protected void onPauseClick() { 
        mImg.pause();
    } 
} 