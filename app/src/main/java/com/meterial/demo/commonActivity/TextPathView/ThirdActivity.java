package com.meterial.demo.commonActivity.TextPathView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.meterial.demo.R;
import com.meterial.demo.commonActivity.TextPathView.view.AsyncPathView;
import com.meterial.demo.commonActivity.TextPathView.view.FireworksPainter;
import com.meterial.demo.commonActivity.TextPathView.view.SyncPathView;

public class ThirdActivity extends Activity {
    private Button btn_start, btn_stop;
    private SyncPathView spv;
    private AsyncPathView aspv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_path_third);

        btn_start = findViewById(R.id.btn_start);
        btn_stop = findViewById(R.id.btn_stop);
        spv = findViewById(R.id.spv);
        aspv = findViewById(R.id.aspv);

        //必须先调用setPath设置路径
        aspv.setPath(new TestPath());

        spv.setPath(new TestPath());
        spv.setPathPainter(new FireworksPainter());



        //设置点击开始播放动画
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spv.startAnimation(1,0);
                aspv.startAnimation(0,1);
            }
        });

        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spv.stopAnimation();
                aspv.stopAnimation();
            }
        });
    }
}