package com.meterial.demo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.meterial.demo.R;

import java.util.List;

/**
 * Created by zenghao on 15/12/1.
 */
public class BannerAdapter extends RecyclingPagerAdapter {
    private boolean isInfiniteLoop;
    private Context mContext;
    private List<String> mList;
    public BannerAdapter(Context context,List<String> list){
        this.mContext = context;
        this.mList = list;

    }
    private int getPosition(int position) {
        return isInfiniteLoop ? position % mList.size() : position;
    }
    /**
     * @return the isInfiniteLoop
     */
    public boolean isInfiniteLoop() {
        return isInfiniteLoop;
    }

    /**
     * @param isInfiniteLoop the isInfiniteLoop to set
     */
    public void setInfiniteLoop(boolean isInfiniteLoop) {
        this.isInfiniteLoop = isInfiniteLoop;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup container) {
        ViewHolder holder;
        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.banner_item,null,false);
            holder = new ViewHolder();
            holder.imageView = ((ImageView) convertView.findViewById(R.id.iv_banner));
            convertView.setTag(holder);
        }else{
            holder = ((ViewHolder) convertView.getTag());

        }
//        mList.get(getPosition(position));

        holder.imageView.setImageResource(R.mipmap.ic_launcher);
        return convertView;
    }

    @Override
    public int getCount() {
        return isInfiniteLoop ? Integer.MAX_VALUE : mList.size();
    }

    class ViewHolder {
        ImageView imageView;
    }
}
