package com.meterial.demo.commonActivity.drag.demo4;


/**
 * Created by Jacky on 2017/6/13.
 *
 *列举一种实现
 */

public class SampleStrategy extends IFBISettingStrategy {

    public SampleStrategy(IFBIBaseWidgetModel widgetModel) {
        super(widgetModel);
    }

    @Override
    protected void onClickXDimension(IFBISettingItemModel item) {
        multiSelect(item);
    }

    @Override
    protected void onClickYDimension(IFBISettingItemModel item) {
        singleSelect(item);
    }

    @Override
    protected void onClickTargets(IFBISettingItemModel item) {
        singleSelect(item);
    }

    @Override
    protected void onMoveToYDimension(IFBISettingItemModel fromModel) {
        checkSingleSelect(fromModel);
    }

    @Override
    protected void onMoveToXTarget(IFBISettingItemModel fromModel) {
        checkSingleSelect(fromModel);
    }

    @Override
    protected void onMoveToYTarget(IFBISettingItemModel fromModel) {
        checkSingleSelect(fromModel);
    }

    @Override
    protected void onMoveToZTarget(IFBISettingItemModel fromModel) {
        checkSingleSelect(fromModel);
    }

    @Override
    protected void addDimension1Title() {
        addTitleItem(Constant.REGION.DIMENSION1, "分类");
    }

    @Override
    protected void addDimension2Title() {
        addTitleItem(Constant.REGION.DIMENSION2, "系列");
    }

    @Override
    protected void addTarget1Title() {
        addTitleItem(Constant.REGION.TARGET1, "x");
    }

    @Override
    protected void addTarget2Title() {
        addTitleItem(Constant.REGION.TARGET2, "y");
    }

    @Override
    protected void addTarget3Title() {
        addTitleItem(Constant.REGION.TARGET3, "z");
    }
}