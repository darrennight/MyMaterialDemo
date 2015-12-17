package com.meterial.demo.holder;

import android.view.View;
import android.widget.TextView;

import com.meterial.demo.R;

/**
 * Created by zenghao on 15/12/2.
 */
public class UseRecycleHolder extends MyBaseHolder {

    public TextView mTxt;
    public UseRecycleHolder(View itemView){
        super(itemView);
        mTxt = ((TextView) itemView.findViewById(R.id.tv_txt));
    }
}
