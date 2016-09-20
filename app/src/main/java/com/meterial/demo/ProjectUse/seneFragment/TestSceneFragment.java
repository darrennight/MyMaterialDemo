package com.meterial.demo.ProjectUse.seneFragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.meterial.demo.R;

public class TestSceneFragment extends Fragment {

    public TestSceneFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_test_scene1, container, false);
        return rootView;
    }

}