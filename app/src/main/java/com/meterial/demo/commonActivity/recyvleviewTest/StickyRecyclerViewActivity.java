package com.meterial.demo.commonActivity.recyvleviewTest;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity; 
import android.support.v7.widget.LinearLayoutManager; 
import android.support.v7.widget.RecyclerView; 
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.meterial.demo.R;
import java.util.ArrayList;
import java.util.List;
 
import butterknife.BindView; 
import butterknife.ButterKnife; 
 
/** 
 * 文字悬浮 
 */ 
public class StickyRecyclerViewActivity extends AppCompatActivity { 
 
    @BindView(R.id.rv)
    RecyclerView mRecyclerView;
 
    RecyclerView.Adapter mAdapter; 
    List<City> dataList = new ArrayList<>();
 
    @Override 
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sticky_recycler_view);
        ButterKnife.bind(this);
        initView(); 
    } 
 
    private void initView() { 
        //模拟数据 
        dataList.addAll(CityUtil.getCityList());
        dataList.addAll(CityUtil.getCityList());
 
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(manager);
        //使用StickyDecoration 
        StickyDecoration decoration = StickyDecoration.Builder
                .init(new GroupListener() { 
                    @Override 
                    public String getGroupName(int position) {
                        //组名回调 
                        if (dataList.size() > position) {
                            //获取城市对应的省份 
                            return dataList.get(position).getProvince();
                        } 
                        return null; 
                    } 
                }) 
                .setGroupBackground(Color.parseColor("#48BDFF"))    //背景色
                .setGroupHeight(DensityUtil.dip2px(this, 35))       //高度
                .setGroupTextColor(Color.WHITE)                     //字体颜色
                .setGroupTextSize(DensityUtil.sp2px(this, 15))      //字体大小
                .setTextLeftMargin(DensityUtil.dip2px(this, 10))    //左边距
                .build(); 
        mRecyclerView.addItemDecoration(decoration);
 
        mAdapter = new RecyclerView.Adapter() { 
            @Override 
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) { 
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view, parent, false); 
                return new Holder(view); 
            } 
 
            @Override 
            public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) { 
                Holder holder = (Holder) viewHolder; 
                holder.mTextView.setText(dataList.get(position).getName()); 
            } 
 
            @Override 
            public int getItemCount() { 
                return dataList.size(); 
            } 
        }; 
        mRecyclerView.setAdapter(mAdapter);
    } 
 
    static class Holder extends RecyclerView.ViewHolder { 
        @BindView(R.id.tv)
        TextView mTextView;
 
        public Holder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        } 
    } 
} 