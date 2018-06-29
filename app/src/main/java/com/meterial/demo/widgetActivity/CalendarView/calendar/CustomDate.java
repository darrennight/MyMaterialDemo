package com.meterial.demo.widgetActivity.CalendarView.calendar;

import java.io.Serializable;

public class CustomDate implements Serializable,Comparable<CustomDate>{

    private static final long serialVersionUID = 1L;
	public int year;
	public int month;
	public int day;
	public int week;
	
	public CustomDate(int year,int month,int day,int week){
		if(month > 12){
			month = 1;
			year++;
		}else if(month <1){
			month = 12;
			year--;
		}
		this.year = year;
		this.month = month;
		this.day = day;
		this.week = week;
	}
	
	public CustomDate(int year,int month,int day){
		if(month > 12){
			month = 1;
			year++;
		}else if(month <1){
			month = 12;
			year--;
		}
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	public CustomDate(){
		this.year = DateUtil.getYear();
		this.month = DateUtil.getMonth();
		this.day = DateUtil.getCurrentMonthDay();
		this.week = DateUtil.getWeekDay();
	}
	
	public static CustomDate modifiDayForObject(CustomDate date,int day,int week){
		CustomDate modifiDate = new CustomDate(date.year,date.month,day,week);
		return modifiDate;
	}


	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}
	
	
	public boolean isSameDay(CustomDate customDate){
		return year == customDate.year&& customDate.month == month && day == customDate.day;
	}

	public int getWeek() {
		return week;
	}

	public void setWeek(int week) {
		this.week = week;
	}

	@Override
	public String toString() {
		return year+"-"+month+"-"+day;
	}


	@Override
	public int compareTo(CustomDate another) {
	if(another != null){
		if(this.year >another.year){
			return 1;
		}else if(this.year  == another.year && this.month > another.month){
			return 1;
		}else if(this.year  == another.year && this.month == another.month && this.day >another.day){
			return 1;
		}else if(this.year  == another.year && this.month == another.month && this.day == another.day){
			return 0;
		}
		return -1;
	}
		return -1;
	}

	
	public int compareDays(CustomDate another){
		if(this.month == another.month){
			return this.day - another.day;
		}else{
			int days = DateUtil.getMonthDays(another.year,another.month);
			return days - another.day + this.day;
		}
	}


}