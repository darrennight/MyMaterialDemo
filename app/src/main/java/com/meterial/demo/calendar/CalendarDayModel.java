package com.meterial.demo.calendar;

import java.util.Calendar;
 
public class CalendarDayModel { 
    public final int day;
    /**过去*/
    public boolean isInThePast;
    /**今天*/
    public boolean isToday;
    /**将来*/
    public boolean isInTheFuture;

    /**是否是开始结束范围之间*/
    public boolean isBetweenStartAndEndSelected;
    /**是否是结束*/
    public boolean isSelectedEndDay;
    /**是否是开始*/
    public boolean isSelectedStartDay;

    /**该日期时间day是否可以被选择点击*/
    public boolean isUnavailable;

    public boolean isSingle;

    public Calendar dayCalendar;
 
    public CalendarDayModel(int day, Calendar dayCalendar) {
        this.day = day;
        this.dayCalendar = dayCalendar;
    } 
 
    public void unSelected() { 
        isBetweenStartAndEndSelected = isSelectedEndDay = isSelectedStartDay = false;
    } 
 
    public boolean isSelected() { 
        return (this.isSelectedStartDay) ||
                (this.isSelectedEndDay) ||
                (this.isBetweenStartAndEndSelected);
    } 
} 