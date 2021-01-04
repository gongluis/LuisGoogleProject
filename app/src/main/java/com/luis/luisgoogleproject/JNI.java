package com.luis.luisgoogleproject;

/**
 * author : luis
 * e-mail : luis.gong@cardinfolink.com
 * date   : 2020/12/17  9:33
 * desc   :
 */
public class JNI {
    {
        // 在这里我们需要加载这个jni so库， 这个Hello名字就是最终编译产出的so的名字，也可以起其他的名字，但必须要和最终的so库名相同。
        System.loadLibrary("Hello");
    }

    /* *
     *  定义native方法
     *  调用C代码对应的方法
     *  @return
     */
    public native String sayHello();  // 在这里我们声明了一个sayHello的本地接口。

}
