package com.meterial.demo.commonActivity.FabulousFilter;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton; 
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.allattentionhere.fabulousfilter.AAH_FabulousFragment;
import com.meterial.demo.R;

 
public class MainSampleActivity extends AppCompatActivity implements AAH_FabulousFragment.Callbacks { 
 
    FloatingActionButton fab;
 
    @Override 
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sample);
        fab = (FloatingActionButton) findViewById(R.id.fab);
 
 
 
        fab.setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View v) {
                MySampleFabFragment dialogFrag = MySampleFabFragment.newInstance();
                dialogFrag.setParentFab(fab);
                dialogFrag.show(getSupportFragmentManager(), dialogFrag.getTag());
            } 
        }); 
 
    } 
 
 
    @Override 
    public void onResult(Object result) {
        Log.d("k9res", "onResult: " + result.toString());
        if (result.toString().equalsIgnoreCase("swiped_down")) {
            //do something or nothing 
        } else { 
            //handle result 
        } 
    } 
 
 
} 