package com.luis.luisgoogleproject.practice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import com.luis.luisgoogleproject.R;

public class LiveDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_data);
        // TODO: 2022/12/30  1. jetpack-liveData
        TextView tv = findViewById(R.id.tv);

        MyLivedata.getInstance().getInfo().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                tv.setText(s);
            }
        });


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                MyLivedata.getInstance().getInfo().setValue("巩贺");
            }
        }, 3000);

        // TODO: 2022/12/30  2.jetpack-viewmodel
//        new ViewModelProvider().get()

        // TODO: 2022/12/30  3. jetpack-room  数据库 实体注解
            //student
            //dao 增删改查
            //database



    }
}