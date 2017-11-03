package com.meterial.demo.calendar;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * @author zenghao
 * @since 2017/7/12 上午10:34
 */
public class MonthViewGrid extends GridView {

    public MonthViewGrid(Context context) {
        super(context);
    }

    public MonthViewGrid(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MonthViewGrid(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
