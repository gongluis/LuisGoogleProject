package com.luis.luisgoogleproject.kotlin.activity

import android.app.Activity

/**
 * 快速退出应用方法
 * onCreat的时候调用add
 * onDestroy的时候调用remove
 */
object ActivityCollector { //带object表示单例
    private val activities = ArrayList<Activity>()

    fun addActivity(activity: Activity){
        activities.add(activity)
    }
    fun removeActivity(activity: Activity){
        activities.remove(activity)
    }

    fun finishAll(){
        for (activity in activities) {
            if(!activity.isFinishing){
               activity.finish()
            }
        }
        activities.clear()
    }
}