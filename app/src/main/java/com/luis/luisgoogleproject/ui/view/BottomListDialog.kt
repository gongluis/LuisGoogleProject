package com.luis.luisgoogleproject.ui.view

import android.content.Context
import android.widget.RadioGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.luis.luisgoogleproject.R
import com.lxj.xpopup.core.BottomPopupView
import com.lxj.xpopup.util.XPopupUtils

class BottomListDialog(context: Context) : BottomPopupView(context) {
//    private var rv: RecyclerView? =null
    override fun getImplLayoutId(): Int {
        return R.layout.gestation_dialog;
    }

    override fun getMaxHeight(): Int {
        return XPopupUtils.getScreenHeight(context) * 3 / 5
    }

    override fun onCreate() {
        val rv : RecyclerView = findViewById(R.id.rv)
        rv.layoutManager = LinearLayoutManager(context)
//        rv.adapter =

    }



//    static class SimpleListAdapter: BaseQuickAdapter<SelectItem, BaseViewHolder>{
//
//    }
}