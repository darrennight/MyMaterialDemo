package com.meterial.demo.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.meterial.demo.MainActivity;
import com.meterial.demo.R;
import com.meterial.demo.adapter.RecyclingPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zenghao on 15/12/1.
 */
public class GuideActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private ImageView[] imageViews;
    private LinearLayout mPoint;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_guide);
        initView();
    }
    private void initView(){
        mViewPager = ((ViewPager) findViewById(R.id.vp_guide));
        mPoint = ((LinearLayout) findViewById(R.id.layout_point));
        List<String> list = new ArrayList<String>();
        list.add("");
        list.add("");
        list.add("");
        imageViews = new ImageView[list.size()];
        for(int i=0;i<list.size();i++){
            ImageView imageView = new ImageView(GuideActivity.this);
            imageView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
            imageView.setPadding(20, 0, 20, 0);
            imageViews[i] = imageView;
            if(i==0){
                imageViews[i].setImageResource(R.drawable.page_indicator_focused);
            }else{
                imageViews[i].setImageResource(R.drawable.page_indicator);
            }
            mPoint.addView(imageViews[i]);

        }

        mViewPager.setAdapter(new GuideAdapter(this,list));
        mViewPager.addOnPageChangeListener(new GuidePagerChange());

    }

    class GuideAdapter extends RecyclingPagerAdapter{
        private Context mContext;
        private List<String> mList;
        public GuideAdapter(Context con,List<String> list){
                this.mContext = con;
            this.mList = list;

        }
        @Override
        public View getView(final int position, View convertView, ViewGroup container) {
            ViewHolder holder;
            if(convertView==null){
                holder = new ViewHolder();
                convertView = LayoutInflater.from(mContext).inflate(R.layout.guide_item,null,false);
                holder.imageView = ((ImageView) convertView.findViewById(R.id.iv_guide_item));
                convertView.setTag(holder);
            }else{
                holder = ((ViewHolder) convertView.getTag());
            }
            holder.imageView.setImageResource(R.mipmap.ic_launcher);
            holder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(position == imageViews.length-1){
                        Intent intent = new Intent(GuideActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }
            });
            return convertView;
        }

        @Override
        public int getCount() {
            return mList.size();
        }
    }
    class ViewHolder {
        ImageView imageView;
    }

        class GuidePagerChange implements ViewPager.OnPageChangeListener{
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                    for(int i=0;i<imageViews.length;i++){
                        if(i == position){
                            imageViews[i].setImageResource(R.drawable.page_indicator_focused);
                        }else{
                            imageViews[i].setImageResource(R.drawable.page_indicator);
                        }
                    }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        }

}
