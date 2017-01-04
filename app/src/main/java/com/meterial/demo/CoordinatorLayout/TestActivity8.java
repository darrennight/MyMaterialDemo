package com.meterial.demo.CoordinatorLayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.meterial.demo.R;

/**
 * @author zenghao
 * @since 16/12/16 上午10:51
 */
public class TestActivity8 extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test8);
        findViewById(R.id.iv_avatar).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                //startActivity(new Intent(TestActivity8.this,EasyBehaviorActivity.class));
            }
        });
    }


    public void titleMode(View v){
        findViewById(R.id.iv_avatar).setVisibility(View.INVISIBLE);
        findViewById(R.id.tv_title).setVisibility(View.VISIBLE);
    }

    public void avatarMode(View v ){

        findViewById(R.id.iv_avatar).setVisibility(View.VISIBLE);
        findViewById(R.id.tv_title).setVisibility(View.INVISIBLE);
    }
}