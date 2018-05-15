package com.meterial.demo.ObjectAnim.customAnim;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * @author zenghao
 * @since 2018/5/11 上午11:26
 */
public class CustomShakeAnimation extends Animation {



    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        t.getMatrix().setTranslate((float)Math.sin(interpolatedTime*50)*20,0);

        super.applyTransformation(interpolatedTime, t);
    }
}