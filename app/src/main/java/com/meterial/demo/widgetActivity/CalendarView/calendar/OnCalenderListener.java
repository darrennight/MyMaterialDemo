package com.meterial.demo.widgetActivity.CalendarView.calendar;

public interface OnCalenderListener {

	 void clickDate(CustomDate date);

	 void showDate(CustomDate date);

	 void onMeasureCellHeight(int cellSpace);

	
	 void changeRowCount(int rows);

	 RecordState setSignDateStatus(CustomDate date);

}