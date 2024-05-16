package com.luis.luisgoogleproject.kotlin.fragment

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.luis.luisgoogleproject.R

class FragmentActivity : AppCompatActivity() {
    companion object{
        fun actionStart(context:Context){
            context.startActivity(Intent(context, FragmentActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        val btn = findViewById<View>(R.id.button)
        btn.setOnClickListener {
            replaceFragment(RightFragment())
            findLeftFragment()
        }
    }

    /**
     * 将右侧的frameLayout 替换成fragment
     * addToBackStack 将一个事务添加到返回栈中，返回会先返回rightFragment再返回activity
     */
    private fun replaceFragment(rightFragment: RightFragment) {
        val fragmentTransaction = supportFragmentManager
        val transaction = fragmentTransaction.beginTransaction()
        transaction.replace(R.id.rightFrag, rightFragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    /**
     * Activity 调用 fragment
     */
    private fun findLeftFragment(){
        val supportFragmentManager = supportFragmentManager
        val leftFragment = supportFragmentManager.findFragmentById(R.id.leftFrag)as LeftFragment
        leftFragment.test()
    }

    public fun test(){
        println("我是 fragmentActivity fragment中的方法")
    }
}