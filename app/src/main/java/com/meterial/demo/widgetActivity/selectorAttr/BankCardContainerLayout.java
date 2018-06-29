package com.meterial.demo.widgetActivity.selectorAttr;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.meterial.demo.R;

public class BankCardContainerLayout extends RelativeLayout {

    final int ext_attr[] = {
            R.attr.bank_card_type
    };

    final int ext_attr_red[] = {
            R.attr.bank_card_type_red
    };

    final int ext_attr_blue[] = {
            R.attr.bank_card_type_blue
    };

    final int ext_attr_green[] = {
            R.attr.bank_card_type_green
    };

    public static final int RED = 1;
    public static final int GREEN = 2;
    public static final int BLUE = 3;

    private int bk_type = 1;

    public BankCardContainerLayout(Context context) {
        this(context, null);
    }

    public BankCardContainerLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BankCardContainerLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray array = context.obtainStyledAttributes(attrs, ext_attr);
        if (array != null) {
            setType(array.getInt(R.styleable.BankCardContainerLayout_bank_card_type, 1));
            array.recycle();
        }
    }

    /**
     * @param type {@link #RED}  {@link #GREEN}  {@link #BLUE}
     */
    public void setType(int type) {
        this.bk_type = type;
        refreshDrawableState();
    }

    @Override
    protected int[] onCreateDrawableState(int extraSpace) {
        int drawableState[] = super.onCreateDrawableState(extraSpace + 1);
        switch (bk_type) {
            case RED:
                mergeDrawableStates(drawableState, ext_attr_red);
                break;
            case GREEN:
                mergeDrawableStates(drawableState, ext_attr_green);
                break;
            case BLUE:
                mergeDrawableStates(drawableState, ext_attr_blue);
                break;
        }
        return drawableState;
    }
}
