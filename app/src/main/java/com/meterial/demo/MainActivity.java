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
import com.meterial.demo.activity.BottomNavigationActivity;
import com.meterial.demo.activity.BottomSheetActivity;
import com.meterial.demo.activity.CircularRevealActivity;
import com.meterial.demo.activity.CoordinatorAndFloating;
import com.meterial.demo.activity.EndlessRecycle;
import com.meterial.demo.activity.ImmersionStatusBar;
import com.meterial.demo.activity.LableMove2Activity;
import com.meterial.demo.activity.LableMoveActivity;
import com.meterial.demo.activity.MyCalendarActivity;
import com.meterial.demo.activity.MyCalendarActivity2;
import com.meterial.demo.activity.MyCalendarThumb;
import com.meterial.demo.activity.MyCalendarThumbGrid;
import com.meterial.demo.activity.RecyclerViewUsed;
import com.meterial.demo.activity.Smallwidget;
import com.meterial.demo.activity.TestActivity;
import com.meterial.demo.activity.TransitionMainActivity;
import com.meterial.demo.adapter.MySimpleAdapter;
import com.meterial.demo.commonActivity.Carousel.CarouselActivity;
import com.meterial.demo.commonActivity.ChameleonActivity;
import com.meterial.demo.commonActivity.CircleImageViewActivity;
import com.meterial.demo.commonActivity.DashBoardActivity;
import com.meterial.demo.commonActivity.ExpandLayoutActivity;
import com.meterial.demo.commonActivity.ExpandLayoutCustomActivity;
import com.meterial.demo.commonActivity.FabulousFilter.FabulousFilterActivity;
import com.meterial.demo.commonActivity.GoodActivty;
import com.meterial.demo.commonActivity.GossipActivity;
import com.meterial.demo.commonActivity.MyTopTabActivity;
import com.meterial.demo.commonActivity.Nice9.NineMainActivity;
import com.meterial.demo.commonActivity.PanningViewActivity;
import com.meterial.demo.commonActivity.Panorama.PanorMainActiivty;
import com.meterial.demo.commonActivity.Panorama.Panorama360Activity;
import com.meterial.demo.commonActivity.Panorama.Panorama360Activity2;
import com.meterial.demo.commonActivity.SecretActivity;
import com.meterial.demo.commonActivity.TestAnimationsActivity;
import com.meterial.demo.commonActivity.TestItemViewPagerActivity;
import com.meterial.demo.commonActivity.TestPinActivity;
import com.meterial.demo.commonActivity.TestRoundBgActivity;
import com.meterial.demo.commonActivity.TestTextSwitcher;
import com.meterial.demo.commonActivity.TextAroundActivity;
import com.meterial.demo.commonActivity.TextSpan.TestTextSpanActivity;
import com.meterial.demo.commonActivity.ToolbarTitleAnimation;
import com.meterial.demo.commonActivity.VerticalTextVActivity;
import com.meterial.demo.commonActivity.WheelActivity;
import com.meterial.demo.commonActivity.XEditTextActivity;
import com.meterial.demo.commonActivity.blur.Blur500pxActivity;
import com.meterial.demo.commonActivity.blur.BlurMainActivity;
import com.meterial.demo.commonActivity.bottomNav.BottomNavMainActivity;
import com.meterial.demo.commonActivity.index.ListIndexActivity;
import com.meterial.demo.commonActivity.ratinbar.TestRatinBarActivity;
import com.meterial.demo.commonActivity.scaleImg.ScaleTransitionImageAnim;
import com.meterial.demo.commonActivity.spruce.RecyclerActivity;
import com.meterial.demo.commonActivity.spruce.SpruceActivity;
import com.meterial.demo.commonActivity.supportBottom.SupportBottomActivity;
import com.meterial.demo.commonActivity.wheel.WheelActivity1;
import com.meterial.demo.customview.MDDialog;
import com.meterial.demo.customview.expandLayout.ExpandLayoutActivity3;
import com.meterial.demo.holder.OnItemClick;
import com.meterial.demo.scene.TransitionActivity;
import com.meterial.demo.sticky.RecycleStickyActivity;
import com.meterial.demo.svg.SvgActivity;

import com.squareup.pollexor.Thumbor;
import java.util.ArrayList;
import java.util.List;

import static com.squareup.pollexor.ThumborUrlBuilder.HorizontalAlign.RIGHT;
import static com.squareup.pollexor.ThumborUrlBuilder.VerticalAlign.BOTTOM;
import static com.squareup.pollexor.ThumborUrlBuilder.quality;
import static com.squareup.pollexor.ThumborUrlBuilder.roundCorner;
import static com.squareup.pollexor.ThumborUrlBuilder.watermark;

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

        //android Pollexor server Thumbor
        Thumbor thumbor = Thumbor.create("http://example.com/");
        String s1 = thumbor.buildImage("image.png")
                .resize(48, 48)
                .toUrl();// Produces: /unsafe/48x48/example.com/image.pngthumbor.buildImage("http://example.com/image.png")

        String s2 = thumbor.buildImage("http://example.com/image.png")
                .crop(10, 10, 90, 90)
                .resize(40, 40)
                .smart()
                .toUrl();// Produces: /unsafe/10x10:90x90/smart/40x40/example.com/image.pngthumbor.buildImage("http://example.com/image.png")

        String s3 = thumbor.buildImage("http://example.com/image.png")
                .crop(5, 5, 195, 195)
                .resize(95, 95)
                .align(BOTTOM, RIGHT)
                .toUrl();// Produces: /unsafe/5x5:195x195/right/bottom/95x95/example.com/image.pngthumbor.buildImage("http://example.com/background.png")


       String s4 = thumbor.buildImage("http://example.com/image.png")
               .resize(200, 100)
                .filter(
                        roundCorner(10),
                        watermark(thumbor.buildImage("http://example.com/overlay1.png").resize(200, 100)),
                        watermark(thumbor.buildImage("http://example.com/overlay2.png").resize(50, 50), 75, 25),
                        quality(85)
                )
                .toUrl();

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
        list.add("32评分ratingbar");
        list.add("33自定义cardView");
        list.add("34textView Span");
        list.add("35Carousel");
        list.add("36背景左右移动缩放");
        list.add("37editText显示分块内容");
        list.add("38editText显示分块内容2");
        list.add("39editText显示分块内容3");
        list.add("40背景圆角");
        list.add("41动画测试");
        list.add("42item是viewpager");
        list.add("43viewpager卡片式");
        list.add("44点赞+1效果");
        list.add("45列表字母索引");
        list.add("46顶部table&Viewpager");
        list.add("47MD圆形放大切换");
        list.add("48评分ratingbar");
        list.add("49毛玻璃");
        list.add("50毛玻璃");
        list.add("51panoramaImage");
        list.add("52panorama360");
        list.add("53搜索框");
        list.add("54 9张图样式变化");
        list.add("55recycleView悬浮吸顶");
        list.add("56XEditText");
        list.add("57仪表盘");
        list.add("58两个颜色平滑过渡");
        list.add("59图片缩放过度");
        list.add("60交互样式效果");
        list.add("61google规范底部导航样式第三方开源");
        list.add("62googleSupporot底部导航");
        list.add("63google规范底部导航样式第三方开源");
        list.add("64airbnb日历");
        list.add("65日历缩略图显示");
        list.add("66 日历");
        list.add("67日历缩略图显示grid");
        list.add("68文字跟随移动");
        list.add("69expandLayout显示隐藏layout");
        list.add("70expandLayout显示隐藏layout");
        list.add("71expandLayout");
        list.add("72多行文字跟随移动");
        list.add("73测试Test");
        list.add("74图片文字环绕");
        list.add("75RecyclerView悬浮吸顶01");
        list.add("76RecyclerView悬浮吸顶+索引");
//        for (int i = 0; i <= 10; i++) {
//            list.add(i + "");
//        }
        mAdapter = new MySimpleAdapter(this, list, this);
        mRecycler.setAdapter(mAdapter);

        lm.scrollToPosition(list.size()-1);
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

            case 34:
                Intent intent34 = new Intent(this, TestTextSpanActivity.class);
                startActivity(intent34);
                break;

            case 35:
                Intent intent35 = new Intent(this, CarouselActivity.class);
                startActivity(intent35);
                break;

            case 36:
                Intent intent36 = new Intent(this, com.meterial.demo.commonActivity.KenBurns.MainActivity.class);
                startActivity(intent36);
                break;

            case 37:
                Intent intent37 = new Intent(this, com.meterial.demo.commonActivity.ship.MainActivity.class);
                startActivity(intent37);
                break;

            case 38:
                Intent intent38 = new Intent(this, com.meterial.demo.commonActivity.ship.view2.MainActivity.class);
                startActivity(intent38);
                break;

            case 39:
                Intent intent39 = new Intent(this, com.meterial.demo.commonActivity.ship.view3.MainActivity.class);
                startActivity(intent39);
                break;

            case 40:
                Intent intent40 = new Intent(this, TestRoundBgActivity.class);
                startActivity(intent40);
                break;

            case 41:
                Intent intent41 = new Intent(this, TestAnimationsActivity.class);
                startActivity(intent41);
                break;

            case 42:
                Intent intent42 = new Intent(this, TestItemViewPagerActivity.class);
                startActivity(intent42);
                break;

            case 43:
                Intent intent43 = new Intent(this, com.meterial.demo.commonActivity.ViewPagerCards.MainActivity.class);
                startActivity(intent43);
                break;

            case 44:
                Intent intent44 = new Intent(this, GoodActivty.class);
                startActivity(intent44);
                break;

            case 45:
                Intent intent45 = new Intent(this, ListIndexActivity.class);
                startActivity(intent45);
                break;

            case 46:
                Intent intent46 = new Intent(this, MyTopTabActivity.class);
                startActivity(intent46);
                break;

            case 47:
                Intent intent47 = new Intent(this, com.meterial.demo.ProjectUse.custom.CircularRevealActivity.class);
                startActivity(intent47);
                break;

            case 48:
                Intent intent48 = new Intent(this, com.meterial.demo.RatingBar.TestRatinBarActivity.class);
                startActivity(intent48);
                break;
            case 49:
                Intent intent49 = new Intent(this, BlurMainActivity.class);
                startActivity(intent49);
                break;

            case 50:
                Intent intent50 = new Intent(this, Blur500pxActivity.class);
                startActivity(intent50);
                break;

            case 51:
                Intent intent51 = new Intent(this, PanorMainActiivty.class);
                startActivity(intent51);
                break;

            case 52:
                Intent intent52 = new Intent(this, Panorama360Activity2.class);
                //Intent intent52 = new Intent(this, Panorama360Activity.class);
                startActivity(intent52);
                break;

            case 53:
                Intent intent53 = new Intent(this, com.meterial.demo.commonActivity.BilibiliSearchView.MainActivity.class);
                startActivity(intent53);
                break;

            case 54:
                Intent intent54 = new Intent(this, NineMainActivity.class);
                startActivity(intent54);
                break;

            case 55:
                Intent intent55 = new Intent(this, com.meterial.demo.commonActivity.recyvleviewTest.MainActivity.class);
                startActivity(intent55);
                break;

            case 56:
                Intent intent56 = new Intent(this, XEditTextActivity.class);
                startActivity(intent56);
                break;

            case 57:
                Intent intent57 = new Intent(this, DashBoardActivity.class);
                startActivity(intent57);
                break;

            case 58:
                Intent intent58 = new Intent(this, ChameleonActivity.class);
                startActivity(intent58);
                break;

            case 59:
                Intent intent59 = new Intent(this, ScaleTransitionImageAnim.class);
                startActivity(intent59);
                break;

            case 60:
                Intent intent60 = new Intent(this, FabulousFilterActivity.class);
                startActivity(intent60);
                break;

            case 61:
                Intent intent61 = new Intent(this, BottomNavigationActivity.class);
                startActivity(intent61);
                break;

            case 62:
                Intent intent62 = new Intent(this, SupportBottomActivity.class);
                startActivity(intent62);
                break;

            case 63:
                Intent intent63 = new Intent(this, BottomNavMainActivity.class);
                startActivity(intent63);
                break;

            case 64:
                Intent intent64 = new Intent(this, MyCalendarActivity.class);
                startActivity(intent64);
                break;

            case 65:
                Intent intent65 = new Intent(this, MyCalendarThumb.class);
                startActivity(intent65);
                break;

            case 66:
                Intent intent66 = new Intent(this, MyCalendarActivity2.class);
                startActivity(intent66);
                break;

            case 67:
                Intent intent67 = new Intent(this, MyCalendarThumbGrid.class);
                startActivity(intent67);
                break;

            case 68:
                Intent intent68 = new Intent(this, LableMoveActivity.class);
                startActivity(intent68);
                break;

            case 69:
                Intent intent69 = new Intent(this, ExpandLayoutActivity.class);
                startActivity(intent69);
                break;

            case 70:
                Intent intent70 = new Intent(this, ExpandLayoutCustomActivity.class);
                startActivity(intent70);
                break;

            case 71:
                Intent intent71 = new Intent(this, ExpandLayoutActivity3.class);
                startActivity(intent71);
                break;

            case 72:
                Intent intent72 = new Intent(this, LableMove2Activity.class);
                startActivity(intent72);
                break;

            case 73:
                Intent intent73 = new Intent(this, TestActivity.class);
                startActivity(intent73);
                break;

            case 74:
                Intent intent74 = new Intent(this, TextAroundActivity.class);
                startActivity(intent74);
                break;

            case 75:
                Intent intent75 = new Intent(this, RecycleStickyActivity.class);
                startActivity(intent75);
                break;

            case 76:
                Intent intent76 = new Intent(this, com.meterial.demo.index.sample.MainActivity.class);
                startActivity(intent76);
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
