package com.meterial.demo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.view.ViewPager;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.meterial.demo.R;
import com.meterial.demo.adapter.BannerAdapter;
import com.meterial.demo.customview.AutoScrollViewPager;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zenghao on 15/12/1.
 */
public class BannerActivity extends SwipeActivity {

    private AutoScrollViewPager viewPager;
    private BannerAdapter mAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);
        setSwipeAnyWhere(false);
        initView();
    }
    private void initView(){
        viewPager = ((AutoScrollViewPager) findViewById(R.id.as_pager_movie));
        viewPager.setWeakReference(new WeakReference<Activity>(this));

        List<String> list = new ArrayList<String>();
        mAdapter = new BannerAdapter(this,list);
        mAdapter.setInfiniteLoop(true);
        viewPager.setAdapter(mAdapter);

        viewPager.addOnPageChangeListener(new MyOnPageChangeListener());

        viewPager.setInterval(5000);
        viewPager.startAutoScroll();
        viewPager.setAutoScrollDurationFactor(10);
        viewPager.setStopScrollWhenTouch(true);
        //viewPager.setCurrentItem(1000*imageIdList.size());
        //viewPager显示之前设置没问题 显示之后显示卡
        viewPager.setCurrentItem(Integer.MAX_VALUE/2);
        viewPager.setCycle(true);

        final TextInputLayout inputLayout = (TextInputLayout)findViewById(R.id.textInput);
        inputLayout.setHint("请输入姓名:");

        EditText editText = inputLayout.getEditText();
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length()>4){
                    inputLayout.setErrorEnabled(true);
                    inputLayout.setError("姓名长度不能超过4个");
                }else{
                    inputLayout.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }


    class MyOnPageChangeListener implements ViewPager.OnPageChangeListener{
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}
