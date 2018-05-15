package com.meterial.demo.enterAnim.enter2;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.GridLayoutAnimationController;

/**
 * @version Created by haibozheng on 2016/12/9.
 * @Author Zheng Haibo
 * @Blog github.com/nuptboyzhb
 * @Company Alibaba Group
 * @Description StaggeredGridRecyclerView
 */
public class StaggeredGridRecyclerView extends RecyclerView {

    public StaggeredGridRecyclerView(Context context) {
        super(context);
    }

    public StaggeredGridRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public StaggeredGridRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    /**
     * 支持GridLayoutManager以及StaggeredGridLayoutManager
     *
     * @param child
     * @param params
     * @param index
     * @param count
     */
    @Override
    protected void attachLayoutAnimationParameters(View child, ViewGroup.LayoutParams params,
                                                   int index, int count) {
        LayoutManager layoutManager = this.getLayoutManager();
        if (getAdapter() != null && (layoutManager instanceof GridLayoutManager
                || layoutManager instanceof StaggeredGridLayoutManager)) {

            GridLayoutAnimationController.AnimationParameters animationParams =
                    (GridLayoutAnimationController.AnimationParameters) params.layoutAnimationParameters;

            if (animationParams == null) {
                animationParams = new GridLayoutAnimationController.AnimationParameters();
                params.layoutAnimationParameters = animationParams;
            }

            int columns = 0;
            if (layoutManager instanceof GridLayoutManager) {
                columns = ((GridLayoutManager) layoutManager).getSpanCount();
            } else {
                columns = ((StaggeredGridLayoutManager) layoutManager).getSpanCount();
            }

            animationParams.count = count;
            animationParams.index = index;
            animationParams.columnsCount = columns;
            animationParams.rowsCount = count / columns;

            final int invertedIndex = count - 1 - index;
            animationParams.column = columns - 1 - (invertedIndex % columns);
            animationParams.row = animationParams.rowsCount - 1 - invertedIndex / columns;

        } else {
            super.attachLayoutAnimationParameters(child, params, index, count);
        }
    }
}