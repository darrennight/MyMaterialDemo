package com.meterial.demo.commonActivity.spruce.sort;

import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ContinuousSort extends RadialSort {
 
    private final long duration;
    private final boolean reversed;
    private double maxDistance;
 
    /** 
     * Establishes the delay between object animations and their starting position based on distance, 
     * delay, and a value from the Position enum 
     * 
     * @param interObjectDelay delay between object animations 
     * @param reversed flag to indicate if the animation should be reversed 
     * @param position enum value of the position the animation should start from 
     */ 
    public ContinuousSort(long interObjectDelay, boolean reversed, Position position) {
        super(interObjectDelay, reversed, position);
        this.duration = interObjectDelay;
        this.reversed = reversed;
    } 
 
    @Override 
    public List<SpruceTimedView> getViewListWithTimeOffsets(ViewGroup parent, List<View> children) {
        final PointF comparisonPoint = getDistancePoint(parent, children);
 
        Collections.sort(children, new Comparator<View>() {
            @Override 
            public int compare(View left, View right) {
                double leftDistance = getDistanceBetweenPoints(Utils.viewToPoint(left), comparisonPoint);
                double rightDistance = getDistanceBetweenPoints(Utils.viewToPoint(right), comparisonPoint);
                if (leftDistance > rightDistance && leftDistance > maxDistance) {
                    maxDistance = leftDistance;
                } 
                return Double.compare(leftDistance, rightDistance);
            } 
        }); 
 
        List<SpruceTimedView> timedViews = new ArrayList<>();
        for (View view : children) {
            double normalizedDistance;
            double viewDistance = getDistanceBetweenPoints(Utils.viewToPoint(view), comparisonPoint);
            if (reversed) {
                normalizedDistance = (maxDistance - viewDistance) / maxDistance;
            } else { 
                normalizedDistance = viewDistance / maxDistance;
            } 
 
            long offset = Math.round(duration * normalizedDistance);
            timedViews.add(new SpruceTimedView(view, offset));
        } 
 
        return timedViews;
    } 
} 