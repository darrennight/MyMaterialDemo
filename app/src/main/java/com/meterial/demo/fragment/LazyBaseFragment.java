package com.meterial.demo.fragment;

import android.support.v4.app.Fragment;

/**
 * Created by zenghao on 15/12/4.
 */
public abstract class LazyBaseFragment extends Fragment {

    protected  boolean isVisiable;
//setUserVisibleHint是在onCreateView之前调用的
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(getUserVisibleHint()){
            isVisiable = true;
            onVisible();
        }else{
            isVisiable = false;
            onInvisible();
        }
    }

    /**
     * fragment显示 处理
     */
    protected void onVisible(){
        lazyLoad();
    }

    /**
     * 延迟加载数据
     */
    protected abstract void lazyLoad();

    /**
     * fragment隐藏 处理
     */
    protected void onInvisible(){}
}
