package com.meterial.demo.CoordinatorLayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import com.meterial.demo.R;
import com.meterial.demo.adapter.MySimpleAdapter;
import com.meterial.demo.holder.OnItemClick;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zenghao
 * @since 16/12/16 上午10:51
 */
public class TestActivity5 extends AppCompatActivity{

    private TextView mdepentent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test5);

        mdepentent = ((TextView) findViewById(R.id.depentent));
        mdepentent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewCompat.offsetTopAndBottom(view,5);
            }
        });
    }


}
