package com.luis.luisgoogleproject.data.repository.network;

import androidx.lifecycle.MutableLiveData;

import com.luis.luisgoogleproject.data.bean.HomeDataResult;

/**
 * author : luis
 * e-mail : luis.gong@cardinfolink.com
 * date   : 2020/12/4  9:33
 * desc   : 远程网络请求标准仓库
 */
public interface IRemoteRequest {

    /**
     * 请求首页的数据
     * @param homeDataResultLiveData
     */
    void requestHomeData(MutableLiveData<HomeDataResult> homeDataResultLiveData);

}
