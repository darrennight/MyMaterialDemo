package com.meterial.demo.widgetActivity.AliBehaver.allrecycleview;

import android.content.Context;

import java.util.List;


public interface BodyInitListener<T> {

    public CustomHolder getHolderByViewType(Context context, List<T> lists, int itemID);
}