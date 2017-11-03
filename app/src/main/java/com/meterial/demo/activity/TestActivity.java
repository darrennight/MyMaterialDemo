package com.meterial.demo.activity;

import android.animation.ObjectAnimator;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.meterial.demo.R;
import com.meterial.demo.commonActivity.cardview.CenterDrawable;
import com.meterial.demo.commonActivity.cardview.TestCenterDrawable;

/**
 * TODO
 *测试使用
 * @author zenghao
 * @since 2017/9/6 上午11:47
 */
public class TestActivity extends AppCompatActivity {

    private ImageView icon;
    private Button btn;
    private ImageView line;
    private ImageView line2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        icon = ((ImageView) findViewById(R.id.iv_icon));
        icon.setVisibility(View.INVISIBLE);
        btn = ((Button) findViewById(R.id.btn_click));

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                icon.setVisibility(View.VISIBLE);
                move();
            }
        });

        //LinearLayout layout = ((LinearLayout) findViewById(R.id.root_haha));
        //layout.setLayerType(View.LAYER_TYPE_SOFTWARE, null);//没有这句不显示

        line = ((ImageView) findViewById(R.id.iv_line));
        line2 = ((ImageView) findViewById(R.id.iv_line2));
        line.setBackground(new TestCenterDrawable(BitmapFactory.decodeResource(getResources(), R.drawable.quote)));
        line2.setBackground(new TestCenterDrawable(BitmapFactory.decodeResource(getResources(), R.drawable.quote)));
    }

    private void move(){
        ObjectAnimator animator = ObjectAnimator.ofFloat(icon, "translationX", icon.getWidth(), 0f);
        animator.setDuration(500).start();
    }
}
