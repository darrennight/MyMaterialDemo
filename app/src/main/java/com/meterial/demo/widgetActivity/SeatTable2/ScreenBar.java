package com.meterial.demo.widgetActivity.SeatTable2;

import android.graphics.Canvas;
import android.graphics.Rect;

import sviolet.turquoise.uix.viewgesturectrl.output.SimpleRectangleOutput;

/**
 * 屏幕标识
 * Created by S.Violet on 2016/10/18.
 */

public interface ScreenBar {

    void draw(Canvas canvas, Rect srcRect, Rect dstRect, SimpleRectangleOutput output, SeatTable seatTable);

}