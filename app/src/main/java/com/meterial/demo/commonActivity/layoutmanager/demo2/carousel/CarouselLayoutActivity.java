package com.meterial.demo.commonActivity.layoutmanager.demo2.carousel;

import com.meterial.demo.commonActivity.layoutmanager.demo2.BaseActivity;
import com.meterial.demo.commonActivity.layoutmanager.demo2.CarouselLayoutManager;
import com.meterial.demo.commonActivity.layoutmanager.demo2.Util;

/**
 * Created by Dajavu on 27/10/2017. 
 */ 
 
public class CarouselLayoutActivity extends
        BaseActivity<CarouselLayoutManager, CarouselPopUpWindow> {
 
    @Override 
    protected CarouselLayoutManager createLayoutManager() { 
        return new CarouselLayoutManager(this, Util.Dp2px(this, 100));
    } 
 
    @Override 
    protected CarouselPopUpWindow createSettingPopUpWindow() { 
        return new CarouselPopUpWindow(this, getViewPagerLayoutManager(), getRecyclerView());
    } 
} 