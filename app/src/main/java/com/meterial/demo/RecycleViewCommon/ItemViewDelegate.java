package com.meterial.demo.RecycleViewCommon;

import android.content.Context;

public interface ItemViewDelegate<T> {

    int getItemViewLayoutId();

    boolean isForViewType(T item, int position);

    void convert(Context context,RVCommonViewHolder holder, T t, int position);


}