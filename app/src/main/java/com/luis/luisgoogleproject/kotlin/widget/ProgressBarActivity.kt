package com.luis.luisgoogleproject.kotlin.widget

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import com.luis.luisgoogleproject.R

/**
 * progressbar的基本使用
 */
class ProgressBarActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var progressBar:ProgressBar
    companion object{
        fun actionStart(context: Context){
            val intent = Intent(context,ProgressBarActivity::class.java)
            context.startActivity(intent)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progress_bar)
        progressBar = findViewById<View>(R.id.progressbar) as ProgressBar
        val testBnt = findViewById<View>(R.id.test)
        testBnt.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.test ->{
                //每点击一次进度增加10
                progressBar.progress = progressBar.progress+10
            }
        }

    }
}