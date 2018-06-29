package com.meterial.demo.widgetActivity.selectorAttr;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.meterial.demo.R;

/**
 *自定义selector属性状态
 * @author zenghao
 * @since 2018/6/28 下午5:23
 */
public class TestSelectorAttrActivity extends AppCompatActivity {

    private BankCardContainerLayout layout = null;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_selector_attr);
        layout = findViewById(R.id.layout_root);

        findViewById(R.id.btn_red).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout.setType(1);
            }
        });

        findViewById(R.id.btn_blue).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout.setType(2);
            }
        });


        findViewById(R.id.btn_green).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout.setType(3);
            }
        });
    }
}
