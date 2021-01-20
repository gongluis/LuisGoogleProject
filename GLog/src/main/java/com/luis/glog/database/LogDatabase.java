package com.luis.glog.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

/**
 * author : luis
 * e-mail : luis.gong@cardinfolink.com
 * date   : 2021/1/15  10:57
 * desc   :
 */
@Database(entities = {LogMessage.class}, version = 1, exportSchema = true)
public abstract class LogDatabase extends RoomDatabase {
    private static LogDatabase INSTANCE;

    public static synchronized LogDatabase getDataBase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room
                    .databaseBuilder(context.getApplicationContext(), LogDatabase.class, "log_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return INSTANCE;
    }

    public abstract LogMessageDao getLogMessageDao();
}
