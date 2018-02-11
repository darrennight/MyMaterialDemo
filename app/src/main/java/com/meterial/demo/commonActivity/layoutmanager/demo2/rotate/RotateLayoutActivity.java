package com.meterial.demo.commonActivity.layoutmanager.demo2.rotate;

import com.meterial.demo.commonActivity.layoutmanager.demo2.BaseActivity;
import com.meterial.demo.commonActivity.layoutmanager.demo2.RotateLayoutManager;
import com.meterial.demo.commonActivity.layoutmanager.demo2.Util;

/**
 * Created by Dajavu on 27/10/2017. 
 */ 
 
public class RotateLayoutActivity extends BaseActivity<RotateLayoutManager, RotatePopUpWindow> {

 
    @Override 
    protected RotateLayoutManager createLayoutManager() { 
        return new RotateLayoutManager(this, Util.Dp2px(this, 10));
    } 
 
    @Override 
    protected RotatePopUpWindow createSettingPopUpWindow() { 
        return new RotatePopUpWindow(this, getViewPagerLayoutManager(), getRecyclerView());
    } 
} 