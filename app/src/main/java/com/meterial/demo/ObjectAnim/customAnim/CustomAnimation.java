package com.meterial.demo.ObjectAnim.customAnim;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * 创建自定义动画非常简单，只需要实现applyTransformation和initialize方法即可。
 * 在applyTransformation中完成自己想要实现的效果，在initialize中做一些初始化操作。
 */
public class CustomAnimation extends Animation {

    private Camera mCamera;
    private float mCenterHeight;
    private float mCenterWdith;

    //四个参数，子控件长宽和父控件长宽
    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);

        mCamera = new Camera();
        setFillAfter(true);
        mCenterHeight = height / 2;
        mCenterWdith = width / 2;
    }

    //第一个参数interpolatedTime为0.0~1.0的递增值，随着动画执行时间逐渐增大；
    // 而t可以用来获取初始变换矩阵Matrix，我们就是根据这个矩阵值的改变来进行动画的，
    // 并且往往会使用到Camera这个类来执行一些3D效果

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);

        Matrix matrix = t.getMatrix();

        mCamera.save();
        mCamera.translate(0,0,interpolatedTime * 300);
        mCamera.rotateY(interpolatedTime * 360);
        mCamera.getMatrix(matrix);
        mCamera.restore();

        /* 以高度的中心点作为旋转中心 */
        matrix.preTranslate(0,-mCenterHeight);
        matrix.postTranslate(0,mCenterHeight);
    }
}