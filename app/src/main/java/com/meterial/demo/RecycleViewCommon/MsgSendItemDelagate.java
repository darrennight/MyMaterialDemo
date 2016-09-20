package com.meterial.demo.RecycleViewCommon;

import android.content.Context;

import com.meterial.demo.R;

/***
 * 不同的item写不同的ItemViewDelegate
 */
public class MsgSendItemDelagate implements ItemViewDelegate<ChatMessage>
{

    @Override
    public int getItemViewLayoutId()
    {
        return R.layout.main_chat_send_msg;//item布局
    }

    @Override
    public boolean isForViewType(ChatMessage item, int position)
    {
        return !item.isComMeg();//是否是自己的这种类型
    }

    @Override
    public void convert(Context context, RVCommonViewHolder holder, ChatMessage chatMessage, int position)
    {
        holder.setText(R.id.chat_send_content, chatMessage.getContent());
        holder.setText(R.id.chat_send_name, chatMessage.getName());
        holder.setImageResource(R.id.chat_send_icon, R.mipmap.ic_launcher);
    }
}