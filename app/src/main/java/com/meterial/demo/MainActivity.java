package com.meterial.demo;

import android.content.DialogInterface;
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
import android.view.MotionEvent;
import android.widget.Toast;

import com.meterial.demo.CoordinatorLayout.TestCoordinatorLayoutActivity;
import com.meterial.demo.MDesign.BehaviorMainActivity;
import com.meterial.demo.ProjectUse.ProjectUserMainActivity;
import com.meterial.demo.RecycleViewCommon.RVCommonActivity;
import com.meterial.demo.activity.BannerActivity;
import com.meterial.demo.activity.BottomSheetActivity;
import com.meterial.demo.activity.CircularRevealActivity;
import com.meterial.demo.activity.CoordinatorAndFloating;
import com.meterial.demo.activity.EndlessRecycle;
import com.meterial.demo.activity.ImmersionStatusBar;
import com.meterial.demo.activity.RecyclerViewUsed;
import com.meterial.demo.activity.Smallwidget;
import com.meterial.demo.activity.TransitionMainActivity;
import com.meterial.demo.adapter.MySimpleAdapter;
import com.meterial.demo.commonActivity.CircleImageViewActivity;
import com.meterial.demo.commonActivity.GossipActivity;
import com.meterial.demo.commonActivity.PanningViewActivity;
import com.meterial.demo.commonActivity.SecretActivity;
import com.meterial.demo.commonActivity.TestPinActivity;
import com.meterial.demo.commonActivity.TestTextSwitcher;
import com.meterial.demo.commonActivity.ToolbarTitleAnimation;
import com.meterial.demo.commonActivity.VerticalTextVActivity;
import com.meterial.demo.commonActivity.WheelActivity;
import com.meterial.demo.commonActivity.ratinbar.TestRatinBarActivity;
import com.meterial.demo.commonActivity.spruce.RecyclerActivity;
import com.meterial.demo.commonActivity.spruce.SpruceActivity;
import com.meterial.demo.commonActivity.wheel.WheelActivity1;
import com.meterial.demo.customview.MDDialog;
import com.meterial.demo.customview.PanningView;
import com.meterial.demo.holder.OnItemClick;
import com.meterial.demo.scene.TransitionActivity;
import com.meterial.demo.svg.SvgActivity;

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
        list.add("17共享动画");
        list.add("18lottie动画Sample");
        list.add("19toolBarTitleAnim");
        list.add("20圆形头像");
        list.add("21微信支付宝密码输入");
        list.add("22wheel");
        list.add("23wheel第二个");
        list.add("24");
        list.add("25垂直滑动下一个页面");
        list.add("26字符串字符渐隐渐现");
        list.add("27背景图片左右移动");
        list.add("28列表item动画");
        list.add("29列表item动画");
        list.add("30圆形菜单");
        list.add("31textswitcher&&&FadeTextView");
        list.add("32ratingbar");
        list.add("33自定义cardView");
//        for (int i = 0; i <= 10; i++) {
//            list.add(i + "");
//        }
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
            case 5:
                Intent intent5 = new Intent(this, TransitionMainActivity.class);
                startActivity(intent5);
                break;
            case 6:
                Intent intent6 = new Intent(this,CircularRevealActivity.class);
                startActivity(intent6);
                break;
            case 7:
                Intent intent7 = new Intent(this, BottomSheetActivity.class);
                startActivity(intent7);
                break;
            case 8:
                Intent intent8 = new Intent(this, Smallwidget.class);
                startActivity(intent8);
                break;
            case 9:
                Intent intent9 = new Intent(this, SvgActivity.class);
                startActivity(intent9);
                break;
            case 10:
                Intent intent10 = new Intent(this, RVCommonActivity.class);
                startActivity(intent10);
                break;
            case 11:
                Intent intent11 = new Intent(this, BehaviorMainActivity.class);
                startActivity(intent11);
                break;
            case 12:
                Intent intent12 = new Intent(this, TransitionActivity.class);
                startActivity(intent12);
                break;
            case 13:
                Intent intent13 = new Intent(this, ProjectUserMainActivity.class);
                startActivity(intent13);
                break;
            case 14:
                new MDDialog.Builder(this)
                        .setTitle("hahahtitle")
                        .setTitleColor(getResources().getColor(R.color.themeColor))
                        .setMessage("hahaTips")
                        .setPositive("qued")
                        .setNegetive("cancan")
                        .setmNegetiveListener(new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this,"sfaf",Toast.LENGTH_SHORT).show();
                            }
                        })
//                        .setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                            @Override
//                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                                Toast.makeText(MainActivity.this,"posp"+position,Toast.LENGTH_SHORT).show();
//                            }
//                        })
                        .build();
                break;

            case 15:
                Intent intent15 = new Intent(this, VerticalTextVActivity.class);
                startActivity(intent15);
                break;
            case 16:
                Intent intent16 = new Intent(this, TestCoordinatorLayoutActivity.class);
                startActivity(intent16);
                break;

            case 17:
                Intent intent17 = new Intent(this, com.meterial.demo.MDTransition.MorphTransitions.MainActivity.class);
                startActivity(intent17);
                break;


            case 18:
                Intent intent18 = new Intent(this, com.meterial.demo.LottieAnim.MainActivity.class);
                startActivity(intent18);
                break;

            case 19:
                Intent intent19 = new Intent(this, ToolbarTitleAnimation.class);
                startActivity(intent19);
                break;

            case 20:
                Intent intent20 = new Intent(this, CircleImageViewActivity.class);
                startActivity(intent20);
                break;

            case 21:
                Intent intent21 = new Intent(this, TestPinActivity.class);
                startActivity(intent21);
                break;

            case 22:
                Intent intent22 = new Intent(this, WheelActivity.class);
                startActivity(intent22);
                break;

            case 23:
                Intent intent23 = new Intent(this, WheelActivity1.class);
                startActivity(intent23);
                break;

            case 24:
                Intent intent24 = new Intent(this, com.meterial.demo.commonActivity.chanelView.MainActivity.class);
                startActivity(intent24);
                break;

            case 25:
                Intent intent25 = new Intent(this, com.meterial.demo.commonActivity.verticalslide.MainActivity.class);
                startActivity(intent25);
                break;

            case 26:
                Intent intent26 = new Intent(this, SecretActivity.class);
                startActivity(intent26);
                break;

            case 27:
                Intent intent27 = new Intent(this, PanningViewActivity.class);
                startActivity(intent27);
                break;

            case 28:
                Intent intent28 = new Intent(this, RecyclerActivity.class);
                startActivity(intent28);
                break;

            case 29:
                Intent intent29 = new Intent(this, SpruceActivity.class);
                startActivity(intent29);
                break;

            case 30:
                Intent intent30 = new Intent(this, GossipActivity.class);
                startActivity(intent30);
                break;

            case 31:
                Intent intent31 = new Intent(this, TestTextSwitcher.class);
                startActivity(intent31);
                break;

            case 32:
                Intent intent32 = new Intent(this, TestRatinBarActivity.class);
                startActivity(intent32);
                break;

            case 33:
                Intent intent33 = new Intent(this, com.meterial.demo.commonActivity.cardview.MainActivity.class);
                startActivity(intent33);
                break;
            default:
                break;
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }
}
