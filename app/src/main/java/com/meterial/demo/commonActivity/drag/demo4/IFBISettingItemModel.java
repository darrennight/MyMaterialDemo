package com.meterial.demo.commonActivity.drag.demo4;
 

/** 
 * Created by Jacky on 2017/6/6. 
 * 
 */ 
 
public class IFBISettingItemModel implements IFBISettingItem { 
 
    private IFBIDimensionModel mDimensionModel;
 
    private boolean mIsDimension;
    private boolean mIsTarget;
 
    public IFBISettingItemModel(IFBIDimensionModel dimensionModel, boolean isDimension, boolean isTarget) {
        mDimensionModel = dimensionModel;
        mIsDimension = isDimension;
        mIsTarget = isTarget;
    } 
 
    @Override 
    public boolean isDimension() { 
        return mIsDimension;
    } 
 
    @Override 
    public boolean isTarget() { 
        return mIsTarget;
    } 
 
    public String getName() {
        return mDimensionModel.getName();
    } 
 
    public boolean isUsed() { 
        return mDimensionModel.isUsed();
    } 
 
    public String getID() {
        return mDimensionModel.getID();
    } 
 
    public void setUsed(boolean used) {
        mDimensionModel.setUsed(used);
    } 
 
} 