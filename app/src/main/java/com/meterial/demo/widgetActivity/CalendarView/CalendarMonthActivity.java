package com.meterial.demo.widgetActivity.CalendarView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.meterial.demo.R;
import com.meterial.demo.widgetActivity.CalendarView.lib.CalendarRecyclerHelper;
import com.meterial.demo.widgetActivity.CalendarView.lib.CalendarView;
import com.meterial.demo.widgetActivity.CalendarView.lib.CustomDate;
import com.meterial.demo.widgetActivity.CalendarView.newcalendar.CustomCalendarAdapter;

/**
 * Created by huang on 2017/11/9.
 */

public class CalendarMonthActivity extends AppCompatActivity{

    private RecyclerView recyclerView;
    private TextView showTv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_lib);
        showTv = (TextView) findViewById(R.id.tv_show_date);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        CalendarRecyclerHelper.init(this, recyclerView, new CustomCalendarAdapter(), new CalendarView.OnCalendarPageChanged() {
            @Override
            public void onPageChanged(CustomDate showDate) {
                showTv.setText(showDate.year+"年"+showDate.month+"月");
            }
        });
    }
}