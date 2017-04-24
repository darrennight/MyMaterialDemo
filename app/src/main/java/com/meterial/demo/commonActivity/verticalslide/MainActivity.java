package com.meterial.demo.commonActivity.verticalslide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.meterial.demo.R;

/**
 * //https://github.com/xmuSistone/android-vertical-slide-view
 * https://github.com/jeasonlzy/VerticalSlideView
 */

public class MainActivity extends AppCompatActivity {
 
    private VerticalFragment1 fragment1;
    private VerticalFragment3 fragment3;
    private DragLayout draglayout;
 
    @Override 
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_slide);
        initView(); 
    } 
 
    /** 
     * 初始化View 
     */ 
    private void initView() { 
        fragment1 = new VerticalFragment1();
        fragment3 = new VerticalFragment3();
 
        getSupportFragmentManager().beginTransaction() 
                .add(R.id.first, fragment1)
                .add(R.id.second, fragment3)
                .commit(); 
 
        DragLayout.ShowNextPageNotifier nextIntf = new DragLayout.ShowNextPageNotifier() {
            @Override 
            public void onDragNext() { 
                fragment3.initView();
            } 
        }; 
        draglayout = (DragLayout) findViewById(R.id.draglayout);
        draglayout.setNextPageListener(nextIntf);
    } 
 
} 