package com.meterial.demo.commonActivity.Door;

import android.content.Intent;
import android.net.Uri;
import android.os.Debug;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowManager;
import android.widget.SeekBar;
import com.meterial.demo.BuildConfig;
import com.meterial.demo.R;

/**
 * https://github.com/renaudcerrato/DoorSignView
 */
public class DoorMainActivity extends AppCompatActivity {


    private static final Uri GITHUB_PROJECT_URI = Uri.parse("https://github.com/renaudcerrato/DoorSignView");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_door);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (BuildConfig.DEBUG) {
            if (Debug.isDebuggerConnected()) {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
            }
        }
    }

    public void onFabClick(View view) {
        final Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(GITHUB_PROJECT_URI);
        startActivity(intent);
    }
}