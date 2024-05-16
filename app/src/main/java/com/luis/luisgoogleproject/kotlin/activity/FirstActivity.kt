package com.luis.luisgoogleproject.kotlin.activity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.luis.luisgoogleproject.R
import com.luis.luisgoogleproject.kotlin.broadcastreceiver.BroadCastReceiverActivity
import com.luis.luisgoogleproject.kotlin.chat.ChatActivityActivity
import com.luis.luisgoogleproject.kotlin.filepersistence.FilepersistenceActivity
import com.luis.luisgoogleproject.kotlin.fragment.FragmentActivity
import com.luis.luisgoogleproject.kotlin.jetpack.LiveDataActivity
import com.luis.luisgoogleproject.kotlin.jetpack.ReflectActivity
import com.luis.luisgoogleproject.kotlin.widget.RecyclerViewActivity

class FirstActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        val btn1 = findViewById<View>(R.id.button1)
        //隐式意图启动secondActivity
        btn1.setOnClickListener(this)
        //隐式意图启动系统应用
        val btn2 = findViewById<View>(R.id.button2)
        btn2.setOnClickListener(this)
        val btn3 =findViewById<View>(R.id.button3)
        btn3.setOnClickListener(this)
        val btn4 =findViewById<View>(R.id.button4)
        btn4.setOnClickListener(this)
        val btn5= findViewById<View>(R.id.button5)
        btn5.setOnClickListener (this)
        val btn6= findViewById<View>(R.id.button6)
        btn6.setOnClickListener(this)
        val btn7 = findViewById<View>(R.id.button7)
        btn7.setOnClickListener(this)
        val btn8 = findViewById<View>(R.id.button8)
        btn8.setOnClickListener(this)
        val btn9 = findViewById<View>(R.id.button9)
        btn9.setOnClickListener (this)
        val btn10 = findViewById<View>(R.id.button10)
        btn10.setOnClickListener (this)
        val btn11 = findViewById<View>(R.id.button11)
        btn11.setOnClickListener (this)
        val btn12 = findViewById<View>(R.id.button12)
        btn12.setOnClickListener (this)
        val btn13 = findViewById<View>(R.id.button13)
        btn13.setOnClickListener (this)
    }

    /**
     * 定义actionbar右上角的三个点 隐藏式菜单
     */
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    /**
     * 隐藏式菜单点击事件
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.add_item ->
            Toast.makeText(this, "you clicked add",Toast.LENGTH_SHORT).show()
            R.id.remove_item ->
            Toast.makeText(this, "you clicked remove",Toast.LENGTH_SHORT).show()
        }
        return true
    }

    /**
     * 接收启动的activity销毁时返回值
     */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            1 -> if (resultCode== RESULT_OK){
                val resultStr = data?.getStringExtra("second")
                Log.d("Tag","上个页面返回的结果：$resultStr")
            }
        }
    }

    /**
     * 点击事件
     */
    override fun onClick(view: View?) {
        when(view?.id){
            R.id.button1 ->{
                val intent = Intent("com.luis.ACTION_START").apply {
                    addCategory("com.luis.myCateLog")
                }
                startActivity(intent)
            }
            R.id.button2 ->{
                val webIntent = Intent(Intent.ACTION_VIEW).apply {
                    data = Uri.parse("https://www.baidu.com")
                }
                startActivity(webIntent)
            }
            R.id.button3 ->{
                val btn3Intent = Intent(this, SecondActivity::class.java).apply {
                    putExtra("btn_3", "btn_3")
                }
                startActivity(btn3Intent)
            }
            R.id.button4 ->{
                val btn3Intent = Intent(this, SecondActivity::class.java).apply {
                    putExtra("btn_3", "btn_3")
                }
                startActivityForResult(btn3Intent, 1)
            }
            R.id.button5 ->{
                startActivity(Intent(this, DialogActivity::class.java))
            }
            R.id.button6 ->{
                startActivity(Intent(this, NormalActivity::class.java))
            }
            R.id.button7 -> {
//                ProgressBarActivity.actionStart(this@FirstActivity)
//                AlertDialogActivity.actionStart(this@FirstActivity)
//                CustomViewActivity.actionStart(this@FirstActivity)
                RecyclerViewActivity.actionStart(this@FirstActivity)
//                ChatActivityActivity.actionStart(this@FirstActivity)
            }
            R.id.button8 -> {
                ChatActivityActivity.actionStart(this@FirstActivity)
            }
            R.id.button9 -> {
                FragmentActivity.actionStart(this@FirstActivity)
            }
            R.id.button10 -> {
                BroadCastReceiverActivity.actionStart(this@FirstActivity)
            }
            R.id.button11 -> {
                FilepersistenceActivity.actionStart(this@FirstActivity)
            }
            R.id.button12 -> {
                LiveDataActivity.actionStart(this@FirstActivity)
            }
            R.id.button13 -> {
                ReflectActivity.actionStart(this@FirstActivity)
            }
        }

    }
}