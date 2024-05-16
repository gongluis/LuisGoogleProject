package com.luis.luisgoogleproject.kotlin

/**
 * 接口：在接口中定义一系列抽象行为，然后由具体的类去实现
 * 接口中的函数不要求有函数体
 */
interface Study {
    fun readBooks()
    fun doHomework(){
        println("do homework default implementation.")
    }
}