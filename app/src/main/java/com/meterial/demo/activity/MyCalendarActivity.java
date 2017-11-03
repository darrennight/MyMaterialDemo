package com.meterial.demo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import com.meterial.demo.R;
import com.meterial.demo.calendar.AirCalendarView;
import java.util.Calendar;

/**
 *日历
 * https://github.com/Blankeer/AirCalendarView
 * @author zenghao
 * @since 2017/7/9 下午3:28
 */
public class MyCalendarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_calendar);
        AirCalendarView calendarView = (AirCalendarView) findViewById(R.id.calendarView);
        calendarView.setOnSelectedDayListener(new AirCalendarView.OnSelectedDayListener() {
            @Override
            public void onDaySelected(Calendar startDay, Calendar endDay) {
                Log.e("start:", startDay + ",end:" + endDay) ;
            }
        });
    }
}