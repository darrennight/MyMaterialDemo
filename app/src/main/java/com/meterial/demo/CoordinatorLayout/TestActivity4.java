package com.meterial.demo.CoordinatorLayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import com.meterial.demo.R;
import com.meterial.demo.adapter.MySimpleAdapter;
import com.meterial.demo.holder.OnItemClick;
import java.util.ArrayList;
import java.util.List;

/**
 *折叠效果
 * app:layout_collapseMode="pin"（子布局设置折叠模式）
 有两种“pin”：固定模式，在折叠的时候最后固定在顶端；“parallax”：视差模式，在折叠的时候会有个视差折叠的效果。
 app:title="MyToolBar" 表示给页面设置一个Toolbar
 app:collapsedTitleGravity="right" 表示折叠之后Title显示的位置
 app:expandedTitleGravity="left|bottom" 表示展开时Title显示的位置

 * @author zenghao
 * @since 16/12/16 上午10:51
 */
public class TestActivity4 extends AppCompatActivity implements OnItemClick {

    private RecyclerView mRecyclerView;
    private Toolbar mToolbar;
    private MySimpleAdapter mAdapter;

    private ActionBar mActionbar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test4);
        mToolbar = ((Toolbar) findViewById(R.id.toolbar_test4));
        mToolbar.setTitle("CoordinatorTest1");
        setSupportActionBar(mToolbar);

        mActionbar = getSupportActionBar();
        mActionbar.setDisplayHomeAsUpEnabled(true);
        mActionbar.setHomeAsUpIndicator(R.drawable.ic_arrow_white_24dp);



        mRecyclerView = ((RecyclerView) findViewById(R.id.rv_test4));
        LinearLayoutManager lm = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(lm);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());


        List<String> list = new ArrayList<>();
        list.add("0沉浸式状态栏");
        list.add("1CoordinatorAndFloating");
        list.add("2banner&TextInputLayout");
        list.add("3recylerView表格");
        list.add("4recylerView自动加载");
        list.add("5共享动画");
        list.add("6圆形显示隐藏");
        list.add("7底部弹出菜单BottomSheet");
        list.add("8小widget");
        list.add("9svg测试");
        list.add("10recylerview通用holder和adapter测试");
        list.add("11beHavior");
        list.add("12Scene");
        list.add("13项目调研使用");
        list.add("14mdDialog");
        list.add("15垂直TextView");
        list.add("16CoordinatorLayout测试");
        mAdapter = new MySimpleAdapter(this, list, this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onItemClick(long id) {

    }
}
