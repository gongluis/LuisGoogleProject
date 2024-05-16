package com.luis.luisgoogleproject.kotlin

fun main() {
    //let函数
    val str:String? = "Hello"
    val tim:String? = "Hello Tim"
        //a.避免空指针异常
        str?.let {//当str不为空的时执行以下代码
            println(it.length)
        }
        //b.对象转换
        val upStr=str?.let {
            it.toUpperCase()
        }
        println(upStr)
        //c.调用链
        val length = str?.let {
            it.toUpperCase()
        }.let {
            it+"mike"
        }.let {
            it.length
        }
        println("长度：$length")
        //d.多个变量操作
         str?.let {strValue ->
             tim?.let {str1Value ->{
                 println("tim:$str1Value")
                     val max = if(strValue>str1Value)strValue else str1Value
                    println("较大的数据是：$max")
                }
             }
         }

    //with函数
        //接收两个参数，第一个参数任意类型对象，第二个参数是一个lambda表达式，with函数会在lambada表达式中提供第一个参数的上下文，并用lambada表达式最后一行作为返回值
        //例子，想吃完所有的水果
        val list = listOf<String>("apple","orange","pear","banana")
        val strBuilder = StringBuilder()
        strBuilder.append("start eating fruit: ")
        for (fruit in list){
            strBuilder.append(fruit)
        }
        val result = strBuilder.toString()
        println(result)

        //使用with函数实现
        val resulWith = with(StringBuilder()){
            append("with start eating fruit: ")
            for (fruit in list){
                append(fruit)
            }
            toString()
        }
        println(resulWith)
    //run函数  //在某个对象上调用， 只有一个lambda表达式作为参数，调用对象会被作为上下文传入lambada表达式
        StringBuilder().run {
            append("with start eating fruit: ")
            for (fruit in list){
                append(fruit)
            }
            toString()
        }
    println(resulWith)
    //apply函数
    // 在某个对象上调用，接收lambada表达式参数，表达式中提供调用对象上下文 ，无法指定返回值，会返回调用者本身
    val sb = StringBuilder().apply {
        append("with start eating fruit: ")
        for (fruit in list){
            append(fruit)
        }
    }
    println(sb.toString())


}