package com.meterial.demo.activity;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 *和AndroidStudayDemo里面到多进程通信测试
 * @author zenghao
 * @since 2018/1/9 上午11:05
 */
public class TestIPCActivity extends AppCompatActivity {

    public static final String AUTHORITY = "org.wangchenlong.book.provider"; // 与AndroidManifest保持一致

    public static final Uri USER_CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/user");
    private ContentObserver mObserver;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mObserver = new ContentObserver(new Handler()) {
            @Override
            public void onChange(boolean selfChange, Uri uri) {
                super.onChange(selfChange, uri);
                Log.e("===TestIPCActivity=","onChangeonChangeTestIPCActivity"+uri);
            }

        };
        //监听另外一个进程中对数据库修改
        getContentResolver().registerContentObserver(USER_CONTENT_URI, true, mObserver);
    }
}
