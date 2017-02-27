package com.meterial.demo.CoordinatorLayout.third;
 
import android.os.Bundle;
import android.support.design.widget.AppBarLayout; 
import android.support.design.widget.CollapsingToolbarLayout; 
import android.support.v7.app.AppCompatActivity; 
import android.support.v7.widget.LinearLayoutManager; 
import android.support.v7.widget.RecyclerView; 
import android.support.v7.widget.Toolbar; 
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.meterial.demo.R;
import java.util.ArrayList;
import java.util.List;
import uk.co.ribot.easyadapter.EasyRecyclerAdapter;
import uk.co.ribot.easyadapter.ItemViewHolder;
import uk.co.ribot.easyadapter.PositionInfo;
import uk.co.ribot.easyadapter.annotations.LayoutId;
import uk.co.ribot.easyadapter.annotations.ViewId;

public class SixActivity extends AppCompatActivity { 
 
 
    private List<Integer> integerList = new ArrayList<>();
    private EasyRecyclerAdapter adapter;
    private RecyclerView recyclerView;
    private Toolbar toolbar;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private AppBarLayout appBarLayout;
    public static int scrollRange;
 
    @Override 
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_six);
        init(); 
    } 
 
    private void init() { 
 
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); 
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override 
            public boolean onMenuItemClick(MenuItem item) {
                return false; 
            } 
        }); 
 
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle("AndroidArtStudy");
 
 
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        for (int i = 0; i < 30; i++) {
            integerList.add(i);
        } 
        adapter = new EasyRecyclerAdapter(getApplicationContext(), SixViewHolder.class, integerList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(adapter);
 
 
 
        appBarLayout = (AppBarLayout) findViewById(R.id.appbar_layout);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override 
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                scrollRange = appBarLayout.getTotalScrollRange();
            } 
        }); 
    } 
 
 
    @Override 
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true; 
    } 
 
 
    @LayoutId(R.layout.item_list)
    public static class SixViewHolder extends ItemViewHolder<Integer> {
 
        @ViewId(R.id.item_text)
        TextView txt;
 
        public SixViewHolder(View view) {
            super(view);
        } 
 
        @Override 
        public void onSetValues(Integer item, PositionInfo positionInfo) {
            txt.setText(String.valueOf(item));
        } 
    } 
 
 
} 