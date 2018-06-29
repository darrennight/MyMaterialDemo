package com.meterial.demo.widgetActivity.ScrollCalendar;

public interface DateWatcher {
    @State
    int getStateForDate(int year, int month, int day);
}