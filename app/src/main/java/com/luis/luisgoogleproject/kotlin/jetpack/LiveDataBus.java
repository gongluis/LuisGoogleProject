package com.luis.luisgoogleproject.kotlin.jetpack;

import androidx.lifecycle.MutableLiveData;

import java.util.HashMap;
import java.util.Map;

public class LiveDataBus {
    private final Map<String, MutableLiveData<Object>> bus;
    private LiveDataBus() {//私有构造
        bus = new HashMap<>();
    }
    private static class SingleHolder{
        private static final LiveDataBus DATA_BUS=new LiveDataBus();
    }
    public static LiveDataBus getInstance(){
        return SingleHolder.DATA_BUS;
    }

    public <T>MutableLiveData<T> with(String key, Class<T> type){
        if(!bus.containsKey(key)){
            bus.put(key, new MutableLiveData<Object>());
        }
        return (MutableLiveData<T>) bus.get(key);
    }

    public MutableLiveData<Object> with(String target){
        return with(target, Object.class);
    }

    public void remove(String key){
        if(bus.containsKey(key)){
            bus.remove(key);
        }
    }
}
