package com.luis.luisgoogleproject.jetpack.workmanager;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

/**
 * author : luis
 * e-mail : luis.gong@cardinfolink.com
 * date   : 2021/1/9  15:26
 * desc   :
 */
public class TestWorker extends Worker {

    public TestWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
            //do the exactly peroid work . request serve/upload log/...


//        return Result.failure();//表示任务执行失败并且不会继续执行任务
//        return Result.retry();//workmanager会在之后再次尝试执行任务，至于在之后何时触发可以自定义也可以默认
        return Result.success();//代表任务执行成功
    }
}
