package com.meterial.demo.commonActivity.index;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.meterial.demo.R;
import com.meterial.demo.customview.index.BubbleScroller;
import com.meterial.demo.customview.index.ScrollerListener;
import java.util.List;

/**
 *https://github.com/cdflynn/bubble-scroll
 * @author zenghao
 * @since 2017/5/9 下午3:39
 */
public class ListIndexActivity extends AppCompatActivity {

    private static final String TAG = ListIndexActivity.class.getSimpleName();

    static class Views {
        BubbleScroller scroller;
        RecyclerView recycler;

        Views(ListIndexActivity activity) {
            scroller = (BubbleScroller) activity.findViewById(R.id.bubble_scroller);
            recycler = (RecyclerView) activity.findViewById(R.id.recycler);
        }
    }

    private Views mViews;
    private ContactScrollerAdapter mContactScrollerAdapter;
    private ContactAdapter mContactAdapter;
    private LinearLayoutManager mLayoutManager;
    private boolean mProgrammaticScroll = true;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_list_index);
        mViews = new Views(this);
        List<Contact> contactList = Contact.mocks(this);
        mContactScrollerAdapter = new ContactScrollerAdapter(contactList);
        mContactAdapter = new ContactAdapter(this, contactList, mContactScrollerAdapter);
        mLayoutManager = new LinearLayoutManager(this);
        mViews.scroller.setScrollerListener(mScrollerListener);
        mViews.scroller.setSectionScrollAdapter(mContactScrollerAdapter);
        mViews.recycler.setLayoutManager(mLayoutManager);
        mViews.recycler.setAdapter(mContactAdapter);
        mViews.scroller.showSectionHighlight(0);
        mViews.recycler.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (mProgrammaticScroll) {
                    mProgrammaticScroll = false;
                    return;
                }
                final int firstVisibleItemPosition = mLayoutManager.findFirstCompletelyVisibleItemPosition();
                mViews.scroller.showSectionHighlight(
                        mContactScrollerAdapter.sectionFromPosition(firstVisibleItemPosition));
            }
        });
    }

    private final ScrollerListener mScrollerListener = new ScrollerListener() {
        @Override
        public void onSectionClicked(int sectionPosition) {
            mViews.recycler.smoothScrollToPosition(
                    mContactScrollerAdapter.positionFromSection(sectionPosition));
            mProgrammaticScroll = true;
        }

        @Override
        public void onScrollPositionChanged(float percentage, int sectionPosition) {
            mViews.recycler.smoothScrollToPosition(
                    mContactScrollerAdapter.positionFromSection(sectionPosition));
            mProgrammaticScroll = true;
        }
    };
}

