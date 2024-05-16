package com.luis.luisgoogleproject.kotlin.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.luis.luisgoogleproject.R


/**
 */
class LeftFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_left, container, false)
    }

    fun getParentActivity(){
        if(activity!=null){
            val fragmentActivity = activity as FragmentActivity
            fragmentActivity.test()
        }
    }

    public fun test(){
        println("我是 left fragment中的方法")
        getParentActivity()
    }
}