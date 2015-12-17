package com.meterial.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.meterial.demo.activity.BannerActivity;
import com.meterial.demo.activity.CoordinatorAndFloating;
import com.meterial.demo.activity.EndlessRecycle;
import com.meterial.demo.activity.ImmersionStatusBar;
import com.meterial.demo.activity.RecyclerViewUsed;
import com.meterial.demo.adapter.MySimpleAdapter;
import com.meterial.demo.holder.OnItemClick;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnItemClick {

    private Toolbar mToolbar;
    private DrawerLayout mDlayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private RecyclerView mRecycler;
    private MySimpleAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (navigationView != null) {
            setupDrawerContent(navigationView);
        }
        mDlayout = ((DrawerLayout) findViewById(R.id.drawer_layout));
        mToolbar = ((Toolbar) findViewById(R.id.toolbar));


        mToolbar.setTitle("MyMaterial");
        setSupportActionBar(mToolbar);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDlayout, mToolbar, R.string.drawer_open,
                R.string.drawer_close);
        mDrawerToggle.syncState();
        mDlayout.setDrawerListener(mDrawerToggle);

        mRecycler = ((RecyclerView) findViewById(R.id.rv_list));

        LinearLayoutManager lm = new LinearLayoutManager(this);
        mRecycler.setLayoutManager(lm);
        mRecycler.setItemAnimator(new DefaultItemAnimator());
        List<String> list = new ArrayList<String>();
        list.add("沉浸式状态栏");
        list.add("CoordinatorAndFloating");
        list.add("banner&TextInputLayout");
        list.add("recylerView表格");
        list.add("recylerView自动加载");
        for (int i = 0; i <= 10; i++) {
            list.add(i + "");
        }
        mAdapter = new MySimpleAdapter(this, list, this);
        mRecycler.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sample_actions, menu);
        return true;
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);
                        //mDrawerLayout.closeDrawers();
                        return true;
                    }
                });
    }

    @Override
    public void onItemClick(long id) {
        Toast.makeText(this, "" + id, Toast.LENGTH_SHORT).show();
        switch ((int) id) {
            case 0:
                Intent intent = new Intent(this, ImmersionStatusBar.class);
                startActivity(intent);
                break;
            case 1:
                Intent intent1 = new Intent(this, CoordinatorAndFloating.class);
                startActivity(intent1);
                break;
            case 2:
                Intent intent2 = new Intent(this, BannerActivity.class);
                startActivity(intent2);
                break;
            case 3:
                Intent intent3 = new Intent(this,RecyclerViewUsed.class);
                startActivity(intent3);
                break;
            case 4:
                Intent intent4 = new Intent(this,EndlessRecycle.class);
                startActivity(intent4);
                break;
            default:
                break;
        }
    }
}
