package com.luis.luisgoogleproject.project;

import androidx.lifecycle.ViewModel;

import com.luis.common_utils.project.CustomProjectLiveData;

/**
 * author : luis
 * e-mail : luis.gong@cardinfolink.com
 * date   : 2020/12/3  20:40
 * desc   :
 */
public class ProjectViewModel extends ViewModel {

    private final CustomProjectLiveData<Boolean> isActive;
    private final CustomProjectLiveData<Boolean> isLogin;

    public CustomProjectLiveData<Boolean> getIsActive() {
        return isActive;
    }

    public CustomProjectLiveData<Boolean> getIsLogin() {
        return isLogin;
    }

    {//构造代码块，只有创建一个对象构造代码块都会执行一次，可用于统计创建对象的个数
        isActive = new CustomProjectLiveData<>();
        isActive.setValue(false);

        isLogin = new CustomProjectLiveData<>();
        isLogin.setValue(false);
    }
}
