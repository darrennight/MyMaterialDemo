package com.meterial.demo.commonActivity.stereoview;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import com.meterial.demo.R;

/**
 * https://github.com/ImmortalZ/StereoView
 *
 * @author zenghao
 * @since 2018/3/28 下午4:08
 */
public class StereoMainActivity extends AppCompatActivity {
    private Button btnLogin;
    private Button btnSetting;
    private Button btnImage;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_stereo);
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnSetting = (Button) findViewById(R.id.btn_setting);
        btnImage = (Button) findViewById(R.id.btn_image);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StereoMainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StereoMainActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });
        btnImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StereoMainActivity.this, ImageActivity.class);
                startActivity(intent);
            }
        });
    }
}
