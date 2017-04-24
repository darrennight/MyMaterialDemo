package com.meterial.demo.commonActivity.spruce;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.meterial.demo.R;
import com.meterial.demo.commonActivity.spruce.sort.DefaultSort;
import java.util.ArrayList;
import java.util.List;

import static java.security.AccessController.getContext;

public class RecyclerFragment extends Fragment {
 
    public static RecyclerFragment newInstance() { 
        return new RecyclerFragment(); 
    } 
 
    private RecyclerView recyclerView;
    private Animator spruceAnimator;
 
    @Nullable 
    @Override 
    public View onCreateView(LayoutInflater inflater, ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        recyclerView = (RecyclerView) container.findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
 
        RelativeLayout placeholder = (RelativeLayout) container.findViewById(R.id.placeholder_view);
 
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext()) {
            @Override 
            public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) { 
                super.onLayoutChildren(recycler, state); 
                // Animate in the visible children 
                spruceAnimator = new Spruce.SpruceBuilder(recyclerView)
                    .sortWith(new DefaultSort(100))
                    .animateWith(DefaultAnimations.shrinkAnimator(recyclerView, 800),
                            ObjectAnimator.ofFloat(recyclerView, "translationX", -recyclerView.getWidth(), 0f).setDuration(800))
                    .start(); 
 
            } 
        }; 
 
        List<RelativeLayout> placeHolderList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            placeHolderList.add(placeholder);
        } 
 
        recyclerView.setAdapter(new RecyclerAdapter(placeHolderList));
        recyclerView.setLayoutManager(linearLayoutManager);
 
        return inflater.inflate(R.layout.recycler_fragment, container, false);
    } 
 
    @Override 
    public void onResume() { 
        super.onResume(); 
        if (spruceAnimator != null) {
            spruceAnimator.start();
        } 
    } 
 
    private class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> { 
 
        List<RelativeLayout> placeholderList;
 
        class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
 
            RelativeLayout placeholderView;
 
            ViewHolder(View itemView) {
                super(itemView);
                placeholderView = (RelativeLayout) itemView.findViewById(R.id.placeholder_view);
                placeholderView.setOnClickListener(this);
            } 
 
            @Override 
            public void onClick(View v) {
                if (spruceAnimator != null) {
                    spruceAnimator.start();
                } 
            } 
        } 
 
        RecyclerAdapter(List<RelativeLayout> placeholderList) {
            this.placeholderList = placeholderList;
        } 
 
        @Override 
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            RelativeLayout view = (RelativeLayout) LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.recycler_placeholder, parent, false);
 
            return new ViewHolder(view);
        } 
 
        @Override 
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.placeholderView = placeholderList.get(position);
        } 
 
        @Override 
        public int getItemCount() { 
            return placeholderList.size();
        } 
 
    } 
} 