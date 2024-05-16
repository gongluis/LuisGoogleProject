package com.luis.luisgoogleproject.kotlin

/**
 * 没有主构造函数 只有次构造函数
 */
class StudentWithoutMainConstructure:Person  { //未定义主构造函数，继承Person类不需要加括号
    constructor(name:String, age:Int):super(name, age) //没有主构造函数，次构造函数只能直接调用父类的构造函数
}