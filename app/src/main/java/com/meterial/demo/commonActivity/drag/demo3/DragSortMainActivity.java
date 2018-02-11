package com.meterial.demo.commonActivity.drag.demo3;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.meterial.demo.R;

/**
 * https://github.com/OCNYang/RecyclerViewEvent
 *
 * @author zenghao
 * @since 2018/2/11 下午3:49
 */
public class DragSortMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag_sort);
    }

    public void showListView(View view){
        startActivity(new Intent(this,ListViewActivity.class));
    }

    public void showGridView(View view) {
        startActivity(new Intent(this,GridViewActivity.class));
    }
}
