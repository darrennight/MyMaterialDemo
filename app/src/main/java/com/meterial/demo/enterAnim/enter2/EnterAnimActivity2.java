package com.meterial.demo.enterAnim.enter2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.meterial.demo.R;

/**
 * TODO
 *
 * @author zenghao
 * @since 2018/4/13 下午3:01
 */
public class EnterAnimActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_anim2);

        findViewById(R.id.list_rv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EnterAnimActivity2.this, RecyclerViewActivity.class));
            }
        });

        findViewById(R.id.grid_rv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EnterAnimActivity2.this, StaggeredGridActivity.class));
            }
        });
    }
}
