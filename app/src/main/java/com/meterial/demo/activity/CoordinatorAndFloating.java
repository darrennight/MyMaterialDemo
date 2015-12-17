package com.meterial.demo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.meterial.demo.R;
import com.meterial.demo.fragment.CheeseListFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zenghao on 15/12/1.
 */
public class CoordinatorAndFloating extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_coordinator);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        if (viewPager != null) {
            setupViewPager(viewPager);
        }
        viewPager.setOffscreenPageLimit(1);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        Adapter adapter = new Adapter(getSupportFragmentManager());
        adapter.addFragment(new CheeseListFragment(), "Category 1");
        adapter.addFragment(new CheeseListFragment(), "Category 2");
        adapter.addFragment(new CheeseListFragment(), "Category 3");
        adapter.addFragment(new CheeseListFragment(), "Category 4");
        adapter.addFragment(new CheeseListFragment(), "Category 5");
        adapter.addFragment(new CheeseListFragment(), "Category 6");
        viewPager.setAdapter(adapter);
    }

    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mFragmentTitles = new ArrayList<>();

        public Adapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment, String title) {
            mFragments.add(fragment);
            mFragmentTitles.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitles.get(position);
        }
    }


//    @Override
//    public void onBindViewHolder(final MyViewHolder holder, final int position) {
//
//        final ModelBean bean = list.get(position);
//        holder.title.setText(bean.getTitle());
//        holder.imageView.setImageResource(bean.getResId());
//        Bitmap bitmap = BitmapFactory.decodeResource(res, bean.getResId());
//        //异步获得bitmap图片颜色值
//        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
//            @Override
//            public void onGenerated(Palette palette) {
//                Palette.Swatch vibrant = palette.getVibrantSwatch();//有活力
//                Palette.Swatch c = palette.getDarkVibrantSwatch();//有活力 暗色
//                Palette.Swatch d = palette.getLightVibrantSwatch();//有活力 亮色
//                Palette.Swatch f = palette.getMutedSwatch();//柔和
//                Palette.Swatch a = palette.getDarkMutedSwatch();//柔和 暗色
//                Palette.Swatch b = palette.getLightMutedSwatch();//柔和 亮色
//
//                if (vibrant != null) {
//                    int color1 = vibrant.getBodyTextColor();//内容颜色
//                    int color2 = vibrant.getTitleTextColor();//标题颜色
//                    int color3 = vibrant.getRgb();//rgb颜色
//
//                    holder.title.setBackgroundColor(
//                            vibrant.getRgb());
//                    holder.title.setTextColor(
//                            vibrant.getTitleTextColor());
//                }
//            }
//        });
}
