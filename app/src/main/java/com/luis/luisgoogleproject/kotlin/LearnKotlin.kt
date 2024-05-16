package com.luis.luisgoogleproject.kotlin

import kotlin.math.max

fun main() {
    println("Hello Kotlin!")
    val a = 10  //kotlin自动推导功能，自动推导出a是个整型

    println("result: $a")

    val a1: Int = 10 //显示声明变量a为Int类型 不会进行类型推导 java中int是一个关键字，kotlin中Int是一个类

    //运算
    var a2:Int = 10
    a2 = a2*10
    println("a2= $a2")
    //注意：永远只是用val先定义变量，不能满足需求的时候再使用var,程序会更健壮

    //函数
    println("最大结果：${largerNumber(1, 9)}")
    println("最大结果：${largerNumber1(1, 9)}")

    //程序的执行语句分三种：顺序执行 、条件执行、循环执行
    //条件语句 if
    println("最大结果8：${largerNumber3(1, 8)}")
    println("最大结果7：${largerNumber4(1, 7)}")
    println("最大结果6：${largerNumber5(1, 6)}")
    //条件语句 when
    println("分数：${getScore("WangWu")}")
    println("分数when：${getScoreWhen("WangWu")}")
    println("数据类型when：${checkNumber(4)}")
    //循环语句
    //while语句和java中的一致
    //fori语句被舍弃，foreach被变成了for-in循环   区间概念 val range = 0..10  等同于[0,10]
    for(i in 0..10){
        println(i)
    }
    for(i in 0 until 10 step 2){  //val range = 0 until 10  左闭右开，不包含10，因为长度为10的数据，下标从0开始只到9
        println(i)           //step 2每次循环都加2  输出的结果是：0、2、4、6、8
    }
    for(i in 10 downTo  0){  // 降序
        println(i)           //10 、9、8...0
    }

    //对象
    val p = Person("彦祖",50)
//    p.name = "彦祖"
//    p.age = 50
    p.eat()
    //继承
    //kotlin默认所有非抽象类都是不可被继承的（effect java中明确提到，如果一个类不是专门为继承而设计的，那就应该主动将它加上final声明，禁止它可以被继承）
    //1.在class前面加上open关键字就可以了  告诉kotlin该类专门为继承而设计
    //2.Person后面加上括号  表示主构造函数
    val student = Student("123",5)
    //主构造函数没有函数体，如果想在构造函数中编写逻辑，可在init结构体中编写。
    //接口
    val jack = Student("jack",20)
    doStudy(jack)
    //接口默认实现 接口类中定义的函数添加函数体即表示该韩式为默认实现，当没有实现的时候会执行里面逻辑

    //函数可见性修饰符
//    java: public private protect default  默认修饰符是default protect表示对当前类、子类和同一包路径下类可见 default表示同一路径下类可见
//    kotlin: public private protect internal  默认修饰符是public  protect只对当前类和子类可见， internal同一模块中的类可见  开发一个模块给别人用，一些函数只允许内部调用，不想暴露给外部可以声明为internal

    //数据类与单例
    //数据类即model 需要重写equals()、hashCode()、toSting()这几个方法 但是在kotlin不需要，会自动帮你写好
    val phone =Cellphone("一加", 1799.0)
    println(phone.toString())//在java中如果你未实现toString方法，会打印出一串内存地址
    //单例
    // 避免创建重复对象
    Singleton.singletonTest()  //kotlin中不需要私有化构造函数，不需要提供getInstance静态方法，只需要把class关键字改成Object关键字，一个单例类就创建完成了

    //lambda表达式  kotlin的灵魂所在
    val list = ArrayList<String>()
    list.add("Apple")
    list.add("Banana")
    list.add("Orange")
    list.add("Pear")
    list.add("Grape")
    //以上方式创建集合并赋值太繁琐
    val list1 = listOf("Apple","Banana", "Orange", "Pear", "Grape")  //创建的是一个不可变集合，无法进行增删改，只能查看
//    list1.add 没有add这个函数
    val list2 = mutableListOf<String>("a","b")
    val set = setOf<String>("q","w")//不可变set  与list的区别是不可以存放重复元素，如果存放了多个相同元素只会保留其中一份
    val set1 = mutableSetOf<String>("q","w")//可变set
    list2.add("c")
    for (fruit in list1){
        println(fruit)
    }
    //map
    val map=HashMap<String,Int>()
    map.put("a",1)
    map.put("b",1)
    map.put("c",1)
    val mapa =map.get("a");
    //不建议上面这么做,建议使用以下类似于数组的方式
    map["a"] = 1
    map["b"] = 1
    map["c"] = 1
    val mapa1 =map["a"]

    val mapb = mapOf("a" to 1,"b" to 2, "c" to 3)//快捷方式生成map
    val mapc = mutableMapOf("a" to 1,"b" to 2, "c" to 3)//快捷方式生成map
    for((fruit, number) in mapc){
        println("fruit is $fruit number is $number")
    }

    //集合的函数式API
        //1.找出集合中单词长度最长的那个
        findLengthest()//普通版
        findLengthest1()//lambda表达式版
        //2. map函数 将list中的单词全部转换成大写,小写，取首字母等
        uppercase()
        //3. filter函数 过滤集合中的数据，可结合map使用
        keep5Length()
        //4. any函数 判断集合中是否至少含有一个元素满足指定条件
        //5. all函数 判断集合中是否所有元素满足指定条件
        anyAndAll()
    //以上是Kotlin中函数式API用法
    //下面是Kotlin中函数式API的用法  条件就是调用的java方法接受一个java单抽象方法接口参数（接口中国只有一个待实现方法，有多个则无法使用函数式API）
    threadAndRunnable()

    //空指针异常
    nullPointMethod("null") //传入null编译 报错
        //判空辅助工具
            // ？.  当对象不为空时候正常调用，为空则什么都不做
            questionPoint("jack")
            //?: 左右两边都接收一个表达式，如果左边的表达式结果为空，则返回右侧表达式的结果，如果不为空则返回左侧表达式结果
            questionQuotationMark(null)
            //！！双叹号非空断言，有风险的符号，意思为：我确信这里的对象不为空，所以不用你来帮我做空指针检查，如果出现问题，你可以抛出空指针异常，后果由我自己承担
            //kotlin有时候非空判断也不是很智能
            doubleExclamation() //每次使用非空断言的时候要考虑是否还有更好的实现方式
            //let函数
    //字符串内嵌写法
    StringInLine("测试人",Student("张三",30))
    //函数设置默认参数
        defaultParametersForFunC(1)
        //函数通过键值对传值，可以不受位置约束
        defaultParametersForFunC2(str = "joker", num = 3)//第一个参数有默认值，第二个参数没有默认值
        //函数没必要设置次构造函数，可以用主构造函数的默认参数替代
        val stut = Stut(name = "张三")
        println("学生的年龄是：${stut.age}")
    //activity的学习



}


/**
 * 不传入年龄就会使用默认年龄，不用重新定义次构造函数
 */
class Stut(val name:String, val age:Int = 30){

}

/**
 * 函数默认参数2
 */
fun defaultParametersForFunC2(num:Int=100, str:String){  //调用方再调用函数的时候可以不给带默认值的参数传值
    println("输入的字符串为：$num")
}
/**
 * 函数默认参数
 */
fun defaultParametersForFunC(num:Int, str:String = "default"){  //调用方再调用函数的时候可以不给带默认值的参数传值
    println("输入的字符串为：$str")
}
/**
 * 字符串内嵌用法
 * 解决问题：再也不用 +
 */
fun StringInLine(userName:String,student: Student){
    println("操作人：$userName, 学生姓名：${student.name}")
}
/**
 * let 函数得简单使用
 * 解决了什么问题？ 当我们用if函数判空得时候，在大括号内部都可以放心得使用参数而不用担心空指针，但是使用?.
 */
fun letMethod(){

}

var content:String? = "hello"
/**
 * 非空断言用法
 */
fun doubleExclamation(){
    if(content!=null){
//        val upcase = content.toUpperCase() //此处无法编译通过 必须写成下面的非空断言
        val upCase = content!!.toUpperCase()  //该方式有风险，万一 content为空就会发生空指针异常
    }
}
/**
 * ?: 问号引号的使用
 */
fun questionQuotationMark(student: String?):Int{
    if(student!=null){
        return student.length
    }
    return 0
}
//该方法等同于上面的方法
fun getTextLength(text:String?)= text?.length?:0  //解释：1.入参text是否为空，为空返回null，2. null？：返回0


/**
 *  ？。问号点的使用
 */
fun questionPoint(student:String?){
    if(student!=null){
        val length = student.length
        println("参数不为空: $length")
    }
    //以上代码可简写为
//    student?.length
    println("参数不为空：$student?.length")
}
/**
 * 在java中该方法需要进行参数判空，在kotlin中则不需要
 * 将空指针异常提前到了编译期进行检查
 */
fun nullPointMethod(student: String){
    student.length
}

/**
 * Thread Runnable lambda的应用
 */
fun threadAndRunnable(){
    Thread(object :Runnable{
        override fun run() {
            println("thread is running: ")
        }
    }).start()

    //使用lambda方式写 因为runnable中只有一个需要复写的方法
    Thread(Runnable{
        println("lambda thread is running")
    }).start()
    //Thread中只有一个参数，可以将接口名进行省略
    Thread({
        println("lambda thread is running")
    }).start()

    //  lambda表达式是方法的最后一个参数时，可以将lambda表达式移到方法括号的外面，同时，表达式还是方法唯一一个参数，可以将方法的括号省略
    Thread{
        println("lambda thread is running")
    }.start()
}

/**
 * any和all函数的用法
 */
fun anyAndAll(){
    val list = listOf("Apple","Banana", "Orange", "Pear", "Grape")
    val anyResult = list.any { it.length<=5 }
    val allResult = list.all { it.length<=5 }
    println("anyResult $anyResult allResult $allResult")
}

/**
 * filter 函数 取出小于5字符，后把全部变成大写
 */
fun keep5Length(){
    val list = listOf("Apple","Banana", "Orange", "Pear", "Grape")
    val newList = list.filter {
        it.length<=5
    }.map {
        it.uppercase()
    }

    for (fruit in newList){
        println("长度小于5字符并且转换成大写的水果有：$fruit")
    }
}

/**
 * map函数 list 中全部转换成大写
 */
fun uppercase(){
    val list = listOf("Apple","Banana", "Orange", "Pear", "Grape")
    val newList = list.map { it.uppercase() }
//    val newList = list.map { it.lowercase() }
    for (fruit in newList){
        println(fruit)
    }
}
/**
 *
 */
fun findLengthest1(){
    //lambda标准语法结构
//    {参数名1：参数类型，参数名2：参数类型 ->
//        函数体
//    }

    val list = listOf("Apple","Banana", "Orange", "Pear", "Grape")
    val maxLengthFruit = list.maxBy { it.length }
    println("maxLength fruit is $maxLengthFruit")

    //解释下上面的一行代码
    val lambda = {fruit:String->
        fruit.length
    }
    val max = list.maxBy(lambda)
}
/**
 * 找出最长的单词--很繁琐
 */
fun findLengthest(){
    val list = listOf("Apple","Banana", "Orange", "Pear", "Grape")
    var maxLengthFruit = ""
    for(fruit in list){
        if(fruit.length>maxLengthFruit.length){
            maxLengthFruit = fruit
        }
    }
    println("maxLength fruit is $maxLengthFruit")
}

/**
 *  student实现了study的接口
 */
fun doStudy(study:Study){
    study.readBooks()
    study.doHomework()
}

/**
 * when进阶用法 将when的结构体完整的写在结构体当中
 * 返回所有tom开头的人
 */
fun getScoreWhen1(name:String)=when{
    name.startsWith("tom")->50
    name=="ZhangSan"->60
    name=="LiSi"->70
    name=="WangWu"->80
    else ->0
}

/**
 * when 的模糊判断
 */
fun checkNumber(num:Number){ //判断输入数据的类型，Int Long Float Double均是Number的子类
    when(num){
        is Int -> println("number is Int $num")  //is 相当于java的instance
        is Double -> println("number is Double $num")
        else -> println("num is not support")
    }
}

/**
 * when语句写根据姓名返回分数
 */
fun getScoreWhen(name:String)=when(name){
    "ZhangSan"->60
    "LiSi"->70
    "WangWu"->80
    else ->0
}

/**
 * 使用if语句写根据姓名查询分数
 */
fun getScore(name:String) = if(name=="ZhangSan") 60 else if (name =="LiSi") 70 else if(name =="WangWu") 80 else 0

/**
 * if语句简写4
 */
fun largerNumber7(num1:Int, num2:Int)= if(num1>num2)num1 else num2

/**
 * if语句简写3
 */
fun largerNumber6(num1:Int, num2:Int)= if(num1>num2){  //函数只有一行代码可以用=直接连接，这里等同于一行代码
        num1
    }else {
        num2
    }

/**
 * if语句简写2
 */
fun largerNumber5(num1:Int, num2:Int):Int{
    return if(num1>num2){  //if语句使用每个条件最后一行代码作为返回值，并将返回值赋值给value变量,由于没有重新赋值的情况可使用val声明value变量
        num1
    }else{
        num2
    }
}

/**
 * if语句的简写
 * 与java的区别：kotlin中if语句，可以有返回值，返回值就是if语句每一个条件最后一行代码
 */
fun largerNumber4(num1:Int, num2:Int):Int{
    val value =if(num1>num2){  //if语句使用每个条件最后一行代码作为返回值，并将返回值赋值给value变量,由于没有重新赋值的情况可使用val声明value变量
        num1
    }else{
        num2
    }
    return value
}

/**
 * if条件语句
 */
fun largerNumber3(num1:Int, num2:Int):Int{
    var value = 0
    if(num1>num2){
        value = num1
    }else{
        value = num2
    }
    return value
}

/**
 * 求最大值函数
 */
fun largerNumber(num1:Int, num2:Int):Int{
    return max(num1, num2)
}

/**
 * 函数语法糖：当函数中只有一行代码时，不比写函数体，直接将唯一一行代码写在函数尾部用等号连接
 */
fun largerNumber1(num1: Int, num2: Int):Int = max(num1,num2)

fun largerNumber2(num1: Int, num2: Int)= max(num1,num2)  //kotlin自动推断机制可以推出来返回的是一个Int
