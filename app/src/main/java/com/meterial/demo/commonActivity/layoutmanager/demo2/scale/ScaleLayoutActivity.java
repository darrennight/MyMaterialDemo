package com.meterial.demo.commonActivity.layoutmanager.demo2.scale;

import com.meterial.demo.commonActivity.layoutmanager.demo2.BaseActivity;
import com.meterial.demo.commonActivity.layoutmanager.demo2.ScaleLayoutManager;
import com.meterial.demo.commonActivity.layoutmanager.demo2.Util;

/**
 * Created by Dajavu on 27/10/2017. 
 */ 
 
public class ScaleLayoutActivity extends BaseActivity<ScaleLayoutManager, ScalePopUpWindow> {
 
    @Override 
    protected ScaleLayoutManager createLayoutManager() { 
        return new ScaleLayoutManager(this, Util.Dp2px(this, 10));
    } 
 
    @Override 
    protected ScalePopUpWindow createSettingPopUpWindow() { 
        return new ScalePopUpWindow(this, getViewPagerLayoutManager(), getRecyclerView());
    } 
} 