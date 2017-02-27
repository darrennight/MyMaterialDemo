package com.meterial.demo.CoordinatorLayout.third;

import android.content.Context;
import android.support.v7.widget.RecyclerView; 
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.meterial.demo.R;
import java.util.ArrayList;
import java.util.List;
 
/** 
 * Created by tangyangkai on 16/9/22. 
 */ 
 
public class MyRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> { 
 
 
    private Context context;
    private List<Integer> lists = new ArrayList<>();
    private LayoutInflater layoutInflater;
 
    public MyRecyclerAdapter(Context context, List<Integer> lists) {
        this.context = context;
        this.lists = lists;
        this.layoutInflater = LayoutInflater.from(context);
    } 
 
    @Override 
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyRecyclerViewHolder(layoutInflater.inflate(R.layout.item_list, null, false));
    } 
 
    @Override 
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
 
        MyRecyclerViewHolder viewHolder = (MyRecyclerViewHolder) holder;
        viewHolder.textView.setText(String.valueOf(lists.get(position)));
    } 
 
    @Override 
    public int getItemCount() { 
        return lists.size();
    } 
} 