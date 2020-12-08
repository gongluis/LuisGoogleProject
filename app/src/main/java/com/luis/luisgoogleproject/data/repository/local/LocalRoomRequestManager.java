package com.luis.luisgoogleproject.data.repository.local;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.luis.luisgoogleproject.data.database.Student;
import com.luis.luisgoogleproject.data.database.StudentDao;
import com.luis.luisgoogleproject.data.database.StudentDatabase;

import java.util.List;

/**
 * author : luis
 * e-mail : luis.gong@cardinfolink.com
 * date   : 2020/12/4  17:23
 * desc   :
 */
public class LocalRoomRequestManager implements DatabaseRequest{

    private final StudentDao mStudentDao;
    private final LiveData<List<Student>> mStudentsLive;
    private static LocalRoomRequestManager INSTANCE;

    private LocalRoomRequestManager(Context context) {
        StudentDatabase studentDatabase = StudentDatabase.getDatabase(context.getApplicationContext());
        mStudentDao = studentDatabase.getStudentDao();
        mStudentsLive = mStudentDao.getAllData();
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


    //仓库暴露出数据
    public LiveData<List<Student>> getStudentsLive(){
        return mStudentsLive;
    }


    @Override
    public void insertStudnets(Student... students) {
        new InsertAsyncTask(mStudentDao).execute(students);
    }

    @Override
    public void updateStudnets(Student... students) {
        new UpdateAsyncTask(mStudentDao).execute(students);
    }


    @Override
    public void deleteStudents(Student... students) {
        new DeleteAsyncTask(mStudentDao).execute(students);
    }

    @Override
    public void deleteAllStudnets() {
        new DeleteAllAsyncTask(mStudentDao).execute();
    }

    static class InsertAsyncTask extends AsyncTask<Student,Void, Void>{

        private StudentDao mStudentDao;

        public InsertAsyncTask(StudentDao studentDao) {
            mStudentDao =studentDao;
        }

        @Override
        protected Void doInBackground(Student... students) {
            mStudentDao.insertData(students);
            return null;
        }
    }


    // 异步的 条件 update
    static class UpdateAsyncTask extends AsyncTask<Student, Void, Void> {
        private StudentDao studentDao;

        UpdateAsyncTask(StudentDao studentDao) {
            this.studentDao = studentDao;
        }

        @Override
        protected Void doInBackground(Student... students) {
            studentDao.updateStudent(students);
            return null;
        }

    }

    // 异步的 ID删除
    static class DeleteAsyncTask extends AsyncTask<Student, Void, Void> {
        private StudentDao studentDao;

        DeleteAsyncTask(StudentDao studentDao) {
            this.studentDao = studentDao;
        }

        @Override
        protected Void doInBackground(Student... students) {
            studentDao.deleteAllData();
            return null;
        }

    }

    // 异步的 清空 全部删除
    static class DeleteAllAsyncTask extends AsyncTask<Void, Void, Void> {
        private StudentDao studentDao;

        DeleteAllAsyncTask(StudentDao studentDao) {
            this.studentDao = studentDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            studentDao.deleteAllData();
            return null;
        }
    }

}
