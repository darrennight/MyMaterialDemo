package com.meterial.demo.fragment;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.transition.Fade;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.meterial.demo.R;

public class CircularRevealedFragment extends Fragment {

    public CircularRevealedFragment() { }

    private ImageView mHeader;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_circular_revealed, container, false);
        mHeader = ((ImageView) view.findViewById(R.id.image_header));
        mHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                share();
            }
        });
        return view;
    }
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void share(){
        CircularRevealedFragmentTest2 kitkittenDetails = new CircularRevealedFragmentTest2();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            kitkittenDetails.setSharedElementEnterTransition(new DetailsTransition());
            kitkittenDetails.setEnterTransition(new Fade());
            setExitTransition(new Fade());
            kitkittenDetails.setSharedElementReturnTransition(new DetailsTransition());
        }

        getActivity().getFragmentManager()
                .beginTransaction()
                .addSharedElement(mHeader, "kittenImage")
                .replace(R.id.frame_container, kitkittenDetails)
                .addToBackStack(null)
                .commit();
    }

}