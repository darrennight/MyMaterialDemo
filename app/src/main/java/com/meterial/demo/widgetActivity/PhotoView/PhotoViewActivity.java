package com.meterial.demo.widgetActivity.PhotoView;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.meterial.demo.R;

/**
 * https://github.com/bm-x/PhotoView
 */
public class PhotoViewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_view);
    }

    public void img(View view) {
        startActivity(new Intent(this, ImgActivity.class));
    }

    public void viewpager(View view) {
        startActivity(new Intent(this, ViewPagerActivity.class));
    }

    public void imgclick(View view) {
        startActivity(new Intent(this, ImgClick.class));
    }

    public void photobrowse(View view) {
        startActivity(new Intent(this, PhotoBrowse.class));
    }

    public void imageview(View view) {
        startActivity(new Intent(this, ImageViewActivity.class));
    }
}