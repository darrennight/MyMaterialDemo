package com.meterial.demo.commonActivity.NextLayout.demo1.ui;
 
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.meterial.demo.R;
import com.meterial.demo.commonActivity.NextLayout.demo1.lib.OnItemSelectListener;
import com.meterial.demo.commonActivity.NextLayout.demo1.lib.PullToNextLayout;
import com.meterial.demo.commonActivity.NextLayout.demo1.lib.PullToNextModel;
import com.meterial.demo.commonActivity.NextLayout.demo1.lib.PullToNextModelAdapter;
import java.util.ArrayList;
 
 
public class OtherModelActivity extends AppCompatActivity {
 
    public PullToNextLayout pullToNextLayout;
 
 
    private ArrayList<PullToNextModel> list;
    private  String[] names={"于文文","张钧甯","陈乔恩","贾青"};
 
    @Override 
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull_to_next_layout_demo);
 

        pullToNextLayout= (PullToNextLayout) findViewById(R.id.pullToNextLayout);
 
 
        list=new ArrayList<>();
 
        list.add(new OtherViewModel(0));
        list.add(new OtherViewModel(1));
        list.add(new OtherViewModel(2));
        list.add(new OtherViewModel(3));
 
 
        pullToNextLayout.setAdapter(new PullToNextModelAdapter(this, list));
 
        pullToNextLayout.setOnItemSelectListener(new OnItemSelectListener() {
            @Override 
            public void onSelectItem(int position, View view) {
                setTitle(names[position]);
            } 
        }); 
 
        setTitle(names[0]);
    } 
 
 
 
    @Override 
    public boolean onCreateOptionsMenu(Menu menu) {
        return true; 
    } 
 
    @Override 
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
 
 
        if (id == android.R.id.home) {
 
 
            this.finish();
            return true; 
        } 
 
        return super.onOptionsItemSelected(item);
    } 
} 