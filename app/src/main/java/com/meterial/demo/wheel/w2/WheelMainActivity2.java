package com.meterial.demo.wheel.w2;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;
import com.meterial.demo.R;
import java.util.ArrayList;

/**
 * https://github.com/brucetoo/PickView
 * https://github.com/weidongjian/androidWheelView
 */
public class WheelMainActivity2 extends AppCompatActivity {

//    private ArrayList<ProvinceModel> mProvinceList = null; // 省份列表
//    private String mProvince = null; // 省份
//    private String mCity = null; // 城市
    private LoopView loopView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wheel_main2);

        findViewById(R.id.date).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerPopWin pickerPopWin = new DatePickerPopWin.Builder(WheelMainActivity2.this, new DatePickerPopWin.OnDatePickedListener() {
                    @Override
                    public void onDatePickCompleted(int year, int month, int day, String dateDesc) {
                        Toast.makeText(WheelMainActivity2.this, dateDesc, Toast.LENGTH_SHORT).show();
                    }
                }).textConfirm("CONFIRM") //text of confirm button
                        .textCancel("CANCEL") //text of cancel button
                        .btnTextSize(16) // button text size
                        .viewTextSize(25) // pick view text size
                        .colorCancel(Color.parseColor("#999999")) //color of cancel button
                        .colorConfirm(Color.parseColor("#009900"))//color of confirm button
                        .minYear(1990) //min year in loop
                        .maxYear(2550) // max year in loop
                        .dateChose("2013-11-11") // date chose when init popwindow
                        .build();
                pickerPopWin.showPopWin(WheelMainActivity2.this);
            }
        });

        findViewById(R.id.timepick).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerPopWin timePickerPopWin=new TimePickerPopWin.Builder(WheelMainActivity2.this, new TimePickerPopWin.OnTimePickListener() {
                    @Override
                    public void onTimePickCompleted(int hour, int minute, String AM_PM, String time) {
                        Toast.makeText(WheelMainActivity2.this, time, Toast.LENGTH_SHORT).show();
                    }
                }).textConfirm("CONFIRM")
                        .textCancel("CANCEL")
                        .btnTextSize(16)
                        .viewTextSize(25)
                        .colorCancel(Color.parseColor("#999999"))
                        .colorConfirm(Color.parseColor("#009900"))
                        .build();
                timePickerPopWin.showPopWin(WheelMainActivity2.this);
            }
        });


        findViewById(R.id.province).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(WheelMainActivity2.this, "Working on...", Toast.LENGTH_SHORT).show();
//                if(null != mProvinceList) {
//                    ProvincePickPopWin pickPopWin = new ProvincePickPopWin(MainActivity.this,
//                            mProvince, mCity, mProvinceList, MainActivity.this);
//                    pickPopWin.showPopWin(MainActivity.this);
//                }
            }
        });

        loopView = (LoopView) findViewById(R.id.loop_view);
        loopView.setInitPosition(2);
        loopView.setCanLoop(false);
        loopView.setLoopListener(new LoopScrollListener() {
            @Override
            public void onItemSelect(int item) {

            }
        });
        loopView.setTextSize(25);//must be called before setDateList
        loopView.setDataList(getList());
//        ((new ProvinceInfoParserTask(this, mHandler))).execute();// 解析本地地址信息文件
    }

    public ArrayList<String> getList(){
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            list.add("DAY TEST:" + i);
        }
        return list;
    }


//    private Handler mHandler = new Handler(new Handler.Callback() {
//        @Override
//        public boolean handleMessage(Message msg) {
//            switch (msg.what) {
//                case ProvinceInfoParserTask.MSG_PARSE_RESULT_CALLBACK: // 解析地址完成
//                    mProvinceList = (ArrayList<ProvinceModel>) msg.obj;
//                    break;
//            }
//            return false;
//        }
//    });

//    @Override
//    public void onAddressPickCompleted(String province, String provinceId, String city, String cityId) {
////        Toast.makeText(this,province+"-"+provinceId+"-"+city+"-"+cityId,Toast.LENGTH_SHORT).show();
//        Toast.makeText(this,ProvinceInfoUtils.matchAddress(this,provinceId,cityId,mProvinceList),Toast.LENGTH_SHORT).show();
//        ProvinceInfoUtils.matchAddress(this,provinceId,cityId,mProvinceList);
//    }
}
