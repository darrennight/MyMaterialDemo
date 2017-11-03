package com.meterial.demo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import com.meterial.demo.R;
import com.meterial.demo.calendar.CalendarDayModel;
import com.meterial.demo.calendar.CalendarMonthModel;
import com.meterial.demo.calendar.CalendarUtils;
import com.meterial.demo.calendar.MonthView;
import com.meterial.demo.calendar.MonthViewStyle;
import com.meterial.demo.calendar.MonthViewThum;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *日期缩略图
 * @author zenghao
 * @since 2017/7/9 下午5:20
 */
public class MyCalendarThumb extends AppCompatActivity {

    //private MonthView monthView;
    private MonthViewThum monthView;
    //private MonthViewStyle monthView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thum_calendar);
        //monthView = ((MonthView) findViewById(R.id.mv_thum_monthview));
        monthView = ((MonthViewThum) findViewById(R.id.mv_thum_monthview));
        //monthView = ((MonthViewStyle) findViewById(R.id.mv_thum_monthview));

        List<Calendar> years = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(5);
        list.add(6);
        list.add(7);

        //MonthView需要自定义修改作为缩略图使用
        //月份要减一天
        years.add(CalendarUtils.getCalendar(2017, 6, 1));
        CalendarMonthModel monthModel = new CalendarMonthModel(years.get(0));
        int count = monthModel.getMonthDayCount();
        for(int i=1;i<=count;i++){
            CalendarDayModel dayModel = monthModel.getDayModel(i);
            if(list.contains(dayModel.day)){
                if(i==1){
                    dayModel.isSelectedStartDay = true;
                }else if(i==count){
                    dayModel.isSelectedEndDay = true;
                }else{
                    CalendarDayModel plus = monthModel.getDayModel(i-1);
                    CalendarDayModel add = monthModel.getDayModel(i+1);

                    if(!list.contains(dayModel.day-1)){
                        dayModel.isSelectedStartDay = true;
                    }else if(list.contains(dayModel.day+1)){
                        dayModel.isBetweenStartAndEndSelected = true;
                    }else{
                        dayModel.isSelectedEndDay = true;
                    }

                }
            }
        }

        monthModel.setHasSelectedStartAndEnd(true);

        /*monthModel.getDayModel(1).isSelectedStartDay = true;
        monthModel.getDayModel(1).isSingle = true;

        monthModel.getDayModel(2).isSelectedStartDay = true;
        monthModel.getDayModel(3).isSelectedEndDay = true;

        monthModel.getDayModel(4).isSelectedStartDay = true;

        monthModel.setHasSelectedStartAndEnd(true);

        monthModel.getDayModel(6).isSelectedStartDay = true;
        monthModel.getDayModel(7).isBetweenStartAndEndSelected = true;
        monthModel.getDayModel(8).isBetweenStartAndEndSelected = true;
        monthModel.getDayModel(9).isBetweenStartAndEndSelected = true;
        monthModel.getDayModel(10).isSelectedEndDay = true;*/



        monthView.setCalendarMonthModel(monthModel);

        test1();
        test2();
    }


    private void test1(){
        List<Integer> list = new ArrayList<>();
        String s1 = "2017-7-6";
        String s2 = "2017-7-10";

        String[] day1 = s1.split("-");
        String[] day2 = s2.split("-");

        int temp1 = Integer.parseInt(day1[2]);
        int temp2 = Integer.parseInt(day2[2]);

        for (int i=temp1;i<=temp2;i++){
            list.add(i);
            Log.e("=====hahahha",""+list.get(i-temp1));

        }
        Log.e("=====hahahha",""+list.size());


    }



    private void test2(){
        String start = "2017-6-23";
        String end = "2017-7-5";
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date date = sdf.parse(start);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);

            Date endDate = sdf.parse(end);

            while (endDate.after(calendar.getTime())){
                Log.e("====","hahhaa"+sdf.format(calendar.getTime()));
                calendar.add(Calendar.DAY_OF_MONTH,1);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }


    }

}
