package com.luis.luisgoogleproject;

import android.text.TextUtils;
import android.util.Log;

import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.luis.luisgoogleproject.base.BaseActivity;
import com.luis.luisgoogleproject.change.MainActivityViewModel;
import com.luis.luisgoogleproject.databinding.ActivityMainBinding;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends BaseActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private MainActivityViewModel mMainActivityViewModel;
    private ActivityMainBinding mActivityMainBinding;

    public static String formatNumber(double number) {

        String result = "";

        try {

            DecimalFormat decimalFormat = new DecimalFormat("0.00");//构造方法的字符格式这里如果小数不足2位,会以0补足.

            result = decimalFormat.format(number);//format 返回的是四舍五入后的字符串

        } catch (Exception e) {


        }

        return result;

    }

    public static String getFormartBrand(String value) {
        if (value.length() < 3) {
            StringBuilder stringBuilder = new StringBuilder(value);
            while (stringBuilder.length() < 3) {
                stringBuilder.append(" ");
            }
            return stringBuilder.toString();
        }

        if (TextUtils.equals("qcom", value)) {
            return "XDL";
        } else if (TextUtils.equals("LANDI", value)) {
            return "LDI";
        } else if (TextUtils.equals("PAX", value)) {
            return "PAX";
        } else {
            return value.substring(0, 3);
        }
    }

    @Override
    public void initWorkSpace() {
        mMainActivityViewModel = getActivityViewModelProvider(this).get(MainActivityViewModel.class);
        mActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mActivityMainBinding.setLifecycleOwner(this);//livedata
        mActivityMainBinding.setVm(mMainActivityViewModel);//viewmodel


        BottomNavigationView navView = findViewById(R.id.nav_view);

        AppBarConfiguration appBarConfiguration =
                new AppBarConfiguration.Builder(
                        R.id.navigation_home,
                        R.id.navigation_contact,
                        R.id.navigation_personal)
                        .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        //jni 测试
        // 创建JNI实例，并调用本地声明的方法
//        String result = new JNI().sayHello();
//        System.out.println(result);
        // 打印JNI本地方法返回的字符串。
//        Log.d("TAG", "the string from JNC C '"+result + "'");
        //c-s  syn(sequence=x)       s-c   ack(sequence x+1) synchronous(sequencey)  c-s ack(sequence y+1)  estanblish


//        WorkManager.getInstance(getApplicationContext())
//        .beginWith(Arrays.asList(workA, workB))
//                .then(workC)
//                .enqueue();
//        GLog.i(getApplicationContext(),"巩贺", "MainActivity", "我是测试日志哈哈哈哈！！！");

        long timeMillis = Calendar.getInstance().getTimeInMillis();
        String day = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(timeMillis);
        Log.e(TAG, "initWorkSpace: " + day);

//        Date date1 = new Date(new Date(new Date().toString()).getTime());
//        Date date2 = new Date(new Date(new Date().toString()).getTime() + 24 * 60 * 60 * 1000 - 1);
//        String beginTime = date1.getYear() + "-" + ((date1.getMonth() + 1) < 10 ? "0" + (date1.getMonth() + 1) : (date1.getMonth() + 1)) + "-" + (date1.getDate() < 10 ? "0" + date1.getDate() : date1.getDate()) + " " + (date1.getHours() < 10 ? "0" + date1.getHours() : date1.getHours()) + ":" + (date1.getMinutes() < 10 ? "0" + date1.getMinutes() : date1.getMinutes()) + ":" + (date1.getSeconds() < 10 ? "0" + date1.getSeconds() : date1.getSeconds());
//        String endTime = date2.getYear() + '-' + (date2.getMonth() + 1) + '-' + date2.getDate() + ' ' + date2.getHours() + ':' + date2.getMinutes() + ':' + date2.getSeconds();
//        Log.e(TAG, "initWorkSpace: " + beginTime);

        Calendar monEight = Calendar.getInstance();
        monEight.set(Calendar.HOUR_OF_DAY, 0);
        monEight.set(Calendar.MINUTE, 00);
        monEight.set(Calendar.SECOND, 0);
//        monEight.set(Calendar.MILLISECOND, 0);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String effectiveTime = format.format(monEight.getTime());

        Log.e(TAG, "initWorkSpace33: " + effectiveTime);

        Calendar end = Calendar.getInstance();
        end.set(Calendar.HOUR_OF_DAY, 23);
        end.set(Calendar.MINUTE, 59);
        end.set(Calendar.SECOND, 59);
//        end.set(Calendar.MILLISECOND, 9);

        SimpleDateFormat formatEnd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String endTime = formatEnd.format(end.getTime());

        Log.e(TAG, "initWorkSpace44: " + endTime);

    }
}