package com.luis.luisgoogleproject.ui

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.text.TextUtils
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.jcodecraeer.xrecyclerview.XRecyclerView
import com.jcodecraeer.xrecyclerview.XRecyclerView.LoadingListener
import com.luis.luisgoogleproject.R
import com.luis.luisgoogleproject.databinding.ActivityCustomViewBinding
import com.luis.luisgoogleproject.ui.adapter.GHBaseRecyclerAdapter
import com.luis.luisgoogleproject.ui.adapter.GHBaseViewHolder
import com.xuexiang.xui.utils.DensityUtils
import java.util.*
import kotlin.collections.ArrayList

/**
 * 自定义View
 */
class CustomViewActivity : AppCompatActivity() {
    private lateinit var binding : ActivityCustomViewBinding
    private var numClickCount:Int = 0
    private var ascNum:Boolean? = null
    private var dataArrayList:ArrayList<String>? = null
    private lateinit var landingPigletsRecycler: XRecyclerView
    private  var testAdapter: TestAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        val titleMenu = binding.ddmContent
        val inflate = View.inflate(this@CustomViewActivity, R.layout.layout_si_wei_batch_show, null)
        //init rv
        landingPigletsRecycler = inflate.findViewById<XRecyclerView>(R.id.rv_fat_pig_detail)
        landingPigletsRecycler.layoutManager = LinearLayoutManager(this)
        landingPigletsRecycler.setPullRefreshEnabled(true)
        landingPigletsRecycler.setLoadingListener(object : LoadingListener{
            override fun onRefresh() {
                val handler = Handler()
                handler.postDelayed(Runnable {
                    repeat(8){
                        dataArrayList!!.add("新增数据，$it")
                    }
                    testAdapter!!.notifyDataSetChanged()
                    landingPigletsRecycler.refreshComplete()
                },500)
            }

            override fun onLoadMore() {

            }

        })
        dataArrayList = arrayListOf<String>("条目1", "条目2", "条目3", "条目4", "条目1", "条目1")
        testAdapter = TestAdapter(this, R.layout.rv_item_test, dataArrayList!!)
        val headView = View.inflate(this@CustomViewActivity, R.layout.rv_header, null)
        testAdapter!!.setHeaderView(headView)
        landingPigletsRecycler.adapter = testAdapter
        //init title menu
        titleMenu.setDropDownMenu(inflate, getStartDateView(), null, getFilterTopView())
    }

    class TestAdapter(context: Context,  resource : Int,  list : List<String>) :GHBaseRecyclerAdapter<String>(context, resource, list){
        override fun setConvert(viewHolder: GHBaseViewHolder?, t: String) {
            viewHolder!!.setTextView(R.id.tv_test,t)
        }
    }


    /**
     * 用于自定义标题栏-返回一个筛选的view
     */
    private fun getFilterTopView(): List<View>? {
        val linearLayout = LinearLayout(this)
        linearLayout.layoutParams =
            LinearLayout.LayoutParams(0, DensityUtils.dp2px(this, 40f), 1.0f)
        linearLayout.gravity = Gravity.CENTER
        val weightTab = TextView(this)
        weightTab.setSingleLine()
        weightTab.ellipsize = TextUtils.TruncateAt.END
        weightTab.setTextSize(
            TypedValue.COMPLEX_UNIT_PX,
            DensityUtils.dp2px(this, 14f) .toFloat()
        )
        weightTab.setTextColor(ContextCompat.getColor(this, R.color.c_33))
        weightTab.setCompoundDrawablesRelativeWithIntrinsicBounds(
            null,
            null,
            ContextCompat.getDrawable(this, R.mipmap.item_child_filter),
            null
        )
        weightTab.compoundDrawablePadding = DensityUtils.dp2px(this, 7f)
        weightTab.text = "筛选"
        linearLayout.addView(weightTab)
        linearLayout.setOnClickListener { v: View? ->
            //点击类型
//            deliveryNestFilterDialog.show()
            Toast.makeText(this,"筛选", Toast.LENGTH_SHORT).show()
        }
        return Arrays.asList<View>(linearLayout)
    }

    /**
     * 用于自定义标题栏-返回一个开始时间的view
     */
    private fun getStartDateView(): List<View>? {
        val linearLayout = LinearLayout(this)
        linearLayout.layoutParams =
            LinearLayout.LayoutParams(0, DensityUtils.dp2px(this, 40f), 1.0f)
        linearLayout.gravity = Gravity.CENTER
        val numTab = TextView(this)
        numTab.setSingleLine()
        numTab.ellipsize = TextUtils.TruncateAt.END
        numTab.setTextSize(
            TypedValue.COMPLEX_UNIT_PX,
            DensityUtils.dp2px(this, 14f) .toFloat()
        )
        numTab.setTextColor(ContextCompat.getColor(this, R.color.c_33))
        numTab.setCompoundDrawablesRelativeWithIntrinsicBounds(
            null,
            null,
            ContextCompat.getDrawable(this, R.mipmap.icon_sort_default),
            null
        )
        numTab.compoundDrawablePadding = DensityUtils.dp2px(this, 7f)
        numTab.text = "开始日期"
        linearLayout.addView(numTab)
        linearLayout.setOnClickListener { v: View? ->
            numClickCount++
            if (numClickCount == 3) {
                numClickCount = 0
            }
            if (numClickCount == 0) {
                numTab.setCompoundDrawablesRelativeWithIntrinsicBounds(
                    null,
                    null,
                    ContextCompat.getDrawable(
                        this,
                        R.mipmap.icon_sort_default
                    ),
                    null
                )
                ascNum = null
            } else if (numClickCount == 1) {
                numTab.setCompoundDrawablesRelativeWithIntrinsicBounds(
                    null,
                    null,
                    ContextCompat.getDrawable(this, R.mipmap.icon_sort_top),
                    null
                )
                ascNum = true
            } else if (numClickCount == 2) {
                numTab.setCompoundDrawablesRelativeWithIntrinsicBounds(
                    null,
                    null,
                    ContextCompat.getDrawable(this, R.mipmap.icon_sort_bottom),
                    null
                )
                ascNum = false
            }
//            pageNum = 1
//            binding.etKeyword.setText("")
//            getDataList()
        }
        return Arrays.asList<View>(linearLayout)
    }
}