package com.meterial.demo.commonActivity.NextLayout.demo1.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.meterial.demo.R;

/**
 https://github.com/zzz40500/Android-PullToNextLayout
 *
 * @author zenghao
 * @since 2018/2/12 下午2:16
 */
public class NextLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_layout);

        findViewById(R.id.btn_webView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(NextLayoutActivity.this,WebViewActivity.class));

            }
        });

        findViewById(R.id.btn_ScrollView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NextLayoutActivity.this,ScrollViewModelActivity.class));


            }
        });

        findViewById(R.id.btn_other).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NextLayoutActivity.this,OtherModelActivity.class));
            }
        });
    }



}
