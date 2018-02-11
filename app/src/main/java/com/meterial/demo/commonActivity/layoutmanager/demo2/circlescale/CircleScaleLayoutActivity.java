package com.meterial.demo.commonActivity.layoutmanager.demo2.circlescale;

import com.meterial.demo.commonActivity.layoutmanager.demo2.BaseActivity;
import com.meterial.demo.commonActivity.layoutmanager.demo2.CircleScaleLayoutManager;

/**
 * Created by Dajavu on 27/10/2017.
 */

public class CircleScaleLayoutActivity extends
        BaseActivity<CircleScaleLayoutManager, CircleScalePopUpWindow> {

    @Override
    protected CircleScaleLayoutManager createLayoutManager() {
        return new CircleScaleLayoutManager(this);
    }

    @Override
    protected CircleScalePopUpWindow createSettingPopUpWindow() {
        return new CircleScalePopUpWindow(this, getViewPagerLayoutManager(), getRecyclerView());
    }
}