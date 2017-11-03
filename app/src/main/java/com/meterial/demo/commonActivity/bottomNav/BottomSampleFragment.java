package com.meterial.demo.commonActivity.bottomNav;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.meterial.demo.commonActivity.chanelView.SampleFragment;

/**
 * TODO
 *
 * @author zenghao
 * @since 2017/7/6 下午6:21
 */
public class BottomSampleFragment extends Fragment {
    private static final String ARG_TEXT = "ARG_TEXT";

    public BottomSampleFragment() {
    }

    public static SampleFragment newInstance(String text) {
        Bundle args = new Bundle();
        args.putString(ARG_TEXT, text);

        SampleFragment sampleFragment = new SampleFragment();
        sampleFragment.setArguments(args);

        return sampleFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        TextView textView = new TextView(getActivity());
        textView.setText(getArguments().getString(ARG_TEXT));

        return textView;
    }
}