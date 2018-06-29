package com.meterial.demo.widgetActivity.ScrollCalendar;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


/**
 * Created by rafal.manka on 10/09/2017
 */
@IntDef({
        CalendarDay.DEFAULT,
        CalendarDay.DISABLED,
        CalendarDay.TODAY,
        CalendarDay.UNAVAILABLE,
        CalendarDay.SELECTED,
})
@Retention(value = RetentionPolicy.SOURCE)
public @interface State {
}