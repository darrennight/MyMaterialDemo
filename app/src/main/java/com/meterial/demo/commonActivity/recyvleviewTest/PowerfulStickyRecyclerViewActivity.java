package com.meterial.demo.commonActivity.recyvleviewTest;

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
 * 自定义View悬浮 
 */ 
public class PowerfulStickyRecyclerViewActivity extends AppCompatActivity { 
 
    @BindView(R.id.rv)
    RecyclerView mRv;
 
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
        mRv.setLayoutManager(manager);
        PowerfulStickyDecoration decoration = PowerfulStickyDecoration.Builder
                .init(new PowerGroupListener() { 
                    @Override 
                    public String getGroupName(int position) {
                        //获取组名，用于判断是否是同一组 
                        if (dataList.size() > position) {
                            return dataList.get(position).getProvince();
                        } 
                        return null; 
                    } 
 
                    @Override 
                    public View getGroupView(int position) {
                        //获取自定定义的组View 
                        if (dataList.size() > position) {
                            View view = getLayoutInflater().inflate(R.layout.item_group, null, false);
                            ((TextView) view.findViewById(R.id.tv)).setText(dataList.get(position).getProvince());
                            return view;
                        } else { 
                            return null; 
                        } 
                    } 
                }) 
                .setGroupHeight(DensityUtil.dip2px(this, 40))   //设置高度
                .build(); 
 
        mRv.addItemDecoration(decoration);
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
        mRv.setAdapter(mAdapter);
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