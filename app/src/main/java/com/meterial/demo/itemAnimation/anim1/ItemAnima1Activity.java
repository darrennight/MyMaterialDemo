package com.meterial.demo.itemAnimation.anim1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.CompoundButton;
import com.meterial.demo.R;

/**
 * https://github.com/wasabeef/recyclerview-animators
 * @author zenghao
 * @since 2018/2/8 下午8:21
 */
public class ItemAnima1Activity extends AppCompatActivity {
    private boolean enabledGrid = false;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_anim1);

        findViewById(R.id.btn_animator_sample).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent i = new Intent(ItemAnima1Activity.this, AnimatorSampleActivity.class);
                i.putExtra("GRID", enabledGrid);
                startActivity(i);
            }
        });

        findViewById(R.id.btn_adapter_sample).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent i = new Intent(ItemAnima1Activity.this, AdapterSampleActivity.class);
                i.putExtra("GRID", enabledGrid);
                startActivity(i);
            }
        });

        ((SwitchCompat) findViewById(R.id.grid)).setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        enabledGrid = isChecked;
                    }
                });
    }
}