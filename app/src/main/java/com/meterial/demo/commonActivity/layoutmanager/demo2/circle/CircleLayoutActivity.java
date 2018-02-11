package com.meterial.demo.commonActivity.layoutmanager.demo2.circle;

import com.meterial.demo.commonActivity.layoutmanager.demo2.BaseActivity;
import com.meterial.demo.commonActivity.layoutmanager.demo2.CircleLayoutManager;

/**
 * Created by Dajavu on 25/10/2017.
 */

public class CircleLayoutActivity extends BaseActivity<CircleLayoutManager, CirclePopUpWindow> {

    @Override
    protected CircleLayoutManager createLayoutManager() {
        return new CircleLayoutManager(this);
    }

    @Override
    protected CirclePopUpWindow createSettingPopUpWindow() {
        return new CirclePopUpWindow(this, getViewPagerLayoutManager(), getRecyclerView());
    }
}