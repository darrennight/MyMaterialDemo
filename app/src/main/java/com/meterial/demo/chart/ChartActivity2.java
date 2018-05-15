package com.meterial.demo.chart;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.meterial.demo.R;
import com.meterial.demo.chart.view.MyView;

/**
 * @author zenghao
 * @since 2018/4/11 下午6:17
 */
public class ChartActivity2 extends AppCompatActivity {

    private EditText editText;
    private Button btn;
    private MyView myView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart2);

        myView = (MyView) findViewById(R.id.myview);

        editText = (EditText) findViewById(R.id.edit);

        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(editText.getText().toString().trim())) {
                    myView.aDDEntry(editText.getText().toString().trim());
                }
            }
        });


    }
}