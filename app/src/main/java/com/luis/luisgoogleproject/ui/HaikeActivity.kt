package com.luis.luisgoogleproject.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.luis.luisgoogleproject.R
import com.luis.luisgoogleproject.databinding.ActivityHaikeBinding
import com.luis.luisgoogleproject.ui.view.DeliveryNestFilterDialog
import com.luis.luisgoogleproject.ui.view.MyMiniLoadingDialog
import com.luis.luisgoogleproject.utils.KtCommonUtils

class HaikeActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityHaikeBinding //第一步： 注意，Kotlin声明的变量都必须在声明的同时对其进行初始化,而这里我们显然无法在声明全局binding变量的同时对它进行初始化，所以这里又使用了lateinit关键字对binding变量进行了延迟初始化。

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding 第二步：
        binding = ActivityHaikeBinding.inflate(layoutInflater)
        //binding 第三步：
        setContentView(binding.root)
//        var  bottomDialogBtn: TextView = findViewById(R.id.btn_bottom_dialog);//第一种方法直接findViewById
//        var bottomDialogBtn = findViewById<TextView>(R.id.btn_bottom_dialog);//第二种通过泛型findViewById
//        btn_simple_loading_dialog //第三种通过扩展直接不用findViewById 官方已弃用，性能原因 hashmap来存储控件实例缓存，额外的内存消耗，推荐使用viewBinding进行绑定
//        btn_bottom_dialog.setOnClickListener{ //点击事件第一种方法
//        }
        initView()
//        KtCommonUtils.symbol()
        KtCommonUtils.threadUse()
    }

    /**
     * 初始化view相关
     */
    private fun initView() {
        binding.btnBottomDialog.setOnClickListener(this)
        binding.btnSimpleLoadingDialog.setOnClickListener(this)//点击事件第二种方法
        binding.btnCustomView.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_simple_loading_dialog ->{
                val mLoadingDialog = MyMiniLoadingDialog(this)
                mLoadingDialog.show()
                val handler = Handler()
                handler.postDelayed({
                    mLoadingDialog.dismiss()
                },2000)
            }
            R.id.btn_bottom_dialog ->{
                val deliveryNestFilterDialog = DeliveryNestFilterDialog(this)
                deliveryNestFilterDialog.setOnConfirmClickListener(object:DeliveryNestFilterDialog.OnConfirmClickListener{
                    override fun onConfirm(
                        pigStateStr: String,
                        filterStateStr: String,
                        filterTypeStr: String
                    ) {
                        Toast.makeText(this@HaikeActivity,pigStateStr+filterStateStr+filterTypeStr , Toast.LENGTH_SHORT).show()//此处必须加艾特符号
                    }
                })
                deliveryNestFilterDialog.show()
            }
            R.id.btn_bottom_list_dialog ->{

            }
            R.id.btn_custom_view ->{
                startActivity(Intent(this@HaikeActivity, CustomViewActivity::class.java)) //双冒号表示获取类对象的引用
            }
        }
    }

}