package com.meterial.demo.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.meterial.demo.R;
import com.meterial.demo.calendar.MonthView;
import com.meterial.demo.calendar.MonthViewGrid;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author zenghao
 * @since 2017/7/12 上午10:45
 */
public class MyCalendarThumbGrid extends AppCompatActivity {

    private MonthViewGrid mGrid;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_thumb_grid);
        mGrid = ((MonthViewGrid) findViewById(R.id.mvg_mothon));

        List<String> list = new ArrayList<String>();
        for (int i=0;i<42;i++){
            list.add(i+"");
        }

        mGrid.setAdapter(new MyAdapter(this,list));
    }



    class MyAdapter extends BaseAdapter{

        private Context mContext;
        private List<String> mList;
        public MyAdapter(Context context,List<String> list){
            this.mContext = context;
            this.mList = list;
        }
        @Override
        public int getCount() {
            return mList.size();
        }

        @Override
        public Object getItem(int position) {
            return mList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if(convertView == null){
                convertView = LayoutInflater.from(mContext).inflate(R.layout.item_month_day,parent,false);
                holder = new ViewHolder();
                holder.day = ((TextView) convertView.findViewById(R.id.tv_day));
                convertView.setTag(holder);
            }else{
                holder = ((ViewHolder) convertView.getTag());
            }

            String txt = mList.get(position);
            int temp = Integer.parseInt(txt);

            holder.day.setText(txt);

            if(temp == 0){
                holder.day.setBackgroundResource(R.drawable.month_left_bg);
            }else if(temp == 1){
                holder.day.setBackgroundResource(R.drawable.month_mid_bg);
            }else if(temp == 2){
                holder.day.setBackgroundResource(R.drawable.month_right_bg);
            }

            return convertView;
        }

        class ViewHolder{
            TextView day;
        }
    }
}
