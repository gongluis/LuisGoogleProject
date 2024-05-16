package com.luis.luisgoogleproject.kotlin.filepersistence

import android.content.Context
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.FileInputStream
import java.io.IOException
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class FileUtils {
    companion object{
        /**
         * 将内容写入 data/data/packageName/files/
         */
        fun save(inputText: String, context: Context){
            //kotlin中没有异常检查机制，意味所有的kotlin代码都不会强制你进行异常捕获或抛出，try catch即使你不写编译依然可以通过
            try {
                val outPut  = context.openFileOutput("data", Context.MODE_PRIVATE)//覆盖模式
                val writer = BufferedWriter(OutputStreamWriter(outPut))
                writer.use {
                    //use 为java内置扩展函数， 它会保证在lambda表达式中的代码全部执行完毕后自动将外层的流关闭，这样就不用写finally语句，手动关流
                    it.write(inputText)
                }
            }catch (e: IOException){
                e.printStackTrace()
            }
        }

        /**
         * 读取 data/data/packagename/files/filName 文件中每一行内容
         */
        fun load(fileName:String, context: Context):String{
            val content = java.lang.StringBuilder()
            try {
                val input = context.openFileInput(fileName)
                val reader = BufferedReader(InputStreamReader(input))
                reader.use {
                    reader.forEachLine {
                        //kotlin 内置函数，将读到的每行内容都回调到lambda表达式中
                        content.append(it)
                    }
                }

            }catch (e: IOException){
                e.printStackTrace()
            }
            return content.toString()
        }

    }
}