package com.luis.luisgoogleproject;

import android.util.Log;

import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.work.WorkManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.luis.glog.GLog;
import com.luis.luisgoogleproject.base.BaseActivity;
import com.luis.luisgoogleproject.change.MainActivityViewModel;
import com.luis.luisgoogleproject.databinding.ActivityMainBinding;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MainActivity extends BaseActivity {

    private MainActivityViewModel mMainActivityViewModel;
    private ActivityMainBinding mActivityMainBinding;

    @Override
    public void initWorkSpace() {
        mMainActivityViewModel = getActivityViewModelProvider(this).get(MainActivityViewModel.class);
        mActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mActivityMainBinding.setLifecycleOwner(this);//livedata
        mActivityMainBinding.setVm(mMainActivityViewModel);//viewmodel


        BottomNavigationView navView = findViewById(R.id.nav_view);

        AppBarConfiguration appBarConfiguration =
                new AppBarConfiguration.Builder(
                        R.id.navigation_home,
                        R.id.navigation_contact,
                        R.id.navigation_personal)
                        .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);


        //jni 测试
        // 创建JNI实例，并调用本地声明的方法
//        String result = new JNI().sayHello();
//        System.out.println(result);
        // 打印JNI本地方法返回的字符串。
//        Log.d("TAG", "the string from JNC C '"+result + "'");
        //c-s  syn(sequence=x)       s-c   ack(sequence x+1) synchronous(sequencey)  c-s ack(sequence y+1)  estanblish


//        WorkManager.getInstance(getApplicationContext())
//        .beginWith(Arrays.asList(workA, workB))
//                .then(workC)
//                .enqueue();
        GLog.i(getApplicationContext(),"巩贺", "MainActivity", "我是测试日志哈哈哈哈！！！");

    }
}