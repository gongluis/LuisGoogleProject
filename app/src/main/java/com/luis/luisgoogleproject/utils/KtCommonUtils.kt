package com.luis.luisgoogleproject.utils

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.concurrent.thread

class KtCommonUtils {
    companion object {
        val ktCommonUtils by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
            KtCommonUtils()
        }

        /**
         * 回调的使用
         */
        fun callBack(){
            //适用于kotlin中对于一个接口中含有多个回调方法
//            mView.setEventListener(object: ExamPlanHomeEventListener{
//                public void onSuccess(Data data){
//                    //todo
//                }
//            });

            //使用lambda函数可简化如下
//            mView.setEventListener({
//                    data: Data ->
//                //todo
//            })

            //如果以上代码中data没有使用到的话，可以简化成以下方式
//            mView.setEventListener(){
//                //todo
//            }
            //setEventListener 只有一个参数的话可以省略圆括号
//            mView.setEventListener{
//                //todo
//            }
        }

        /**
         * 协程的使用
         * 挂起与阻塞的区别，阻塞的进程仍在内存，挂起的进程会被换出到磁盘中，阻塞是为了等待资源，挂起os为了提高内存使用率将暂时不能运行的而进程调出到磁盘
         * 单线程上可运行多个协程，支持挂起，不会阻塞线程，挂起比阻塞节省内吞
         * 减少内存泄漏
         */
        fun coroutinesUse(){

        }

        /**
         * 线程的使用
         */
        fun threadUse(){
            Thread{
                println("打印1当前线程id:"+Thread.currentThread())
            }.start()

            thread{
                println("打印2当前线程id:"+Thread.currentThread())
            }

            val states = arrayOf("Starting", "Doing Task 1", "Doing Task 2", "Ending")
            repeat(3) {
                Thread {
                    println("${Thread.currentThread()} has started")
                    for (i in states) {
                        println("${Thread.currentThread()} - $i")
                        Thread.sleep(50)
                    }
                }.start()
            }
            repeat(3) {
                GlobalScope.launch {
                    println("Hi from ${Thread.currentThread()}")
                }
            }

        }

        /**
         * 常用符号的理解 问号，叹号，引号
         */
        fun symbol(){
            var str1:String?= "23" //代表该变量是可以为空的，如果不加问号，下面一行代码则会报错
            str1=null
            println("安全调用："+str1?.length) //这里会返回str1的length,或者返回null;如果str1是null的话，这种安全调用会节省很大if的判断，比如我们可能会碰到这样的代码 bob?.department?.head?.name ,任何一个对象为null都会返回null
            var str2:String?= "23"
            val result =str2!!.length //表示str2不能为空，为空则爆出空指针异常，相当于java的if else(如果不是空则正常返回，如果是空则返回空指针)
            //kotlin不推荐使用非空断言,通常会使用?:来防止程序运行时报空指针异常而崩溃，如下：
            val s = str2 ?: "我为空拉"//相当于java中的三元运算符
            str2=null
            val length = str2?.length
            println("可空字符串值为：$length")

//            tabViews1?.let { addTabViews(it) }  //表示object不为Null的情况下会执行let后的函数


        }

        /**
         * var与val区别
         */
        fun testVarAndVal() {
            var name = "zhang san"
            println(name)
            name = "li si"
            println(name)
            val finalValue = "我是不可改变的";
            println(finalValue);
//        finalValue = "" //会直接编译报错不让你赋值
        }

        /**
         * 集合定义相关
         * 访问集合数据的接口和修改集合数据的接口分开了
         * Collection：使用这个接口，可以遍历集合中的元素、获取集合的大小、判断集合中是否包含某个元素，以及执行其他从该集合中读取数据的操作。但是这个接口没有任何添加或移除元素的方法。
         * MutableCollections：接口可以修改集合中的数据。它继承了普通的Kotlin.collections.Collection接口，还提供了方法来添加和移除元素、清空集合等。
         */
        fun aboutCollections() {
            val array = arrayListOf<Int>(1,2,3)//必须指定元素类型 可变
            val mutableList = mutableListOf<String>()//必须指定元素类型 可变
            val listOf = listOf<Int>(1,2,3) //必须指定元素类型和初始化数据 不可变
//        val arraySetOf = arraySetOf<Int>() //会对元素自动去重
            //集合转数组
            val toList = array.toList()
            //数组转集合
            val toTypedArray = toList.toTypedArray()

            //集合操作符
            val any = array.any { it > 2 }//至少有一个元素满足条件返回true
            println("any是否满足：$any")
            val all = array.all { it < 4 }//元素全部满足条件返回true
            println("全部是否满足：$all")
            val average = array.average()
            println("平均值 is: $average ")
            val component1 = array.component1()//返回第一个元素，越界返回索引越界异常
            println("第一个元素是：$component1")
            val contains = array.contains(3)
            println("是否包含3：$contains")
            val subList = listOf(2,1)
            val containsAll = array.containsAll(subList)
            println("是否包含子集合：$containsAll")
            //...


            //遍历
            for (i in array) {
                println("集合for循环：$i")
            }
        }



        /**
         * 方法相关定义
         */
        fun aboutFunction() {
            var reslutValue =string2IntWithDefault("20")
            println("结果：$reslutValue")
        }

        /**
         * 数组相关定义
         */
        fun aboutArray() {
//        val array1 = arrayOfNulls<String>(12)//新建一个长度为12的string 数组，并初始化每个元素为null
            val array1 = arrayOf("str1","str2","str3")

            for (item in array1) {
                println("元素遍历：$item")
            }
            for (index in array1.indices) {
                println("下标遍历：$index")
                println("下标遍历："+"->"+array1[index])
            }
            array1.forEach { println(it) } //forEach遍历
            array1.forEachIndexed{index,item-> //增强版forEach 索引+元素
                println("$index -> $item")
            }
        }

        /**
         * 简单函数定义
         */
        fun string2Int(value: String):Int{
            return value.toInt()
        }

        /**
         * 带默认值的函数定义 java调kotlin是无效的
         */
        fun string2IntWithDefault(value: String = "100"):Int{//默认值
            return value.toInt()
        }

        fun printArray(name:String, vararg arrays:String){

        }
    }
}