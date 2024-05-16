package com.luis.luisgoogleproject.kotlin.customView

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import com.luis.luisgoogleproject.R

class TitleLayout(context:Context,attrs: AttributeSet):LinearLayout(context, attrs) {
    init {
        //在init结构体中进行布局的动态加载
        LayoutInflater.from(context).inflate(R.layout.title, this) //第二个参数表示给加载进来的布局再添加一个父布局
        val back = findViewById<View>(R.id.back)
        back.setOnClickListener{
            val activity = context as Activity
            activity.finish()
        }
        val edit = findViewById<View>(R.id.edit)
        edit.setOnClickListener {
            Toast.makeText(context, "you click edit button", Toast.LENGTH_SHORT).show()
        }
    }

}