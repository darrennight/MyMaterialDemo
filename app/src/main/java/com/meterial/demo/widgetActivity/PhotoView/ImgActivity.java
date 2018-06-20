package com.meterial.demo.widgetActivity.PhotoView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.meterial.demo.R;

/**
 * Created by liuheng on 2015/6/21.
 */
public class ImgActivity extends Activity {

    String url = "https://ss0.baidu.com/94o3dSag_xI4khGko9WTAnF6hhy/super/whfpf%3D425%2C260%2C50/sign=30f49b810ff79052ef4a147e6acee3f8/5bafa40f4bfbfbedbb34deed7ef0f736afc31f36.jpg";
    String gif = "http://imgsrc.baidu.com/baike/pic/item/7af40ad162d9f2d339d2a789abec8a136227cc91.jpg";

    MyNewPhotoView mPhotoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img);

        mPhotoView = (MyNewPhotoView) findViewById(R.id.img1);
        mPhotoView.enable();
        mPhotoView.enableRotate();

        mPhotoView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(ImgActivity.this, "长按了", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

//        使用ImageLoader
//        ImaggeLoaderConfiguration configuration = ImageLoaderConfiguration
//                .createDefault(this);
//        ImageLoader.getInstance().init(configuration);
//        ImageLoader.etInstance().displayImage(url, (ImageView) findViewById(R.id.img1));

//        使用Glide加载的gif图片同样支持缩放功能
//        Glide.with(this)
//                .load(gif)
//                .crossFade()
//                .placeholder(R.mipmap.bbb)
//                .into(((PhotoView) findViewById(R.id.img1)));
    }
}