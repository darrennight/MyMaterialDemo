package com.meterial.demo.widgetActivity.HotelCalendar;

public class HotelMonthBean extends HotelDateBean{
    private String month;
    public HotelMonthBean(){}
    public HotelMonthBean(String month){
        this.month=month;
    }
    public String getMonth(){
        return month;
    }
}