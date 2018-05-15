package com.meterial.demo.customview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

/**
 * 多行省略号
 * @author zenghao
 * @since 2018/5/7 下午3:37
 */
public class LableTextView4 extends AppCompatTextView {

    public LableTextView4(Context context) {
        super(context);
    }

    public LableTextView4(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public LableTextView4(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        //给省略号留的长度（但是，因为字符占位问题，获取的这个长度，要比省略号的三个点的长度大一些）
        //float moreText = getTextSize()*3;
        //float moreText = getTextSize();
        float moreText = 0;
        int wd = getWidth();
        //乘2，是代表2行的意思，减去moreText，是给省略号预留一点位置
        float availableTextWidth = (getWidth() - getPaddingLeft() - getPaddingRight()) * 2 - moreText;

        CharSequence tt = getText();

        CharSequence ellipsizeStr = TextUtils.ellipsize(getText(), getPaint(), availableTextWidth, TextUtils.TruncateAt.END);

        setText(ellipsizeStr);
    }



}
