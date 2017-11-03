package com.meterial.demo.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.text.DynamicLayout;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class DynamicRichText extends View {
 
private DynamicLayout mLayout;
private Point mCirclePosition;
private int mCircleRadius;
private Rect mRect;
private TextPaint mTextPaint;
 
private int latestFirstLine;
private int latestLastLine;
private int latestOffsetStart;
private int latestOffsetEnd;
 
private SpannableStringBuilder mText;
 
public DynamicRichText(Context context){
    this(context, null);
} 
 
public DynamicRichText(Context context, AttributeSet attrs){
    this(context, attrs, 0);
} 
 
public DynamicRichText(Context context, AttributeSet attrs, int defStyle){
    super(context, attrs, defStyle);
 
    mText = new SpannableStringBuilder("abcdefghijklmnopqrstuvwxyz" +
            "abcdefghijklmnopqrstuvwxyz" + 
            "abcdefghijklmnopqrstuvwxyz" + 
            "abcdefghijklmnopqrstuvwxyz" + 
            "abcdefghijklmnopqrstuvwxyz" + 
            "abcdefghijklmnopqrstuvwxyz" + 
            "abcdefghijklmnopqrstuvwxyz" + 
            "abcdefghijklmnopqrstuvwxyz" + 
            "abcdefghijklmnopqrstuvwxyz" + 
            "abcdefghijklmnopqrstuvwxyz" + 
            "abcdefghijklmnopqrstuvwxyz" + 
            "abcdefghijklmnopqrstuvwxyz" + 
            "abcdefghijklmnopqrstuvwxyz" + 
            "abcdefghijklmnopqrstuvwxyz" + 
            "abcdefghijklmnopqrstuvwxyz" + 
            "abcdefghijklmnopqrstuvwxyz"); 
 
    mRect = new Rect();
    mCirclePosition = new Point();
    mCircleRadius = 120;
    mTextPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
    mTextPaint.setTextSize(80);
    mTextPaint.setColor(0xFF0099CC);
} 
 
@Override 
public boolean onTouchEvent(MotionEvent event){
    if(event.getActionMasked() == MotionEvent.ACTION_MOVE){
        mCirclePosition.x = (int) event.getX();
        mCirclePosition.y = (int) event.getY();
        mRect.left = mCirclePosition.x - mCircleRadius;
        mRect.right = mCirclePosition.x + mCircleRadius;
        mRect.top = mCirclePosition.y - mCircleRadius;
        mRect.bottom = mCirclePosition.y + mCircleRadius;
 
        resolveLayout(); 
 
        invalidate();
 
    } 
 
    return true; 
} 
 
private void resolveLayout(){ 
 
    Object[] spans = mText.getSpans(latestOffsetStart, latestOffsetEnd, Object.class);
    for(int i = 0; i < spans.length; i++){
        int start = mText.getSpanStart(spans[i]);
        if(spans[i] instanceof ImageSpan) mText.delete(start, start + 1);
        mText.removeSpan(spans[i]);
 
    } 
 
    int line = mLayout.getLineForVertical(mRect.top);
 
    int offsetStart = mLayout.getOffsetForHorizontal(line, mRect.left) - 1;
    latestOffsetStart = offsetStart;
    while(mLayout.getLineTop(line) < mRect.bottom){
        offsetStart = mLayout.getOffsetForHorizontal(line, mRect.left) - 1;
        int lineHeight = mLayout.getLineBottom(line) - mLayout.getLineTop(line);
 
        mText.insert(offsetStart, " ");
 
        ColorDrawable emptyDrawable = new ColorDrawable(0x0);
        emptyDrawable.setBounds(0, 0, mRect.width() + (int) mTextPaint.getTextSize(), lineHeight);
        ImageSpan emptySpan = new ImageSpan(emptyDrawable);
        mText.setSpan(emptySpan, offsetStart, offsetStart + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
 
 
        line++;
    } 
 
    latestOffsetEnd = offsetStart + 1;
 
} 
 
@Override 
public void onSizeChanged(int w, int h, int oldw, int oldh){
    mCirclePosition = new Point(w / 2, h / 2);
    mLayout = new DynamicLayout(mText, mText, mTextPaint, w, Layout.Alignment.ALIGN_NORMAL, 1, 0, false);
} 
 
@Override 
public void onDraw(Canvas canvas){
    mTextPaint.setColor(0xFF000000);
    canvas.drawRect(mRect, mTextPaint);
    mTextPaint.setColor(0xFF0099CC);
    mLayout.draw(canvas);
} 
} 