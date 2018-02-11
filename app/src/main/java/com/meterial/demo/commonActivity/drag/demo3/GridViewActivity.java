package com.meterial.demo.commonActivity.drag.demo3;
 
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity; 
import android.support.v7.widget.GridLayoutManager; 
import android.support.v7.widget.RecyclerView; 
import android.support.v7.widget.helper.ItemTouchHelper; 
import android.view.MenuItem;
import android.widget.Toast;
import com.meterial.demo.R;
import java.util.ArrayList;
import java.util.List;
 
public class GridViewActivity extends AppCompatActivity { 
    RecyclerView mRecyclerView;
    List<String> mStringList;
    RecyAdapter mRecyAdapter;

    @Override 
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mRecyclerView = (RecyclerView) findViewById(R.id.recy);
        initRecy(); 
    } 
 
    private void initRecy() { 
        if (mStringList == null) {
            mStringList = new ArrayList<>();
        } 
        mStringList.addAll(DataManager.getData(50 - mStringList.size()));
        mRecyAdapter = new RecyAdapter(R.layout.item_gridview, mStringList, true);
 
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        mRecyclerView.addItemDecoration(new DividerGridItemDecoration(this));
        mRecyclerView.setHasFixedSize(true);
 
        RecyItemTouchHelperCallback itemTouchHelperCallback = new RecyItemTouchHelperCallback(mRecyAdapter, false, true);
        final ItemTouchHelper itemTouchHelper = new ItemTouchHelper(itemTouchHelperCallback);
        itemTouchHelper.attachToRecyclerView(mRecyclerView);
 
        mRecyclerView.addOnItemTouchListener(new OnRecyclerItemClickListener(mRecyclerView) {
            @Override 
            public void onItemClick(RecyclerView.ViewHolder viewHolder) {
                RecyAdapter.ViewHolder viewHolder1 = (RecyAdapter.ViewHolder) viewHolder;
                String tvString = viewHolder1.mTextView.getText().toString();
                Toast.makeText(GridViewActivity.this, "逗逗~" + tvString, Toast.LENGTH_SHORT).show();
            } 
 
            @Override 
            public void onLongClick(RecyclerView.ViewHolder viewHolder) {
                Toast.makeText(GridViewActivity.this, "" + "讨厌，不要老是摸人家啦...", Toast.LENGTH_SHORT).show();
                if (viewHolder.getLayoutPosition() != 0) {
                    itemTouchHelper.startDrag(viewHolder);
                } 
            } 
        }); 
        mRecyclerView.setAdapter(mRecyAdapter);
    } 
 
    @Override 
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish(); 
        } 
        return super.onOptionsItemSelected(item);
    } 
} 