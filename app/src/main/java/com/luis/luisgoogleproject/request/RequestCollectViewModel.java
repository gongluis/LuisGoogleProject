package com.luis.luisgoogleproject.request;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.luis.luisgoogleproject.data.database.Student;
import com.luis.luisgoogleproject.data.repository.local.LocalRoomRequestManager;

import java.util.List;

/**
 * author : luis
 * e-mail : luis.gong@cardinfolink.com
 * date   : 2020/12/7  11:18
 * desc   :
 */
public class RequestCollectViewModel extends AndroidViewModel {

    private final Application mApplication;

    public RequestCollectViewModel(@NonNull Application application) {
        super(application);
        mApplication = application;
    }

    public LiveData<List<Student>> getStudentsLive(){
        return LocalRoomRequestManager.getInstance(mApplication).getStudentsLive();
    }

    //以下是增删改查
    public void touchOffInsertStudents(Student... students){
        LocalRoomRequestManager.getInstance(mApplication).insertStudnets(students);
    }

    public void touchOffUpdateWords(Student... students) {
        LocalRoomRequestManager.getInstance(mApplication).updateStudnets(students);
    }

    public void touchOffDeleteStudents(Student... students) {
        LocalRoomRequestManager.getInstance(mApplication).deleteStudents(students);
    }

    public void touchOffDeleteAllWords() {
        LocalRoomRequestManager.getInstance(mApplication).deleteAllStudnets();
    }
}
