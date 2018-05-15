package com.meterial.demo.chart.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/**
 *  画饼图类 
 */  
@SuppressLint("ViewConstructor")
public class PieView extends View {
      
    int areaX = 1;  
    int areaY = 22;  
      
    //饼图的宽高  
    private int areaWidth = 360;     
    private int areaHight = 300;  
         
    //颜色数组  
    private int[] colors =new int[]{  
            Color.rgb(54,217,169),Color.rgb(0,171,255),Color.rgb(80,195,252),Color.rgb(13,142,207),
            Color.rgb(2,211,21),Color.rgb(176,222,9),Color.rgb(248,255,1),Color.rgb(252,210,2),  
            Color.rgb(255,159,13),Color.rgb(255,100,0),Color.rgb(234,14,0),  
            };  
    //阴影数组  
    private int[] shade_colors = new int[]{  
            Color.rgb(26,164,123),Color.rgb(0,154,230),Color.rgb(21,178,255),Color.rgb(5,102,153),  
            Color.rgb(3,147,15),Color.rgb(124,158,8),Color.rgb(212,218,2),Color.rgb(219,183,6),  
            Color.rgb(214,135,5),Color.rgb(210,90,13),Color.rgb(199,13,1),  
            };  
      
    //区域百分比  
    private int percent[];  
      
    private String title;  
    private int thickness= 20;  
    float x, y;  
      
    //默认可响应点击事件  
    private boolean isOntouch= true;  
    //下面的图例文字  
    private String[] info;  
      
    //点击事件的计算  
    private float centerX;  
    private float centerY;  
      
    private Context context;
      
    //图例文字的pain  
    private Paint legendPaint;
    //饼图的paint  
    private Paint mainPaint;  
      
    //默认显示右边  
    private WHERE where  = WHERE.right;  
  
    public static enum WHERE{  
        right ,bottmo  
    }

    public PieView(Context context) {
        this(context,null);
    }

    public PieView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public PieView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        this.percent = new int[]{90,90,90,90};
        this.context = context;
        this.info = new String[]{"1","1","1","1"};
        initPaint();
    }

    /*public PieView(Context context,int[] percent, String[] info) {
            super(context);

            this.percent = percent;
            this.context = context;
            this.info = info;
            initPaint();
        }
      */
    //初始化 画笔  
    private void initPaint(){  
          
        legendPaint = new Paint();  
        legendPaint.setColor(Color.BLACK);  
        legendPaint.setStrokeWidth(1f);  
  
        mainPaint = new Paint();  
        mainPaint.setStyle(Paint.Style.FILL);
        mainPaint.setAntiAlias(true);     
    }  
  
    //设置饼图的大小  这里已经给了默认大小了  
    public void  setSize(int areaWidth ,int areaHight){   
        this.areaWidth = areaWidth;  
        this.areaHight = areaHight;  
    }  
      
    //饼图的标题  
    public void setTitle(String title){  
        this.title = title;  
    }  
      
    public void setWhere(WHERE s){  
        this.where =  s;  
    }  
      
    public void setThickness(int thickness) {  
        this.thickness = thickness;  
        areaY=thickness+2;  
        this.invalidate();  
    }  
  
  
    // 主要访法   
    @Override  
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);  
          
        //开画  
        for(int i=0;i <= thickness;i++){  
              
            int tempAngle=0;  
            for(int j=0;j< percent.length;j++){  
                //画笔的颜色  
                mainPaint.setColor(shade_colors[j]);  
                //坐标点 start end  
                RectF rectF = new RectF(areaX, areaY-i, areaX+areaWidth, areaHight-i);  
                //画弧  
                canvas.drawArc(rectF, tempAngle,percent[j], true, mainPaint);  
                tempAngle+=percent[j];    
            }  
              
              
            //开始画图例区域  
            if(i  == thickness ){  
                  
                RectF rectF = new RectF(areaX, areaY- thickness, areaX + areaWidth, areaHight- thickness);
                centerX = rectF.centerX();  
                centerY = rectF.centerY();  
  
                int temp = areaHight + 20/* height-320*/;                 
                  
                for(int j=0;j<percent.length;j++){  
                      
                      
                    mainPaint.setColor(colors[j]);  
                    canvas.drawArc(rectF , tempAngle,percent[j], true, mainPaint);  
                    tempAngle+=percent[j];  
                      
                      
                    //说明区域  
                    RectF rect = new RectF(areaX, temp, areaX+40, temp-10);//标识区域  
                    canvas.drawText(info[j], areaX+60, temp, legendPaint);  
                    canvas.drawRect(rect, mainPaint);  
                    temp += 25;  
                }  
            }  
        }  
          
        //  
        for (int i = 0; i < colors.length; i++) {  
              
            if (isOntouch) {  
                isOntouch = false;  
                System.out.println(centerX + ""  + centerY);  
                  
                double d = Math.atan2(y-centerY, x-centerX)*180/Math.atan2(0.0, -1.0);  
                  
                if (d < 0) {  
                    d = 360 + d;  
                }  
          
                int temp = 0;  
                for (int j = 0; j < percent.length; j++) {  
                      
                    Log.e(Float.toString(y), Float.toString(areaHight));
                      
                    if (d >temp && d < percent[j]+temp && y < areaHight) {  
                           System.out.println(" " + colors[j]);  
          
//                      context.startActivity(it);  
                          
                        Toast.makeText(context, "colors[j]="+ colors[j]
                                                + "----x,y="+ x+","+y  
                                                +"--temp="+ temp,     
                                Toast.LENGTH_SHORT).show();
                    }  
                    temp += percent[j];  
                }  
            }  
        }  
    }  
      
    @Override  
    public boolean onTouchEvent(MotionEvent event) {
          
        if (event.getAction() == MotionEvent.ACTION_UP) {  
            isOntouch = true;  
            x = event.getX();  
            y = event.getY();  
            invalidate();  
        }  
        return true;  
    }  
      
      
    @Override  
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {  
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);  
    }  
}  