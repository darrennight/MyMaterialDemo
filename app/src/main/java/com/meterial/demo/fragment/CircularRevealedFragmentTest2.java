package com.meterial.demo.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.meterial.demo.R;

public class CircularRevealedFragmentTest2 extends Fragment {

    public CircularRevealedFragmentTest2() { }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_circular_revealed2, container, false);
        return view;
    }


}