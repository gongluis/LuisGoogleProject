package com.luis.luisgoogleproject.kotlin.widget

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.luis.luisgoogleproject.R

class AlertDialogActivity : AppCompatActivity() {
    companion object{
        fun actionStart(context: Context){
            val intent = Intent(context, AlertDialogActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alert_dialog)
        val alertBtn = findViewById<View>(R.id.alert)
        alertBtn.setOnClickListener{
            AlertDialog.Builder(this).apply {
                setTitle("提示")
                setMessage("some thine important!")
                setCancelable(false)
                setPositiveButton("OK"){
                    dialog, which ->
                }
                setNegativeButton("Cancel"){
                    dialog, which ->
                }
                show()
            }
        }
    }


}