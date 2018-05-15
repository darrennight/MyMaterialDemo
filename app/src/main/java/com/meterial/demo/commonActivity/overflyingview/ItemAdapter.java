package com.meterial.demo.commonActivity.overflyingview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.meterial.demo.R;
import java.util.ArrayList;

/**
 * Created by LuckyCrystal on 2017/6/6.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.viewHolder> {

    private ArrayList<String> items = new ArrayList<>();
    private onItemClickListener mOnItemClickListerer;

    public ItemAdapter(ArrayList<String> items) {
        this.items = items;
    }

    public void setOnItemClickListerer(onItemClickListener onItemClickListerer) {
        mOnItemClickListerer = onItemClickListerer;
    }

    @Override
    public viewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_card_over,
                viewGroup, false);
        if (mOnItemClickListerer != null) {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListerer.onItemClick(v);
                }
            });
        }
        return new viewHolder(view);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public void onBindViewHolder(viewHolder viewHolder, int position) {
        String info = items.get(position);
        viewHolder.textView.setText(info);
    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    class viewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public viewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.info_text);
        }
    }

   public interface onItemClickListener {
        void onItemClick(View view);
    }
}