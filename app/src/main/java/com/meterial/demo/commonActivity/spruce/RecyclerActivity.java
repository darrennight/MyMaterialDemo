package com.meterial.demo.commonActivity.spruce;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import com.meterial.demo.R;

/**
 * https://github.com/willowtreeapps/spruce-android
 */

public class RecyclerActivity extends AppCompatActivity {
 
    @Override 
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
 
        setContentView(R.layout.recycler_fragment);
 
        FragmentManager fm = getSupportFragmentManager();
        Fragment recyclerFragment = fm.findFragmentById(R.id.recycler_fragment);
        if (recyclerFragment == null) {
            recyclerFragment = RecyclerFragment.newInstance();
            fm.beginTransaction()
                    .replace(R.id.recycler_fragment, recyclerFragment)
                    .commit(); 
        } 
 
        Toolbar toolBar = (Toolbar) findViewById(R.id.recycler_tool_bar);
        setSupportActionBar(toolBar);
 
 
        if (getSupportActionBar() != null) { 
            getSupportActionBar().setTitle(R.string.recycler_name);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true); 
        } 
    } 
 
    @Override 
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    } 
 
    @Override 
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.sort_option:
                startActivity(new Intent(this, SpruceActivity.class)
                .addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP));
                break; 
            case R.id.recycler_option:
                break; 
            default: 
                finish(); 
                break; 
        } 
        return super.onOptionsItemSelected(item);
    } 
 
} 