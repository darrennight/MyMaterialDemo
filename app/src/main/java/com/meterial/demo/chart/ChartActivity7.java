package com.meterial.demo.chart;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.meterial.demo.R;
import com.meterial.demo.chart.view.PinChart;

/**
 * TODO
 *
 * @author zenghao
 * @since 2018/4/12 下午12:11
 */
public class ChartActivity7 extends AppCompatActivity {
    private PinChart pinChart;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart7);
        pinChart= (PinChart) findViewById(R.id.pinchart);
    }


}
