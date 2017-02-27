package com.meterial.demo.CoordinatorLayout.third;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity; 
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.meterial.demo.R;

public class ThirdActivity extends AppCompatActivity { 
 
    private ImageView img, circleImg;
    private Button button;
 
    @Override 
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        init(); 
    } 
 
    private void init() { 
        img = (ImageView) findViewById(R.id.img);
        circleImg = (ImageView) findViewById(R.id.circle_img);
        button = (Button) findViewById(R.id.change);
        button.setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View v) {
                Bitmap bitmap = ((BitmapDrawable) img.getDrawable()).getBitmap();
                Matrix matrix = new Matrix();
                float size = Math.min(bitmap.getWidth(), bitmap.getHeight());
                //x缩放比例 
                float x = size / bitmap.getWidth();
                //y缩放比例 
                float y = size / bitmap.getHeight();
                matrix.setScale(x, y);
                //缩放以后的bitmap 
                Bitmap newBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
                int width = newBitmap.getWidth();
                int height = newBitmap.getHeight();
 
                //圆形bitmap 
                Bitmap circleBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(circleBitmap);
                Paint paint = new Paint();
                paint.setAntiAlias(true);
                paint.setColor(Color.BLACK);
                /**第一种方式**/ 
//                canvas.drawCircle(width / 2, height / 2, width / 2, paint); 
//                PorterDuffXfermode porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN); 
//                paint.setXfermode(porterDuffXfermode); 
//                canvas.drawBitmap(newBitmap, 0, 0, paint); 
                /**第二种方式**/ 
//                BitmapShader bitmapShader = new BitmapShader(newBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP); 
//                paint.setShader(bitmapShader); 
//                canvas.drawCircle(width / 2, height / 2, width / 2, paint); 
//                circleImg.setImageBitmap(circleBitmap); 
                /**第三种方式**/ 
                Path path = new Path();
                //按照顺时针方向添加一个圆 
                path.addCircle(width / 2, height / 2, width / 2, Path.Direction.CW);
                canvas.save();
                //设置为在圆形区域内绘制 
                canvas.clipPath(path);
                canvas.drawBitmap(newBitmap, 0, 0, paint);
                canvas.restore();
                circleImg.setImageBitmap(circleBitmap);
            } 
        }); 
    } 
 
 
} 