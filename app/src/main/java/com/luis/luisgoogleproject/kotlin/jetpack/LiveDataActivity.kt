package com.luis.luisgoogleproject.kotlin.jetpack

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.luis.luisgoogleproject.R
import com.luis.luisgoogleproject.kotlin.filepersistence.FilepersistenceActivity

/**
 * liveData
 *      保存数据
 *      观察持有者
 *      对持有者的生命周期感知能力  ：如何做到的？ liveData.observe(this)中将当前activity传入，livecycler传进去
 * 与handler区别，handler主要作用不是用来传值的，事件分发，用来管理安卓,activityThread中的基本都是围绕handler来的，心跳机制
 */
class LiveDataActivity : AppCompatActivity() {
    private lateinit var liveData:MutableLiveData<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data2)

        val tv = findViewById<TextView>(R.id.tv)
        val setValueBtn = findViewById<View>(R.id.setValue)
        val setValueInThreadBtn = findViewById<View>(R.id.setValueInThread)
        val startNewActivityBtn = findViewById<View>(R.id.startNewActivity)

        liveData =MutableLiveData<String>()

        liveData.observe(this, Observer {
            //这里不会一收到数据就执行，必须还要满足 持有者（当前activity处于可见状态）才会执行，中间的时间，数据存储与liveData中
            tv.text = it
        })
        setValueBtn.setOnClickListener {
            liveData.value = "我是数据，我变了"
        }

        setValueInThreadBtn.setOnClickListener {
            //此处睡眠5s后发送数据，在未发送前切换至其它页面，当前页面不可见，这个时候收到消息也不会执行观察者中的方法，会在你回到当前页面的时候执行
           Thread(Runnable {
               try {
                    Thread.sleep(5*1000)
               }catch (e:InterruptedException){
                    e.printStackTrace()
               }
               liveData.postValue("我是子线程更新的数据，持有者生命周期可见的时候再接收我")
           }).start()

        }

        startNewActivityBtn.setOnClickListener{
            FilepersistenceActivity.actionStart(this@LiveDataActivity)
        }


        val startBusActivity = findViewById<View>(R.id.startBusActivity)
        startBusActivity.setOnClickListener {
            LiveDataBusActivity.actionStart(this)
        }
    }

    companion object{
        fun actionStart(context: Context){
            context.startActivity(Intent(context, LiveDataActivity::class.java))
        }
    }

}