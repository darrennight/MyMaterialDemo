package com.meterial.demo.menu.m7;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import com.meterial.demo.R;
import java.util.ArrayList;
import java.util.List;

/**
 * https://github.com/shangmingchao/PopupList
 *
 * @author zenghao
 * @since 2018/1/22 下午3:46
 */
public class Menu7Activity extends AppCompatActivity {

    private Button btn_long_click;
    private ListView lv_main;
    private List<String> mDataList = new ArrayList<>();
    private ArrayAdapter<String> mDataAdapter;
    private List<String> popupMenuItemList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu7);
        btn_long_click = (Button) findViewById(R.id.btn_long_click);
        lv_main = (ListView) findViewById(R.id.lv_main);
        mDataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, mDataList);
        lv_main.setAdapter(mDataAdapter);

        popupMenuItemList.add(getString(R.string.copy));
        popupMenuItemList.add(getString(R.string.delete));
        popupMenuItemList.add(getString(R.string.share));
        popupMenuItemList.add(getString(R.string.more));
        PopupList popupList = new PopupList(this);
        popupList.bind(lv_main, popupMenuItemList, new PopupList.PopupListListener() {
            @Override
            public boolean showPopupList(View adapterView, View contextView, int contextPosition) {
                return true;
            }

            @Override
            public void onPopupListClick(View contextView, int contextPosition, int position) {
                Toast.makeText(Menu7Activity.this, contextPosition + "," + position, Toast.LENGTH_SHORT).show();
            }
        });

        PopupList normalViewPopupList = new PopupList(this);
        normalViewPopupList.bind(btn_long_click, popupMenuItemList, new PopupList.PopupListListener() {
            @Override
            public boolean showPopupList(View adapterView, View contextView, int contextPosition) {
                return true;
            }

            @Override
            public void onPopupListClick(View contextView, int contextPosition, int position) {
                Toast.makeText(Menu7Activity.this, contextPosition + "," + position, Toast.LENGTH_SHORT).show();
            }
        });

        lv_main.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Menu7Activity.this, "onItemClicked:" + position, Toast.LENGTH_SHORT).show();
            }
        });
        btn_long_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu7Activity.this, SecondaryActivity.class));
            }
        });
        getData();
    }

    private void getData() {
        for (int i = 0; i < 40; i++) {
            mDataList.add("No." + i);
        }
        mDataAdapter.notifyDataSetChanged();
    }

}
