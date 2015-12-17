/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.meterial.demo.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.meterial.demo.R;

import java.util.ArrayList;
import java.util.List;

public class CheeseListFragment extends LazyBaseFragment {
    // 标志位，标志已经初始化完成。
    private boolean isPrepared;
    private RecyclerView rv;
    /** 是否已被加载过一次，第二次就不再去请求数据了 */
    private boolean mHasLoadedOnce;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.e("====","=======oncreadonc");
        if(rv == null){
            rv = (RecyclerView) inflater.inflate( R.layout.fragment_cheese_list, container, false);
            isPrepared = true;
            lazyLoad();
            setupRecyclerView(rv);
        }
        return rv;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //viewpager 默认保留三个  其他倒会被 销毁 此处倒adapter  deatch
        Log.e("====","=======desdesdesdes");
    }


    private void setupRecyclerView(RecyclerView recyclerView) {
        mHasLoadedOnce = true;
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        List<String> list = new ArrayList<String>();
        for(int i=0;i<=10;i++){
            list.add(i+"");
        }
        recyclerView.setAdapter(new SimpleStringRecyclerViewAdapter(getActivity(),list));
    }

    @Override
    protected void lazyLoad() {
        if(!isPrepared || !isVisiable || mHasLoadedOnce){
            return;
        }
        //setupRecyclerView(rv);
    }

    public static class SimpleStringRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleStringRecyclerViewAdapter.ViewHolder> {

        private final TypedValue mTypedValue = new TypedValue();
        private int mBackground;
        private List<String> mValues;

        public static class ViewHolder extends RecyclerView.ViewHolder {
            public String mBoundString;

            public final View mView;
            public final ImageView mImageView;
            public final TextView mTextView;

            public ViewHolder(View view) {
                super(view);
                mView = view;
                mImageView = (ImageView) view.findViewById(R.id.avatar);
                mTextView = (TextView) view.findViewById(android.R.id.text1);
            }

            @Override
            public String toString() {
                return super.toString() + " '" + mTextView.getText();
            }
        }

        public String getValueAt(int position) {
            return mValues.get(position);
        }

        public SimpleStringRecyclerViewAdapter(Context context, List<String> items) {
            context.getTheme().resolveAttribute(R.attr.selectableItemBackground, mTypedValue, true);
            mBackground = mTypedValue.resourceId;
            mValues = items;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_item, parent, false);
            view.setBackgroundResource(mBackground);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            holder.mBoundString = mValues.get(position);
            holder.mTextView.setText(""+System.currentTimeMillis());

            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, CheeseDetailActivity.class);

                    context.startActivity(intent);
                }
            });

           holder.mImageView.setImageResource(R.mipmap.ic_launcher);
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }
    }
}
