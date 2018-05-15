package com.meterial.demo.commonActivity.roll3D;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import com.meterial.demo.R;

/**
 * https://github.com/zhangyuChen1991/Roll3DImageView
 *
 * @author zenghao
 * @since 2018/3/28 下午6:17
 */
public class Roll3DMainActivity extends AppCompatActivity implements View.OnClickListener {

    @ViewInject(R.id.debug_btn)
    private Button debugBtn;
    @ViewInject(R.id.demo_btn)
    private Button demoBtn;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roll_3d);
        ViewInjectUtil.injectView(this);
        initView();
    }

    private void initView() {
        debugBtn.setOnClickListener(this);
        demoBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.debug_btn:
                intent = new Intent(this, RollDebugAct.class);
                startActivity(intent);
                break;
            case R.id.demo_btn:
                intent = new Intent(this, DemoAct.class);
                startActivity(intent);
                break;

        }
    }
}