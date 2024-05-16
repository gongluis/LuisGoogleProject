package com.luis.luisgoogleproject.kotlin.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.luis.luisgoogleproject.R

class SecondActivity : AppCompatActivity() {
    companion object{ //类似于java的静态方法
        fun actionStart(context: Context, data1:String, data2:String){//启动activity的最佳写法
            val intent =Intent();
            intent.putExtra("data1", data1)
            intent.putExtra("data2", data2)
            context.startActivity(intent)
        }

        /**
         * 使用apply函数来简化代码
         */
        fun actionStartGood(context: Context, data1:String, data2:String){//启动activity的最佳写法
            val intent =Intent().apply {
                putExtra("data1", data1)
                putExtra("data2", data2)
            }
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        //显示意图获取传递过来的数据
        val dataFromFirst = intent.getStringExtra("btn_3")
        Log.d("SecondActivity", dataFromFirst?:"空")

        initView()
    }

    private fun initView() {
        val btn1 = findViewById<View>(R.id.btn1)
        btn1.setOnClickListener {
            dealWithDestroyData()
        }
    }

    override fun onBackPressed() {
        dealWithDestroyData()
        finish()
    }

    private fun dealWithDestroyData(){
        val resultIntent = Intent()
        resultIntent.putExtra("second","from second activity")
        setResult(RESULT_OK, resultIntent)
        finish()
    }


}