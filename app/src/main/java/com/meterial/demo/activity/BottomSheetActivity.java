package com.meterial.demo.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.meterial.demo.R;
import com.meterial.demo.customview.BottomSheetDialogView;
import com.meterial.demo.customview.TripListPop;

/**
 * Created by zenghao on 16/3/9.
 */
public class BottomSheetActivity extends AppCompatActivity {

    private TextView mApiSupport;
    private TextView mNestedSV;
    private TextView btn_rv_behavior;
    private TextView btn_beaut;
    private TextView btn_dialog;
    private TextView btn_pop_window;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_sheet);
        mApiSupport = ((TextView) findViewById(R.id.btn_api_support));
        mNestedSV = ((TextView) findViewById(R.id.btn_nsv));
        btn_rv_behavior = ((TextView) findViewById(R.id.btn_rv_behavior));
        btn_beaut = ((TextView) findViewById(R.id.btn_beaut));
        btn_dialog = ((TextView) findViewById(R.id.btn_dialog));
        btn_pop_window = ((TextView) findViewById(R.id.btn_pop_window));

        mApiSupport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialogView.show(BottomSheetActivity.this);
            }
        });

        mNestedSV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BottomSheetActivity.this,NestedScrollViewActivity.class));
            }
        });

        btn_rv_behavior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BottomSheetActivity.this,RecyclerViewBehaviorActivity.class));
            }
        });

        btn_beaut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BottomSheetActivity.this,BeautifulBottomSheetActivity.class));
            }
        });

        btn_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBottomSheet();
            }
        });

        btn_pop_window.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TripListPop pop = new TripListPop(BottomSheetActivity.this);
                pop.showAtLocation(btn_pop_window, Gravity.BOTTOM, 0, 0);
                pop.update();
            }
        });
    }

    public void openBottomSheet () {


        View view = getLayoutInflater ().inflate (R.layout.bottom_sheet, null);
        TextView txtBackup = (TextView)view.findViewById( R.id.txt_backup);
        TextView txtDetail = (TextView)view.findViewById( R.id.txt_detail);
        TextView txtOpen = (TextView)view.findViewById( R.id.txt_open);
        final TextView txtUninstall = (TextView)view.findViewById( R.id.txt_uninstall);


        final Dialog mBottomSheetDialog = new Dialog (BottomSheetActivity.this, R.style.MaterialDialogSheet);
        mBottomSheetDialog.setContentView (view);
        mBottomSheetDialog.setCancelable (true);
        mBottomSheetDialog.getWindow ().setLayout (LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        mBottomSheetDialog.getWindow ().setGravity (Gravity.BOTTOM);
        mBottomSheetDialog.show ();




        txtBackup.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Toast.makeText(BottomSheetActivity.this,"Clicked Backup",Toast.LENGTH_SHORT).show();
                mBottomSheetDialog.dismiss();
            }
        });


        txtDetail.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Toast.makeText(BottomSheetActivity.this,"Clicked Detail",Toast.LENGTH_SHORT).show();
                mBottomSheetDialog.dismiss();
            }
        });


        txtOpen.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Toast.makeText(BottomSheetActivity.this,"Clicked Open",Toast.LENGTH_SHORT).show();
                mBottomSheetDialog.dismiss();
            }
        });


        txtUninstall.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Toast.makeText(BottomSheetActivity.this,"Clicked Uninstall",Toast.LENGTH_SHORT).show();
                mBottomSheetDialog.dismiss();
            }
        });
    }
}