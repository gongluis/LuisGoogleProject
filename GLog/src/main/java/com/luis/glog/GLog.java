package com.luis.glog;

import android.content.Context;
import android.os.Handler;

import com.luis.glog.database.LogMessage;
import com.luis.glog.repository.local.LocalRoomRequestManager;

import java.util.logging.LogRecord;

/**
 * author : luis
 * e-mail : luis.gong@cardinfolink.com
 * date   : 2021/1/15  13:56
 * desc   :
 */
public class GLog {

    public static void i(Context context, String userName, String tag, String msg) {
        //创建msg
        LogMessage log = LogMessage.createLog(userName, tag, msg,LogMessage.SEVERITY_INFO);
        //存储msg

//        LogFileStorage.getInstance(context).saveLog2SDCard(log);
        LocalRoomRequestManager.getInstance(context.getApplicationContext()).insertLogMessage(log);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

            }
        },3000);
    }


}
