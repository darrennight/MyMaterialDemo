package com.meterial.demo.index.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.meterial.demo.R;
import com.meterial.demo.index.sample.city.PickCityActivity;
import com.meterial.demo.index.sample.contact.PickContactActivity;

/**
 * https://github.com/YoKeyword/IndexableRecyclerView
 */
public class MainActivity extends AppCompatActivity {
 
    @Override 
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index_main);
 
        findViewById(R.id.btn_pick_city).setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PickCityActivity.class));
            } 
        }); 
        findViewById(R.id.btn_pick_contact).setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PickContactActivity.class));
            } 
        }); 
    } 
}
