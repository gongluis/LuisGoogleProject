package com.luis.luisgoogleproject.data.repository.request;

import com.luis.luisgoogleproject.data.config.ServerConfigs;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * author : luis
 * e-mail : luis.gong@cardinfolink.com
 * date   : 2020/12/4  10:37
 * desc   :
 */
public class RequestAPI implements IRequest {

    public static IRequest instanceRequestAPI(){

        return new RequestAPI();
    }
    @Override
    public void instanceRequestAction(String url, NetWorkResultData resultData) {
        commonOKHttpRequestAction(url, resultData);
    }


    @Override
    public void instanceRequestAction(String url, String value, NetWorkResultData resultData) {
        commonOKHttpRequestAction(url, resultData, value);
    }

    @Override
    public void instanceRequestAction(String url, String value1, String value2, NetWorkResultData resultData) {
        commonOKHttpRequestAction(url, resultData, value1,value2);
    }

    @Override
    public void instanceRequestAction(String url, String value1, String value2, String value3, NetWorkResultData resultData) {
        commonOKHttpRequestAction(url, resultData, value1,value2,value3);
    }

    @Override
    public void instanceRequestAction(String url, NetWorkResultData resultData, String... args) {
        commonOKHttpRequestAction(url, resultData, args);
    }

    @Override
    public void instanceRequestAction(String url, NetWorkResultData resultData, Map<String, String> parameter) {
        commonOKHttpRequestAction(url, resultData, parameter);
    }



    private void commonOKHttpRequestAction(String url, NetWorkResultData resultData) {
        OkHttpClient okHttpClient = new OkHttpClient();//新建一个请求client

        MultipartBody.Builder builder =  new MultipartBody.Builder().setType(MultipartBody.FORM);//表单形式

        Request request = new Request.Builder().url(url).post(builder.build()).build();//构建一个请求，post里面是参数的builder

        okHttpClient.newCall(request).enqueue(resultData);
    }

    private final void commonOKHttpRequestAction(String url, NetWorkResultData resultData, String value) {
        // OKHTTP
        // 1.创建一个OkhttpClient对象
        OkHttpClient okHttpClient = new OkHttpClient();

        // 2.构建参数的body  MultipartBody.FORM 表单形式
        MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);

        // 2.2封装参数
        builder.addFormDataPart(ServerConfigs.PART, value);

        // 3.构建一个请求  post 提交里面是参数的builder   url()请求路径
        Request request = new Request.Builder().url(url)
                .post(builder.build()).build();

        // 4.发送一个请求
        okHttpClient.newCall(request).enqueue(resultData);
    }

    private final void commonOKHttpRequestAction(String url, NetWorkResultData resultData, String... value) {
        // OKHTTP
        // 1.创建一个OkhttpClient对象
        OkHttpClient okHttpClient = new OkHttpClient();

        // 2.构建参数的body  MultipartBody.FORM 表单形式
        MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);

        for (String s : value) {
            // 2.2封装参数
            builder.addFormDataPart(ServerConfigs.PART, s);
            // builder.addFormDataPart("");  添加多个参数
        }

        // 3.构建一个请求  post 提交里面是参数的builder   url()请求路径
        Request request = new Request.Builder().url(url)
                .post(builder.build()).build();

        // 4.发送一个请求
        okHttpClient.newCall(request).enqueue(resultData);
    }

    private final void commonOKHttpRequestAction(String url, NetWorkResultData resultData, Map<String, String> parameter) {
        // OKHTTP
        // 1.创建一个OkhttpClient对象
        OkHttpClient okHttpClient = new OkHttpClient();

        // 2.构建参数的body  MultipartBody.FORM 表单形式
        MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);

        for(Map.Entry<String, String> entry : parameter.entrySet()){
            // 2.2封装参数
            builder.addFormDataPart(entry.getKey(), entry.getValue());
            // builder.addFormDataPart("");  添加多个参数
        }

        // 3.构建一个请求  post 提交里面是参数的builder   url()请求路径
        Request request = new Request.Builder().url(url)
                .post(builder.build()).build();

        // 4.发送一个请求
        okHttpClient.newCall(request).enqueue(resultData);
    }



}
