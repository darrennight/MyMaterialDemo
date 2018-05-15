package com.meterial.demo.commonActivity.NextLayout.demo1.ui;
 
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.meterial.demo.R;
import com.meterial.demo.commonActivity.NextLayout.demo1.lib.OnItemSelectListener;
import com.meterial.demo.commonActivity.NextLayout.demo1.lib.PullToNextLayout;
import com.meterial.demo.commonActivity.NextLayout.demo1.lib.PullToNextModel;
import com.meterial.demo.commonActivity.NextLayout.demo1.lib.PullToNextModelAdapter;
import com.meterial.demo.menu.m3.ActionBarActivity;
import java.util.ArrayList;
import java.util.List;

public class ScrollViewModelActivity extends AppCompatActivity {
 
    public PullToNextLayout pullToNextLayout;
 
    private List<PullToNextModel> list;
 
    private int  currentIndex=0;
    private PullToNextModelAdapter adapter;
 
    @Override 
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull_to_next_layout_demo);
 

        pullToNextLayout= (PullToNextLayout) findViewById(R.id.pullToNextLayout);
 
 
        list=new ArrayList<>();
 
        for (int i = 0; i < 4; i++) {
 
            list.add(new ScrollViewModel(currentIndex++));
        } 
 
        adapter=  new PullToNextModelAdapter(this,list);
        pullToNextLayout.setAdapter(adapter);
 
        pullToNextLayout.setOnItemSelectListener(new OnItemSelectListener() {
            @Override 
            public void onSelectItem(int position, View view) {
                setTitle(position+1+".0 谷歌仍是毕业生心目中的最佳雇主");
 
            } 
        }); 
        setTitle(1+".0 谷歌仍是毕业生心目中的最佳雇主"); 
    } 
 
 
 
    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present. 
        getMenuInflater().inflate(R.menu.menu_pull_to_next_layout_demo, menu);
        return true; 
    } 
 
    @Override 
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will 
        // automatically handle clicks on the Home/Up button, so long 
        // as you specify a parent activity in AndroidManifest.xml. 
        int id = item.getItemId();
 
        //noinspection SimplifiableIfStatement 
        if(id== R.id.action_addALL){
 
 
            for (int i = 0; i < 5; i++) {
 
                list.add(new ScrollViewModel(currentIndex++));
            } 
 
            adapter.notifyDataSetChanged();
 
        }else if(id== R.id.action_setSelection){
 
            pullToNextLayout.setCurrentItem(1);
 
        }else if(id== R.id.action_delete){
            pullToNextLayout.deleteCurrentItem();
        } 
 
        if (id == android.R.id.home) {
 
 
            this.finish();
            return true; 
        } 
 
        return super.onOptionsItemSelected(item);
    } */
} 