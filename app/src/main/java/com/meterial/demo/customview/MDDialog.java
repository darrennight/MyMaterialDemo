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
 * Created by zenghao on 16/9/13.
 */
public class MDDialog {

    private AlertDialog.Builder mBuilder;
    public static int style;

    private MDDialog(){}

    private MDDialog(Context context, Builder inBuilder){
        mBuilder = new AlertDialog.Builder(context, R.style.BreadTripAlerDialogStyle);

        initDialogBase(context,inBuilder);
        initMenuView(context,new String[]{"hahah","hhhee","hhhee","hhhee","hhhee","hhhee","hhhee","hhhee","hhhee","hhhee","hhhee","hhhee"},mBuilder,inBuilder);
        initDialogSetting(inBuilder);

//        dialog.hide();
//        dialog.getWindow().getDecorView().setVisibility(View.VISIBLE);


    }


    private void initDialogBase(Context context, Builder inBuilder){
        mBuilder.setCancelable(inBuilder.cancelable);

        if(!TextUtils.isEmpty(inBuilder.title)){
            mBuilder.setTitle(inBuilder.title);
        }

        if(!TextUtils.isEmpty(inBuilder.message)){
            mBuilder.setMessage(inBuilder.message);
        }


//        android.R.id.text1



        if(!TextUtils.isEmpty(inBuilder.positive)){
            mBuilder.setPositiveButton(inBuilder.positive,inBuilder.mPositiveListener);
        }

        if(!TextUtils.isEmpty(inBuilder.negetive)){

            mBuilder.setNegativeButton(inBuilder.negetive,inBuilder.mNegetiveListener);

        }

        mBuilder.setOnDismissListener(inBuilder.mDismissListener);


    }

    private void initDialogSetting(Builder inBuilder){

        AlertDialog dialog = mBuilder.create();
        dialog.show();
        TextView tvTitle = (TextView) dialog.findViewById(android.support.v7.appcompat.R.id.alertTitle);
        TextView tvMessage = (TextView) dialog.findViewById(android.R.id.message);
        Button btnNegetive = dialog.getButton(DialogInterface.BUTTON_NEGATIVE);
        Button btnPositive = dialog.getButton(DialogInterface.BUTTON_POSITIVE);

        if(inBuilder.titleColor != 0){
            tvTitle.setTextColor(inBuilder.titleColor);
        }

        if(inBuilder.titleSize != 0){
            tvTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP,inBuilder.titleSize);
        }

        if(inBuilder.titleTypeface != null){
            tvTitle.setTypeface(inBuilder.titleTypeface);
        }

        if(inBuilder.msgColor != 0){
            tvMessage.setTextColor(inBuilder.msgColor);
        }

        if(inBuilder.msgSize != 0){
            tvMessage.setTextSize(TypedValue.COMPLEX_UNIT_SP,inBuilder.msgSize);
        }

        if(inBuilder.negetiveColor != 0){
            btnNegetive.setTextColor(inBuilder.negetiveColor);
        }

        if(inBuilder.negetiveTextSize != 0){
            btnNegetive.setTextSize(TypedValue.COMPLEX_UNIT_SP,inBuilder.negetiveTextSize);
        }

        if(inBuilder.positiveColor != 0){
            btnPositive.setTextColor(inBuilder.positiveColor);
        }

        if(inBuilder.positiveTextSize != 0){
            btnPositive.setTextSize(TypedValue.COMPLEX_UNIT_SP,inBuilder.positiveTextSize);
        }
    }




  public  static class Builder{

       private Context mContext;

       private String title;
       private int titleColor;
       private int titleSize;
       private Typeface titleTypeface;

       private String message;
       private int msgColor;
       private int msgSize;

       private String negetive;
       private int negetiveColor;
       private int negetiveTextSize;
       private DialogInterface.OnClickListener mNegetiveListener;


       private String positive;
       private int positiveColor;
       private int positiveTextSize;
       private DialogInterface.OnClickListener mPositiveListener;

      /**是否点击空白区域消失*/
      private boolean canceledOnTouchOutside;
      /**返回键是否能关闭对话框*/
      private boolean cancelable;

       private DialogInterface.OnDismissListener mDismissListener;

      private AdapterView.OnItemClickListener onItemClickListener;

       public Builder(Context context){
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

      public Builder setmNegetiveListener(DialogInterface.OnClickListener mNegetiveListener) {
          this.mNegetiveListener = mNegetiveListener;
          return this;
      }

      public Builder setmPositiveListener(DialogInterface.OnClickListener mPositiveListener) {
          this.mPositiveListener = mPositiveListener;
          return this;
      }

      public Builder setCancelable(boolean cancelable) {
          this.cancelable = cancelable;
          return this;
      }

      public Builder setmDismissListener(DialogInterface.OnDismissListener mDismissListener) {
          this.mDismissListener = mDismissListener;
          return this;
      }

      public Builder setCanceledOnTouchOutside(boolean canceledOnTouchOutside) {
          this.canceledOnTouchOutside = canceledOnTouchOutside;
          return this;
      }

      public Builder setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
          this.onItemClickListener = onItemClickListener;
          return this;
      }


      public void build(){
            new MDDialog(mContext,this);
        }

   }


    private void initMenuView(Context context, String [] mItems, AlertDialog.Builder builder,Builder inBuild){
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_list_layout,null,false);
        final ListView listView = ((ListView) view.findViewById(R.id.list_menu_dialog));
        listView.setOnItemClickListener(inBuild.onItemClickListener);
        ArrayAdapter adapter = new ArrayAdapter<CharSequence>( context, R.layout.item_dialog_list, R.id.tv_dialog_menu, mItems){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                return super.getView(position, convertView, parent);
            }
        } ;
        listView.setAdapter(adapter);
        builder.setView(view);
    }



}
