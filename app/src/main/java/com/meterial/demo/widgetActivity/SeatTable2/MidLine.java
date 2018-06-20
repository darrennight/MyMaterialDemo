package com.meterial.demo.widgetActivity.SeatTable2;

import android.graphics.Canvas;
import android.graphics.Rect;
import sviolet.turquoise.uix.viewgesturectrl.output.SimpleRectangleOutput;

/**
 * 影厅中线标记
 *
 * Created by S.Violet on 2016/10/26.
 */

public interface MidLine {

    void draw(Canvas canvas, Rect srcRect, Rect dstRect, SimpleRectangleOutput output, SeatTable seatTable);

    boolean isUnderSeatLayer();

}