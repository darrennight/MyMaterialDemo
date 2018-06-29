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
import com.meterial.demo.FragmentAnimation.anim1.MainActivityAnim1;
import com.meterial.demo.FragmentAnimation.anim2.MainActivityAnim2;
import com.meterial.demo.MDesign.BehaviorMainActivity;
import com.meterial.demo.ObjectAnim.TestSetAndGet;
import com.meterial.demo.ObjectAnim.customAnim.NumberAnimationActivity;
import com.meterial.demo.ObjectAnim.customAnim.TestCustomAnimation;
import com.meterial.demo.ObjectAnim.customAnim.TestCustomAnimationActivity01;
import com.meterial.demo.ProjectUse.ProjectUserMainActivity;
import com.meterial.demo.RecycleViewCommon.RVCommonActivity;
import com.meterial.demo.activity.ArcActivity;
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
import com.meterial.demo.activity.TestIPCActivity;
import com.meterial.demo.activity.TransitionMainActivity;
import com.meterial.demo.activity.WindowImageActivity;
import com.meterial.demo.adapter.MySimpleAdapter;
import com.meterial.demo.chart.ChartActivity1;
import com.meterial.demo.chart.ChartActivity2;
import com.meterial.demo.chart.ChartActivity3;
import com.meterial.demo.chart.ChartActivity4;
import com.meterial.demo.chart.ChartActivity5;
import com.meterial.demo.chart.ChartActivity6;
import com.meterial.demo.chart.ChartActivity7;
import com.meterial.demo.chart.ChartActivity8;
import com.meterial.demo.commonActivity.AnimatedRandomLayout.AnimaRandomLayoutActivity;
import com.meterial.demo.commonActivity.BankCard.AddBankCardActivity;
import com.meterial.demo.commonActivity.CardStack.CardStackMainActivity;
import com.meterial.demo.commonActivity.Carousel.CarouselActivity;
import com.meterial.demo.commonActivity.ChameleonActivity;
import com.meterial.demo.commonActivity.CircleImageViewActivity;
import com.meterial.demo.commonActivity.ClipChildrenActivity;
import com.meterial.demo.commonActivity.CouponView.CouponViewActivity;
import com.meterial.demo.commonActivity.CustomLayoutAnimation.TestCustomLayoutAnimationController;
import com.meterial.demo.commonActivity.DashBoardActivity;
import com.meterial.demo.commonActivity.Door.DoorMainActivity;
import com.meterial.demo.commonActivity.ExpandLayoutActivity;
import com.meterial.demo.commonActivity.ExpandLayoutCustomActivity;
import com.meterial.demo.commonActivity.ExpandingCollection.ExpandCollectionActivity;
import com.meterial.demo.commonActivity.FabulousFilter.FabulousFilterActivity;
import com.meterial.demo.commonActivity.FlightSeat.FlightSeatActivity;
import com.meterial.demo.commonActivity.FlipAnimation.FilpAnimActivity;
import com.meterial.demo.commonActivity.FoldableLayout.FoldMainActivity;
import com.meterial.demo.commonActivity.GoodActivty;
import com.meterial.demo.commonActivity.GossipActivity;
import com.meterial.demo.commonActivity.InfiniteCards.InfiniteCardActivity;
import com.meterial.demo.commonActivity.MyTopTabActivity;
import com.meterial.demo.commonActivity.NextLayout.demo1.ui.NextLayoutActivity;
import com.meterial.demo.commonActivity.Nice9.NineMainActivity;
import com.meterial.demo.commonActivity.PanningViewActivity;
import com.meterial.demo.commonActivity.Panorama.PanorMainActiivty;
import com.meterial.demo.commonActivity.Panorama.Panorama360Activity2;
import com.meterial.demo.commonActivity.SecretActivity;
import com.meterial.demo.commonActivity.ShimmerText.KTVTextView;
import com.meterial.demo.commonActivity.ShimmerText.TestKTVTextActivity;
import com.meterial.demo.commonActivity.ShimmerText.TestShimmerActivity;
import com.meterial.demo.commonActivity.ShimmerText.TestXFormodeActivity;
import com.meterial.demo.commonActivity.SlidingDeck.DeckMainActivity;
import com.meterial.demo.commonActivity.SmileView.SmileMainActivity;
import com.meterial.demo.commonActivity.TestAnimationsActivity;
import com.meterial.demo.commonActivity.TestItemViewPagerActivity;
import com.meterial.demo.commonActivity.TestLayoutTransition.TestLayoutTransition;
import com.meterial.demo.commonActivity.TestLayoutTransition.TestLayoutTransition2;
import com.meterial.demo.commonActivity.TestPinActivity;
import com.meterial.demo.commonActivity.TestRoundBgActivity;
import com.meterial.demo.commonActivity.TestTextSwitcher;
import com.meterial.demo.commonActivity.TextAroundActivity;
import com.meterial.demo.commonActivity.TextPathView.TextPathMainActivity;
import com.meterial.demo.commonActivity.TextSpan.TestTextSpanActivity;
import com.meterial.demo.commonActivity.ToolbarTitleAnimation;
import com.meterial.demo.commonActivity.VerticalTextVActivity;
import com.meterial.demo.commonActivity.ViewpagerHeader.VPHeaderMainActivity;
import com.meterial.demo.commonActivity.WaveView.WaveViewMainActivity;
import com.meterial.demo.commonActivity.WheelActivity;
import com.meterial.demo.commonActivity.XEditTextActivity;
import com.meterial.demo.commonActivity.blur.Blur500pxActivity;
import com.meterial.demo.commonActivity.blur.BlurMainActivity;
import com.meterial.demo.commonActivity.bottomNav.BottomNavMainActivity;
import com.meterial.demo.commonActivity.captcha.CaptchaMainActivity;
import com.meterial.demo.commonActivity.captcha1.CaptchaMainActivity1;
import com.meterial.demo.commonActivity.carouse.CustomCarouseActivity;
import com.meterial.demo.commonActivity.cube.CubeMainActivity;
import com.meterial.demo.commonActivity.dialogAnima.DialogAnimActivity;
import com.meterial.demo.commonActivity.drag.demo1.ViewDragActivity;
import com.meterial.demo.commonActivity.drag.demo2.DragDeleteActivity;
import com.meterial.demo.commonActivity.drag.demo3.DragSortMainActivity;
import com.meterial.demo.commonActivity.drag.demo4.DragGroupActivity;
import com.meterial.demo.commonActivity.expandView.ExpandViewActivity;
import com.meterial.demo.commonActivity.index.ListIndexActivity;
import com.meterial.demo.commonActivity.layoutmanager.demo1.CustomManagerActivity1;
import com.meterial.demo.commonActivity.layoutmanager.demo2.CustomManager2Activity;
import com.meterial.demo.commonActivity.rangeseekbar.RangeSeekBarActivity;
import com.meterial.demo.commonActivity.ratinbar.TestRatinBarActivity;
import com.meterial.demo.commonActivity.remote.RemoteActivity;
import com.meterial.demo.commonActivity.retail.ListDemoActivity;
import com.meterial.demo.commonActivity.roll3D.Roll3DMainActivity;
import com.meterial.demo.commonActivity.rotateText.RotatingTextActivity;
import com.meterial.demo.commonActivity.scaleImg.ScaleTransitionImageAnim;
import com.meterial.demo.commonActivity.spinMenu.SpinMenuActivity;
import com.meterial.demo.commonActivity.spruce.RecyclerActivity;
import com.meterial.demo.commonActivity.spruce.SpruceActivity;
import com.meterial.demo.commonActivity.stereoview.StereoMainActivity;
import com.meterial.demo.commonActivity.supportBottom.SupportBottomActivity;
import com.meterial.demo.commonActivity.swipecard.SwipeCardActivity;
import com.meterial.demo.commonActivity.swipecard.demo.SwipCardActivity;
import com.meterial.demo.commonActivity.swipecard.tantan.TanTanActivity;
import com.meterial.demo.commonActivity.swipecard.zuimei.ScaleCardActivity;
import com.meterial.demo.commonActivity.switchloop3D.LoopRotarySwitchActivity;
import com.meterial.demo.commonActivity.wheel.WheelActivity1;
import com.meterial.demo.customview.MDDialog;
import com.meterial.demo.customview.expandLayout.ExpandLayoutActivity3;
import com.meterial.demo.enterAnim.EnterAnimActivity;
import com.meterial.demo.enterAnim.enter2.EnterAnimActivity2;
import com.meterial.demo.excelpanel.ExcelPanelActivity;
import com.meterial.demo.holder.OnItemClick;
import com.meterial.demo.itemAnimation.ItemAnimaActivity;
import com.meterial.demo.itemAnimation.anim1.ItemAnima1Activity;
import com.meterial.demo.itemAnimation.anim2.MyActivity;
import com.meterial.demo.menu.m1.DemoActivity;
import com.meterial.demo.menu.m2.Menu2Activity;
import com.meterial.demo.menu.m3.MenuMain3Activity;
import com.meterial.demo.menu.m4.CircleMenuActivity;
import com.meterial.demo.menu.m5.CircleMenu5Activity;
import com.meterial.demo.menu.m6.Menu6Activity;
import com.meterial.demo.menu.m7.Menu7Activity;
import com.meterial.demo.scene.TransitionActivity;
import com.meterial.demo.sticky.RecycleStickyActivity;
import com.meterial.demo.svg.SvgActivity;

import com.meterial.demo.test.DiDi.DiDiAnimationActivity;
import com.meterial.demo.test.TestScanerActivity;
import com.meterial.demo.wheel.w1.WheelMainActivity1;
import com.meterial.demo.wheel.w2.WheelMainActivity2;
import com.meterial.demo.widgetActivity.AccentFirst.AccentFIrstActivity;
import com.meterial.demo.widgetActivity.Calendar1.SampleActivity;
import com.meterial.demo.widgetActivity.CalendarView.HomeActivity;
import com.meterial.demo.widgetActivity.ExpandTable.ExpandTableActivity;
import com.meterial.demo.widgetActivity.HotelCalendar.MenuActivity;
import com.meterial.demo.widgetActivity.InDoor.InDoorActivity;
import com.meterial.demo.widgetActivity.PhotoView.PhotoViewActivity;
import com.meterial.demo.widgetActivity.PhotoView2.LauncherActivity;
import com.meterial.demo.widgetActivity.ScrollCalendar.activity.NavigationActivity;
import com.meterial.demo.widgetActivity.SeatTable.SeatTable;
import com.meterial.demo.widgetActivity.SeatTable.SeatTableActivity1;
import com.meterial.demo.widgetActivity.SeatTable2.SeatSelectionActivity;
import com.meterial.demo.widgetActivity.SublimePicker.Sampler;
import com.meterial.demo.widgetActivity.TimesSquare.SampleTimesSquareActivity;
import com.meterial.demo.widgetActivity.TouchImage.TouchImageActivity;
import com.meterial.demo.widgetActivity.selectorAttr.TestSelectorAttrActivity;
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
        list.add("64airbnb日历 重点研究");
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
        list.add("77顶部弧形");
        list.add("78和AndroidStudayDemo两个apk进程通信");
        list.add("79excel表格");
        list.add("80windowImage");
        list.add("81拼图验证码");
        list.add(("82旋转木马"));
        list.add("83菜单1");
        list.add("84菜单2");
        list.add(("85菜单3"));
        list.add("86菜单4");
        list.add("87菜单5");
        list.add("88菜单6");
        list.add("89菜单7");
        list.add("90滑块拼图验证码");
        list.add("91itemAnimation进入动画");
        list.add("92itemAnimation列表添加删除item动画和滑动时动画");
        list.add("93动画集合");
        list.add("94卡片滑动");
        list.add("95卡片滑动");
        list.add("96卡片滑动");
        list.add("97item侧滑动ViewDragHelper");
        list.add("98item侧滑");
        list.add("99拖动排序");
        list.add("100卡片滑动");
        list.add("101RecycleerView自定义样式");
        list.add("102RecycleerView自定义样式");
        list.add("103头条feed");
        list.add("104RecyclerView分组滑动删除");
        list.add("105text文字下移动切换");
        list.add("106NextLayout上拉下一个界面");
        list.add("107card可以自定义动画切换");
        list.add("108卡片放大成界面");
        list.add("109范围seekbar");
        list.add("110菜单8");
        list.add("111card动画");
        list.add("112层叠item");
        list.add("113dialog动画");
        list.add("114测试扫描动画");
        list.add("115指纹扫描动画");
        list.add("116立体旋转切换3D无限");
        list.add("117花式3D翻转效果");
        list.add("118轮盘fragment菜单");
        list.add("119竖直方向的SlidingPanelLayout");
        list.add("120饼状图1");
        list.add("121饼状图2");
        list.add("122饼状图3");
        list.add("123饼状图4");
        list.add("124饼状图5");
        list.add("125饼状图6");
        list.add("126饼状图7");
        list.add("127饼状图8");
        list.add("128进入动画");
        list.add("129进入动画");
        list.add("130子控件高度超过父控件 类似底部导航");
        list.add("131万能遥控器交互效果");
        list.add("132自定义carouse");
        list.add("133列表向上滑动item放大");
        list.add("134expand展开收起layout");
        list.add("135滴滴动画");
        list.add("136wheel滑动选择器1");
        list.add("137wheel滑动选择器2");
        list.add("138仿《最美有物》笑脸点赞控件");
        list.add("139自定义LayoutAnimation");
        list.add("140layoutTransition动画使用");
        list.add("141listview属性动画test");
        list.add("142继承animation自定义动画");
        list.add("143layoutTransition动画使用2");
        list.add("144自定义动画");
        list.add("145数字切换自定义动画");
        list.add("146cube立体切换界面动画");
        list.add("147fold不明天demo");
        list.add(("148Deck交互样式"));
        list.add("149CardStack卡片堆栈");
        list.add("150textPath效果");
        list.add("151viewpager有header一起滑动");
        list.add("152Fragment切换动画1");
        list.add("153Fragment切换动画2");
        list.add("154添加银行卡");
        list.add("155流量双波浪");
        list.add("156Xfermode 制作动态文字加载动画");
        list.add("157shimmer文字高亮");
        list.add("158歌词颜色变化");
        list.add("159重力感应器门票动画");
        list.add("160flip翻转动画");
        list.add("161飞机选座");
        list.add("162随机出现子控件向中间移动动画");
        list.add("163半圆锯齿背景虚线边框");
        list.add("164RecycleView第一个item放大");
        list.add("165点击展开的表格效果");
        list.add("166室内户型图交互组件库");
        list.add("167电影选座");
        list.add("168电影选座");
        list.add("169PhotoView手势缩放旋转");
        list.add("170PhotoView手势缩放旋转");
        list.add("171ImageView手势缩放旋转");
        list.add("172日历控件1 和下面一个api");
        list.add("173日历控件2 重点研究 和上面一个api 研究这个即可");
        list.add("174Selector自定义属性状态");
        list.add("175日历控件3卡顿不太好");
        list.add("176日历控件4");
        list.add("177日历控件5 忽略");
        list.add("178日历控件6 重点研究");
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

            case 77:
                Intent intent77 = new Intent(this, ArcActivity.class);
                startActivity(intent77);
                break;

            case 78:
                Intent intent78 = new Intent(this, TestIPCActivity.class);
                startActivity(intent78);
                break;

            case 79:
                Intent intent79 = new Intent(this, ExcelPanelActivity.class);
                startActivity(intent79);
                break;

            case 80:
                Intent intent80 = new Intent(this, WindowImageActivity.class);
                startActivity(intent80);
                break;

            case 81:
                Intent intent81 = new Intent(this, CaptchaMainActivity.class);
                startActivity(intent81);
                break;

            case 82:
                Intent intent82 = new Intent(this, LoopRotarySwitchActivity.class);
                startActivity(intent82);
                break;

            case 83:
                Intent intent83 = new Intent(this, DemoActivity.class);
                startActivity(intent83);
                break;

            case 84:
                Intent intent84 = new Intent(this, Menu2Activity.class);
                startActivity(intent84);
                break;

            case 85:
                Intent intent85 = new Intent(this, MenuMain3Activity.class);
                startActivity(intent85);
                break;

            case 86:
                Intent intent86 = new Intent(this, CircleMenuActivity.class);
                startActivity(intent86);
                break;

            case 87:
                Intent intent87 = new Intent(this, CircleMenu5Activity.class);
                startActivity(intent87);
                break;

            case 88:
                Intent intent88 = new Intent(this, Menu6Activity.class);
                startActivity(intent88);
                break;

            case 89:
                Intent intent89 = new Intent(this, Menu7Activity.class);
                startActivity(intent89);
                break;

            case 90:
                Intent intent90 = new Intent(this, CaptchaMainActivity1.class);
                startActivity(intent90);
                break;

            case 91:
                Intent intent91 = new Intent(this, ItemAnimaActivity.class);
                startActivity(intent91);
                break;

            case 92:
                Intent intent92 = new Intent(this, ItemAnima1Activity.class);
                startActivity(intent92);
                break;

            case 93:
                Intent intent93 = new Intent(this, MyActivity.class);
                startActivity(intent93);
                break;

            case 94:
                Intent intent94 = new Intent(this, SwipeCardActivity.class);
                startActivity(intent94);
                break;

            case 95:
                Intent intent95 = new Intent(this, TanTanActivity.class);
                startActivity(intent95);
                break;

            case 96:
                Intent intent96 = new Intent(this, ScaleCardActivity.class);
                startActivity(intent96);
                break;

            case 97:
                Intent intent97 = new Intent(this, ViewDragActivity.class);
                startActivity(intent97);
                break;

            case 98:
                Intent intent98 = new Intent(this, DragDeleteActivity.class);
                startActivity(intent98);
                break;

            case 99:
                Intent intent99 = new Intent(this, DragSortMainActivity.class);
                startActivity(intent99);
                break;

            case 100:
                Intent intent100 = new Intent(this, SwipCardActivity.class);
                startActivity(intent100);
                break;

            case 101:
                Intent intent101 = new Intent(this, CustomManagerActivity1.class);
                startActivity(intent101);
                break;

            case 102:
                Intent intent102 = new Intent(this, CustomManager2Activity.class);
                startActivity(intent102);
                break;
            case 103:
                Intent intent103 = new Intent(this, com.meterial.demo.commonActivity.toutiao.MainActivity.class);
                startActivity(intent103);
                break;

            case 104:
                Intent intent104 = new Intent(this, DragGroupActivity.class);
                startActivity(intent104);
                break;

            case 105:
                Intent intent105 = new Intent(this, RotatingTextActivity.class);
                startActivity(intent105);
                break;

            case 106:
                Intent intent106 = new Intent(this, NextLayoutActivity.class);
                startActivity(intent106);
                break;

            case 107:
                Intent intent107 = new Intent(this, InfiniteCardActivity.class);
                startActivity(intent107);
                break;

            case 108:
                Intent intent108 = new Intent(this, ExpandCollectionActivity.class);
                startActivity(intent108);
                break;

            case 109:
                Intent intent109 = new Intent(this, RangeSeekBarActivity.class);
                startActivity(intent109);
                break;

            case 110:
                Intent intent110 = new Intent(this, com.meterial.demo.menu.m8.MainActivity.class);
                startActivity(intent110);
                break;

            case 111:
                Intent intent111 = new Intent(this, com.meterial.demo.commonActivity.filpcard.MainActivity.class);
                startActivity(intent111);
                break;

            case 112:
                Intent intent112 = new Intent(this, com.meterial.demo.commonActivity.overflyingview.MainActivity.class);
                startActivity(intent112);
                break;

            case 113:
                Intent intent113 = new Intent(this, DialogAnimActivity.class);
                startActivity(intent113);
                break;

            case 114:
                Intent intent114 = new Intent(this, TestScanerActivity.class);
                startActivity(intent114);
                break;

            case 115:
                Intent intent115 = new Intent(this, com.meterial.demo.commonActivity.finger.MainActivity.class);
                startActivity(intent115);
                break;

            case 116:
                Intent intent116 = new Intent(this, StereoMainActivity.class);
                startActivity(intent116);
                break;

            case 117:
                Intent intent117 = new Intent(this, Roll3DMainActivity.class);
                startActivity(intent117);
                break;

            case 118:
                Intent intent118 = new Intent(this, SpinMenuActivity.class);
                startActivity(intent118);
                break;

            case 119:
                Intent intent119 = new Intent(this, com.meterial.demo.commonActivity.PanelLayout.MainActivity.class);
                startActivity(intent119);
                break;

            case 120:
                Intent intent120 = new Intent(this, ChartActivity1.class);
                startActivity(intent120);
                break;

            case 121:
                Intent intent121 = new Intent(this, ChartActivity2.class);
                startActivity(intent121);
                break;

            case 122:
                Intent intent122 = new Intent(this, ChartActivity3.class);
                startActivity(intent122);
                break;

            case 123:
                Intent intent123 = new Intent(this, ChartActivity4.class);
                startActivity(intent123);
                break;

            case 124:
                Intent intent124 = new Intent(this, ChartActivity5.class);
                startActivity(intent124);
                break;

            case 125:
                Intent intent125 = new Intent(this, ChartActivity6.class);
                startActivity(intent125);
                break;

            case 126:
                Intent intent126 = new Intent(this, ChartActivity7.class);
                startActivity(intent126);
                break;

            case 127:
                Intent intent127 = new Intent(this, ChartActivity8.class);
                startActivity(intent127);
                break;

            case 128:
                Intent intent128 = new Intent(this, EnterAnimActivity.class);
                startActivity(intent128);
                break;

            case 129:
                Intent intent129 = new Intent(this, EnterAnimActivity2.class);
                startActivity(intent129);
                break;

            case 130:
                Intent intent130 = new Intent(this, ClipChildrenActivity.class);
                startActivity(intent130);
                break;

            case 131:
                Intent intent131 = new Intent(this, RemoteActivity.class);
                startActivity(intent131);
                break;

            case 132:
                Intent intent132 = new Intent(this, CustomCarouseActivity.class);
                startActivity(intent132);
                break;

            case 133:
                Intent intent133 = new Intent(this, ListDemoActivity.class);
                startActivity(intent133);
                break;

            case 134:
                Intent intent134 = new Intent(this, ExpandViewActivity.class);
                startActivity(intent134);
                break;

            case 135:
                Intent intent135 = new Intent(this, DiDiAnimationActivity.class);
                startActivity(intent135);
                break;

            case 136:
                Intent intent136 = new Intent(this, WheelMainActivity1.class);
                startActivity(intent136);
                break;

            case 137:
                Intent intent137 = new Intent(this, WheelMainActivity2.class);
                startActivity(intent137);
                break;

            case 138:
                Intent intent138 = new Intent(this, SmileMainActivity.class);
                startActivity(intent138);
                break;

            case 139:
                Intent intent139 = new Intent(this, TestCustomLayoutAnimationController.class);
                startActivity(intent139);
                break;

            case 140:
                Intent intent140 = new Intent(this, TestLayoutTransition.class);
                startActivity(intent140);
                break;

            case 141:
                Intent intent141 = new Intent(this, TestSetAndGet.class);
                startActivity(intent141);
                break;

            case 142:
                Intent intent142 = new Intent(this, TestCustomAnimation.class);
                startActivity(intent142);
                break;

            case 143:
                Intent intent143 = new Intent(this, TestLayoutTransition2.class);
                startActivity(intent143);
                break;

            case 144:
                Intent intent144 = new Intent(this, TestCustomAnimationActivity01.class);
                startActivity(intent144);
                break;

            case 145:
                Intent intent145 = new Intent(this, NumberAnimationActivity.class);
                startActivity(intent145);
                break;

            case 146:
                Intent intent146 = new Intent(this, CubeMainActivity.class);
                startActivity(intent146);
                break;
            case 147:
                Intent intent147 = new Intent(this, FoldMainActivity.class);
                startActivity(intent147);
                break;
            case 148:
                Intent intent148 = new Intent(this, DeckMainActivity.class);
                startActivity(intent148);
                break;
            case 149:
                Intent intent149 = new Intent(this, CardStackMainActivity.class);
                startActivity(intent149);
                break;

            case 150:
                Intent intent150 = new Intent(this, TextPathMainActivity.class);
                startActivity(intent150);
                break;

            case 151:
                Intent intent151 = new Intent(this, VPHeaderMainActivity.class);
                startActivity(intent151);
                break;

            case 152:
                Intent intent152 = new Intent(this, MainActivityAnim1.class);
                startActivity(intent152);
                break;

            case 153:
                Intent intent153 = new Intent(this, MainActivityAnim2.class);
                startActivity(intent153);
                break;

            case 154:
                Intent intent154 = new Intent(this, AddBankCardActivity.class);
                startActivity(intent154);
                break;

            case 155:
                Intent intent155 = new Intent(this, WaveViewMainActivity.class);
                startActivity(intent155);
                break;

            case 156:
                Intent intent156 = new Intent(this, TestXFormodeActivity.class);
                startActivity(intent156);
                break;

            case 157:
                Intent intent157 = new Intent(this, TestShimmerActivity.class);
                startActivity(intent157);
                break;

            case 158:
                Intent intent158 = new Intent(this, TestKTVTextActivity.class);
                startActivity(intent158);
                break;

            case 159:
                Intent intent159 = new Intent(this, DoorMainActivity.class);
                startActivity(intent159);
                break;

            case 160:
                Intent intent160 = new Intent(this, FilpAnimActivity.class);
                startActivity(intent160);
                break;

            case 161:
                Intent intent161 = new Intent(this, FlightSeatActivity.class);
                startActivity(intent161);
                break;

            case 162:
                Intent intent162 = new Intent(this, AnimaRandomLayoutActivity.class);
                startActivity(intent162);
                break;

            case 163:
                Intent intent163 = new Intent(this, CouponViewActivity.class);
                startActivity(intent163);
                break;

            case 164:
                Intent intent164 = new Intent(this, AccentFIrstActivity.class);
                startActivity(intent164);
                break;

            case 165:
                Intent intent165 = new Intent(this, ExpandTableActivity.class);
                startActivity(intent165);
                break;

            case 166:
                Intent intent166 = new Intent(this, InDoorActivity.class);
                startActivity(intent166);
                break;

            case 167:
                Intent intent167 = new Intent(this, SeatTableActivity1.class);
                startActivity(intent167);
                break;

            case 168:
                Intent intent168 = new Intent(this, SeatSelectionActivity.class);
                startActivity(intent168);
                break;

            case 169:
                Intent intent169 = new Intent(this, PhotoViewActivity.class);
                startActivity(intent169);
                break;

            case 170:
                Intent intent170 = new Intent(this, LauncherActivity.class);
                startActivity(intent170);
                break;

            case 171:
                Intent intent171 = new Intent(this, TouchImageActivity.class);
                startActivity(intent171);
                break;

            case 172:
                Intent intent172 = new Intent(this, SampleActivity.class);
                startActivity(intent172);
                break;

            case 173:
                Intent intent173 = new Intent(this, SampleTimesSquareActivity.class);
                startActivity(intent173);
                break;

            case 174:
                Intent intent174 = new Intent(this, TestSelectorAttrActivity.class);
                startActivity(intent174);
                break;

            case 175:
                Intent intent175 = new Intent(this, MenuActivity.class);
                startActivity(intent175);
                break;

            case 176:
                Intent intent176 = new Intent(this, NavigationActivity.class);
                startActivity(intent176);
                break;

            case 177:
                Intent intent177 = new Intent(this, Sampler.class);
                startActivity(intent177);
                break;

            case 178:
                Intent intent178 = new Intent(this, HomeActivity.class);
                startActivity(intent178);
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
