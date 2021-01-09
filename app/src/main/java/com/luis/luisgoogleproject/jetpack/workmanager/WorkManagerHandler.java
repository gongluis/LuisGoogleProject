package com.luis.luisgoogleproject.jetpack.workmanager;

import android.content.Context;

import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;

import java.util.concurrent.TimeUnit;

/**
 * author : luis
 * e-mail : luis.gong@cardinfolink.com
 * date   : 2021/1/9  15:33
 * desc   :
 */
public class WorkManagerHandler {
    private static WorkManagerHandler workManagerHandler = null;

    public static WorkManagerHandler getInstance() {
        if (workManagerHandler == null) {
            workManagerHandler = new WorkManagerHandler();
        }
        return workManagerHandler;
    }

    public void startPeroidWork(Context context, long intervalMilis){
        //任务执行的其它限制如网络，充电等。。。
        Constraints build = new Constraints.Builder()
                .setRequiresCharging(true)//连接充电器
                .build();


        PeriodicWorkRequest request = new PeriodicWorkRequest.Builder(TestWorker.class, intervalMilis, TimeUnit.SECONDS)
//                .setConstraints(build)
                .setBackoffCriteria(BackoffPolicy.LINEAR, OneTimeWorkRequest.MIN_BACKOFF_MILLIS, TimeUnit.MILLISECONDS)//重试策略，可配置，每次重试会增加10秒，第一个参数代表线性增加重试时间
                .build();
        WorkManager.getInstance(context).enqueue(request);//异步开启任务
    }
}
