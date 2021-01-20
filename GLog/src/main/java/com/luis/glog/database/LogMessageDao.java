package com.luis.glog.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/**
 * author : luis
 * e-mail : luis.gong@cardinfolink.com
 * date   : 2021/1/15  10:57
 * desc   : 数据操作类
 */
@Dao
public interface LogMessageDao {
    @Insert
    void insertData(LogMessage... logMessages);

    @Update
    void updateData(LogMessage... logMessages);

    @Query("DELETE FROM logmessage")
    void deleteAllData();

    @Query("SELECT * FROM logmessage ORDER BY ID DESC")
    List<LogMessage> getAllMsg();
}
