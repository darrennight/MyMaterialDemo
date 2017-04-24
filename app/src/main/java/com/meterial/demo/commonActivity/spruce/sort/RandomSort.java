package com.meterial.demo.commonActivity.spruce.sort;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomSort extends SortFunction {
 
    private final long interObjectDelay;
 
    /** 
     * Random sort pattern that utilizes {@link Collections#shuffle(List) shuffle()} 
     * 
     * @param interObjectDelay 
     */ 
    public RandomSort(long interObjectDelay) {
        this.interObjectDelay = interObjectDelay;
    } 
 
    @Override 
    public List<SpruceTimedView> getViewListWithTimeOffsets(ViewGroup parent, List<View> children) {
        // randomize view list 
        Collections.shuffle(children);
 
        List<SpruceTimedView> timedViews = new ArrayList<>();
        long currentTimeOffset = 0;
 
        for (View view : children) {
            timedViews.add(new SpruceTimedView(view, currentTimeOffset));
            currentTimeOffset += interObjectDelay;
        } 
 
        return timedViews;
    } 
 
} 