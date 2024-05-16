package com.luis.luisgoogleproject.ui.adapter

import android.util.SparseArray
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class GHBaseViewHolder(itemView : View) : ViewHolder(itemView) {
    private var mViews : SparseArray<View>? = null
    init {
        mViews = SparseArray<View>()
        println("viewHold基类 构造函数 $mViews")
    }
    /**
     * @param viewId 控件id
     * @return 根据控件id获取到控件
     */
    fun <T : View?> getView(viewId: Int): T {
       var  view = mViews!!.get(viewId)
        if (view == null) {
            view = itemView!!.findViewById<View>(viewId)
            mViews!!.put(viewId, view)
        }
        return view as T
    }

    /**
     * @return 设置textview相关
     */
    fun setTextView(viewId: Int, content: String?): GHBaseViewHolder? {
        val tv = getView<TextView>(viewId)
        tv.text = content
        return this
    }
}