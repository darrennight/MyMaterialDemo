package com.meterial.demo.commonActivity.bottomNav;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.meterial.demo.R;

/**
 * TODO
 *https://github.com/roughike/BottomBar
 * @author zenghao
 * @since 2017/7/6 下午6:20
 */
public class BottomNavMainActivity extends AppCompatActivity implements View.OnClickListener {
    @SuppressWarnings("ConstantConditions")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_nav_third);

        findViewById(R.id.simple_three_tabs).setOnClickListener(this);
        findViewById(R.id.icons_only).setOnClickListener(this);
        findViewById(R.id.five_tabs_changing_colors).setOnClickListener(this);
        findViewById(R.id.three_tabs_quick_return).setOnClickListener(this);
        findViewById(R.id.five_tabs_custom_colors).setOnClickListener(this);
        findViewById(R.id.badges).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Class clazz = null;

        switch (v.getId()) {
            case R.id.simple_three_tabs:
                clazz = ThreeTabsActivity.class;
                break;
            case R.id.icons_only:
                clazz = IconsOnlyActivity.class;
                break;
            case R.id.five_tabs_changing_colors:
                clazz = FiveColorChangingTabsActivity.class;
                break;
            case R.id.three_tabs_quick_return:
                clazz = ThreeTabsQRActivity.class;
                break;
            case R.id.five_tabs_custom_colors:
                clazz = CustomColorAndFontActivity.class;
                break;
            case R.id.badges:
                clazz = BadgeActivity.class;
                break;
        }

        startActivity(new Intent(this, clazz));
    }
}