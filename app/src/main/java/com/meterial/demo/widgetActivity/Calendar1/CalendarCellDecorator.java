package com.meterial.demo.widgetActivity.Calendar1;

import java.util.Date;

public interface CalendarCellDecorator {
  void decorate(CalendarCellView cellView, Date date);
}