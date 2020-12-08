package com.luis.luisgoogleproject.data.repository.request;

import java.util.Map;

/**
 * author : luis
 * e-mail : luis.gong@cardinfolink.com
 * date   : 2020/12/4  9:55
 * desc   :
 */
public interface IRequest {

    /** TODO ********************** 下面这一系列都是 NetWork相关的 ************************/
    void instanceRequestAction(String url, NetWorkResultData resultData);

    void instanceRequestAction(String url, String value, NetWorkResultData resultData);

    void instanceRequestAction(String url, String value1, String value2, NetWorkResultData resultData);

    void instanceRequestAction(String url, String value1, String value2, String value3, NetWorkResultData resultData);

    void instanceRequestAction(String url, NetWorkResultData resultData, String... args);

    void instanceRequestAction(String url, NetWorkResultData resultData, Map<String, String> parameter);

    /** TODO ********************** 下面这一系列都是 本地相关的 ************************/
//    void instanceLocalAction(String path, LocalResultData localResultData);
}
