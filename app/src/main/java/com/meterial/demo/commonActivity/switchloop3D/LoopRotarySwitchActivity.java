package com.meterial.demo.commonActivity.switchloop3D;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.Toast;
import com.meterial.demo.R;
import com.meterial.demo.customview.loop3DSwitch.LoopRotarySwitchView;
import com.meterial.demo.customview.loop3DSwitch.OnItemClickListener;
import com.meterial.demo.customview.loop3DSwitch.OnItemSelectedListener;

/**
 * https://github.com/dalong982242260/LoopRotarySwitch
 *旋转木马样式
 * @author zenghao
 * @since 2018/1/19 下午2:49
 */
public class LoopRotarySwitchActivity extends AppCompatActivity {

    private LoopRotarySwitchView mLoopRotarySwitchView;

    private  int width;
    private SeekBar mSeekBarX,mSeekBarZ;
    private CheckBox mCheckbox;
    private Switch mSwitchLeftright;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loop_rotary_switch);
        initView();
        initLoopRotarySwitchView();
        initLinstener();
        mLoopRotarySwitchView.setSelectItem(4);
    }

    private void initLinstener() {
        mLoopRotarySwitchView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int item, View view) {
                Toast.makeText(LoopRotarySwitchActivity.this, "item:"+item, Toast.LENGTH_SHORT).show();
            }
        });
        /**
         * 选中回调
         */
        mLoopRotarySwitchView.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void selected(int position, View view) {

            }
        });
        /**
         * 设置子view的x坐标
         */
        mSeekBarX.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mLoopRotarySwitchView.setLoopRotationX(progress - seekBar.getMax() / 2);
                mLoopRotarySwitchView.initView();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        /**
         * 设置子view的z坐标
         */
        mSeekBarZ.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mLoopRotarySwitchView.setLoopRotationZ(progress - seekBar.getMax() / 2);
                mLoopRotarySwitchView.initView();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        /**
         * 设置是否自动旋转
         */
        mCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mLoopRotarySwitchView.setAutoRotation(isChecked);//启动LoopViewPager自动切换
            }
        });
        /**
         * 设置向左还是向右自动旋转
         */
        mSwitchLeftright.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mLoopRotarySwitchView.setAutoScrollDirection(isChecked?LoopRotarySwitchView.AutoScrollDirection.left
                        :LoopRotarySwitchView.AutoScrollDirection.right);
            }
        });
    }

    /**
     * 设置LoopRotarySwitchView
     */
    private void initLoopRotarySwitchView() {
        mLoopRotarySwitchView
                .setR(width/3)//设置R的大小
                .setMultiple(0.1f)
                .setAutoRotation(false)//是否自动切换
                .setAutoScrollDirection(LoopRotarySwitchView.AutoScrollDirection.left)
                .setAutoRotationTime(1500);//自动切换的时间  单位毫秒

    }

    /**
     *  初始化布局
     */
    private void initView() {
        mLoopRotarySwitchView=(LoopRotarySwitchView)findViewById(R.id.mLoopRotarySwitchView);
        mSeekBarX = (SeekBar) findViewById(R.id.seekBarX);
        mSeekBarZ = (SeekBar) findViewById(R.id.seekBarZ);
        mCheckbox = (CheckBox) findViewById(R.id.checkbox);
        mSwitchLeftright = (Switch) findViewById(R.id.switchLeftright);
        mSeekBarX.setProgress(mSeekBarX.getMax() / 2);
        mSeekBarZ.setProgress(mSeekBarZ.getMax() / 2);

        DisplayMetrics dm = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        windowManager.getDefaultDisplay().getMetrics(dm);
        width=dm.widthPixels;
    }



}