package com.luis.luisgoogleproject.data.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/**
 * author : luis
 * e-mail : luis.gong@cardinfolink.com
 * date   : 2020/12/4  16:57
 * desc   :
 */
@Dao    //增删改查 实际操作
public interface StudentDao {

    @Insert
    void insertData(Student... students);

    @Update
    void updateStudent(Student... students);

    //条件删除
    @Delete
    void deleteData(Student... students);

    //删除全部
    @Query("DELETE FROM student")
    void deleteAllData();

    //查询全部
    @Query("SELECT * FROM student ORDER BY ID DESC")
    // List<Student> getAllWords();
    // LiveData 就是为了被动的知道  数据的变化
    public LiveData<List<Student>> getAllData();
}
