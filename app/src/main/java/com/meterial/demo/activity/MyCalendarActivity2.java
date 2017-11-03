package com.meterial.demo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import com.meterial.demo.R;
import com.meterial.demo.calendar2.CalendarPickerView;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * https://github.com/savvisingh/DateRangePicker
 * @author zenghao
 * @since 2017/7/9 下午6:59
 */
public class MyCalendarActivity2 extends AppCompatActivity {
    CalendarPickerView calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_2);

        final Calendar nextYear = Calendar.getInstance();
        nextYear.add(Calendar.YEAR, 10);

        final Calendar lastYear = Calendar.getInstance();
        lastYear.add(Calendar.YEAR, -10);

        calendar = (CalendarPickerView) findViewById(R.id.calendar_view);

        calendar.init(lastYear.getTime(), nextYear.getTime()) //
                .inMode(CalendarPickerView.SelectionMode.RANGE) //
                .withSelectedDate(new Date());



        SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
        String strdate = "22-06-2017";
        String strdate2 = "26-06-2017";




        try {
            Date newdate = dateformat.parse(strdate);
            Date newdate2 = dateformat.parse(strdate2);
            ArrayList<Date> arrayList = new ArrayList<>();
            arrayList.add(newdate);
            arrayList.add(newdate2);
            calendar.highlightDates(arrayList);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(7);

        calendar.deactivateDates(list);

        Log.d("list",  calendar.getSelectedDates().toString());


    }
}