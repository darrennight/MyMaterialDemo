package com.meterial.demo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import android.widget.TextView;
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
            holder.mNum = ((TextView) convertView.findViewById(R.id.tv_banner_num));
            convertView.setTag(holder);
        }else{
            holder = ((ViewHolder) convertView.getTag());

        }
        holder.mNum.setText(""+position);
//        mList.get(getPosition(position));

        holder.imageView.setImageResource(R.mipmap.ic_launcher);
        return convertView;
    }

    @Override
    public int getCount() {
        return isInfiniteLoop ? Integer.MAX_VALUE : mList.size();

        //如果层ViewPager中有两个或两个以上的Item的时候，则映射出边界Item，否则显示与内层个数一致
        //return mList.size() <= 1 ? mList.size() : mList.size() + 2;
    }


    public int getInnerAdapterPosition(int position) {
        //viewPager真正的可用的个数
        int realCount = getInnerCount();
        //内层没有可用的Item则换回为零
        if (realCount == 0)
            return 0;
        int realPosition = (position - 1) % realCount;
        if (realPosition < 0)
            realPosition += realCount;
        return realPosition;
    }

    public int toLooperPosition(int position) {
        if (getInnerCount() > 1) {
            return position + 1;
        } else return position;
    }

    public int getInnerCount() {
        return mList.size();
    }

    class ViewHolder {
        ImageView imageView;
        TextView mNum;
    }
}
