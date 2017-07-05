package com.meterial.demo.commonActivity.blur;
 
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.meterial.demo.R;

/** 
 * Created by mmin18 on 9/21/16. 
 */ 
public class MyListAdapter extends BaseAdapter {
 
	View[] cells;
 
	public MyListAdapter(Context ctx) {
		super(); 
 
		int[] imgs = {
				R.drawable.p0, R.drawable.p1, R.drawable.p2, R.drawable.p3, R.drawable.p4,
				R.drawable.p5, R.drawable.p6, R.drawable.p7, R.drawable.p8, R.drawable.p9
		}; 
		LayoutInflater inflater = LayoutInflater.from(ctx);
		cells = new View[imgs.length];
		for (int i = 0; i < imgs.length; i++) {
			ImageView iv = ((ImageView) inflater.inflate(R.layout.item_list_blur, null));
			iv.setImageResource(imgs[i]);
			cells[i] = iv;
		} 
 
	} 
 
	@Override 
	public int getCount() { 
		return cells.length;
	} 
 
	@Override 
	public Object getItem(int position) {
		return position;
	} 
 
	@Override 
	public long getItemId(int position) {
		return position;
	} 
 
	@Override 
	public View getView(int position, View convertView, ViewGroup parent) {
		return cells[position];
	} 
} 