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
 * TODO
 *标签跟随动态移动 限制两行
 * 后期处 以动态添加设置行数 文字标签间距等
 * @author zenghao
 * @since 2017/9/27 上午10:30
 */
public class LableTextView extends ViewGroup {

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


    public LableTextView(Context context) {
        super(context);
    }

    public LableTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LableTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //子控件个数
        int childCount = getChildCount();
        int width = MeasureSpec.getSize(widthMeasureSpec);

        if(childCount == 2){

            TextView txtView;
            if(getChildAt(0) instanceof TextView){
                txtView = ((TextView) getChildAt(0));
                //initTextParams(txtView,txtView.getMeasuredWidth(),txtView.getPaint());
            }else{
                throw new RuntimeException("CustomLayout first child view not a TextView");
            }

            View sencodView = getChildAt(1);
            //测量子view的宽高
            measureChildren(widthMeasureSpec, heightMeasureSpec);
            //两个子view宽度相加小于该控件宽度的时候
            if(txtView.getMeasuredWidth() + sencodView.getMeasuredWidth() <= width){
                initTextParams(txtView,txtView.getMeasuredWidth(), txtView.getPaint());
                int tempWidth = txtView.getMeasuredWidth() + sencodView.getMeasuredWidth();
                int tempHeigh = Math.max(txtView.getMeasuredHeight(), sencodView.getMeasuredHeight());

                //设置该viewgroup的宽高
                setMeasuredDimension(tempWidth, tempHeigh);
                //只有一行显示
                type = SINGLE_LINE;
                return;
            }else{
                int lineCount = txtView.getLineCount();
                if(lineCount == 1){
                    initTextParams(txtView,txtView.getMeasuredWidth(), txtView.getPaint());
                    //文字显示只有一行
                    //第一行宽度不够lable显示 换到下一行
                    setMeasuredDimension(txtView.getMeasuredWidth(), txtView.getMeasuredHeight() + sencodView.getMeasuredHeight());
                    type = NEXT_LINE;
                    return;

                }else if(lineCount >= 2){
                    //文字显示超过一行

                    int firstend = txtView.getLayout().getLineEnd(0);
                    int sencod = txtView.getLayout().getLineEnd(1);

                    String firstStr = txtView.getText().subSequence(0,firstend).toString();
                    String sencodStr = txtView.getText().subSequence(firstend,sencod).toString();

                    String elisStr = TextUtils.ellipsize(sencodStr,txtView.getPaint(),width-sencodView.getMeasuredWidth(),TextUtils.TruncateAt.END).toString();

                    String allStr = firstStr+elisStr;

                    txtView.setText(allStr);
                    initTextParams(txtView,txtView.getMeasuredWidth(), txtView.getPaint());

                    setMeasuredDimension(txtView.getMeasuredWidth(), txtView.getMeasuredHeight());
                    type = MULTI_LINE;
                }


            }

        }else {
            throw new RuntimeException("CustomLayout child count must is 2");
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        TextView txtView = (TextView) getChildAt(0);
        //initTextParams(txtView,txtView.getMeasuredWidth(),txtView.getPaint());
        int lineCount = txtView.getLineCount();

        View lable = getChildAt(1);

        if(type == SINGLE_LINE){

            txtView.layout(0, 0, txtView.getMeasuredWidth(), txtView.getMeasuredHeight());

            lable.layout((int)lastLineRight,0,(int)lastLineRight+lable.getMeasuredWidth(),lable.getMeasuredHeight());

        }else if(type == NEXT_LINE){
            txtView.layout(0, 0, txtView.getMeasuredWidth(), txtView.getMeasuredHeight());
            lable.layout(0,txtView.getMeasuredHeight(),lable.getMeasuredWidth(),txtView.getMeasuredHeight()+lable.getMeasuredHeight());

        }else if(type == MULTI_LINE){
            txtView.layout(0, 0, txtView.getMeasuredWidth(), txtView.getMeasuredHeight());
            lable.layout((int)lastLineRight,lastLineTop,(int)lastLineRight+lable.getMeasuredWidth(),lastLineTop+lable.getMeasuredHeight());
        }


    }


    private void initTextParams(TextView tv, int maxWidth, TextPaint paint) {
        StaticLayout staticLayout = new StaticLayout(tv.getText(), paint, maxWidth, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        int lineCount = staticLayout.getLineCount();

        lastLineTop = staticLayout.getLineTop(lineCount - 1);
        lastLineRight = staticLayout.getLineRight(lineCount - 1);
    }
}
