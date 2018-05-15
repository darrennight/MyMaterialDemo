package com.meterial.demo.ObjectAnim.customAnim;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * TODO
 *
 * @author zenghao
 * @since 2018/5/11 上午11:33
 */
public class CustomSwingAnimation extends Animation {


    @Override
    /**
     * 此方法可以获取到对象物体的宽高
     */
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
    }

    @Override
    /**
     * applyTransformation()方法，此方法会一直执行到补间时间结束，
     * 一切的动画效果都可以通过此方法来实现
     * applyTransformation()方法中的interpolatedTime是补间时间。从0-1
     * applyTransformation()方法中的Transformation为状态变化对象
     */
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);

        //通过获取矩阵来实现对象的效果
        //        t.getMatrix().setTranslate(200,200);//无动画直接移动
        //        t.getMatrix().setTranslate(200*interpolatedTime,200*interpolatedTime);//有动画移动
        t.getMatrix().setTranslate((float) (Math.sin(interpolatedTime*10)*70),0);
        //Math.sin()为周期性函数，周期为interpolatedTime*10,振幅为50 70
    }
}