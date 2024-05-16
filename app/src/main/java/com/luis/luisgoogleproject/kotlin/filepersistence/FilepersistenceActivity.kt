package com.luis.luisgoogleproject.kotlin.filepersistence

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.luis.luisgoogleproject.R
import java.io.BufferedWriter
import java.io.IOException
import java.io.OutputStreamWriter

/**
 * press back key and save input value to file system
 */
class FilepersistenceActivity : AppCompatActivity(), View.OnClickListener {
    private val TAG = FilepersistenceActivity::class.java.simpleName

    private lateinit var edit:EditText
    private lateinit var spBtn:Button
    private lateinit var spGetBtn:Button
    private lateinit var loginBtn:Button
    companion object{
        fun actionStart(context: Context){
            context.startActivity(Intent(context, FilepersistenceActivity::class.java))
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filepersistence)

        edit = findViewById(R.id.edittext)
        spBtn = findViewById(R.id.button_sp)
        spGetBtn = findViewById(R.id.button_sp_get)
        loginBtn = findViewById(R.id.button_login)

        spBtn.setOnClickListener(this)
        spGetBtn.setOnClickListener(this)
        loginBtn.setOnClickListener(this)

        val inputText = FileUtils.load("data", this@FilepersistenceActivity)
        if(inputText.isNotEmpty()){
            edit.setText(inputText)
            edit.setSelection(inputText.length)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        val inputText = edit.text.toString()
        FileUtils.save(inputText, this@FilepersistenceActivity)
    }

    override fun onClick(view: View) {
        when(view.id){
            R.id.button_sp ->{
                SPUtils.saveString(this@FilepersistenceActivity, "this is sp save string!", "value")
            }
            R.id.button_sp_get ->{
                val value = SPUtils.getString(this@FilepersistenceActivity, "value")
                Log.d(TAG, "onClick: value from sp is :$value")

            }

            R.id.button_login ->{
                LoginActivity.actionStart(this@FilepersistenceActivity)
            }
        }
    }

}