package com.luis.luisgoogleproject.kotlin.filepersistence

import android.content.Context

/**
 * 直接在activity 中获取 sp = getPreferences(Context.MODE_PRIVATE) 默认是用 activity的名称作为sp文件的名称
 * 如：LoginActivity------ data/data/packagename/files/share_prefs/kotlin.filepersistence.LoginActivity.xml
 */
class SPUtils {
    companion object {
        /**
         * 保存一个String 类型内容到 名称为data的sp文件
         * sp文件的位置 data/data/packageName/files/shared_prefs/data.xml
         */
        fun saveString(context: Context, saveValue: String, saveKey: String) {
            val editor = context.getSharedPreferences("data", Context.MODE_PRIVATE).edit()
            editor.putString(saveKey, saveValue)
            editor.apply()
        }

        /**
         * 获取 data/data/packageName/files/shared_prefs/data.xml 中key 为 ”value“ 的值
         */
        fun getString(context: Context, key: String): String {
            val sp = context.getSharedPreferences("data", Context.MODE_PRIVATE)
            val value = sp.getString(key, " ")
            return value.toString()
        }
    }
}