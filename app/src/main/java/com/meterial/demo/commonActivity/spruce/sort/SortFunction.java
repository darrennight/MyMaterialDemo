package com.meterial.demo.commonActivity.spruce.sort;

import android.view.View;
import android.view.ViewGroup;
import java.util.List;
 
public abstract class SortFunction { 
 
    /** 
     * Get a list of SpruceTimedView 
     * 
     * @param parent ViewGroup parent of the collection of child views 
     * @param children List of views to be animated 
     * @return List of SpruceTimedView objects that contain the view and it's offset 
     */ 
    public abstract List<SpruceTimedView> getViewListWithTimeOffsets(ViewGroup parent, List<View> children);
 
} 