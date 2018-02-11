package com.meterial.demo.commonActivity.captcha1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.meterial.demo.R;

/**
 * https://github.com/luozhanming/Captcha
 * @author zenghao
 * @since 2018/2/6 上午10:43
 */
public class CaptchaMainActivity1 extends AppCompatActivity {

    private Captcha captcha;
    private Button btnMode;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_captcha_main1);
        captcha = (Captcha) findViewById(R.id.captCha);
        btnMode = (Button) findViewById(R.id.btn_mode);
        btnMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (captcha.getMode() == Captcha.MODE_BAR) {
                    captcha.setMode(Captcha.MODE_NONBAR);
                    btnMode.setText("滑动条模式");
                } else {
                    captcha.setMode(Captcha.MODE_BAR);
                    btnMode.setText("无滑动条模式");
                }
            }
        });
        captcha.setCaptchaListener(new Captcha.CaptchaListener() {
            @Override
            public String onAccess(long time) {
                Toast.makeText(CaptchaMainActivity1.this, "验证成功", Toast.LENGTH_SHORT).show();
                return "验证通过";
            }

            @Override
            public String onFailed(int count) {
                Toast.makeText(CaptchaMainActivity1.this, "验证失败,失败次数" + count, Toast.LENGTH_SHORT).show();
                return "验证失败";
            }

            @Override
            public String onMaxFailed() {
                Toast.makeText(CaptchaMainActivity1.this, "验证超过次数，你的帐号被封锁", Toast.LENGTH_SHORT).show();
                return "可以走了";
            }

        });
    }
}
