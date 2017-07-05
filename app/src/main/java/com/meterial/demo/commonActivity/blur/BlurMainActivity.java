package com.meterial.demo.commonActivity.blur;

import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.meterial.demo.R;
import java.util.Random;

/**
 *https://github.com/mmin18/RealtimeBlurView
 * @author zenghao
 * @since 2017/5/22 下午2:50
 */
public class BlurMainActivity extends AppCompatActivity {

    RealtimeBlurView blurView;
    SeekBar blurRadius;
    TextView blurRadiusText;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_blur);
        blurView = (RealtimeBlurView) findViewById(R.id.blur_view);
        ((ListView) findViewById(R.id.list)).setAdapter(new MyListAdapter(this));

        blurRadius = (SeekBar) findViewById(R.id.blur_radius);
        blurRadius.setProgress(10);
        blurRadius.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updateRadius();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        blurRadiusText = (TextView) findViewById(R.id.blur_radius_val);
        updateRadius();

        findViewById(R.id.drag).setOnTouchListener(touchListener);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Popup Window");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        showPopup();
        return true;
    }

    private void showPopup() {
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            LayoutInflater inflater = LayoutInflater.from(this);
            View layout = inflater.inflate(R.layout.popup_layout, null);
            b.setView(layout);
        } else {
            b.setView(R.layout.popup_layout);
        }
        Dialog dlg = b.show();
        dlg.findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ListView) findViewById(R.id.list)).smoothScrollToPosition(new Random(System.currentTimeMillis()).nextInt(10));
            }
        });
    }

    private void updateRadius() {
        blurView.setBlurRadius(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, blurRadius.getProgress(), getResources().getDisplayMetrics()));
        blurRadiusText.setText(blurRadius.getProgress() + "dp");
    }

    private View.OnTouchListener touchListener = new View.OnTouchListener() {
        float dx, dy;

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            View target = findViewById(R.id.blur_frame);
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                dx = target.getX() - event.getRawX();
                dy = target.getY() - event.getRawY();
            } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
                target.setX(event.getRawX() + dx);
                target.setY(event.getRawY() + dy);
            }
            return true;
        }
    };

    private boolean slideUp;

    public void doSlide(View v) {
        final View view = findViewById(R.id.blur_frame);
        view.animate().translationYBy((slideUp ? -1 : 1) * view.getHeight()).setDuration(1000).start();
        slideUp = !slideUp;
    }

}
