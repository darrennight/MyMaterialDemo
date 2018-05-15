package com.meterial.demo.ObjectAnim.customAnim;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class FlipAnimation extends Animation {

    private Camera mCamera;

    private float centerX;

    private float centerY;

    private float scale = 0.5f;

    @Override

    public void initialize(int width, int height, int parentWidth, int parentHeight) {

        super.initialize(width, height, parentWidth, parentHeight);

        // 初始化Camera,并得View  X和Y轴的中心点坐标

        mCamera = new Camera();

        centerX = width / 2;

        centerY = height / 2;
    }

    @Override

    protected void applyTransformation(float interpolatedTime, Transformation t) {

        final double radians = Math.PI * interpolatedTime;

        float degrees = (float) (180.0 * radians / Math.PI);

        if (interpolatedTime >= 0.5f) {

            degrees -= 180.f;
        }

        //利用Matrix 对view进行平移，缩放等变换

        final Matrix matrix = t.getMatrix();

        mCamera.save();

        // 根据动画播放进度，在Z轴方向进行平移，达到先远离屏幕，在靠近屏幕的效果

        mCamera.translate(0.0f, 0.0f, (float) (300.0 * Math.sin(radians)));

        // 围绕X轴进行旋转

        mCamera.rotateX(degrees);

        // 围绕Y轴进行旋转，此处是实现上下翻转，因此不要Y轴变换

        //camera.rotateY(degrees);

        //围绕Z轴进行旋转，此处是实现上下翻转，因此不要Z轴变换

        //camera.rotateZ(degrees);

        mCamera.getMatrix(matrix);

        mCamera.restore();

        // 下面两行代码是设置旋转中心点为图像正中

        matrix.preTranslate(-centerX, -centerY);

        matrix.postTranslate(centerX, centerY);

        // 对图像进行缩放

        matrix.preScale(scale, scale, centerX, centerY);
    }
}