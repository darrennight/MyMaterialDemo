package com.meterial.demo.widgetActivity.DragDrop.DragHelper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.meterial.demo.R;

public class DragHelperMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 底部菜抽屉示例
        setContentView(R.layout.activity_main_dragh1);
        // 其他用法
//        setContentView(R.layout.activity_main_dragh2);
    }
}