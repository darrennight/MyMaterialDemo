package com.meterial.demo.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.meterial.demo.R;

/**
 *添加了动态宽度wrap_content类型
 * @author zenghao
 * @since 2017/4/27 下午5:20
 */
public class RoundBgTest2 extends RelativeLayout {

    /**文字*/
    private String btnText;
    /**文字颜色*/
    private int textColor;
    /**文字大小*/
    private int textSize;


    /**纯色正常态颜色*/
    private int pureNormalColor;
    /**纯色点击态颜色*/
    private int purePressColor;

    /**渐变色正常态*/
    private int gradientNormalStartColor;
    private int gradientNormalEndColor;

    /**渐变色点击态*/
    private int gradientPressStartColor;
    private int gradientPressEndColor;

    /**边框颜色*/
    private int strokeColor;
    /**边框宽度*/
    private int strokeSize;

    /**边框渐变色*/
    private int strokeGradientStartColor;
    private int strokeGradientEndColor;

    /**按钮圆角角度*/
    private int cornerRadius;

    /**是否按钮颜色渐变*/
    private boolean hasGradient;

    /**边框是否渐变*/
    private boolean hasStrokeGradient;
    /**是否需要边框*/
    private boolean hasStroke;
    /**渐变方向*/
    private int GraditenOrientaton;

    private int mLeftPadding;
    private int mRightPadding;

    public RoundBgTest2(Context context) {
        this(context,null,0);
    }

    public RoundBgTest2(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public RoundBgTest2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initTypedArray(attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int specMode = MeasureSpec.getMode(widthMeasureSpec);
        int specSize = MeasureSpec.getSize(widthMeasureSpec);

        if (specMode == MeasureSpec.AT_MOST) {//相当于我们设置为wrap_content
            //设置左右padding textview的padding
            View view =   getChildAt(0);
            view.setPadding(mLeftPadding,0,mRightPadding,0);

        } else if (specMode == MeasureSpec.EXACTLY) {//相当于我们设置为match_parent或者为一个具体的值

            View view =   getChildAt(0);
            ViewGroup.LayoutParams params =  view.getLayoutParams();
            params.width = specSize;
            view.setLayoutParams(params);
        }
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        initTextView();
    }

    private void initTextView(){

        TextView textView = new TextView(getContext());
        LayoutParams textParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        textView.setLayoutParams(textParams);
        textView.setGravity(Gravity.CENTER);

        textView.setText(TextUtils.isEmpty(btnText)?"":btnText);
        textView.setTextColor(textColor);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_PX,textSize);

        if (hasGradient){
            GradientStyle();
        }else{
            PureStyle();
        }

        if(hasStrokeGradient){
            GradientStrok();
            PureContent(textView);
            setPadding(strokeSize,strokeSize,strokeSize,strokeSize);
        }

        addView(textView);

        setClickable(true);
    }

    /***
     * 按钮纯颜色+纯色边框背景样式
     */
    private void PureStyle(){

        GradientDrawable normal = new GradientDrawable();
        GradientDrawable press = new GradientDrawable();

        normal.setColor(pureNormalColor);
        normal.setCornerRadius(cornerRadius);
        normal.setStroke(strokeSize,strokeColor);


        press.setColor(purePressColor);
        press.setCornerRadius(cornerRadius);
        press.setStroke(strokeSize,strokeColor);




        StateListDrawable drawable = new StateListDrawable();

        drawable.addState(new int[]{android.R.attr.state_pressed}, press);
        drawable.addState(new int[0], normal);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            setBackground(drawable);
        } else {
            setBackgroundDrawable(drawable);
        }

    }

    /**
     *按钮渐变+纯色边框样式
     */
    private void GradientStyle(){

        GradientDrawable normal = new GradientDrawable(getOrientation(GraditenOrientaton),
                                                       new int[]{ gradientNormalStartColor,gradientNormalEndColor});
        GradientDrawable press = new GradientDrawable(getOrientation(GraditenOrientaton),
                                                        new int[]{gradientPressStartColor,gradientPressEndColor});

        normal.setCornerRadius(cornerRadius);
        normal.setStroke(strokeSize,strokeColor);

        press.setCornerRadius(cornerRadius);
        press.setStroke(strokeSize,strokeColor);

        StateListDrawable drawable = new StateListDrawable();

        drawable.addState(new int[]{android.R.attr.state_pressed}, press);
        drawable.addState(new int[0], normal);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            setBackground(drawable);
        } else {
            setBackgroundDrawable(drawable);
        }
    }


    private GradientDrawable.Orientation getOrientation(int orientation){

        switch (orientation){
            case 0:
                return GradientDrawable.Orientation.TOP_BOTTOM;
            case 1:
                return GradientDrawable.Orientation.TR_BL;
            case 2:
                return GradientDrawable.Orientation.RIGHT_LEFT;
            case 3:
                return GradientDrawable.Orientation.BR_TL;
            case 4:
                return GradientDrawable.Orientation.BOTTOM_TOP;
            case 5:
                return GradientDrawable.Orientation.BL_TR;
            case 6:
                return GradientDrawable.Orientation.LEFT_RIGHT;
            case 7:
                return GradientDrawable.Orientation.TL_BR;

            default:
                break;
        }
        return GradientDrawable.Orientation.TOP_BOTTOM;
    }

    /**
     * 内容填充色
     */
    private void PureContent(TextView view){


        GradientDrawable normal = new GradientDrawable();
        GradientDrawable press = new GradientDrawable();

        normal.setColor(pureNormalColor);
        normal.setCornerRadius(cornerRadius);


        press.setColor(purePressColor);
        press.setCornerRadius(cornerRadius);




        StateListDrawable drawable = new StateListDrawable();

        drawable.addState(new int[]{android.R.attr.state_pressed}, press);
        drawable.addState(new int[0], normal);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }

    }

    /**渐变边框*/
    private void GradientStrok(){
        GradientDrawable normal = new GradientDrawable(getOrientation(GraditenOrientaton),
                new int[]{ strokeGradientStartColor,strokeGradientEndColor});
        normal.setCornerRadius(cornerRadius);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            setBackground(normal);
        } else {
            setBackgroundDrawable(normal);
        }
    }


    private void initTypedArray(AttributeSet attrs){
        TypedArray type = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.BreadRoundButton, 0, 0);

        btnText = type.getString(R.styleable.BreadRoundButton_bread_bt_text);
        textColor = type.getColor(R.styleable.BreadRoundButton_bread_bt_text_color,
                ContextCompat.getColor(getContext(), R.color.white));
        textSize = type.getDimensionPixelSize(R.styleable.BreadRoundButton_bread_bt_text_size,
                (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_SP, 12, getResources().getDisplayMetrics()));


        pureNormalColor = type.getColor(R.styleable.BreadRoundButton_pure_normal_color
                          ,ContextCompat.getColor(getContext(), R.color.white));
        purePressColor = type.getColor(R.styleable.BreadRoundButton_pure_press_color
                          ,ContextCompat.getColor(getContext(), R.color.white));

        gradientNormalStartColor = type.getColor(R.styleable.BreadRoundButton_gradient_normal_start_color
                        ,ContextCompat.getColor(getContext(), R.color.white));
        gradientNormalEndColor = type.getColor(R.styleable.BreadRoundButton_gradient_normal_end_color
                        ,ContextCompat.getColor(getContext(), R.color.white));

        gradientPressStartColor = type.getColor(R.styleable.BreadRoundButton_gradient_press_start_color
                        ,ContextCompat.getColor(getContext(), R.color.white));
        gradientPressEndColor = type.getColor(R.styleable.BreadRoundButton_gradient_press_end_color
                        ,ContextCompat.getColor(getContext(), R.color.white));


        strokeColor = type.getColor(R.styleable.BreadRoundButton_bread_stroke_color
                        ,ContextCompat.getColor(getContext(), R.color.white));
        strokeSize = type.getDimensionPixelSize(R.styleable.BreadRoundButton_bread_stroke_size,0);

        strokeGradientStartColor = type.getColor(R.styleable.BreadRoundButton_stroke_gradient_start_color
                        ,ContextCompat.getColor(getContext(), R.color.white));
        strokeGradientEndColor = type.getColor(R.styleable.BreadRoundButton_stroke_gradient_end_color
                        ,ContextCompat.getColor(getContext(), R.color.white));

        cornerRadius = type.getDimensionPixelSize(R.styleable.BreadRoundButton_bread_corner_radius,0);

        hasGradient = type.getBoolean(R.styleable.BreadRoundButton_bread_has_gradient,false);
        hasStrokeGradient = type.getBoolean(R.styleable.BreadRoundButton_bread_has_stroke_gradient,false);
        hasStroke = type.getBoolean(R.styleable.BreadRoundButton_bread_has_stroke,false);

        GraditenOrientaton = type.getInteger(R.styleable.BreadRoundButton_bread_gradient_orientation
                            , 0);
        mLeftPadding = type.getDimensionPixelSize(R.styleable.BreadRoundButton_bread_text_padding_left,0);
        mRightPadding = type.getDimensionPixelSize(R.styleable.BreadRoundButton_bread_text_padding_right,0);
        type.recycle();
    }

    public String getBtnText() {
        return btnText;
    }

    public void setBtnText(String btnText) {
        this.btnText = btnText;
    }

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }

    public int getTextSize() {
        return textSize;
    }

    public void setTextSize(int textSize) {
        this.textSize = textSize;
    }

    public int getPureNormalColor() {
        return pureNormalColor;
    }

    public void setPureNormalColor(int pureNormalColor) {
        this.pureNormalColor = pureNormalColor;
    }

    public int getPurePressColor() {
        return purePressColor;
    }

    public void setPurePressColor(int purePressColor) {
        this.purePressColor = purePressColor;
    }

    public int getGradientNormalStartColor() {
        return gradientNormalStartColor;
    }

    public void setGradientNormalStartColor(int gradintNormalStartColor) {
        this.gradientNormalStartColor = gradintNormalStartColor;
    }

    public int getGradientNormalEndColor() {
        return gradientNormalEndColor;
    }

    public void setGradientNormalEndColor(int gradlintNormalEndColor) {
        this.gradientNormalEndColor = gradlintNormalEndColor;
    }

    public int getGradientPressStartColor() {
        return gradientPressStartColor;
    }

    public void setGradientPressStartColor(int gradintPressStartColor) {
        this.gradientPressStartColor = gradintPressStartColor;
    }

    public int getGradientPressEndColor() {
        return gradientPressEndColor;
    }

    public void setGradientPressEndColor(int gradlintPressEndColor) {
        this.gradientPressEndColor = gradlintPressEndColor;
    }

    public int getStrokeColor() {
        return strokeColor;
    }

    public void setStrokeColor(int strokeColor) {
        this.strokeColor = strokeColor;
    }

    public int getStrokeSize() {
        return strokeSize;
    }

    public void setStrokeSize(int strokeSize) {
        this.strokeSize = strokeSize;
    }

    public int getStrokeGradientStartColor() {
        return strokeGradientStartColor;
    }

    public void setStrokeGradientStartColor(int strokeGradientColor) {
        this.strokeGradientStartColor = strokeGradientColor;
    }

    public int getStrokeGradientEndColor() {
        return strokeGradientEndColor;
    }

    public void setStrokeGradientEndColor(int strokeGradientEndColor) {
        this.strokeGradientEndColor = strokeGradientEndColor;
    }

    public int getCornerRadius() {
        return cornerRadius;
    }

    public void setCornerRadius(int cornerRadius) {
        this.cornerRadius = cornerRadius;
    }

    public boolean isHasGradient() {
        return hasGradient;
    }

    public void setHasGradient(boolean hasGradient) {
        this.hasGradient = hasGradient;
    }

    public boolean isHasStrokeGradient() {
        return hasStrokeGradient;
    }

    public void setHasStrokeGradient(boolean hasStrokeGradient) {
        this.hasStrokeGradient = hasStrokeGradient;
    }

    public boolean isHasStroke() {
        return hasStroke;
    }

    public void setHasStroke(boolean hasStroke) {
        this.hasStroke = hasStroke;
    }

    public int getGraditenOrientaton() {
        return GraditenOrientaton;
    }

    public void setGraditenOrientaton(int graditenOrientaton) {
        GraditenOrientaton = graditenOrientaton;
    }


    /* 自定设置圆形按钮 onMeasure 里面执行
    public void setRound(boolean round){
        this.mRound = round;
        int height = getMeasuredHeight();
        if(mRound){
            setRadius(height / 2f);
        }
    }*/
}
