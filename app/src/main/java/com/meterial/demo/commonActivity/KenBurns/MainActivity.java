package com.meterial.demo.commonActivity.KenBurns;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity; 
import android.view.View;
import android.widget.AdapterView; 
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.meterial.demo.R;

/**
 * https://github.com/flavioarfaria/KenBurnsView
 */
public class MainActivity extends AppCompatActivity { 
 
    private static final int POS_SINGLE_IMG = 0;
    private static final int POS_MULTI_IMG = 1;
    private static final int POS_FROM_URL = 2;
 
 
    @Override 
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ken_burns);
 
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.main_options, android.R.layout.simple_list_item_1);
 
        final ListView listView = (ListView) findViewById(android.R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override 
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                onListItemClick(parent, view, position, id);
            } 
        }); 
    } 
 
 
    protected void onListItemClick(AdapterView<?> parent, View v, int position, long id) {
        switch (position) {
            case POS_SINGLE_IMG:
                startActivity(new Intent(this, SingleImageActivity.class));
                break; 
            case POS_MULTI_IMG:
                startActivity(new Intent(this, MultiImageActivity.class));
                break; 
            case POS_FROM_URL:
                startActivity(new Intent(this, FromURLActivity.class));
                break; 
        } 
    } 
} 