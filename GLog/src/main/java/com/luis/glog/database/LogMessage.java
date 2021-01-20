package com.luis.glog.database;

import android.os.Build;

import androidx.annotation.StringDef;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.luis.glog.DeviceUtils;

/**
 * author : luis
 * e-mail : luis.gong@cardinfolink.com
 * date   : 2021/1/15  10:57
 * desc   :
 */
@Entity
public class LogMessage {

    @PrimaryKey(autoGenerate = true) //主键 唯一，自增长
    private int id;

    /**
     * 日志内容
     */
    @ColumnInfo(name = "message")
    private String message;
    /**
     * 手机类别
     */
    @ColumnInfo(name = "deviceType")
    private String deviceType = "Android";
    /**
     * app版本
     */
    @ColumnInfo(name = "appVersion")
    private String appVersion;
    /**
     * 手机系统版本
     */
    @ColumnInfo(name = "androidVersion")
    private String androidVersion;
    /**
     * 手机名称
     */
    @ColumnInfo(name = "deviceName")
    private String deviceName;
    /**
     * 用户名
     */
    @ColumnInfo(name = "userName")
    private String userName;
    /**
     * 打印日志类
     */
    @ColumnInfo(name = "activityName")
    private String activityName;
    /**
     * 时间
     */
    @ColumnInfo(name = "timeStamp")
    private String timeStamp;
    /**
     * 日志级别
     */
    @ColumnInfo(name = "severity")
    private String severity;



    public static final String SEVERITY_INFO = "Info";
    public static final String SEVERITY_DEBUG = "Debug";
    public static final String SEVERITY_WARN = "Warn";
    public static final String SEVERITY_ERROR = "Error";
    @StringDef({SEVERITY_INFO,SEVERITY_DEBUG,SEVERITY_WARN,SEVERITY_ERROR})
    public @interface Severity{
    }

    public static LogMessage createLog(String userName, String tag, String msg, @Severity String severityInfo) {
        return createLog(userName, tag, msg, "",severityInfo);
    }

    public static LogMessage createLog(String userName, String tag, String msg, String appVersion, @Severity String severityInfo) {
        LogMessage logMessage = new LogMessage();
        logMessage.severity = severityInfo;
        logMessage.activityName = tag;
        logMessage.message = msg;
        logMessage.appVersion = appVersion;
        logMessage.deviceName = userName;
        logMessage.timeStamp = DeviceUtils.getCurrentTime();
        logMessage.androidVersion = "Android" + Build.VERSION.RELEASE;
        logMessage.userName = userName;
        return logMessage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getAndroidVersion() {
        return androidVersion;
    }

    public void setAndroidVersion(String androidVersion) {
        this.androidVersion = androidVersion;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }
}
