package com.meterial.demo.chart;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.meterial.demo.R;
import com.meterial.demo.chart.view.PieChart;

/**
 * TODO
 *
 * @author zenghao
 * @since 2018/4/11 下午6:38
 */
public class ChartActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart4);
        final PieChart pie = (PieChart) this.findViewById(R.id.Pie);
        final PieChart pie2 = (PieChart) this.findViewById(R.id.Pie2);
        pie.addItem("红", 1, 0xffF36C60);
        pie.addItem("绿", 2, 0xff1DE9B6);
        pie.addItem("蓝", 3, 0xff4FC3F7);

        pie2.addItem("红", 1, 0xffF36C60);
        pie2.addItem("绿", 2, 0xff1DE9B6);
        pie2.addItem("蓝", 3, 0xff4FC3F7);

        findViewById(R.id.Reset).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                pie.setCurrentItem(0);
                pie2.setCurrentItem(0);
            }
        });
    }
}