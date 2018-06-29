package com.meterial.demo.widgetActivity.ScrollCalendar;

public interface MonthScrollListener {
    boolean shouldAddNextMonth(int lastDisplayedYear, int lastDisplayedMonth);

    boolean shouldAddPreviousMonth(int firstDisplayedYear, int firstDisplayedMonth);
}