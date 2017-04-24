package com.meterial.demo.commonActivity.spruce.sort;

import android.view.View;
 
public class SpruceTimedView { 
 
    private final View view;
    private final long timeOffset;
 
    public SpruceTimedView(View view, long timeOffset) {
        this.view = view;
        this.timeOffset = timeOffset;
    } 
 
    public View getView() {
        return view;
    } 
 
    public long getTimeOffset() { 
        return timeOffset;
    } 
} 