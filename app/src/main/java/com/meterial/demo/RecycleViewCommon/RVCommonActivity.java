package com.meterial.demo.RecycleViewCommon;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.meterial.demo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zenghao on 16/8/1.
 */
public class RVCommonActivity extends Activity {

    private RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv_common);
        mRecyclerView = ((RecyclerView) findViewById(R.id.recyclerview));
        List<ChatMessage> list = new ArrayList<>();
        for(int i=0; i<=10;i++){
            ChatMessage msg = new ChatMessage();
            msg.setName(i+"name");
            msg.setContent(i+"content");
            if(i%2 == 0){
                msg.setComMeg(true);
            }
            list.add(msg);
        }
//        LinearLayoutManager、GridLayoutManager、StaggeredGridLayoutManager。
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        SimpleAdapter adapter = new SimpleAdapter(this,list);
        mRecyclerView.setAdapter(adapter);
    }

}
