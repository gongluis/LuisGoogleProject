package com.luis.luisgoogleproject.utils

class KtInstance {
    companion object{ // 此处声明表示声明半生对象，作用是在原类中生成一个内部类，并在原类中创建这个内部类对象
        val ktInstance by lazy(LazyThreadSafetyMode.NONE) {//by lazy
            KtInstance()
        }
    }

    class SynInstance{
        companion object{
        var singInstance:SynInstance? = null
            @Synchronized
            fun getInstance():SynInstance?{
                if(SynInstance ==null){
                    singInstance = SynInstance()
                }
                return singInstance
            }
        }
    }
    //推荐
    class FinalInstance{
        companion object{
            val finalInstance by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
                FinalInstance()
            }
        }
    }
    //推荐 静态内部类 多一个静态类，空间置换效率
    class StaticInstance{
        companion object{
            fun getInstance() = InstanceHelper.single
        }
        object InstanceHelper{
            val single = StaticInstance()
        }
    }
}