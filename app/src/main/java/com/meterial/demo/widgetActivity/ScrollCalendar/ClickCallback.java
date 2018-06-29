package com.meterial.demo.widgetActivity.ScrollCalendar;

import android.support.annotation.NonNull;


/**
 * Created by rafal.manka on 11/09/2017
 */
public interface ClickCallback {
    void onCalendarDayClicked(@NonNull CalendarMonth calendarMonth, @NonNull CalendarDay calendarDay);

}