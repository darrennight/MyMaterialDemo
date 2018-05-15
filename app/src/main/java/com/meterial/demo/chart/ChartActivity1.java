package com.meterial.demo.chart;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import com.meterial.demo.R;
import com.meterial.demo.chart.view.DensityUtils;
import com.meterial.demo.chart.view.MyPieChart;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zenghao
 * @since 2018/4/11 下午5:57
 */
public class ChartActivity1 extends AppCompatActivity implements MyPieChart.OnItemClickListener {

    private MyPieChart myPieChart;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart1);
        myPieChart = (MyPieChart) findViewById(R.id.mypiechart);

        myPieChart.setRadius(DensityUtils.dp2px(this, 80));

        myPieChart.setOnItemClickListener(this);

        List<MyPieChart.PieEntry> pieEntries = new ArrayList<>();
        pieEntries.add(new MyPieChart.PieEntry(1, R.color.chart_orange, true));
        pieEntries.add(new MyPieChart.PieEntry(1, R.color.chart_green, false));
        pieEntries.add(new MyPieChart.PieEntry(1, R.color.chart_blue, false));
        pieEntries.add(new MyPieChart.PieEntry(1, R.color.chart_purple, false));
        pieEntries.add(new MyPieChart.PieEntry(1, R.color.chart_mblue, false));
        pieEntries.add(new MyPieChart.PieEntry(1, R.color.chart_turquoise, false));

        myPieChart.setPieEntries(pieEntries);

    }

    @Override
    public void onItemClick(int position) {
        Toast.makeText(this, "点击了" + position, Toast.LENGTH_SHORT).show();
    }
}