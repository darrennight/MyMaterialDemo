package com.meterial.demo.commonActivity.FoldableLayout;

import android.os.Bundle;
import com.alexvasilkov.android.commons.ui.Views;
import com.meterial.demo.R;

public class FoldableListActivity extends FoldBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foldable_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FoldableListLayout foldableListLayout = Views.find(this, R.id.foldable_list);
        foldableListLayout.setAdapter(new PaintingsAdapter(this));
    }

}