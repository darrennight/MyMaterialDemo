package com.meterial.demo.CoordinatorLayout.easeBehavior.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import com.meterial.demo.CoordinatorLayout.easeBehavior.CommonTabLayout;
import com.meterial.demo.CoordinatorLayout.easeBehavior.CustomTabEntity;
import com.meterial.demo.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * TODO
 *https://github.com/JmStefanAndroid/EasyBehavior
 * NestedScrollView 嵌套 RecyclerView
 * RecyclerViewitem全部加载了 感觉不可用
 * @author zenghao
 * @since 2017/7/4 上午11:09
 */
public class TestActivity16 extends AppCompatActivity {

    private CommonTabLayout mTablayout;
    private ViewPager mViewPager;

    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private List<Fragment> fragments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test16);


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