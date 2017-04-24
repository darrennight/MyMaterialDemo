package com.meterial.demo.commonActivity.spruce.sort;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

public class DefaultSort extends SortFunction {
 
    private final long interObjectDelay;
 
    /** 
     * Default sort; handles views with a provided offset delay 
     * @param interObjectDelay (long) delay between object animations 
     */ 
    public DefaultSort(long interObjectDelay) {
        this.interObjectDelay = interObjectDelay;
    } 
 
    @Override 
    public List<SpruceTimedView> getViewListWithTimeOffsets(ViewGroup parent, List<View> children) {
        List<SpruceTimedView> childTimedViews = new ArrayList<>();
        long currentTimeOffset = 0L;
 
        for (View childView : children) {
            childTimedViews.add(new SpruceTimedView(childView, currentTimeOffset));
            currentTimeOffset += interObjectDelay;
        } 
 
        return childTimedViews;
    } 
 
} 