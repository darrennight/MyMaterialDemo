package com.meterial.demo.commonActivity.drag.demo2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import com.meterial.demo.R;
import java.util.ArrayList;
import java.util.List;

/**
 * item侧滑
 * https://github.com/loopeer/itemtouchhelper-extension
 * @author zenghao
 * @since 2018/2/11 下午3:32
 */
public class DragDeleteActivity extends AppCompatActivity {


    private RecyclerView mRecyclerView;
    private MainRecyclerAdapter mAdapter;
    public ItemTouchHelperExtension mItemTouchHelper;
    public ItemTouchHelperExtension.Callback mCallback;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag_delete);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_main);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new MainRecyclerAdapter(this);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this));
        mAdapter.updateData(createTestDatas());
        mCallback = new ItemTouchHelperCallback();
        mItemTouchHelper = new ItemTouchHelperExtension(mCallback);
        mItemTouchHelper.attachToRecyclerView(mRecyclerView);
        mAdapter.setItemTouchHelperExtension(mItemTouchHelper);
    }
    private List<TestModel> createTestDatas() {
        List<TestModel> result = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            TestModel testModel= new TestModel(i,":Item Swipe Action Button Container Width");
            if (i == 1) {
                testModel = new TestModel(i, "Item Swipe with Action container width and no spring");
            }
            if (i == 2) {
                testModel = new TestModel(i, "Item Swipe with RecyclerView Width");
            }
            if (i == 3) {
                testModel = new TestModel(i, "Item No swipe");
            }
            result.add(testModel);
        }
        return result;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_refresh, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_refresh) {
            mAdapter.updateData(createTestDatas());
        }
        return super.onOptionsItemSelected(item);
    }
}
