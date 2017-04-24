package com.meterial.demo.commonActivity.spruce;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;

public class DefaultAnimations {
 
    private static final float GROW_SCALE = 1.5F;
    private static final float SHRINK_SCALE = 0.1F;
    private static final float ORIGINAL_SCALE = 1.0F;
    private static final float FADE_AWAY_TO = 0.0F;
    private static final float FADE_IN_TO = 1.0F;
    private static final float START_ROTATION = 0F;
    private static final float END_ROTATION = 360F;
 
    public static Animator growAnimator(View view, long duration) {
        return ObjectAnimator.ofPropertyValuesHolder(view,
                PropertyValuesHolder.ofFloat(View.SCALE_X, GROW_SCALE, ORIGINAL_SCALE),
                PropertyValuesHolder.ofFloat(View.SCALE_Y, GROW_SCALE, ORIGINAL_SCALE))
                .setDuration(duration);
    } 
 
    public static Animator shrinkAnimator(View view, long duration) {
        return ObjectAnimator.ofPropertyValuesHolder(view,
                PropertyValuesHolder.ofFloat(View.SCALE_X, SHRINK_SCALE, ORIGINAL_SCALE),
                PropertyValuesHolder.ofFloat(View.SCALE_Y, SHRINK_SCALE, ORIGINAL_SCALE))
                .setDuration(duration);
    } 
 
    public static Animator fadeAwayAnimator(View view, long duration) {
        return ObjectAnimator.ofFloat(view, View.ALPHA, FADE_AWAY_TO)
                .setDuration(duration);
    } 
 
    public static Animator fadeInAnimator(View view, long duration) {
        return ObjectAnimator.ofFloat(view, View.ALPHA, FADE_IN_TO)
                .setDuration(duration);
    } 
 
    public static Animator spinAnimator(View view, long duration) {
        return ObjectAnimator.ofFloat(view, View.ROTATION, START_ROTATION, END_ROTATION)
                .setDuration(duration);
    } 
 
} 