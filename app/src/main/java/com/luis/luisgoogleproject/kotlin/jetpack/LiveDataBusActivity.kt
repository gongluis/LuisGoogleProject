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
 * LiveDataBus 工具类的使用
 */
class LiveDataBusActivity : AppCompatActivity() {
    companion object{
        fun actionStart(context: Context){
            context.startActivity(Intent(context, LiveDataBusActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data_bus)

        val sendBtn = findViewById<View>(R.id.send_btn)
        sendBtn.setOnClickListener {
            LiveDataBus.getInstance().with("LiveDataBusActivity").value = "我是新数据"
        }
        val nextBtn = findViewById<View>(R.id.nextBtn)
        nextBtn.setOnClickListener {
            LiveDataBus2Activity.actionStart(this)
        }
        val sendToNextBtn = findViewById<View>(R.id.sendToNext)
        sendToNextBtn.setOnClickListener {
            //此处触发 数据粘性问题，第二个页面还没创建呢，发消息过去，待第二个页面创建后居然还能收到，解决方法？
            //原因： 正常流程：创建LiveData->设置观察者->发送数据   异常流程：创建LiveData->发送数据->设置观察者   看源码可知，流程发生改变后，version和 lastVersion 会导致事件分发时无法return，触发onchange
            LiveDataBus.getInstance().with("LiveDataBus2Activity", String::class.java).value = "来自上个页面"
        }

        LiveDataBus.getInstance().with("LiveDataBusActivity", String::class.java).observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        LiveDataBus.getInstance().remove("LiveDataBusActivity")
    }
}