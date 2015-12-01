package com.meterial.demo.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.meterial.demo.R;

/**
 * Created by zenghao on 15/11/30.
 */
public class MySimpleHolder extends MyBaseHolder {
    public ImageView header;
    public TextView txt;
    public MySimpleHolder(View itemView, final OnItemClick click){
        super(itemView);
        header = ((ImageView) itemView.findViewById(R.id.avatar));
        txt = ((TextView) itemView.findViewById(R.id.text1));
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click.onItemClick(getAdapterPosition());
            }
        });
    }
}
