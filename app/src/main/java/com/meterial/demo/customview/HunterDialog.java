package com.meterial.demo.customview;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.meterial.demo.R;

/**
 * 通用对话框
 * Created by  on
 *
 * @author zenghao
 * @since 16/9/14 上午11:43
 */
public class HunterDialog {

    private AlertDialog.Builder mBuilder;

    private HunterDialog() {
    }

    private HunterDialog(Context context, final Builder inBuilder) {
        mBuilder = new AlertDialog.Builder(context, R.style.BreadTripAlerDialogStyle);

        mBuilder.setCancelable(inBuilder.cancelable);

        if (!TextUtils.isEmpty(inBuilder.title)) {
            mBuilder.setTitle(inBuilder.title);
        }

        if (inBuilder.mItems != null) {
            initMenuView(context, mBuilder, inBuilder.mItems, inBuilder);
        } else if (!TextUtils.isEmpty(inBuilder.message)) {
            mBuilder.setMessage(inBuilder.message);
        }

        if (!TextUtils.isEmpty(inBuilder.positive)) {
            mBuilder.setPositiveButton(inBuilder.positive, inBuilder.mPositiveListener);
        }

        if (!TextUtils.isEmpty(inBuilder.negetive)) {

            mBuilder.setNegativeButton(inBuilder.negetive, inBuilder.mNegetiveListener);
        }

        mBuilder.setOnDismissListener(inBuilder.mDismissListener);

        AlertDialog dialog = mBuilder.create();
        dialog.setCanceledOnTouchOutside(inBuilder.canceledOnTouchOutside);
        dialog.show();

        TextView tvTitle =
                (TextView) dialog.findViewById(android.support.v7.appcompat.R.id.alertTitle);
        TextView tvMessage = (TextView) dialog.findViewById(android.R.id.message);
        Button btnNegetive = dialog.getButton(DialogInterface.BUTTON_NEGATIVE);
        Button btnPositive = dialog.getButton(DialogInterface.BUTTON_POSITIVE);

        if (inBuilder.titleColor != 0) {
            tvTitle.setTextColor(inBuilder.titleColor);
        }

        if (inBuilder.titleSize != 0) {
            tvTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, inBuilder.titleSize);
        }

        if (inBuilder.titleTypeface != null) {
            tvTitle.setTypeface(inBuilder.titleTypeface);
        }

        if (inBuilder.msgColor != 0) {
            tvMessage.setTextColor(inBuilder.msgColor);
        }

        if (inBuilder.msgSize != 0) {
            tvMessage.setTextSize(TypedValue.COMPLEX_UNIT_SP, inBuilder.msgSize);
        }

        if (inBuilder.negetiveColor != 0) {
            btnNegetive.setTextColor(inBuilder.negetiveColor);
        }

        if (inBuilder.negetiveTextSize != 0) {
            btnNegetive.setTextSize(TypedValue.COMPLEX_UNIT_SP, inBuilder.negetiveTextSize);
        }

        if (inBuilder.positiveColor != 0) {
            btnPositive.setTextColor(inBuilder.positiveColor);
        }

        if (inBuilder.positiveTextSize != 0) {
            btnPositive.setTextSize(TypedValue.COMPLEX_UNIT_SP, inBuilder.positiveTextSize);
        }
    }

    public static class Builder {

        private Context mContext;
        /**
         * 标题文字
         */
        private String title;
        /**
         * 标题颜色
         */
        private int titleColor;
        /**
         * 标题字号
         */
        private int titleSize;
        /**
         * 样式例如加粗
         */
        private Typeface titleTypeface;

        /**
         * 内容文字
         */
        private String message;
        /**
         * 内容颜色
         */
        private int msgColor;
        /**
         * 内容字号
         */
        private int msgSize;

        /**
         * 确定按钮文字
         */
        private String negetive;
        /**
         * 确定按钮文字颜色
         */
        private int negetiveColor;
        /**
         * 确定按钮文字字号
         */
        private int negetiveTextSize;
        /**
         * 确定按钮点击
         */
        private DialogInterface.OnClickListener mNegetiveListener;

        /**
         * 取消按钮文字
         */
        private String positive;
        /**
         * 取消按钮文字颜色
         */
        private int positiveColor;
        /**
         * 取消按钮文字字号
         */
        private int positiveTextSize;
        /**
         * 取消按钮点击
         */
        private DialogInterface.OnClickListener mPositiveListener;

        /**
         * 是否点击空白区域消失
         */
        private boolean canceledOnTouchOutside;
        /**
         * 返回键是否能关闭对话框
         */
        private boolean cancelable;
        /**
         * 消失监听
         */
        private DialogInterface.OnDismissListener mDismissListener;

        /**
         * 菜单式dialog数据
         */
        private String[] mItems;

        /**
         * menu点击
         */
        private AdapterView.OnItemClickListener mItemClick;

        public Builder(Context context) {
            this.mContext = context;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setTitleColor(int titleColor) {
            this.titleColor = titleColor;
            return this;
        }

        public Builder setTitleSize(int titleSize) {
            this.titleSize = titleSize;
            return this;
        }

        public Builder setTitleTypeface(Typeface titleTypeface) {
            this.titleTypeface = titleTypeface;
            return this;
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder setMsgColor(int msgColor) {
            this.msgColor = msgColor;
            return this;
        }

        public Builder setMsgSize(int msgSize) {
            this.msgSize = msgSize;
            return this;
        }

        public Builder setNegetive(String negetive) {
            this.negetive = negetive;
            return this;
        }

        public Builder setNegetiveColor(int negetiveColor) {
            this.negetiveColor = negetiveColor;
            return this;
        }

        public Builder setNegetiveTextSize(int negetiveTextSize) {
            this.negetiveTextSize = negetiveTextSize;
            return this;
        }

        public Builder setPositive(String positive) {
            this.positive = positive;
            return this;
        }

        public Builder setPositiveColor(int positiveColor) {
            this.positiveColor = positiveColor;
            return this;
        }

        public Builder setPositiveTextSize(int positiveTextSize) {
            this.positiveTextSize = positiveTextSize;
            return this;
        }

        public Builder setNegetiveListener(DialogInterface.OnClickListener negetiveListener) {
            this.mNegetiveListener = negetiveListener;
            return this;
        }

        public Builder setPositiveListener(DialogInterface.OnClickListener positiveListener) {
            this.mPositiveListener = positiveListener;
            return this;
        }

        public Builder setCancelable(boolean cancelable) {
            this.cancelable = cancelable;
            return this;
        }

        public void setCanceledOnTouchOutside(boolean canceledOnTouchOutside) {
            this.canceledOnTouchOutside = canceledOnTouchOutside;
        }

        public void setmItems(String[] items) {
            this.mItems = items;
        }

        public Builder setDismissListener(DialogInterface.OnDismissListener dismissListener) {
            this.mDismissListener = dismissListener;
            return this;
        }

        public void setOnItemClcik(AdapterView.OnItemClickListener itemClick) {
            this.mItemClick = itemClick;
        }

        public void build() {
            new HunterDialog(mContext, this);
        }
    }

    private void initMenuView(Context context, AlertDialog.Builder builder, String[] mItems,
            Builder inBuild) {
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_hunter_menu, null, false);
        ListView listView = ((ListView) view.findViewById(R.id.list_menu_dialog));
        listView.setOnItemClickListener(inBuild.mItemClick);
        ArrayAdapter adapter =
                new ArrayAdapter<CharSequence>(context, R.layout.item_dialog_hunter_menu,
                        R.id.tv_dialog_menu_item, mItems) {
                    @Override
                    public View getView(int position, View convertView, ViewGroup parent) {

                        return super.getView(position, convertView, parent);
                    }
                };
        listView.setAdapter(adapter);
        builder.setView(view);
    }
}