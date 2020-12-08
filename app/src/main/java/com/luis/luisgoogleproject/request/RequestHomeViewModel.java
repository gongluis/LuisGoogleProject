package com.luis.luisgoogleproject.request;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.luis.luisgoogleproject.data.bean.HomeDataResult;
import com.luis.luisgoogleproject.data.repository.network.HttpRequestManager;

/**
 * author : luis
 * e-mail : luis.gong@cardinfolink.com
 * date   : 2020/12/3  21:24
 * desc   :
 */
public class RequestHomeViewModel extends ViewModel {

    private MutableLiveData<HomeDataResult> homeDataResultMutableLiveData;
    public MutableLiveData<HomeDataResult> getHomeDataResultMutableLiveData() {
        if (homeDataResultMutableLiveData == null) {
            homeDataResultMutableLiveData = new MutableLiveData<>();
        }
        return homeDataResultMutableLiveData;
    }

    public void touchOffHomeData() {
        HttpRequestManager.getInstance().requestHomeData(getHomeDataResultMutableLiveData());//将livedata传给网络请求模块
    }

}
