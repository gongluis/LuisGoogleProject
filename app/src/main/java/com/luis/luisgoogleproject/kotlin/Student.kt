package com.luis.luisgoogleproject.kotlin

class Student(val sno:String,val grade:Int, name:String, age:Int) :Person(name, age),Study{ //主构造函数表示对该类进行实例化的时候，必须传入构造函数中要求的所有参数
                                                                    //此处表示继承父类的两个参数的构造函数，需要传入name和age,只有在自身的构造函数中添加这两个参数，但是不能添加val 或者var,会自动成为该类的字段与父类冲突
    init {
        println("sno is $sno grade is $grade")
    }

    //次构造函数 必须调用主构造函数才合法
    constructor(name:String, age:Int):this("",0,name, age){//通过this关键字调用主构造函数，并将sno和grade两个参数赋值成初始值

    }

    //次构造函数
    constructor():this("", 0){ //该次构造函数不接收任何参数，通过this关键字调用刚才定义的第一个次构造函数，并将name和age参数也赋值成初始值

    }

    override fun readBooks() {
        println(name+"is reading")
    }

    override fun doHomework() {
        println(name+"is doing homework")
    }
}