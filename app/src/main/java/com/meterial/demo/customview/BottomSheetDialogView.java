package com.meterial.demo.customview;

import android.content.Context;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.meterial.demo.R;

/**
 * Created by zenghao on 16/3/8.
 */
public class BottomSheetDialogView {

    private static String[] sStringList;


    static {
        sStringList = new String[50];
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < sStringList.length; i++) {
            stringBuilder.append(i + 1);
            sStringList[i] = stringBuilder.toString();
        }
    }


    /**
     * remember to call setLocalNightMode for dialog
     *
     * @param context
     * @param dayNightMode current day night mode
     */
    public BottomSheetDialogView(Context context, int dayNightMode) {
        BottomSheetDialog dialog = new BottomSheetDialog(context);
        dialog.getDelegate().setLocalNightMode(dayNightMode);


        View view = LayoutInflater.from(context).inflate(R.layout.bottom_sheet_dialog_recycler_view, null);


        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.bottom_sheet_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(new SimpleAdapter());


        dialog.setContentView(view);
        dialog.show();

    }


    public BottomSheetDialogView(Context context) {
        BottomSheetDialog dialog = new BottomSheetDialog(context);

        View view = LayoutInflater.from(context).inflate(R.layout.bottom_sheet_dialog_recycler_view, null);


        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.bottom_sheet_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(new SimpleAdapter());

        dialog.setContentView(view);

//＊＊＊＊＊＊＊＊＊＊＊＊＊＊
        View parent = (View) view.getParent();
        BottomSheetBehavior behavior = BottomSheetBehavior.from(parent);
        view.measure(0, 0);
        behavior.setPeekHeight(view.getMeasuredHeight());
        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) parent.getLayoutParams();
        params.gravity = Gravity.TOP | Gravity.CENTER_HORIZONTAL;
        parent.setLayoutParams(params);
//        这段代码 设置对话框完全显示 内容多 不适合使用  默认即可
//＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊
//        behavior.setState();



        /*bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                if (newState == BottomSheetBehavior.STATE_HIDDEN) {
                    mBottomSheetDialog.dismiss();
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
            }
        });*/

        dialog.show();
    }


    public static void show(Context context, int dayNightMode) {
        new BottomSheetDialogView(context, dayNightMode);
    }

    public static void show(Context context) {
        new BottomSheetDialogView(context);
    }


    private static class ViewHolder extends RecyclerView.ViewHolder {


        private TextView mTextView;


        public ViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.list_item_text_view);
        }
    }


    private static class SimpleAdapter extends RecyclerView.Adapter<ViewHolder> {


        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.list_item_new, null);
            return new ViewHolder(view);
        }


        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.mTextView.setText(sStringList[position]);
        }


        @Override
        public int getItemCount() {
            return 5;
        }
    }
}
