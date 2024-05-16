package com.luis.luisgoogleproject.kotlin.chat

class Msg(val content: String, val type:Int) {
    companion object{
        const val TYPE_RECEIVED = 0  //常量，只有在单例类，companion object 或顶层方法中才可以使用const关键字
        const val TYPE_SENT = 1
    }
}