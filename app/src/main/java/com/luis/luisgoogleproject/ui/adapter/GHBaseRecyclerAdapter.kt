package com.luis.luisgoogleproject.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView.Adapter

/**
 * Rv 基类适配器
 */
abstract class GHBaseRecyclerAdapter<T> (val context: Context, val resource : Int, val list : List<T>) : Adapter<GHBaseViewHolder>() {
    //(context: Context, resource : Int, list : List<T>)未主构造函数，没有函数体，主构造函数中的逻辑写在init结构体中
    //父类Adapter后面的括号代表调用父类的无参构造，父类如果没有无参构造，子类要在括号中传入相应的参数不然会报错

    private val TYPE_HEADER = 0
    private val TYPE_NORMAL = 1
    private val TYPE_EMPTY = 2
    private var mHeaderView: View? = null
    private var mEmptyView: View? = null
    init {
        //构造函数中的逻辑写在这里
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GHBaseViewHolder {
        if(viewType==TYPE_HEADER){
            return GHBaseViewHolder(mHeaderView!!)
        }else if(viewType==TYPE_EMPTY){
            return GHBaseViewHolder(mEmptyView!!)
        }else{
            return GHBaseViewHolder(LayoutInflater.from(context).inflate(resource, parent, false))
        }
    }

    override fun getItemCount(): Int {
        var itemCount = list.size
        if (null != mEmptyView && itemCount == 0) {
            itemCount++
        }
        if (null != mHeaderView) {
            itemCount++
        }
        return list.size
    }

    override fun onBindViewHolder(holder: GHBaseViewHolder, position: Int) {
        val type = getItemViewType(position)
        if (type == TYPE_HEADER|| type == TYPE_EMPTY) {
            return
        }

        if (mHeaderView != null) {
            setConvert(holder, list[position - 1])
        } else {
            setConvert(holder, list[position])
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (null != mHeaderView && position == 0) {
            return TYPE_HEADER
        }
        return if (null != mEmptyView && list.isEmpty()) {
            TYPE_EMPTY
        } else TYPE_NORMAL
    }

    /**
     * 设置头布局
     */
    open fun setHeaderView(headerView: View) {
        mHeaderView = headerView
        val sp_params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT
        )
        mHeaderView!!.layoutParams = sp_params
        notifyItemInserted(0)
    }

    /**
     * 设置空view
     */
    open fun setEmptyView(view: View) {
        mEmptyView = view
        val sp_params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT
        )
        mEmptyView!!.setLayoutParams(sp_params)
        notifyDataSetChanged()
    }
    /**
     * @param @param viewHolder
     * @param @param t 设定文件
     * @return void 返回类型
     * @Title: setConvert
     * @Description: 抽象方法，由子类去实现每个itme如何设置
     */
    abstract fun setConvert(viewHolder: GHBaseViewHolder?, t: T)
}