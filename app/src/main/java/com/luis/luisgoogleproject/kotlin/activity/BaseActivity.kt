package com.luis.luisgoogleproject.kotlin.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity :AppCompatActivity(){ //添加open 表示可以被继承

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("BaseActivity", javaClass.simpleName) //获取当前java实例
    }


}