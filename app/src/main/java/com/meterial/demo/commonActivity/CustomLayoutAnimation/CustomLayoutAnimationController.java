package com.meterial.demo.commonActivity.CustomLayoutAnimation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.LayoutAnimationController;

public class CustomLayoutAnimationController extends LayoutAnimationController {

    public final static int CUSTOM_ORDER = 7;
    private CurrentIndexListener mListener;


    public CustomLayoutAnimationController(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomLayoutAnimationController(Animation animation) {
        super(animation);
    }

    public CustomLayoutAnimationController(Animation animation, float delay) {
        super(animation, delay);
    }

    public void setCurrentIndexListener(CurrentIndexListener listener){
        this.mListener = listener;
    }

    @Override
    protected int getTransformedIndex(AnimationParameters params) {
        if (mListener != null && getOrder() == CUSTOM_ORDER) {
            return mListener.currentIndex(this, params.count, params.index);
        } else {
            return super.getTransformedIndex(params);
        }
    }

    public interface CurrentIndexListener {
        int currentIndex(CustomLayoutAnimationController controller, int count, int index);
    }
}