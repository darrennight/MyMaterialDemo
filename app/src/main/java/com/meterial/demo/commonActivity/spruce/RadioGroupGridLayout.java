package com.meterial.demo.commonActivity.spruce;

import android.content.Context;
import android.support.v7.widget.AppCompatRadioButton;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.RadioButton;
import com.meterial.demo.R;
import com.meterial.demo.commonActivity.spruce.sort.RadialSort;

public class RadioGroupGridLayout extends GridLayout implements View.OnClickListener {
 
    private AppCompatRadioButton activeRadioButton;
    private RadialSort.Position position;
    private OnChangedListener listener;
 
    public RadioGroupGridLayout(Context context) {
        super(context);
        init(); 
    } 
 
    public RadioGroupGridLayout(Context context, OnChangedListener listener) {
        super(context);
        this.listener = listener;
        init(); 
    } 
 
    public RadioGroupGridLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(); 
    } 
 
    private void init() { 
        // set default position 
        position = RadialSort.Position.TOP_LEFT;
    } 
 
    @Override 
    public void onClick(View view) {
        final AppCompatRadioButton rb = (AppCompatRadioButton) view;
        if ( activeRadioButton != null ) {
            activeRadioButton.setChecked(false);
        } 
        rb.setChecked(true);
        activeRadioButton = rb;
 
        switch (getCheckedRadioButtonId()) 
        { 
            case R.id.top_left:
                position = RadialSort.Position.TOP_LEFT;
                break; 
            case R.id.top_middle:
                position = RadialSort.Position.TOP_MIDDLE;
                break; 
            case R.id.top_right:
                position = RadialSort.Position.TOP_RIGHT;
                break; 
            case R.id.right:
                position = RadialSort.Position.RIGHT;
                break; 
            case R.id.middle:
                position = RadialSort.Position.MIDDLE;
                break; 
            case R.id.left:
                position = RadialSort.Position.LEFT;
                break; 
            case R.id.bottom_left:
                position = RadialSort.Position.BOTTOM_LEFT;
                break; 
            case R.id.bottom_middle:
                position = RadialSort.Position.BOTTOM_MIDDLE;
                break; 
            case R.id.bottom_right:
                position = RadialSort.Position.BOTTOM_RIGHT;
                break; 
        } 
        listener.onRadioGroupChildChanged();
    } 
 
    @Override 
    public void addView(View child, ViewGroup.LayoutParams params) {
        super.addView(child, params);
        setChildrenOnClickListener((AppCompatRadioButton) child);
    } 
 
    public void onResume() { 
        // reset to default 
        AppCompatRadioButton activeRadioButton = this.activeRadioButton;
        clearCheckedChildren(); 
        this.activeRadioButton = activeRadioButton;
        this.activeRadioButton.setChecked(true);
    } 
 
    private void setChildrenOnClickListener(AppCompatRadioButton child) {
        GridLayout parent = (GridLayout) child.getParent();
        final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View v = parent.getChildAt(i);
            if (v instanceof AppCompatRadioButton) {
                if (((RadioButton) v).isChecked()) {
                    activeRadioButton = (AppCompatRadioButton) v;
                } 
                v.setOnClickListener(this);
            } 
        } 
    } 
 
    private void clearCheckedChildren() { 
        for (int i = 0; i < getChildCount(); i++) {
            if (getChildAt(i) instanceof AppCompatRadioButton) {
                ((AppCompatRadioButton) getChildAt(i)).setChecked(false);
            } 
        } 
    } 
 
    private int getCheckedRadioButtonId() { 
        if (activeRadioButton != null) {
            return activeRadioButton.getId();
        } 
 
        return -1; 
    } 
 
    public RadialSort.Position getPosition() { 
        return position;
    } 
 
    public void setGroupChildChangedListener(OnChangedListener listener) {
        this.listener = listener;
    } 
 
    public interface OnChangedListener { 
        void onRadioGroupChildChanged(); 
    } 
 
} 