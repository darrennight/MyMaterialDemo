package com.meterial.demo.ProjectUse.fragmentTransition;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.meterial.demo.R;

public class FragmentTran1 extends Fragment {

    public FragmentTran1() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_test_scene1, container, false);
        return rootView;
    }

}