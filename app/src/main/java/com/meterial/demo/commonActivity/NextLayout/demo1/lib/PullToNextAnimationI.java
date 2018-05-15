package com.meterial.demo.commonActivity.NextLayout.demo1.lib;

import android.view.View;
 
import com.nineoldandroids.animation.Animator; 
 
/** 
 * Created by zzz40500 on 15/5/3. 
 */ 
public interface PullToNextAnimationI { 
 
 
    public Animator getPullDownAnim(View showView,View dismissView);
 
    public Animator getPullUpAnim(View showView,View dismissView);
    public Animator getDeleteItemAnim(View showView,View dismissView);
 
 
}