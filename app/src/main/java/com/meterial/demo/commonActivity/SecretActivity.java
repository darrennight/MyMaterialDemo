package com.meterial.demo.commonActivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import com.meterial.demo.R;
import com.meterial.demo.customview.SecretTextView;

/**
 *字符串中字符渐隐渐现
 *
 * @author zenghao
 * @since 17/3/28 下午4:56
 */
public class SecretActivity extends AppCompatActivity {
    SecretTextView secretTextView;

    Button change;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secret);
        secretTextView = (SecretTextView)findViewById(R.id.textview);
        secretTextView.setmDuration(3000);
        secretTextView.setIsVisible(true);
        secretTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                secretTextView.toggle();
            }
        });

        change = (Button) findViewById(R.id.change);
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secretTextView.setText("This is really an amazing TextView");
            }
        });
    }
}