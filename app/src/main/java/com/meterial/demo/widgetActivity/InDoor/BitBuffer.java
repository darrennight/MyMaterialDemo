package com.meterial.demo.widgetActivity.InDoor;

import android.graphics.Bitmap;


import java.util.List;

/**
 * Created by karonl on 16/4/1.
 * 为绘制canvas供应getBitBuffer和路径
 */
public interface BitBuffer {

    List<PathUnit> getPathUnit();

    Bitmap getBitBuffer();

    void setOnAdapterListener(BitAdapter.AttrListener listener);
}