package com.luis.luisgoogleproject.practice;

import androidx.lifecycle.MutableLiveData;

public class MyLivedata {
    private MutableLiveData<String> info;//1.定义数据

    public MutableLiveData<String> getInfo() {//2.对外提供数据的方法
        if(info==null){
            info = new MutableLiveData<>();
        }
        return info;
    }

    //3.单例模式返回liveData
    private static MyLivedata  livedata=new MyLivedata();
    public static MyLivedata getInstance(){return livedata;}
}
