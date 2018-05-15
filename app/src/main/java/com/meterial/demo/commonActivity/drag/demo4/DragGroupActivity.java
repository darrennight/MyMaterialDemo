package com.meterial.demo.commonActivity.drag.demo4;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import com.meterial.demo.R;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * https://github.com/laszhiai/DragGroupSampleRecyclerView
 *
 * @author zenghao
 * @since 2018/2/12 上午10:58
 */
public class DragGroupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goup_drag);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        SampleStrategy sampleStrategy = initStrategy();
        IFBIDragSortRecyclerViewAdapter adapter = new IFBIDragSortRecyclerViewAdapter(this,sampleStrategy );
        recyclerView.setAdapter(adapter);

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new IFBISimpleItemTouchHelperCallback(adapter));
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

    /**
     * 根据自身数据结构定制
     */
    @NonNull
    private SampleStrategy initStrategy() {
        IFBIBaseWidgetModel model = null;
        try {
            model = new IFBIBaseWidgetModel(new JSONObject(Constant.DATA));
        } catch (JSONException e) {
        }
        return new SampleStrategy(model);
    }
}