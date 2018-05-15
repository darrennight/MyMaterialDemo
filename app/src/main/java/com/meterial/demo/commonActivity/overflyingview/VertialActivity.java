package com.meterial.demo.commonActivity.overflyingview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.meterial.demo.R;
import java.util.ArrayList;

public class VertialActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ItemAdapter mAdapter;
    private ArrayList<String> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vertial);
        initView();
    }

    private void initView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        OverFlyingLayoutManager layoutManager = new OverFlyingLayoutManager(OrientationHelper.VERTICAL,true);
        mRecyclerView.setLayoutManager(layoutManager);

        //构建一个临时数据源
        for (int i = 0; i < 1126; i++) {
            items.add("Item:第" + i + "项");
        }
        mAdapter = new ItemAdapter(items);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListerer(new ItemAdapter.onItemClickListener() {
            @Override
            public void onItemClick(View view) {
                Toast.makeText(VertialActivity.this, "", Toast.LENGTH_SHORT).show();
            }
        });
    }


}