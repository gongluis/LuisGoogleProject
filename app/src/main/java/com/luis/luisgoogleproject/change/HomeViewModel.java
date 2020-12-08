package com.luis.luisgoogleproject.change;

import android.graphics.drawable.Drawable;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.luis.common_utils.utils.Utils;
import com.luis.luisgoogleproject.R;

/**
 * author : luis
 * e-mail : luis.gong@cardinfolink.com
 * date   : 2020/12/3  20:50
 * desc   :
 */
public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private MutableLiveData<String> imageURL1;
    private MutableLiveData<String> imageURL2;
    private MutableLiveData<Drawable> placeHolder;
    private MutableLiveData<String> linkURL1;
    private MutableLiveData<String> linkURL2;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("首页中心");

        imageURL1 = new MutableLiveData<>();
        imageURL1.setValue(null);

        imageURL2 = new MutableLiveData<>();
        imageURL2.setValue(null);

        placeHolder = new MutableLiveData<>();
        placeHolder.setValue(Utils.getApp().getResources().getDrawable(R.drawable.pictures_no));

        linkURL1 = new MutableLiveData<>();
        linkURL2 = new MutableLiveData<>();
    }

    public MutableLiveData<String> getText() {
        return mText;
    }

    public MutableLiveData<String> getImageURL1() {
        return imageURL1;
    }

    public MutableLiveData<Drawable> getPlaceHolder() {
        return placeHolder;
    }

    public MutableLiveData<String> getLinkURL1() {
        return linkURL1;
    }

    public MutableLiveData<String> getImageURL2() {
        return imageURL2;
    }

    public MutableLiveData<String> getLinkURL2() {
        return linkURL2;
    }
}
