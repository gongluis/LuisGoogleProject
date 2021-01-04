package com.luis.luisgoogleproject;

import android.app.Activity;
import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * author : luis
 * e-mail : luis.gong@cardinfolink.com
 * date   : 2020/12/3  20:35
 * desc   :
 */
public class ProjectApplication extends Application implements ViewModelStoreOwner {

    private ViewModelStore mAppViewModelStore;
    private ViewModelProvider.AndroidViewModelFactory mFactory;

    @Override
    public void onCreate() {
        super.onCreate();

        // 实例化 ViewModelStore
        mAppViewModelStore = new ViewModelStore();
    }

    @NonNull
    @Override
    public ViewModelStore getViewModelStore() {
        return mAppViewModelStore;
    }

    /**
     * 暴露出去 对外界提供一份唯一的ViewModelProvider
     * @param activity
     * @return
     */
    public ViewModelProvider getAppViewModelProvider(Activity activity) {
        return new ViewModelProvider((ProjectApplication) activity.getApplicationContext(),
                ((ProjectApplication) activity.getApplicationContext()).getAppFactory(activity));
    }

    /**
     * 内部享有 就是为了拿到 ViewModelProvider.Factory
     * @param activity
     * @return
     */
    private ViewModelProvider.Factory getAppFactory(Activity activity) {
        Application application = checkApplication(activity);
        if (mFactory == null) {
            mFactory = ViewModelProvider.AndroidViewModelFactory.getInstance(application);
        }
        return mFactory;
    }

    /**
     * 内部享有 检查Application
     * @param activity
     * @return
     */
    private Application checkApplication(Activity activity) {
        Application application = activity.getApplication();
        if (application == null) {
            throw new IllegalStateException("Your activity/fragment is not yet attached to "
                    + "Application. You can't request ViewModel before onCreate call.");
        }
        return application;
    }


    public static HashSet<String> getSoList(int pid, String pkg)
    {
        HashSet<String> temp = new HashSet<String>();
        File file = new File("/proc/" + pid + "/maps");
        if (!file.exists())
        {
            return temp;
        }
        try
        {
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(new FileInputStream(file)));
            String lineString = null;
            while ((lineString = bufferedReader.readLine()) != null)
            {
                String tempString = lineString.trim();
                if (tempString.contains("/data/data")
                        && !tempString.contains("/data/data/" + pkg))
                {
                    int index = tempString.indexOf("/data/data");
                    temp.add(tempString.substring(index));
                }
            }
            bufferedReader.close();
        }
        catch (FileNotFoundException e)
        {
            //TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IOException e)
        {
            //TODO Auto-generated catch block
            e.printStackTrace();
        }
        return temp;
    }
    //卸载加载的so库
    public static native void uninstall(String soPath);

}
