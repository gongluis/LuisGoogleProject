package com.luis.luisgoogleproject.kotlin.chat

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.luis.luisgoogleproject.R

class ChatActivityActivity : AppCompatActivity(), View.OnClickListener {
    private val msgList = ArrayList<Msg>()
//    private var adapter: MsgAdapter?=null
    private lateinit var adapter: MsgAdapter  //使用延迟初始化替代上面的写法，避免后面引用该变量还需要做空判断  引用时也可以做是否初始化的判断 if(!::adapter.isInitialized){adapter=MsgAdapter(msgList)}
    private lateinit var inputText: EditText
    private lateinit var rv: RecyclerView

    companion object{
        fun actionStart(context: Context){
            val intent = Intent(context, ChatActivityActivity::class.java)
            context.startActivity(intent)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_activity)
        initMsg()
        val layoutManager = LinearLayoutManager(this)
        rv = findViewById<View>(R.id.recycleView) as RecyclerView
        rv.layoutManager = layoutManager
        adapter = MsgAdapter(msgList)
        rv.adapter = adapter

        val send = findViewById<View>(R.id.send)
        send.setOnClickListener(this)
        inputText = findViewById<View>(R.id.inputText) as EditText
    }

    private fun initMsg() {
        val msg1 = Msg("Hello guy.", Msg.TYPE_RECEIVED)
        msgList.add(msg1)
        val msg2 = Msg("Hello who is that?", Msg.TYPE_SENT)
        msgList.add(msg2)
        val msg3 = Msg("this is Tom, Nice talking to you.", Msg.TYPE_RECEIVED)
        msgList.add(msg3)

    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.send ->{
                val content = inputText.text.toString()
                if(content.isNotEmpty()){
                    val msg = Msg(content, Msg.TYPE_SENT)
                    msgList.add(msg)
                    adapter.notifyItemInserted(msgList.size-1)//当有新消息时刷新recycleView中的显示
                    rv.scrollToPosition(msgList.size-1)//将recyclerView定位到最后一行
                    inputText.setText("") //清空输入框内容

                }
            }
        }

    }
}