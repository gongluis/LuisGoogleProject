package com.luis.luisgoogleproject.data.repository.request;

/**
 * author : luis
 * e-mail : luis.gong@cardinfolink.com
 * date   : 2020/12/4  9:56
 * desc   : 这里采用抽象类的抽象方法，1是为了封装统一的接口名称。2是为了只返回有用的数据回去过滤掉无用的参数
 */

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
public abstract class NetWorkResultData implements Callback{

    @Override
    public void onFailure(@NotNull Call call, @NotNull IOException e) {
        requestError(e.getMessage());
    }

    @Override
    public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
        requestSuccess(response);
    }

    public abstract void requestError(String info);

    public abstract void requestSuccess(Response result);
}
