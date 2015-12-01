package com.meterial.demo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.meterial.demo.R;
import com.meterial.demo.holder.MyBaseHolder;
import com.meterial.demo.holder.MySimpleHolder;
import com.meterial.demo.holder.OnItemClick;

import java.util.List;

/**
 * Created by zenghao on 15/11/30.
 */
public class MySimpleAdapter extends RecyclerView.Adapter<MyBaseHolder> {

    private Context mContext;
    private List<String> mList;
    private OnItemClick mClick;
    public MySimpleAdapter(Context con,List<String> list,OnItemClick click){
            this.mContext = con;
            this.mList = list;
            mClick = click;
    }

    @Override
    public MyBaseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View holderView = inflater.inflate(R.layout.list_item, parent, false);

        return new MySimpleHolder(holderView,mClick);
    }

    @Override
    public void onBindViewHolder(MyBaseHolder holder, int position) {
                String s = mList.get(position);
                MySimpleHolder msh = ((MySimpleHolder) holder);
                msh.txt.setText(s);
                msh.header.setImageResource(R.mipmap.ic_launcher);
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
