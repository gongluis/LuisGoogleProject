package com.luis.luisgoogleproject.base;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.luis.luisgoogleproject.ProjectApplication;
import com.luis.luisgoogleproject.project.ProjectViewModel;

/**
 * author : luis
 * e-mail : luis.gong@cardinfolink.com
 * date   : 2020/12/3  20:33
 * desc   :
 */
public class BaseFragment extends Fragment {
    protected AppCompatActivity mActivity;
    public ProjectViewModel sharedViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedViewModel = getAppViewModelProvider().get(ProjectViewModel.class);

    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mActivity = (AppCompatActivity) context;
    }

    // 给当前BaseFragment用的
    protected ViewModelProvider getAppViewModelProvider() {
        return ((ProjectApplication) mActivity.getApplicationContext()).getAppViewModelProvider(mActivity);
    }

    /**
     * 暴露给自己的孩子 隐藏ActionBar
     */
    public void hideActionBar() {
        ActionBar actionBar = mActivity.getSupportActionBar();
        if(actionBar!=null){
            actionBar.hide();
        }
    }

    /**
     * 暴露给自己的孩子 显示ActionBar
     */
    public void showActionBar() {
        ActionBar actionBar = mActivity.getSupportActionBar();
        if(actionBar!=null){
            actionBar.show();
        }
    }
}
