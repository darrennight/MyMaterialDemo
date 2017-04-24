package com.meterial.demo.commonActivity.spruce.sort;

import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class InlineSort extends CorneredSort {
 
    private final long interObjectDelay;
    private final boolean reversed;
 
    /** 
     * Animate child views from side to side (based on the provided corner parameter). 
     * 
     * @param interObjectDelay long delay between objects 
     * @param reversed boolean indicating if the selection is reversed 
     * @param corner {@link com.willowtreeapps.spruce.sort.CorneredSort.Corner Corner} value to start from 
     */ 
    public InlineSort(long interObjectDelay, boolean reversed, Corner corner) {
        super(interObjectDelay, reversed, corner);
        this.interObjectDelay = interObjectDelay;
        this.reversed = reversed;
    } 
 
    @Override 
    public List<SpruceTimedView> getViewListWithTimeOffsets(ViewGroup parent, List<View> children) {
        final PointF comparisonPoint = getDistancePoint(parent, children);
        List<SpruceTimedView> timedViews = new ArrayList<>();
        long currentTimeOffset = 0;
 
        Collections.sort(children, new Comparator<View>() {
            @Override 
            public int compare(View left, View right) {
                double leftHorizontalDistance = Utils.horizontalDistance(comparisonPoint, Utils.viewToPoint(left));
                double leftVerticalDistance = Utils.verticalDistance(comparisonPoint, Utils.viewToPoint(left));
                double rightHorizontalDistance = Utils.horizontalDistance(comparisonPoint, Utils.viewToPoint(right));
                double rightVerticalDistance = Utils.verticalDistance(comparisonPoint, Utils.viewToPoint(right));
 
                if (leftVerticalDistance < rightVerticalDistance ||
                        leftVerticalDistance == rightVerticalDistance &&
                                leftHorizontalDistance < rightHorizontalDistance) {
                    return -1; 
                } 
                return 1; 
            } 
        }); 
 
        if (reversed) {
            Collections.reverse(children);
        } 
 
        for (View view : children) {
            timedViews.add(new SpruceTimedView(view, currentTimeOffset));
            currentTimeOffset += interObjectDelay;
        } 
 
        return timedViews;
    } 
 
} 