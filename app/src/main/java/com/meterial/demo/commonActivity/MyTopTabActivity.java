package com.meterial.demo.commonActivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import com.meterial.demo.R;
import com.meterial.demo.customview.TopTab.BreadTopTable;
import com.meterial.demo.customview.TopTab.SimpleCardFragment;
import java.util.ArrayList;

/**
 *https://github.com/ogaclejapan/SmartTabLayout
 * https://github.com/hackware1993/MagicIndicator
 *
 * use : https://github.com/H07000223/FlycoRoundView
 * @author zenghao
 * @since 2017/5/10 下午5:10
 */
public class MyTopTabActivity extends AppCompatActivity {

    private BreadTopTable mTab;
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private ViewPager mViewPager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_tab);
        mTab = ((BreadTopTable) findViewById(R.id.btt_tab));
        mViewPager = ((ViewPager) findViewById(R.id.vp));

        for(int i=0;i<20;i++){
            mFragments.add(SimpleCardFragment.getInstance(String.valueOf(i)));
            mTab.addTab(String.valueOf(i));
        }

        mViewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        mTab.setViewPager(mViewPager);
    }


    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }


        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }
    }
}
