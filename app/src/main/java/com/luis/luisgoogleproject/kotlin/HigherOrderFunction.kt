package com.luis.luisgoogleproject.kotlin

fun example(func:(String, Int)-> Unit){
    func("hello", 123)
}

fun main() {
    val num1 = 10
    val num2 =8
    val result1 = num1AndNum2(num1, num2, ::plus)
    val result2 = num1AndNum2(num1, num2, ::minus)

    println("result1 is $result1")
    println("result2 is $result2")
    //以上还需要每次都定义两个函数，比较繁琐
    val result3 = num1AndNum2(num1,num2){n1, n2 ->
        n1+n2
    }
    val result4 = num1AndNum2(num1,num2){n1, n2 ->
        n1-n2
    }

}

fun plus(num1: Int, num2: Int):Int{
    return num1+num2
}
fun minus(num1: Int, num2: Int):Int{
    return num1-num2
}
fun num1AndNum2(num1:Int, num2:Int, operation:(Int,Int)->Int):Int{
    val result =  operation(num1, num2)
    return result
}