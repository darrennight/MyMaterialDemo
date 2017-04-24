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

public class SpruceActivity extends AppCompatActivity {
 
    @Override 
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
 
        setContentView(R.layout.activity_fragment);
 
        FragmentManager fm = getSupportFragmentManager();
        Fragment viewFragment = fm.findFragmentById(R.id.view_fragment);
 
        if (viewFragment == null) {
            viewFragment = ViewFragment.newInstance();
            fm.beginTransaction()
                    .add(R.id.view_fragment, viewFragment)
                    .commit(); 
        } 
 
        Toolbar toolBar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolBar);
        if (getSupportActionBar() != null) { 
            getSupportActionBar().setDisplayShowTitleEnabled(false); 
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
                break; 
            case R.id.recycler_option:
                startActivity(new Intent(this, RecyclerActivity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP));
                break; 
        } 
        return super.onOptionsItemSelected(item);
    } 
} 