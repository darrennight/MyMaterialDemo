package com.meterial.demo.commonActivity.layoutmanager.demo1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import com.meterial.demo.R;
import java.util.Random;

/**
 * https://github.com/Chacojack/HiveLayoutManager
 *https://chacojack.github.io/2016/09/14/%E6%8A%8ARecyclerView%E5%81%9A%E6%88%90-%E9%A9%AC-%E8%9C%82-%E7%AA%9D/
 * @author zenghao
 * @since 2018/2/11 下午5:55
 */
public class CustomManagerActivity1 extends AppCompatActivity {
    public static final int[] resIds = new int[]{
            R.drawable.img_0
            , R.drawable.img_1
            , R.drawable.img_2
            , R.drawable.img_3
            , R.drawable.img_4
            , R.drawable.img_5
            , R.drawable.img_6
            , R.drawable.img_7
            , R.drawable.img_8
            , R.drawable.img_9
            , R.drawable.img_10
            , R.drawable.img_11
            , R.drawable.img_12
    };
    private static final String TAG = CustomManagerActivity1.class.getSimpleName();

    RecyclerView recyclerView;
    HiveLayoutManager layoutManager;
    HiveAdapter adapter;
    int index = 39;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_manager1);
        initObjects();

        initViews();
        afterViews();

    }

    private void initObjects() {
        BitmapCache.INSTANCE.init(this, 200 * 200 * 4 * 13);
        adapter = new HiveAdapter();
    }

    private void initViews() {
        recyclerView = (RecyclerView) findViewById(R.id.list);
        findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int r = getRandomPosition();
                Log.d(TAG, "onClick: r" + r);
                adapter.addData(resIds[index % resIds.length], r);
                adapter.notifyItemInserted(r);
                index++;
            }
        });
        findViewById(R.id.remove).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (adapter.getItemCount() != 0) {
                    int r = getRandomPosition();
                    Log.d(TAG, "onClick: r" + r);
                    adapter.remove(r);
                    adapter.notifyItemRemoved(r);
                    index--;
                }
            }
        });
        findViewById(R.id.move).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int r = getRandomPosition();
                int r2 = getRandomPosition();
                Log.d(TAG, "onClick: r" + r);
                adapter.move(r, r2);
                adapter.notifyItemMoved(r, r2);
            }
        });
    }

    private int getRandomPosition() {
        int count = adapter.getItemCount();
        if (count > 0) {
            return new Random().nextInt(count);
        } else {
            return 0;
        }
    }

    private void afterViews() {
        recyclerView.setLayoutManager(layoutManager = new HiveLayoutManager(HiveLayoutManager.HORIZONTAL));
        recyclerView.setAdapter(adapter);
        for (int i = 0; i < index; i++) {
            adapter.addData(resIds[i % resIds.length]);
        }
        //        layoutManager.setGravity(HiveLayoutManager.CENTER);
        layoutManager.setGravity(HiveLayoutManager.ALIGN_LEFT);
        //        layoutManager.setGravity(HiveLayoutManager.ALIGN_RIGHT);
        //        layoutManager.setGravity(HiveLayoutManager.ALIGN_TOP);
        //        layoutManager.setGravity(HiveLayoutManager.ALIGN_BOTTOM);
        //        layoutManager.setGravity(HiveLayoutManager.ALIGN_LEFT | HiveLayoutManager.ALIGN_TOP);
        //        layoutManager.setGravity(HiveLayoutManager.ALIGN_LEFT | HiveLayoutManager.ALIGN_BOTTOM);
        //        layoutManager.setGravity(HiveLayoutManager.ALIGN_RIGHT | HiveLayoutManager.ALIGN_TOP);
        //        layoutManager.setGravity(HiveLayoutManager.ALIGN_RIGHT | HiveLayoutManager.ALIGN_BOTTOM);
        layoutManager.setPadding(300, 400, 500, 600);

    }


}
