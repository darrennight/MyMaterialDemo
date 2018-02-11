package com.meterial.demo.menu.m3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity; 
import android.support.v7.widget.LinearLayoutManager; 
import android.support.v7.widget.RecyclerView;
import com.meterial.demo.R;

public class RecyclerViewActivity extends AppCompatActivity { 
 
    @Override 
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
 
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        assert recyclerView != null;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new RecyclerViewAdapter());
    } 
} 