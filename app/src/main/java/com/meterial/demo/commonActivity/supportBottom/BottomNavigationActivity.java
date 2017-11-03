package com.meterial.demo.commonActivity.supportBottom;

import android.os.Bundle;
import android.support.annotation.NonNull; 
import android.support.design.widget.BottomNavigationView; 
import android.view.MenuItem;
import com.meterial.demo.R;

public class BottomNavigationActivity extends BaseActivity { 
 
    @Override 
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);
        initToolbar("BottomNavigation"); 
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override 
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.item1:
                        break; 
                    case R.id.item2:
                        break; 
                    case R.id.item3:
                        break;

                    case R.id.item4:
                        break;

                    case R.id.item5:
                        break;
                } 
                return true;
            } 
        });

        //BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);//添加 放大效果
    } 
} 
