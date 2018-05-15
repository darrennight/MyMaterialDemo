package com.meterial.demo.chart;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.meterial.demo.R;
import com.meterial.demo.chart.view.PieHelper;
import com.meterial.demo.chart.view.PlanPieView;
import java.util.ArrayList;

/**
 * https://github.com/HackPlan/AndroidCharts
 *
 * @author zenghao
 * @since 2018/4/12 上午11:01
 */
public class ChartActivity6 extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart6);

        textView = (TextView) findViewById(R.id.textView);
        final PlanPieView pieView = (PlanPieView) findViewById(R.id.pie_view);
        Button button = (Button) findViewById(R.id.pie_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                randomSet(pieView);
            }
        });
        set(pieView);
    }


    private void randomSet(PlanPieView pieView) {
        ArrayList<PieHelper> pieHelperArrayList = new ArrayList<PieHelper>();
        ArrayList<Integer> intList = new ArrayList<Integer>();
        int totalNum = (int) (5 * Math.random()) + 5;

        int totalInt = 0;
        for (int i = 0; i < totalNum; i++) {
            int ranInt = (int) (Math.random() * 10) + 1;
            intList.add(ranInt);
            totalInt += ranInt;
        }
        for (int i = 0; i < totalNum; i++) {
            pieHelperArrayList.add(new PieHelper(100f * intList.get(i) / totalInt));
        }

        pieView.selectedPie(PlanPieView.NO_SELECTED_INDEX);
        pieView.showPercentLabel(true);
        pieView.setDate(pieHelperArrayList);
    }

    private void set(PlanPieView pieView) {
        ArrayList<PieHelper> pieHelperArrayList = new ArrayList<PieHelper>();
        pieHelperArrayList.add(new PieHelper(20, Color.BLACK));
        pieHelperArrayList.add(new PieHelper(6));
        pieHelperArrayList.add(new PieHelper(30));
        pieHelperArrayList.add(new PieHelper(12));
        pieHelperArrayList.add(new PieHelper(32));

        pieView.showPercentLabel(true);

        pieView.setDate(pieHelperArrayList);
        pieView.setOnPieClickListener(new PlanPieView.OnPieClickListener() {
            @Override public void onPieClick(int index) {
                if (index != PlanPieView.NO_SELECTED_INDEX) {
                    textView.setText(index + " selected");
                } else {
                    textView.setText("No selected pie");
                }
            }
        });

        pieView.selectedPie(2);
    }
}
