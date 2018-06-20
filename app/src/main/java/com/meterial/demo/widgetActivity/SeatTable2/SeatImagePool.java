package com.meterial.demo.widgetActivity.SeatTable2;

import android.graphics.Bitmap;
import android.graphics.Rect;

/**
 * Created by S.Violet on 2016/10/9.
 */

public interface SeatImagePool {

    Bitmap getImage(SeatType type, SeatState state);

    Rect getImageRect(SeatType type, SeatState state);

    void destroy();

}