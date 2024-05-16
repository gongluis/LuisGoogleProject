package com.luis.luisgoogleproject.kotlin

//调用的时候无需类名. 直接写方法名即可
fun doSomething(){ //顶层方法 被视为静态方法，被java调用的时候不行，因为java没有顶层方法这个概念
    println("静态方法-真正意义静态方法-顶层方法")
}

object Until{
    fun doAction(){
        println("静态方法-单例")
    }
}

class Until1(){
    fun action1(){
        println("非静态方法")
    }
    companion object{
        fun action2(){
            println("不是静态方法，但是可以使用 类名.方法 的方式调用") //companion object 这个关键字会在Until1内部创建一个伴生类，action2定义在伴生类中的方法，kotlin保证只会生成一个伴生类对象。
        }
    }
}

//注解-真正意义静态方法
class Until2(){
    companion object{
        @JvmStatic     //该主注解只能加在单例或者伴生类内部方法上面
        fun action2(){
            println("注解-真正意义静态方法")
        }
    }
}

