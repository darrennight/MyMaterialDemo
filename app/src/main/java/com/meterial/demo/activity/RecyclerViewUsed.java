package com.meterial.demo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.meterial.demo.R;
import com.meterial.demo.adapter.RecyclerUseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zenghao on 15/12/2.
 */
public class RecyclerViewUsed extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener{

    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mSwipeLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_use_recycler);
        initView();
    }

    private void setRefresh(){
        mSwipeLayout.setOnRefreshListener(this);
//		mSwipeLayout.setColorSchemeColors(android.R.color.holo_green_dark, android.R.color.holo_green_light,
//				android.R.color.holo_orange_light, android.R.color.holo_red_light);


        // 设置下拉圆圈上的颜色，蓝色、绿色、橙色、红色
        mSwipeLayout.setColorSchemeResources(android.R.color.holo_blue_bright, android.R.color.holo_green_light,
                android.R.color.holo_orange_light, android.R.color.holo_red_light);

//	    mSwipeLayout.setDistanceToTriggerSync(400);// 设置手指在屏幕下拉多少距离会触发下拉刷新
//	    mSwipeLayout.setProgressBackgroundColor(android.R.color.holo_red_light); // 设定下拉圆圈的背景
//	    mSwipeLayout.setProgressBackgroundColorSchemeResource(android.R.color.holo_red_light);
//	    mSwipeLayout.setSize(SwipeRefreshLayout.LARGE); // 设置圆圈的大小

//        mSwipeLayout.post(new Runnable() {
//            @Override
//            public void run() {
//                mSwipeLayout.setRefreshing(true);
//            }
//        });
//
//        onRefresh();
    }

    private void initView() {

        mSwipeLayout = (SwipeRefreshLayout) findViewById(R.id.id_swipe_ly);
        setRefresh();

        mRecyclerView = ((RecyclerView) findViewById(R.id.recyclerview));

        //LinearLayoutManager lm = new LinearLayoutManager(this);
        //mRecyclerView.setLayoutManager(lm);

       // mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        GridLayoutManager manager = new GridLayoutManager(this, 3);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return (3 - position % 3);
            }
        });
        mRecyclerView.setLayoutManager(manager);


        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setHasFixedSize(true);
        //mRecyclerView.addItemDecoration(new MarginDecoration(this));

        List<String> list = new ArrayList<String>();
        for(int i=0;i<=50;i++){
            list.add(i+"");
        }
        RecyclerUseAdapter mAdapter = new RecyclerUseAdapter(this,list);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onRefresh() {

    }
}
