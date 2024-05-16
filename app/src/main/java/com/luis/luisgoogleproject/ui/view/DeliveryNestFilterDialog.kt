package com.luis.luisgoogleproject.ui.view

import android.content.Context
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import com.luis.luisgoogleproject.R
import com.lxj.xpopup.XPopup
import com.lxj.xpopup.core.BasePopupView
import com.lxj.xpopup.core.BottomPopupView

/**
 * 底部弹窗
 */
class DeliveryNestFilterDialog(context: Context) : BottomPopupView(context), View.OnClickListener {
    private var rgPigState: RadioGroup? =null
    private var rgFilterState: RadioGroup? =null
    private var rgFilterType: RadioGroup? =null
    private var tvReset: TextView? =null
    private var tvConfirm: TextView? =null
    private var onConfirmClickListener: OnConfirmClickListener? = null //该变量有可能为空，因为你不调用set方法ta即为空值，如何判空，在回调的时候继续宁判空
    private var basePopupView: BasePopupView? = null

    override fun getImplLayoutId(): Int {

        return R.layout.delivery_nest_filter_dialog
    }

    override fun onCreate() {
        rgPigState = findViewById(R.id.rg_pig_state)
        rgFilterState = findViewById(R.id.rg_filter_state)
        rgFilterType = findViewById(R.id.rg_filter_type)
        tvReset = findViewById(R.id.tv_reset)
        tvConfirm = findViewById(R.id.tv_confirm)
        initListener()
    }

    private fun initListener() {
        tvReset?.setOnClickListener(this)
        tvConfirm?.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id){
          R.id.tv_reset ->{
              rgPigState!!.clearCheck()
              rgFilterState!!.clearCheck()
              rgFilterType!!.clearCheck ()
          }
          R.id.tv_confirm ->{
              val checkedPigStateId = rgPigState!!.checkedRadioButtonId
              val checkedFilterStateId = rgFilterState!!.checkedRadioButtonId
              val checkedFilterTypeId = rgFilterType!!.checkedRadioButtonId
              var pigStateStr = ""
              var filterStateStr = ""
              var filterTypeStr = ""
              if (checkedPigStateId != -1) {
                  pigStateStr =
                      (findViewById<View>(checkedPigStateId) as RadioButton).text.toString()
              }
              if (checkedFilterStateId != -1) {
                  filterStateStr =
                      (findViewById<View>(checkedFilterStateId) as RadioButton).text.toString()
              }
              if (checkedFilterTypeId != -1) {
                  filterTypeStr =
                      (findViewById<View>(checkedFilterTypeId) as RadioButton).text.toString()
              }
              onConfirmClickListener?.onConfirm(pigStateStr, filterStateStr, filterTypeStr)
              dismiss()
          }
        }
    }

    fun setOnConfirmClickListener(onConfirmClickListener: DeliveryNestFilterDialog.OnConfirmClickListener) {
        this.onConfirmClickListener = onConfirmClickListener
    }

    interface OnConfirmClickListener {
        fun onConfirm(pigStateStr: String, filterStateStr: String, filterTypeStr: String)
    }

    override fun show(): BasePopupView {
        if (basePopupView == null) {
            basePopupView = XPopup.Builder(context).asCustom(this)
        }
        return super.show()
    }
}