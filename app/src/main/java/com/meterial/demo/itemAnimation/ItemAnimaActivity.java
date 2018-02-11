package com.meterial.demo.itemAnimation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.meterial.demo.R;

/**
 * https://github.com/nuptboyzhb/RecyclerViewAnimation
 *
 * @author zenghao
 * @since 2018/2/8 下午6:22
 */
public class ItemAnimaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_anim);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        findViewById(R.id.list_rv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ItemAnimaActivity.this, RecyclerViewActivity.class));
            }
        });

        findViewById(R.id.grid_rv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ItemAnimaActivity.this, StaggeredGridActivity.class));
            }
        });

    }
}