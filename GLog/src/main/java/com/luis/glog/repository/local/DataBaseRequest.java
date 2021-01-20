package com.luis.glog.repository.local;

import com.luis.glog.database.LogMessage;

import java.util.List;

/**
 * author : luis
 * e-mail : luis.gong@cardinfolink.com
 * date   : 2021/1/15  15:08
 * desc   :
 */
public interface DataBaseRequest {
    void insertLogMessage(LogMessage... logMessages);

    void deleteAllStudents();

    List<LogMessage> getAllMsg();
}
