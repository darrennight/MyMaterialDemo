package com.meterial.demo.commonActivity.remote;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import com.meterial.demo.R;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

/**
 *https://github.com/simplezhli/RemoteControlView
 *https://blog.csdn.net/qq_17766199/article/details/79466506
 * https://blog.csdn.net/zhangfei2018/article/details/39498703
 * https://blog.csdn.net/qianchenglenger/article/details/50484053
 * @author zenghao
 * @since 2018/4/13 下午4:31
 */
public class RemoteActivity extends AppCompatActivity {
    private RemoteControlView remoteControlView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remote);
        ViewPager viewPager = this.findViewById(R.id.viewpager);
        SmartTabLayout viewPagerTab = this.findViewById(R.id.viewpagertab);

        FragmentPagerItems pages = new FragmentPagerItems(this);
        pages.add(FragmentPagerItem.of("功能键", DemoFragment.class));
        pages.add(FragmentPagerItem.of("音量键", DemoFragment1.class));
        pages.add(FragmentPagerItem.of("播放键", DemoFragment.class));
        pages.add(FragmentPagerItem.of("数字键", DemoFragment.class));

        FragmentPagerItemAdapter
                adapter = new FragmentPagerItemAdapter(getSupportFragmentManager(), pages);

        viewPager.setAdapter(adapter);
        viewPagerTab.setViewPager(viewPager);

        remoteControlView = this.findViewById(R.id.rcv);
    }

    public void setDragInfo(DraggableInfo mButton){
        remoteControlView.setDragInfo(mButton);
    }
}