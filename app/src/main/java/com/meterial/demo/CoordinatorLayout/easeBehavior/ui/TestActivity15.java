package com.meterial.demo.CoordinatorLayout.easeBehavior.ui;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.jaeger.library.StatusBarUtil;
import com.meterial.demo.CoordinatorLayout.easeBehavior.CommonTabLayout;
import com.meterial.demo.CoordinatorLayout.easeBehavior.CustomTabEntity;
import com.meterial.demo.CoordinatorLayout.easeBehavior.OnTabSelectListener;
import com.meterial.demo.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * TODO
 *https://github.com/JmStefanAndroid/EasyBehavior
 * @author zenghao
 * @since 2017/7/4 上午11:09
 */
public class TestActivity15 extends AppCompatActivity {

    private CommonTabLayout mTablayout;
    private ViewPager mViewPager;

    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private List<Fragment> fragments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test15);


        mTablayout = (CommonTabLayout) findViewById(R.id.uc_tablayout);
        mViewPager = (ViewPager) findViewById(R.id.uc_viewpager);

        initTab();
    }

    /**
     * 初始化tab
     */
    private void initTab() {
        fragments = getFragments();
        MyFragmentPagerAdapter myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), fragments, getNames());

        mTablayout.setTabData(mTabEntities);
        mViewPager.setAdapter(myFragmentPagerAdapter);
    }
    public List<Fragment> getFragments() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new ItemFragment());
        fragments.add(new ItemFragment());
        fragments.add(new ItemFragment());
        fragments.add(new ItemFragment());
        return fragments;
    }
    /**
     * 假数据
     *
     * @return
     */
    public String[] getNames() {
        String[] mNames = new String[]{"Weather", "Moon", "Like", "Fans"};
        for (String str : mNames) {
            mTabEntities.add(new TabEntity(String.valueOf(new Random().nextInt(200)), str));
        }

        return mNames;
    }
}