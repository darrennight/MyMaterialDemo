package com.meterial.demo.commonActivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.meterial.demo.R;
import com.meterial.demo.customview.PanningView;

/**
 *背景图片左右移动
 * 另外一种效果
 * https://github.com/flavioarfaria/KenBurnsView
 * @author zenghao
 * @since 17/3/29 下午6:10
 */
public class PanningViewActivity extends AppCompatActivity {


    private static final int[] drawables = new int[] {R.drawable.bg_default_artist_art, R.drawable.bg_default_artist_art2, R.drawable.bg_default_artist_art3, R.drawable.bg_default_artist_art4};

    private int mDrawableIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panning);

        final PanningView panningView = (PanningView) findViewById(R.id.panningView);

        findViewById(R.id.buttonStart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                panningView.startPanning();
            }
        });
        findViewById(R.id.buttonStop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                panningView.stopPanning();
            }
        });
        findViewById(R.id.buttonChange).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawableIndex++;
                if(mDrawableIndex >= drawables.length) {
                    mDrawableIndex = 0;
                }
                panningView.setImageResource(drawables[mDrawableIndex]);
            }
        });
    }
}
