package com.luis.luisgoogleproject.kotlin.customView

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.luis.luisgoogleproject.R

class CustomViewActivity : AppCompatActivity() {
    companion object{
        fun actionStart(context: Context){
            val intent = Intent(context, CustomViewActivity::class.java)
            context.startActivity(intent)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_view2)
        supportActionBar?.hide() //取消自带的标题栏

    }
}