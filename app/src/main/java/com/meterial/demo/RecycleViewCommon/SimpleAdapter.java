package com.meterial.demo.RecycleViewCommon;

import android.content.Context;

import java.util.List;

/**
 * Created by zenghao on 16/8/1.
 * 参考资料
 * https://github.com/hongyangAndroid/baseAdapter
 */
public class SimpleAdapter extends MultiItemTypeAdapter<ChatMessage> {

    public SimpleAdapter(Context context, List<ChatMessage> datas) {
        super(context, datas);
        //new MsgComingItemDelagate();
        //添加item－－item 类型
        addItemViewDelegate(new MsgSendItemDelagate());
        addItemViewDelegate(new MsgComingItemDelagate());
    }

    @Override
    protected boolean isEnableItemClick(int viewType) {
        //设置item点击
        return super.isEnableItemClick(viewType);
    }
}
