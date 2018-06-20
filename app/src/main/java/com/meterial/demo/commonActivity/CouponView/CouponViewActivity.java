package com.meterial.demo.commonActivity.CouponView;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import butterknife.BindView;
import com.meterial.demo.R;
import java.util.Arrays;
import java.util.List;

import butterknife.ButterKnife;

/**
 * https://github.com/dongjunkun/CouponView
 */
public class CouponViewActivity extends AppCompatActivity {

    @BindView(R.id.tab) TabLayout mTab;
    @BindView(R.id.pager) ViewPager mPager;

    private List<String> titles = Arrays.asList("半圆边缘", "虚线边框", "半圆虚线", "自定义属性", "自定义ImageView");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupon_view);
        ButterKnife.bind(this);
        mPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        mTab.setupWithViewPager(mPager);
    }

    public class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new CouponSemiCircleFragment();
                case 1:
                    return new CouponDashLineFragment();
                case 2:
                    return new CouponCombinationFragment();
                case 3:
                    return new CouponCustomFragment();
                case 4:
                    return new CouponImageViewFragment();
                default:
                    return new CouponSemiCircleFragment();
            }

        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }

        @Override
        public int getCount() {
            return titles.size();
        }
    }


}