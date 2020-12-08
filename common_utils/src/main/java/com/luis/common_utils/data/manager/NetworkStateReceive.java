package com.luis.common_utils.data.manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Build;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import com.luis.common_utils.R;
import com.luis.common_utils.utils.NetworkUtils;

import java.util.Objects;

/**
 * 监听网络状态的广播接收者
 * 例如：可以收到 “网络不给力”
 */
public class NetworkStateReceive extends BroadcastReceiver {

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onReceive(Context context, Intent intent) {
        if (Objects.equals(intent.getAction(), ConnectivityManager.CONNECTIVITY_ACTION)) {
            if (!NetworkUtils.isConnected()) {
                Toast.makeText(context, "网络断了", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
