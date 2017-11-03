package com.meterial.demo.sticky;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.meterial.demo.R;

/**
 * TODO
 *
 * @author zenghao
 * @since 2017/10/16 上午11:59
 */
public class StickyAdapter01 extends RecyclerView.Adapter<StickyAdapter01.StickyHolder> {


    private Context mContext;
    public StickyAdapter01(Context context){

        this.mContext = context;
    }
    @Override
    public StickyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.layout_sticky_item,parent,false);

        return new StickyHolder(itemView);
    }

    @Override
    public void onBindViewHolder(StickyHolder holder, int position) {

        if(position == 2){
            holder.tv_text.setTextColor(Color.parseColor("#ffca28"));
            holder.tv_text.setBackgroundResource(R.color.black);
        }else{
            holder.tv_text.setTextColor(Color.parseColor("#000000"));
            holder.tv_text.setBackgroundResource(R.color.white);
        }

    }

    @Override
    public int getItemCount() {
        return 20;
    }

    class StickyHolder extends RecyclerView.ViewHolder{
        TextView tv_text;
        public StickyHolder(View itemView) {
            super(itemView);
            tv_text = ((TextView) itemView.findViewById(R.id.tv_item_sticky01));
        }
    }
}
