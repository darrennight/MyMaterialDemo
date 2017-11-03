package com.meterial.demo.sticky;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.meterial.demo.R;

/**
 * TODO
 * 悬浮吸顶01
 * @author zenghao
 * @since 2017/10/16 上午11:05
 */
public class RecycleStickyActivity extends AppCompatActivity {

    private TextView tvSticky;
    private RecyclerView rvSticky;
    private LinearLayoutManager manager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sticky01);

        tvSticky = ((TextView) findViewById(R.id.tv_sticky01));
        rvSticky = ((RecyclerView) findViewById(R.id.rv_sticky01));

        manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        rvSticky.setLayoutManager(manager);


        rvSticky.setAdapter(new StickyAdapter01(this));

        rvSticky.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int position = manager.findFirstVisibleItemPosition();
                if (position >= 2){
                    tvSticky.setVisibility(View.VISIBLE);
                }else{
                    tvSticky.setVisibility(View.GONE);
                }
            }
        });
    }
}
