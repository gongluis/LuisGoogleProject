package com.luis.luisgoogleproject.base;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.luis.common_utils.data.manager.CustomNetworkStateManager;
import com.luis.common_utils.utils.BarUtils;

/**
 * author : luis
 * e-mail : luis.gong@cardinfolink.com
 * date   : 2020/12/3  15:26
 * desc   :
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 给工具类初始化
        // BarUtils.setStatusBarColor(this, Color.RED);
        // BarUtils.setStatusBarLightMode(this, true);
        BarUtils.setStatusBarVisibility(this, false); // 隐藏 状态栏

        getLifecycle().addObserver(CustomNetworkStateManager.getInstance());

        //初始化工作函数，子类不需要再重写父类的onCreat()方法,只需要在initWorkSpace方法中进行初始化
        initWorkSpace();
    }



    /**
     * 交由子类来完成此动作
     */
    public abstract void initWorkSpace();

    /**
     * 给子类提供一个统一的获取ViewModelProvider对象的方法
     * @param activity
     * @return
     */
    protected ViewModelProvider getActivityViewModelProvider(AppCompatActivity activity) {
        return new ViewModelProvider(activity, activity.getDefaultViewModelProviderFactory());
    }



    /**
     * 暴露给自己的孩子 隐藏ActionBar
     */
    public void hideActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.hide();
        }
    }

    /**
     * 暴露给自己的孩子 显示ActionBar
     */
    public void showActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.show();
        }
    }
}
