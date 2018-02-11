package com.meterial.demo.excelpanel;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import com.meterial.demo.R;
import java.util.Arrays;
import java.util.List;

/**
 * @author zenghao
 * @since 2018/1/12 上午11:15
 */
public class ExcelPanelActivity extends AppCompatActivity {

    private ViewPager pager;
    private TabLayout tabLayout;
    private List<ExcelFragment> list = Arrays.asList(new ExcelFragment(), new ExcelFragment(),
            new ExcelFragment(), new ExcelFragment(), new ExcelFragment());

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excel_panel);
        pager = (ViewPager) findViewById(R.id.pager);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        pager.setAdapter(new ExcelPagerAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(pager);
        tabLayout.setTabTextColors(Color.WHITE, Color.WHITE);
    }
    class ExcelPagerAdapter extends FragmentStatePagerAdapter {

        public ExcelPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "Item:" + position;
        }
    }

}
