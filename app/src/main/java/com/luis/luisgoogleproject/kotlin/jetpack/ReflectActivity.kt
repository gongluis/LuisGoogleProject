package com.luis.luisgoogleproject.kotlin.jetpack

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.luis.luisgoogleproject.R

class ReflectActivity : AppCompatActivity() {
    companion object{
        fun actionStart(context: Context){
            context.startActivity(Intent(context, ReflectActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reflect)
        var person = PersonForReflect("小明")
        Log.e("TAG", "onCreate: "+person.name )
        findViewById<View>(R.id.reflectChangeName).setOnClickListener {
            handleReflect(person)
            Log.e("TAG", "after: "+person.name)
        }
    }

    private fun handleReflect(personForReflect:PersonForReflect){
        val clazz = personForReflect.javaClass
        val field = clazz.getDeclaredField("name")
        field.isAccessible = true
        val instance = clazz.newInstance()
        field.set(instance, "巩贺")
    }


}