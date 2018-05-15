package com.meterial.demo.commonActivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.meterial.demo.R;

/**
 * 神奇的android:clipChildren属性
 * @author zenghao
 * @since 2018/4/13 下午4:08
 */
public class ClipChildrenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clip_child);
    }
}
