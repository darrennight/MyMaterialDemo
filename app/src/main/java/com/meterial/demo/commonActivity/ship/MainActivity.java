package com.meterial.demo.commonActivity.ship;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.meterial.demo.R;
import com.meterial.demo.commonActivity.ship.view.Chip;
import com.meterial.demo.commonActivity.ship.view.OnChipClickListener;
import com.meterial.demo.commonActivity.ship.view.OnCloseClickListener;
import com.meterial.demo.commonActivity.ship.view.OnIconClickListener;
import com.meterial.demo.commonActivity.ship.view.OnSelectClickListener;

/**
 * https://github.com/robertlevonyan/materialChipView
 */
public class MainActivity extends AppCompatActivity {
 
    @Override 
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ship_main);
 
        Chip chip = (Chip) findViewById(R.id.football_chip);
 
        chip.setOnChipClickListener(new OnChipClickListener() {
            @Override 
            public void onChipClick(View v) {
                //Your action here... 
            } 
        }); 
 
        chip.setOnCloseClickListener(new OnCloseClickListener() {
            @Override 
            public void onCloseClick(View v) {
                //Your action here... 
            } 
        }); 
 
        chip.setOnIconClickListener(new OnIconClickListener() {
            @Override 
            public void onIconClick(View v) {
                //Your action here... 
            } 
        }); 
 
        chip.setOnSelectClickListener(new OnSelectClickListener() {
            @Override 
            public void onSelectClick(View v, boolean selected) {
                //Your action here... 
            } 
        }); 
    } 
} 