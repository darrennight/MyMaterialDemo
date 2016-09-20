package com.meterial.demo.MDTransition;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.os.Build;
import android.transition.ChangeBounds;
import android.transition.TransitionValues;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;

@TargetApi(Build.VERSION_CODES.KITKAT)
public class CustomChangeBounds extends ChangeBounds {

 @Override
  public Animator createAnimator(final ViewGroup sceneRoot,TransitionValues startValues,final TransitionValues endValues) {
      Animator changeBounds = super.createAnimator(sceneRoot, startValues, endValues);

      if (startValues == null || endValues == null || changeBounds == null) {
          return null;
      }

      changeBounds.setDuration(300);
      changeBounds.setInterpolator(AnimationUtils.loadInterpolator(sceneRoot.getContext(),android.R.interpolator.fast_out_slow_in));
      return changeBounds;
  }

}