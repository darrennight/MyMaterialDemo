package com.meterial.demo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.meterial.demo.R;
import com.meterial.demo.customview.BottomSheetDialogView;

/**
 * Created by zenghao on 16/3/9.
 */
public class BottomSheetActivity extends AppCompatActivity {

    private TextView mApiSupport;
    private TextView mNestedSV;
    private TextView btn_rv_behavior;
    private TextView btn_beaut;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_sheet);
        mApiSupport = ((TextView) findViewById(R.id.btn_api_support));
        mNestedSV = ((TextView) findViewById(R.id.btn_nsv));
        btn_rv_behavior = ((TextView) findViewById(R.id.btn_rv_behavior));
        btn_beaut = ((TextView) findViewById(R.id.btn_beaut));

        mApiSupport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialogView.show(BottomSheetActivity.this);
            }
        });

        mNestedSV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BottomSheetActivity.this,NestedScrollViewActivity.class));
            }
        });

        btn_rv_behavior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BottomSheetActivity.this,RecyclerViewBehaviorActivity.class));
            }
        });

        btn_beaut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BottomSheetActivity.this,BeautifulBottomSheetActivity.class));
            }
        });
    }
}
