package com.meterial.demo.commonActivity.supportBottom;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.design.widget.BottomNavigationView;
import android.util.AttributeSet;
import com.meterial.demo.Util.MyUtils;

/**
 * 滑动列表时隐藏显示底部导航
 * http://codpoe.me/2016/10/27/bottom_navigation_view/
 */
public class ScrollBottomNavigationView extends BottomNavigationView {
   private Context mContext;
   private ObjectAnimator mHideAnim; // 隐藏的动画
   private ObjectAnimator mShowAnim; // 显现的动画
   private boolean mIsHidden; // 是否已隐藏
   private float mPxHeight; // BottomNavigationView 的 px 高度
   public ScrollBottomNavigationView(Context context) {
       super(context, null);
   }
   public ScrollBottomNavigationView(Context context, AttributeSet attr) {
       super(context, attr);
       mContext = context;
       init();
   }
   private void init() {
       mIsHidden = false;
       // 将 dp 高度转换为 px 高度
       mPxHeight = MyUtils.dip2px(mContext, 56);
       mHideAnim = ObjectAnimator.ofFloat(this, "translationY", 0, mPxHeight)
               .setDuration(300);
       mShowAnim = ObjectAnimator.ofFloat(this, "translationY", mPxHeight, 0)
               .setDuration(300);
               
   }
   public void hide() {
       mIsHidden = true;
       mHideAnim.start();
   }
   public void show() {
       mIsHidden = false;
       mShowAnim.start();
   }
 
   public boolean isHidden() {
       return mIsHidden;
   }
}