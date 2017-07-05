package com.meterial.demo.customview.TopTab;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.meterial.demo.R;

/**
 *viewpager配合的顶部tab
 * @author zenghao
 * @since 2017/5/10 下午3:47
 */
public class BreadTopTable extends HorizontalScrollView implements ViewPager.OnPageChangeListener{

    private LinearLayout mTabsContainer;
    private Context mContext;
    private ViewPager mViewPager;
    private int mTablePadding;

    public BreadTopTable(Context context) {
        this(context,null);
    }

    public BreadTopTable(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public BreadTopTable(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
        initAttributes(context,attrs);
    }


    private void init(Context context){
        mContext = context;
        mTabsContainer = new LinearLayout(context);
        addView(mTabsContainer);
    }

    private void initAttributes(Context context, AttributeSet attrs){
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.BreadTopTab);
        mTablePadding = ta.getDimensionPixelOffset(R.styleable.BreadTopTab_tab_padding,0);
        ta.recycle();
    }


    public void addTab(String title){
        View tabView = View.inflate(mContext, R.layout.item_top_table, null);
        TextView tvtitle = ((TextView) tabView.findViewById(R.id.tv_tab_title));
        tvtitle.setPadding(mTablePadding,0,mTablePadding,0);
        tvtitle.setText(title);

        mTabsContainer.addView(tabView);
        mTabCount++;
    }

    public void setViewPager(ViewPager vp){

        this.mViewPager = vp;
        this.mViewPager.addOnPageChangeListener(this);
    }
    private float mUnderlineHeight = 4;
    private Paint mDividerPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Paint mRectPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private float mIndicatorHeight = 4;
    private GradientDrawable mIndicatorDrawable = new GradientDrawable();
    private float mIndicatorMarginLeft;
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mRectPaint.setColor(Color.BLUE);
        int paddingLeft = getPaddingLeft();
        int height = getHeight();
        //方式一
        //canvas.drawRect(paddingLeft, height - mUnderlineHeight, mTabsContainer.getChildAt(0).getWidth()+ paddingLeft, height, mRectPaint);

        //方式二
        mIndicatorDrawable.setColor(Color.BLUE);
        mIndicatorDrawable.setBounds(paddingLeft, (int)(height - mUnderlineHeight), mTabsContainer.getChildAt(0).getWidth()+ paddingLeft, height);
        mIndicatorDrawable.draw(canvas);
        calcIndicatorRect();


    }

    private int mCurrentTab;
    private float mCurrentPositionOffset;
    /** 用于实现滚动居中 */
    private Rect mTabRect = new Rect();
    private int mLastScrollX;
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        /**
         * position:当前View的位置
         * mCurrentPositionOffset:当前View的偏移量比例.[0,1)
         */

        this.mCurrentTab = position;
        this.mCurrentPositionOffset = positionOffset;
        scrollToCurrentTab();
        invalidate();

    }

    @Override
    public void onPageSelected(int position) {
        updateTabSelection(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private void updateTabSelection(int position) {
        for (int i = 0; i < mTabCount; ++i) {
            View tabView = mTabsContainer.getChildAt(i);
            final boolean isSelect = i == position;
            TextView tab_title = (TextView) tabView.findViewById(R.id.tv_tab_title);

            if (tab_title != null) {
                tab_title.setTextColor(Color.RED);
                /*if (mTextBold == TEXT_BOLD_WHEN_SELECT) {
                    tab_title.getPaint().setFakeBoldText(isSelect);
                }*/
            }
        }
    }

    private void scrollToCurrentTab(){
        int offset = (int) (mCurrentPositionOffset * mTabsContainer.getChildAt(mCurrentTab).getWidth());

        /**当前Tab的left+当前Tab的Width乘以positionOffset*/
        int newScrollX = mTabsContainer.getChildAt(mCurrentTab).getLeft() + offset;

        if (mCurrentTab > 0 || offset > 0) {
            /**HorizontalScrollView移动到当前tab,并居中*/
            newScrollX -= getWidth() / 2 - getPaddingLeft();
            calcIndicatorRect();
            newScrollX += ((mTabRect.right - mTabRect.left) / 2);
        }

        if (newScrollX != mLastScrollX) {
            mLastScrollX = newScrollX;
            /** scrollTo（int x,int y）:x,y代表的不是坐标点,而是偏移量
             *  x:表示离起始位置的x水平方向的偏移量
             *  y:表示离起始位置的y垂直方向的偏移量
             */
            scrollTo(newScrollX, 0);
        }
    }

    private static final int STYLE_NORMAL = 0;
    private static final int STYLE_TRIANGLE = 1;
    private static final int STYLE_BLOCK = 2;
    private int mIndicatorStyle = STYLE_NORMAL;
    private boolean mIndicatorWidthEqualTitle;
    private int mTabCount;
    /** 用于绘制显示器 */
    private Rect mIndicatorRect = new Rect();
    private float margin;
    private float mIndicatorWidth;

    private void calcIndicatorRect() {
        View currentTabView = mTabsContainer.getChildAt(this.mCurrentTab);
        float left = currentTabView.getLeft();
        float right = currentTabView.getRight();

        //for mIndicatorWidthEqualTitle
        if (mIndicatorStyle == STYLE_NORMAL && mIndicatorWidthEqualTitle) {
           /* TextView tab_title = (TextView) currentTabView.findViewById(R.id.tv_tab_title);
            mTextPaint.setTextSize(mTextsize);
            float textWidth = mTextPaint.measureText(tab_title.getText().toString());
            margin = (right - left - textWidth) / 2;*/
        }

        if (this.mCurrentTab < mTabCount - 1) {
            View nextTabView = mTabsContainer.getChildAt(this.mCurrentTab + 1);
            float nextTabLeft = nextTabView.getLeft();
            float nextTabRight = nextTabView.getRight();

            left = left + mCurrentPositionOffset * (nextTabLeft - left);
            right = right + mCurrentPositionOffset * (nextTabRight - right);

            //for mIndicatorWidthEqualTitle
            if (mIndicatorStyle == STYLE_NORMAL && mIndicatorWidthEqualTitle) {
                TextView next_tab_title = (TextView) nextTabView.findViewById(R.id.tv_tab_title);
              /*  mTextPaint.setTextSize(mTextsize);
                float nextTextWidth = mTextPaint.measureText(next_tab_title.getText().toString());
                float nextMargin = (nextTabRight - nextTabLeft - nextTextWidth) / 2;
                margin = margin + mCurrentPositionOffset * (nextMargin - margin);*/
            }
        }

        mIndicatorRect.left = (int) left;
        mIndicatorRect.right = (int) right;
        //for mIndicatorWidthEqualTitle
        if (mIndicatorStyle == STYLE_NORMAL && mIndicatorWidthEqualTitle) {
            mIndicatorRect.left = (int) (left + margin - 1);
            mIndicatorRect.right = (int) (right - margin - 1);
        }

        mTabRect.left = (int) left;
        mTabRect.right = (int) right;

        if (mIndicatorWidth < 0) {   //indicatorWidth小于0时,原jpardogo's PagerSlidingTabStrip

        } else {//indicatorWidth大于0时,圆角矩形以及三角形
            float indicatorLeft = currentTabView.getLeft() + (currentTabView.getWidth() - mIndicatorWidth) / 2;

            if (this.mCurrentTab < mTabCount - 1) {
                View nextTab = mTabsContainer.getChildAt(this.mCurrentTab + 1);
                indicatorLeft = indicatorLeft + mCurrentPositionOffset * (currentTabView.getWidth() / 2 + nextTab.getWidth() / 2);
            }

            mIndicatorRect.left = (int) indicatorLeft;
            mIndicatorRect.right = (int) (mIndicatorRect.left + mIndicatorWidth);
        }
    }
}
