package com.meterial.demo.commonActivity.Nice9;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity; 
import android.os.Bundle;
import android.view.View;
import com.meterial.demo.R;

public class NineMainActivity extends AppCompatActivity {
 
    @Override 
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nine_main);
    } 
 
    public void onList(View v){
        startActivity(DemoListActivity.class); 
    } 
 
    public void onDrag(View v){
        startActivity(DemoDragActivity.class); 
    } 
 
    private void startActivity(Class<?> cls) {
        Intent intent = new Intent();
        intent.setClass(this, cls);
        startActivity(intent);
    } 
} 