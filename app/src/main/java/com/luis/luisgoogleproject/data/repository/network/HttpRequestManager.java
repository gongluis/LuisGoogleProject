package com.luis.luisgoogleproject.data.repository.network;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;
import com.luis.luisgoogleproject.data.bean.HomeDataResult;
import com.luis.luisgoogleproject.data.config.AppConfigs;
import com.luis.luisgoogleproject.data.config.ServerConfigs;
import com.luis.luisgoogleproject.data.repository.request.NetWorkResultData;
import com.luis.luisgoogleproject.data.repository.request.RequestAPI;

import java.io.IOException;

import okhttp3.Response;

/**
 * author : luis
 * e-mail : luis.gong@cardinfolink.com
 * date   : 2020/12/4  9:30
 * desc   :
 */
public class HttpRequestManager implements IRemoteRequest{

    private static final HttpRequestManager httpRequestManager = new HttpRequestManager();
    public static HttpRequestManager getInstance(){
        return httpRequestManager;
    }


    @Override
    public void requestHomeData(MutableLiveData<HomeDataResult> homeDataResultLiveData) {
        RequestAPI.instanceRequestAPI().instanceRequestAction(ServerConfigs.SERVER_URL, "1", new NetWorkResultData() {
            @Override
            public void requestError(String info) {
                Log.e(AppConfigs.TAG, "requestError: "+info);
            }

            @Override
            public void requestSuccess(Response result) {
                try {
                    String resultData = result.body().string();

                    //使用gson解析
                    Gson gson =  new Gson();
                    HomeDataResult homeDataResult = gson.fromJson(resultData, HomeDataResult.class);
                    homeDataResultLiveData.postValue(homeDataResult);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


    }
}
