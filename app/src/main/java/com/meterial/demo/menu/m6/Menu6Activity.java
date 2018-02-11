package com.meterial.demo.menu.m6;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;
import com.meterial.demo.R;

/**
 * https://github.com/xue5455/SmartMenu
 *
 * @author zenghao
 * @since 2018/1/22 下午3:09
 */
public class Menu6Activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu6);
        SmartMenu smartMenu = (SmartMenu) findViewById(R.id.smart_menu);
        MenuAdapter adapter = new MenuAdapter();
        adapter.setListener(new ItemEventListener() {
            @Override
            public void onEventNotify(View view, int position, Object... data) {
                switch (position) {
                    case 0:
                        toast("ALBUM");
                        break;
                    case 1:
                        toast("COMMENT");
                        break;
                    case 2:
                        toast("DRAFT");
                        break;
                    case 3:
                        toast("LIKE");
                        break;
                }
            }
        });
        smartMenu.setAdapter(adapter);
    }

    private void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}