package com.meterial.demo.commonActivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import com.meterial.demo.R;
import com.meterial.demo.customview.Pinview;

/**
 * https://github.com/GoodieBag/Pinview
 *
 * @author zenghao
 * @since 17/3/9 下午4:44
 */
public class TestPinActivity extends AppCompatActivity {

    private Pinview pinview1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin);
        pinview1= (Pinview) findViewById(R.id.pinview1);
        pinview1.setPinViewEventListener(new Pinview.PinViewEventListener() {
            @Override
            public void onDataEntered(Pinview pinview, boolean fromUser) {
                Toast.makeText(TestPinActivity.this, pinview.getValue(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
