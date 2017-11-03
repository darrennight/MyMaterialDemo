package com.meterial.demo.calendar2;

import java.util.Date;
 
public interface CalendarCellDecorator { 
  void decorate(CalendarCellView cellView, Date date);
} 