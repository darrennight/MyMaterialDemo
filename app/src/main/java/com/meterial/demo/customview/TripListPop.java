
package com.meterial.demo.customview;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.RelativeLayout.LayoutParams;

import com.meterial.demo.R;

public class TripListPop extends PopupWindow {

	private View mBottomView;
	public TripListPop(Context context){
		super(context);
		mBottomView = View.inflate(context, R.layout.pop_triplist, null);
		this.setWidth(LayoutParams.MATCH_PARENT);  
	    this.setHeight(LayoutParams.WRAP_CONTENT);  
	    this.setContentView(mBottomView);  
	    this.setFocusable(true);  
//	    LinearLayout layout = (LinearLayout) mBottomView.findViewById(R.id.pop_layout);
//	    AnimationUtils.loadAnimation(context, id)
//	    layout.setAnimation(animation);
	    this.setBackgroundDrawable(new BitmapDrawable());
	    this.setAnimationStyle(R.style.AnimBottom);
	}
}
