package com.meterial.demo.widgetActivity.MultiSnapRecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.meterial.demo.R;

public class MultiSnapRVActivity extends AppCompatActivity {

    String[] titles = {
            "HorizontalLayout",
            "VerticalLayout",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.snap_activity_main);

        findViewById(R.id.horizontal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MultiSnapRVActivity.this, HorizontalActivity.class));
            }
        });

        findViewById(R.id.vertical).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MultiSnapRVActivity.this, VerticalActivity.class));
            }
        });
    }
}