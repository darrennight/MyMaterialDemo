package com.meterial.demo.customview;

import android.content.Context;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
 
/**
 * Created by Cmad on 2015/11/17.
 */
public class CustomLayout extends ViewGroup {
    //单行显示
    private static final int SINGLE_LINE = 0x01;
    //多行显示
    private static final int MULTI_LINE = 0x02;
    //显示到下一行
    private static final int NEXT_LINE = 0x03;
    //显示样式
    private int type;
    //绘制文字最后一行的顶部坐标
    private int lastLineTop;
    //绘制文字最后一行的右边坐标
    private float lastLineRight;
 
    public CustomLayout(Context context) {
        super(context);
    }
 
    public CustomLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
 
    public CustomLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
 
 
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int childCount = getChildCount();
        int w = MeasureSpec.getSize(widthMeasureSpec);
        if (childCount == 2) {
            TextView tv = null;
            if(getChildAt(0) instanceof  TextView){
                tv = (TextView) getChildAt(0);
                initTextParams(tv.getText(), tv.getMeasuredWidth(), tv.getPaint());
            }else{
                throw new RuntimeException("CustomLayout first child view not a TextView");
            }
 
            View sencodView = getChildAt(1);
 
            //测量子view的宽高
            measureChildren(widthMeasureSpec, heightMeasureSpec);

            //String elis = TextUtils.ellipsize(tv.getText(),tv.getPaint(),w,TextUtils.TruncateAt.END).toString();

            //第一行最后一个字符结束位置
            int end = tv.getLayout().getLineEnd(0);
            String elis = tv.getText().subSequence(0,end).toString();
            Log.e("=====","第一行"+elis);


            int endTwo = tv.getLayout().getLineEnd(1);

            String elisTwo = tv.getText().subSequence(end,endTwo).toString();
            Log.e("=====","第二行"+elisTwo);



            int test = tv.getLineCount();
            Log.e("=====","高度"+test);
            //两个子view宽度相加小于该控件宽度的时候
            if (tv.getMeasuredWidth() + sencodView.getMeasuredWidth() <= w) {                 
                int width = tv.getMeasuredWidth()+sencodView.getMeasuredWidth();                 
                //计算高度                 
                int height = Math.max(tv.getMeasuredHeight(), sencodView.getMeasuredHeight());                 
                //设置该viewgroup的宽高                 
                setMeasuredDimension(width, height);                 
                type = SINGLE_LINE;                 
                return;             
            }

            if (getChildAt(0) instanceof TextView) {                 
                //最后一行文字的宽度加上第二个view的宽度大于viewgroup宽度时第二个控件换行显示                 
                if (lastLineRight + sencodView.getMeasuredWidth() > w && test<=1) {
                    setMeasuredDimension(tv.getMeasuredWidth(), tv.getMeasuredHeight() + sencodView.getMeasuredHeight());
                    type = NEXT_LINE;
                    return;
                }
 
                int height ;
                if(test<=1){
                     height = Math.max(tv.getMeasuredHeight(), lastLineTop + sencodView.getMeasuredHeight());
                }else{
                    height = tv.getMeasuredHeight();
                }
                setMeasuredDimension(tv.getMeasuredWidth(), height);
                type = MULTI_LINE;
            }
        } else {
            throw new RuntimeException("CustomLayout child count must is 2");
        }
 
 
    }
 
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        TextView tv = (TextView) getChildAt(0);
        //initTextParams(tv.getText(), tv.getMeasuredWidth(), tv.getPaint());
        if (type == SINGLE_LINE || type == MULTI_LINE) {
            //TextView tv = (TextView) getChildAt(0);
            View v1 = getChildAt(1);
            int count = tv.getLineCount();

            //设置第二个view在Textview文字末尾位置
            tv.layout(0, 0, tv.getMeasuredWidth(), tv.getMeasuredHeight());
            int left = (int) lastLineRight;
            int top  = lastLineTop;
            //最后一行的高度 注:通过staticLayout得到的行高不准确故采用这种方式
            int lastLineHeight = tv.getBottom()-tv.getPaddingBottom() -lastLineTop;
            //当第二view高度小于单行文字高度时竖直居中显示
            if(v1.getMeasuredHeight() < lastLineHeight && count<=1){
                top = lastLineTop + (lastLineHeight - v1.getMeasuredHeight())/2;
            }

            //v1.layout(left, top, left + v1.getMeasuredWidth(), top+v1.getMeasuredHeight());

            int v1Top = v1.getTop();
            int tvHeight = tv.getHeight();

            //if(v1Top>=tvHeight){
            //    v1.layout(getWidth()-v1.getWidth(), tvHeight/2, getWidth(), v1.getHeight());
            //}else{
            //    v1.layout(left, top, left + v1.getMeasuredWidth(), top+v1.getMeasuredHeight());
            //}

            if(count<=1){
                v1.layout(left, top, left + v1.getMeasuredWidth(), top+v1.getMeasuredHeight());
            }else if(count == 2){

                if(v1.getRight()<=getWidth() && v1Top<tvHeight){
                    v1.layout(left, top, left + v1.getMeasuredWidth(), top+v1.getMeasuredHeight());
                }else{
                    v1.layout(getWidth()-v1.getWidth(), tvHeight/2, getWidth(), tv.getBottom());
                    //if(v1Top>=tvHeight){
                    //    v1.layout(getWidth()-v1.getWidth(), tvHeight/2, getWidth(), v1.getHeight());
                    //}else{
                    //    v1.layout(left, top, left + v1.getMeasuredWidth(), top+v1.getMeasuredHeight());
                    //}
                }



               int right =  tv.getRight();
                int parR = getWidth();
                int v1Right = v1.getRight();

                if(right+v1Right >=parR){

                }else{

                }
                /*Log.e("===",parR+"right"+right);
                Log.e("===",tv.getHeight()+"height"+v1.getTop());*/
            }else {

            }


        } else if (type == NEXT_LINE) {
            View v0 = getChildAt(0);
            View v1 = getChildAt(1);
            //设置第二个view换行显示
            v0.layout(0, 0, v0.getMeasuredWidth(), v0.getMeasuredHeight());
            v1.layout(0, v0.getMeasuredHeight(), v1.getMeasuredWidth(), v0.getMeasuredHeight() + v1.getMeasuredHeight());
        }
    }
 
 private int count = 0;
    /**
     * 得到Textview绘制文字的基本信息
     * @param text Textview的文字内容
     * @param maxWidth Textview的宽度
     * @param paint 绘制文字的paint
     */
    private void initTextParams(CharSequence text, int maxWidth, TextPaint paint) {
        StaticLayout staticLayout = new StaticLayout(text, paint, maxWidth, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        int lineCount = staticLayout.getLineCount();
        count = lineCount;
        lastLineTop = staticLayout.getLineTop(lineCount - 1);
        lastLineRight = staticLayout.getLineRight(lineCount - 1);
        //Log.e("===",count+"====ellipsize"+staticLayout.getEllipsizedWidth());
        Log.e("===","hahahahha");
        for (int i=0 ;i<count;i++){
            Log.e("===",i+"===="+staticLayout.getLineRight(i));
        }
    }
 
}