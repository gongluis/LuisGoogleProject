package com.luis.luisgoogleproject.base;

import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.luis.luisgoogleproject.R;

/**
 * author : luis
 * e-mail : luis.gong@cardinfolink.com
 * date   : 2021/3/18  10:00
 * desc   :
 */
public class BaseDialogFragment extends DialogFragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NO_TITLE, R.style.CommonDialog);
    }

    @Override
    public void onStart() {
        super.onStart();
        if (getDialog() != null) {
            setStickFullScreen(getDialog().getWindow().getDecorView());
        }
    }

    public boolean isShowing() {
        return getActivity() != null && !getActivity().isFinishing() && getDialog() != null && getDialog().isShowing();
    }

    @Override
    public void dismiss() {
        if (getActivity() == null || getActivity().isFinishing()) {
            return;
        }
        super.dismiss();
    }

    @Override
    public void dismissAllowingStateLoss() {
        if (getActivity() == null) {
            return;
        }
        super.dismissAllowingStateLoss();
    }

    /**
     * show the dialog
     * @param manager
     * @param tag
     */
    public void showAllowingStateLoss(FragmentManager manager, String tag) {
        if (!isAdded()) {
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.add(this, tag);
            transaction.commitAllowingStateLoss();
        }
    }

    public static void setStickFullScreen(View view) {
        if (view == null) {
            return;
        }
        if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) { // lower api
            view.setSystemUiVisibility(View.GONE);
        } else if (Build.VERSION.SDK_INT >= 19) {
            int systemUiVisibility = view.getSystemUiVisibility();
            int flags = View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
                    | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
            systemUiVisibility |= flags;
            view.setSystemUiVisibility(systemUiVisibility);
        }
    }
}
