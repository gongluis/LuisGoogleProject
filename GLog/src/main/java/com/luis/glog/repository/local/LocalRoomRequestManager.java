package com.luis.glog.repository.local;

import android.content.Context;
import android.os.AsyncTask;

import com.luis.glog.database.LogMessageDao;
import com.luis.glog.database.LogDatabase;
import com.luis.glog.database.LogMessage;

import java.util.List;

/**
 * author : luis
 * e-mail : luis.gong@cardinfolink.com
 * date   : 2021/1/15  15:10
 * desc   :
 */
public class LocalRoomRequestManager implements DataBaseRequest{


    private static LocalRoomRequestManager INSTANCE;
    private final LogMessageDao mLogMessageDao;

    public LocalRoomRequestManager(Context context) {
        LogDatabase logDatabase = LogDatabase.getDataBase(context.getApplicationContext());
        mLogMessageDao = logDatabase.getLogMessageDao();

    }

    public static LocalRoomRequestManager getInstance(Context context){
        if (INSTANCE==null) {
            synchronized (LocalRoomRequestManager.class){
                if (INSTANCE == null) {
                    INSTANCE = new LocalRoomRequestManager(context);
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public void insertLogMessage(LogMessage... logMessages) {
        new InsertAsyncTask(mLogMessageDao).execute(logMessages);
    }

    @Override
    public void deleteAllStudents() {
        new DeleteAllAsyncTask(mLogMessageDao).execute();
    }

    @Override
    public List<LogMessage> getAllMsg() {


        return mLogMessageDao.getAllMsg();
    }

    /**
     * 插入数据
     */
    static class InsertAsyncTask extends AsyncTask<LogMessage,Void, Void>{

        private LogMessageDao mLogMessageDao;

        public InsertAsyncTask(LogMessageDao logMessageDao) {
            mLogMessageDao = logMessageDao;
        }

        @Override
        protected Void doInBackground(LogMessage... logMessages) {
            mLogMessageDao.insertData(logMessages);
            return null;
        }
    }

    // 异步的 清空 全部删除
    static class DeleteAllAsyncTask extends AsyncTask<Void, Void, Void> {
        private LogMessageDao logMessageDao;

        DeleteAllAsyncTask(LogMessageDao logMessageDao) {
            this.logMessageDao = logMessageDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            logMessageDao.deleteAllData();
            return null;
        }
    }


}
