package com.meterial.demo.commonActivity.ship.view2;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
 
import java.util.ArrayList;
import java.util.List;
 
public class ChipsVerticalLinearLayout extends LinearLayout {
 
    private List<LinearLayout> mLineLayouts = new ArrayList<>();
 
    private float mDensity;
    private int mRowSpacing;
 
    public ChipsVerticalLinearLayout(Context context, int rowSpacing) {
        super(context);
 
        mDensity = getResources().getDisplayMetrics().density;
        mRowSpacing = rowSpacing;
 
        init(); 
    } 
 
    private void init() { 
        setOrientation(VERTICAL);
    } 
 
    public TextLineParams onChipsChanged(List<ChipsView.Chip> chips) {
        clearChipsViews(); 
 
        int width = getWidth();
        if (width == 0) {
            return null; 
        } 
        int widthSum = 0;
        int chipsCount = 0;
        int rowCounter = 0;
 
        LinearLayout ll = createHorizontalView();
 
        for (ChipsView.Chip chip : chips) {
            View view = chip.getView();
            view.measure(MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED), MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
 
            // if width exceed current width. create a new LinearLayout 
            if (widthSum + view.getMeasuredWidth() > width) {
                rowCounter++;
                widthSum = 0;
                chipsCount = 0;
                ll = createHorizontalView();
            } 
 
            widthSum += view.getMeasuredWidth();
            chipsCount++;
            ll.addView(view);
        } 
 
        // check if there is enough space left 
        if (width - widthSum < width * 0.1f) {
            widthSum = 0;
            chipsCount = 0;
            rowCounter++;
        } 
        if (width == 0) {
            rowCounter = 0;
        } 
        return new TextLineParams(rowCounter, widthSum, chipsCount);
    } 
 
    private LinearLayout createHorizontalView() {
        LinearLayout ll = new LinearLayout(getContext());
        ll.setPadding(0, 0, 0, mRowSpacing);
        ll.setOrientation(HORIZONTAL);
        addView(ll);
        mLineLayouts.add(ll);
        return ll;
    } 
 
    private void clearChipsViews() { 
        for (LinearLayout linearLayout : mLineLayouts) {
            linearLayout.removeAllViews();
        } 
        mLineLayouts.clear();
        removeAllViews();
    } 
 
    public static class TextLineParams { 
        public int row;
        public int lineMargin;
        public int chipsCount = 0;
 
        public TextLineParams(int row, int lineMargin, int chipsCount) {
            this.row = row;
            this.lineMargin = lineMargin;
            this.chipsCount = chipsCount;
        } 
    } 
} 