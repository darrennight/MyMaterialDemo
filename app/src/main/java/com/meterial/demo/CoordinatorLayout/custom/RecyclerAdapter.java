package com.meterial.demo.CoordinatorLayout.custom;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.meterial.demo.R;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    private Context mContext;
    private List<String> mDatas;
 
    public RecyclerAdapter(Context context, List<String> datas) {
        mContext = context;
        mDatas = datas;
    } 
 
    @Override 
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                mContext).inflate(R.layout.item_test_coor_item, parent, false));
        return holder;
    } 
 
    @Override 
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv.setText(mDatas.get(position));
    } 
 
    @Override 
    public int getItemCount() { 
        return mDatas.size();
    } 
 
    class MyViewHolder extends RecyclerView.ViewHolder { 
        TextView tv;
 
        public MyViewHolder(View view) {
            super(view);
            tv = (TextView) view.findViewById(R.id.tv_num);
        } 
    } 
} 