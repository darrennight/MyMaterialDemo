package com.meterial.demo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.meterial.demo.R;
import com.meterial.demo.holder.MyBaseHolder;
import com.meterial.demo.holder.UseRecycleHolder;

import java.util.List;

/**
 * Created by zenghao on 15/12/2.
 */
public class RecyclerUseAdapter extends RecyclerView.Adapter<MyBaseHolder> {
    private Context mContext;
    private List<String> mList;
    public RecyclerUseAdapter(Context context,List<String> list){
        this.mContext = context;
        this.mList = list;

    }
    @Override
    public MyBaseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View holderView =  LayoutInflater.from(mContext).inflate(R.layout.item_use_recycle,parent,false);
        UseRecycleHolder holder = new UseRecycleHolder(holderView);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyBaseHolder holder, int position) {

        UseRecycleHolder myHolder = ((UseRecycleHolder) holder);
        myHolder.mTxt.setText(mList.get(position));

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }
}
