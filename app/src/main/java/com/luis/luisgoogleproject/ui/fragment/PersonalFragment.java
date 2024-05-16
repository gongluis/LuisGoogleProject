package com.luis.luisgoogleproject.ui.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.luis.luisgoogleproject.DetailLinkActivity;
import com.luis.luisgoogleproject.R;
import com.luis.luisgoogleproject.base.BaseFragment;
import com.luis.luisgoogleproject.change.MineViewModel;
import com.luis.luisgoogleproject.data.config.AppConfigs;
import com.luis.luisgoogleproject.databinding.FragmentPersonalBinding;
import com.luis.luisgoogleproject.kotlin.activity.FirstActivity;
import com.luis.luisgoogleproject.ui.HaikeActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PersonalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PersonalFragment extends BaseFragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    private FragmentPersonalBinding bind;

    public PersonalFragment() {
        // Required empty public constructor
    }

    public static PersonalFragment newInstance(String param1, String param2) {
        PersonalFragment fragment = new PersonalFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_personal, container, false);
        MineViewModel mineViewModel = new ViewModelProvider(this).get(MineViewModel.class);//负责控制布局展示ui
        bind = FragmentPersonalBinding.bind(inflate);
        bind.setVm(mineViewModel);
        bind.setClick(new ProxyClick());
        bind.setLifecycleOwner(this);
        return inflate;
    }

    public class ProxyClick {
        public void toHaikeActivity() {
            Intent intent = new Intent(getActivity(), HaikeActivity.class);
            mActivity.startActivity(intent);
        }

        public void toKotActivity() {
            Intent intent = new Intent(getActivity(), FirstActivity.class);
            mActivity.startActivity(intent);
        }
    }
}