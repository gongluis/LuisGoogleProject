package com.luis.luisgoogleproject.kotlin.jetpack

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import com.luis.luisgoogleproject.R

/**
 * 从  上一个页面（LiveDataBusActivity）传数据到该页面
 */
class LiveDataBus2Activity : AppCompatActivity() {
    companion object{
        fun actionStart(context: Context){
            context.startActivity(Intent(context, LiveDataBus2Activity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data_bus2)
        findViewById<View>(R.id.sendMsg1).setOnClickListener {
            LiveDataBus.getInstance().with("LiveDataBusActivity").value = "我来自 LiveDataBus2Activity "
        }

        LiveDataBus.getInstance().with("LiveDataBus2Activity", String::class.java).observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })

    }

    override fun onDestroy() {
        super.onDestroy()
        LiveDataBus.getInstance().remove("LiveDataBus2Activity")
    }
}