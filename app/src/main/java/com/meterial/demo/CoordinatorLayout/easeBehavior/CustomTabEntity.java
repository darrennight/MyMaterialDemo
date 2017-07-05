package com.meterial.demo.CoordinatorLayout.easeBehavior;

import android.support.annotation.DrawableRes;
 
public interface CustomTabEntity { 
    String getTabTitle();
 
    @DrawableRes 
    int getTabSelectedIcon(); 
 
    @DrawableRes 
    int getTabUnselectedIcon(); 
 
    String getSubTitle();
} 