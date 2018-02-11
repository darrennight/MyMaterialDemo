package com.meterial.demo.commonActivity.layoutmanager.demo2.gallery;
 

import com.meterial.demo.commonActivity.layoutmanager.demo2.BaseActivity;
import com.meterial.demo.commonActivity.layoutmanager.demo2.GalleryLayoutManager;
import com.meterial.demo.commonActivity.layoutmanager.demo2.Util;

/** 
 * Created by Dajavu on 27/10/2017. 
 */ 
 
public class GalleryLayoutActivity extends BaseActivity<GalleryLayoutManager, GalleryPopUpWindow> {
 
    @Override 
    protected GalleryLayoutManager createLayoutManager() {
        return new GalleryLayoutManager(this, Util.Dp2px(this, 10));
    } 
 
    @Override 
    protected GalleryPopUpWindow createSettingPopUpWindow() { 
        return new GalleryPopUpWindow(this, getViewPagerLayoutManager(), getRecyclerView());
    } 
} 