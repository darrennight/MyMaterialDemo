package com.meterial.demo.CoordinatorLayout.easeBehavior.ui;
 
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager; 
import android.support.v7.widget.LinearLayoutManager; 
import android.support.v7.widget.RecyclerView; 
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.meterial.demo.R;

/** 
 * A fragment representing a list of Items. 
 * <p/> 
 */ 
public class ItemFragment extends Fragment {
 
    // TODO: Customize parameters 
    private int mColumnCount = 1;
 
 
    public ItemFragment() { 
    } 
 
    @Override 
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
 
    } 
 
    @Override 
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);
 
        // Set the adapter 
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else { 
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            } 
            recyclerView.setAdapter(new MyItemRecyclerViewAdapter(DummyContent.ITEMS));
        } 
        return view;
    } 
 
 
} 