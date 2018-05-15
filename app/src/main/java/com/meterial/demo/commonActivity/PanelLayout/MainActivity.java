package com.meterial.demo.commonActivity.PanelLayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;


import butterknife.ButterKnife;
import butterknife.OnClick;
import com.meterial.demo.R;

/**
 * https://github.com/woxingxiao/SlidingUpPanelLayout
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_panel);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @OnClick({R.id.layout1, R.id.layout2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.layout1:
                startActivity(new Intent(this, DemoActivity1.class));

                break;
            case R.id.layout2:
                startActivity(new Intent(this, DemoActivity2.class));

                break;
        }
    }
}