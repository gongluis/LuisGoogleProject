package com.luis.luisgoogleproject.kotlin.chat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.luis.luisgoogleproject.R

/**
 * 聊天消息适配器
 */
class MsgAdapter(val msgList: List<Msg>) : Adapter<ViewHolder>() {
    inner class LeftViewHolder(view: View) : ViewHolder(view){
        val leftMsg: TextView = view.findViewById(R.id.leftMsg)
    }
    inner class RightViewHolder(view: View) : ViewHolder(view){
        val rightMsg: TextView = view.findViewById(R.id.rightMsg)
    }

    override fun getItemViewType(position: Int): Int {
        val msg = msgList[position]
        return msg.type
    }

//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        if(viewType==Msg.TYPE_RECEIVED){
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.msg_left_item, parent, false)
//            return LeftViewHolder(view)
//        }else{
//            val view = LayoutInflater.from(parent.context).inflate(R.layout.msg_right_item, parent, false)
//            return RightViewHolder(view)
//        }
//
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=if (viewType==Msg.TYPE_RECEIVED){
        val view = LayoutInflater.from(parent.context).inflate(R.layout.msg_left_item, parent, false)
        LeftViewHolder(view)
    }else{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.msg_right_item, parent, false)
        RightViewHolder(view)
    }


    override fun getItemCount()=msgList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val msg = msgList[position]
        when (holder){
            is LeftViewHolder -> holder.leftMsg.text = msg.content
            is RightViewHolder -> holder.rightMsg.text = msg.content
            else -> throw IllegalArgumentException()
        }
    }
}