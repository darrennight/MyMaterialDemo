package com.meterial.demo.commonActivity.recyvleviewTest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity; 
import android.view.View;
import com.meterial.demo.R;

/**
 * http://www.jianshu.com/p/b335b620af39
 * https://github.com/Gavin-ZYX/StickyDecoration
 */
public class MainActivity extends AppCompatActivity { 
 
    @Override 
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actiivty_sticky_main);
    } 
 
    public void toSticky(View view) {
        startActivity(new Intent(this, StickyRecyclerViewActivity.class));
    } 
 
    public void toPowerfulSticky(View view) {
        startActivity(new Intent(this, PowerfulStickyRecyclerViewActivity.class));
    } 
 
    public void toPowerfulSticky2(View view) {
        startActivity(new Intent(this, BeautifulRecyclerViewActivity.class));
    } 
} 