package com.luis.luisgoogleproject.data.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * author : luis
 * e-mail : luis.gong@cardinfolink.com
 * date   : 2021/2/20  19:00
 * desc   :
 */
public class ParcelTest implements Parcelable {
    public String name;
    public String id;

    protected ParcelTest(Parcel in) {
    }

    public static final Creator<ParcelTest> CREATOR = new Creator<ParcelTest>() {//反序列化方法
        @Override
        public ParcelTest createFromParcel(Parcel in) {
            return new ParcelTest(in);
        }

        @Override
        public ParcelTest[] newArray(int size) {
            return new ParcelTest[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {//序列化方法
        dest.writeString(this.id);
        dest.writeString(this.name);
    }
}
