package com.luis.luisgoogleproject.data.binding;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.luis.luisgoogleproject.data.config.ServerConfigs;

/**
 * author : luis
 * e-mail : luis.gong@cardinfolink.com
 * date   : 2020/12/3  20:55
 * desc   :
 */
public class ImageAdapter {

    @BindingAdapter(value = {"imageUrl","placeHolder"}, requireAll = false)
    public static void loadUrl(ImageView view, String url, Drawable placeHolder){
        if (url != null) {
            Glide.with(view.getContext()).load(url).placeholder(placeHolder).into(view);
        } else {
            Glide.with(view.getContext()).load(ServerConfigs.DEFAULT_IMG_URL2).placeholder(placeHolder).into(view);
        }
    }
}
