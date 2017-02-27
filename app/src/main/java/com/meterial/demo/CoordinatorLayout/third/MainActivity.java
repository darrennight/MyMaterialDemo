package com.meterial.demo.CoordinatorLayout.third;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity; 
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.meterial.demo.R;

public class MainActivity extends AppCompatActivity { 
 
    private Button mainBtn;
    private TextView mainTxt;
    private LinearLayout maniLinearLayout, textLayout;
 
 
    @Override 
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
 
        setContentView(R.layout.activity_third_main);
        initView(); 
 
    } 
 
    private void initView() { 
        mainBtn = (Button) findViewById(R.id.main_btn);
        mainTxt = (TextView) findViewById(R.id.main_txt);
        maniLinearLayout = (LinearLayout) findViewById(R.id.main_ll);
        textLayout = (LinearLayout) findViewById(R.id.main_txt_ll);
        WindowManager windowManager = (WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        int width = windowManager.getDefaultDisplay().getWidth();
        int height = windowManager.getDefaultDisplay().getHeight();
        Log.e("log", "屏幕宽度:" + width);
        Log.e("log", "屏幕高度:" + height);
 
 
        mainTxt.setOnTouchListener(new View.OnTouchListener() {
            @Override 
            public boolean onTouch(View view, MotionEvent event) {
 
                int x = (int) event.getX();
                int y = (int) event.getY();
                int xRaw = (int) event.getRawX();
                int yRaw = (int) event.getRawY();
                switch (event.getAction()) {
 
                    case MotionEvent.ACTION_DOWN:
                        Log.e("log", "文字相对控件坐标为:" + x + "," + y + "最小距离" + px2dp(getApplicationContext(), ViewConfiguration.get(getApplicationContext()).getScaledTouchSlop()));
                        Log.e("log", "文字相对屏幕坐标为:" + xRaw + "," + yRaw);
 
                        break; 
                    case MotionEvent.ACTION_MOVE:
 
                        break; 
                    case MotionEvent.ACTION_UP:
 
                        break; 
                } 
                return false; 
            } 
        }); 
 
 
        mainTxt.setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                Log.e("log", "监听点击事件");
            } 
        }); 
 
 
        mainBtn.setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), SecondActivity.class));
            } 
        }); 
    } 
 
    @Override 
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
 
        if (hasFocus) {
            Log.e("log", "按钮的getTop():" + mainBtn.getTop());
            Log.e("log", "按钮的getBottom():" + mainBtn.getBottom());
            Log.e("log", "按钮的getLeft():" + mainBtn.getLeft());
            Log.e("log", "按钮的getRight():" + mainBtn.getRight());
 
            Log.e("log", "按钮的getWidth(px):" + mainBtn.getWidth());
            Log.e("log", "按钮的getHeight(px):" + mainBtn.getHeight());
 
            Log.e("log", "按钮的getWidth(dp):" + px2dp(getApplicationContext(), mainBtn.getWidth()));
            Log.e("log", "按钮的getHeight(dp):" + px2dp(getApplicationContext(), mainBtn.getHeight()));
 
 
            Log.e("log", "文字布局的getTop():" + textLayout.getTop());
            Log.e("log", "文字布局的getBottom():" + textLayout.getBottom());
            Log.e("log", "文字布局的getLeft():" + textLayout.getLeft());
            Log.e("log", "文字布局的getRight():" + textLayout.getRight());
 
            Log.e("log", "文字的getTop():" + mainTxt.getTop());
            Log.e("log", "文字的getBottom():" + mainTxt.getBottom());
            Log.e("log", "文字的getLeft():" + mainTxt.getLeft());
            Log.e("log", "文字的getRight():" + mainTxt.getRight());
 
            int[] btnWindowInt = new int[2];
            mainTxt.getLocationInWindow(btnWindowInt);
            Log.e("log", "文字在当前窗口内的绝对横坐标:" + btnWindowInt[0]);
            Log.e("log", "文字在当前窗口内的绝对纵坐标:" + btnWindowInt[1]);
 
 
            int[] llWindowInt = new int[2];
            maniLinearLayout.getLocationInWindow(llWindowInt);
            Log.e("log", "线性布局在当前窗口内的绝对横坐标:" + llWindowInt[0]);
            Log.e("log", "线性布局在当前窗口内的绝对纵坐标:" + llWindowInt[1]);
 
 
        } 
 
    } 
 
    //px转dp 
    public static int px2dp(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    } 
 
 
    @Override 
    public boolean dispatchTouchEvent(MotionEvent event) {
 
        int x = (int) event.getX();
        int y = (int) event.getY();
        int xRaw = (int) event.getRawX();
        int yRaw = (int) event.getRawY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e("log", "dispatchTouchEvent点击坐标为:" + x + "," + y);
                Log.e("log", "dispatchTouchEvent点击坐标为:" + xRaw + "," + yRaw);
                break; 
            case MotionEvent.ACTION_MOVE:
                break; 
            case MotionEvent.ACTION_UP:
                break; 
        } 
        return super.dispatchTouchEvent(event);
    } 
 
 
    @Override 
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        int xRaw = (int) event.getRawX();
        int yRaw = (int) event.getRawY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e("log", "onTouchEvent点击坐标为:" + x + "," + y);
                Log.e("log", "onTouchEvent点击坐标为:" + xRaw + "," + yRaw);
                break; 
            case MotionEvent.ACTION_MOVE:
 
                break; 
            case MotionEvent.ACTION_UP:
                break; 
        } 
 
 
        return super.onTouchEvent(event);
    } 
 
    @Override 
    protected void onStart() { 
        super.onStart(); 
        Log.e("tag", "A生命周期:onStart");
    } 
 
 
    @Override 
    protected void onResume() { 
        super.onResume(); 
        Log.e("tag", "A生命周期:onResume");
    } 
 
    @Override 
    protected void onRestart() { 
        super.onRestart(); 
        Log.e("tag", "A生命周期:onRestart");
    } 
 
 
    @Override 
    protected void onPause() { 
        super.onPause(); 
        Log.e("tag", "A生命周期:onPause");
    } 
 
    @Override 
    protected void onStop() { 
        super.onStop(); 
        Log.e("tag", "A生命周期:onStop");
    } 
 
 
    @Override 
    protected void onDestroy() { 
        super.onDestroy(); 
        Log.e("tag", "A生命周期:onDestroy");
    } 
 
 
} 