package com.luis.luisgoogleproject.ui.view

import android.content.Context
import android.text.TextUtils
import android.view.View
import android.widget.TextView
import com.luis.luisgoogleproject.R
import com.xuexiang.xui.widget.dialog.BaseDialog
import com.xuexiang.xui.widget.progress.loading.IMessageLoader
import com.xuexiang.xui.widget.progress.loading.LoadingCancelListener
import com.xuexiang.xui.widget.progress.loading.MiniLoadingView

class MyMiniLoadingDialog : BaseDialog, IMessageLoader {
    private var mLoadingView: MiniLoadingView? =null
    private var mTvTipMessage: TextView? =null
    private var mLoadingCancelListener: LoadingCancelListener? = null

    constructor(context: Context) : super(context,R.style.XUIDialog_Custom_MiniLoading, R.layout.my_dialog_loading_mini) {//此处为调用父类的构造方法
        initView(getString(R.string.xui_tip_loading_message))
    }

    constructor(context: Context, tipMessage : String) : super(context,R.style.XUIDialog_Custom_MiniLoading, R.layout.my_dialog_loading_mini){//自定义消息构造
        initView(tipMessage)
    }

    constructor(context: Context, themeResId : Int) : super(context, themeResId, R.layout.my_dialog_loading_mini){
        initView(getString(R.string.xui_tip_loading_message))
    }

    constructor(context: Context, themeResId : Int, tipMessage : String) : super(context, themeResId, R.layout.my_dialog_loading_mini){
        initView(tipMessage)
    }

    private fun initView(tipMessage: String?) {
        mLoadingView = findViewById(R.id.mini_loading_view)
        mTvTipMessage = findViewById(R.id.tv_tip_message)

        updateMessage(tipMessage)

        setCancelable(false)
        setCanceledOnTouchOutside(false)
    }

    /**
     * 更新提示信息
     *
     * @param tipMessage 提示信息
     */
    override fun updateMessage(tipMessage: String?) {
        if (mTvTipMessage != null) {
            if (!TextUtils.isEmpty(tipMessage)) {
                mTvTipMessage!!.setText(tipMessage)  //使用 !!.如果数据为空则返回空指针异常
                mTvTipMessage!!.visibility = View.VISIBLE
            } else {
                mTvTipMessage!!.text = ""
                mTvTipMessage!!.visibility = View.GONE
            }
        }
    }
    /**
     * 更新提示信息
     *
     * @param tipMessageId 提示信息的id
     */
    override fun updateMessage(tipMessageId: Int) {
        updateMessage(getString(tipMessageId))
    }

    override fun performShow() {
        super.performShow()
        if (mLoadingView != null) {
            mLoadingView!!.start()
        }
    }

    /**
     * 隐藏加载
     */
    override fun dismiss() {
        if (mLoadingView != null) {
            mLoadingView!!.stop()
        }
        super.dismiss()
    }

    override fun recycle() {
        TODO("Not yet implemented")
    }

    override fun isLoading(): Boolean {
        return isShowing
    }

    /**
     * 设置是否可取消
     *
     * @param flag
     */
    override fun setCancelable(flag: Boolean) {
        super.setCancelable(flag)
        if (flag) {
            setOnCancelListener {
                if (mLoadingCancelListener != null) {
                    mLoadingCancelListener!!.onCancelLoading()
                }
            }
        }
    }
    override fun setLoadingCancelListener(listener: LoadingCancelListener?) {
        mLoadingCancelListener = listener
    }
}