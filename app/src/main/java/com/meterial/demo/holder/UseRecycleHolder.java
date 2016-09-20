package com.meterial.demo.holder;

import android.view.View;
import android.widget.EditText;

import com.meterial.demo.R;

/**
 * Created by zenghao on 15/12/2.
 */
public class UseRecycleHolder extends MyBaseHolder {

    public EditText mTxt;
    public UseRecycleHolder(View itemView){
        super(itemView);
        mTxt = ((EditText) itemView.findViewById(R.id.tv_txt));
    }
}
