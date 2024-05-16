package com.luis.luisgoogleproject.kotlin

/**
 * kotlin 中类默认不可被继承，加了open符号和主构造函数 表示可继承
 */
open class Person(val name:String, val age:Int) {
//    var name = ""   //之所以采用var是因为要创建对象后再指定姓名和年龄
//    var age = 0
    fun eat(){
        println(name+"is eating he is "+age+"years old.")
    }
}