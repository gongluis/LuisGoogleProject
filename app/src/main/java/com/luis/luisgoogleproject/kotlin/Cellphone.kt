package com.luis.luisgoogleproject.kotlin

/**
 * 声明data关键字，表明你希望这个类是个数据类，Kotlin会主动根据主构造函数中的参数帮你实现equals hashCode toString等固定且无实际逻辑意义的方法
 * 大大减少开发量
 */
data class Cellphone(val brand:String, val price:Double) {

}