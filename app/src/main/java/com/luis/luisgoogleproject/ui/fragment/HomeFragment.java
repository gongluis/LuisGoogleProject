package com.luis.luisgoogleproject.ui.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.luis.luisgoogleproject.DetailLinkActivity;
import com.luis.luisgoogleproject.R;
import com.luis.luisgoogleproject.base.BaseFragment;
import com.luis.luisgoogleproject.change.HomeViewModel;
import com.luis.luisgoogleproject.data.bean.HomeDataResult;
import com.luis.luisgoogleproject.data.config.AppConfigs;
import com.luis.luisgoogleproject.databinding.FragmentHomeBinding;
import com.luis.luisgoogleproject.request.RequestHomeViewModel;
import com.luis.luisgoogleproject.ui.adapter.HomeInfoListAdapter;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class HomeFragment extends BaseFragment {

    private HomeViewModel homeViewModel;
    private RequestHomeViewModel requestHomeViewModel;
    private FragmentHomeBinding mBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        requestHomeViewModel = new ViewModelProvider(this).get(RequestHomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        showActionBar();
        mBinding = FragmentHomeBinding.bind(root);
        mBinding.setVm(homeViewModel);
        mBinding.setClick(new ProxyClick());
        mBinding.setLifecycleOwner(this);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //观察数据变化，变化后立马更新到界面
        requestHomeViewModel.getHomeDataResultMutableLiveData().observe(getViewLifecycleOwner(), new Observer<HomeDataResult>() {
            @Override
            public void onChanged(HomeDataResult homeDataResult) {

                // String link = homeDataResult.getData().getCompany_list().get(0).getLink();
                // Log.d(AppConfigs.TAG, "requestHomeViewModel observe link:" + link);

                String imagePath1 = homeDataResult.getData().getCompany_list().get(0).getImage();
                homeViewModel.getImageURL1().setValue(imagePath1);

                String imagePath2 = homeDataResult.getData().getAd_list().get(0).getImage();
                homeViewModel.getImageURL2().setValue(imagePath2);

                String linkPath1 = homeDataResult.getData().getCompany_list().get(0).getLink();
                homeViewModel.getLinkURL1().setValue(linkPath1);

                String linkPath2 = homeDataResult.getData().getAd_list().get(0).getLink();
                homeViewModel.getLinkURL2().setValue(linkPath2);

                //---------------------显示列表--------------------
                mBinding.industryInformationLv
                        .setAdapter(new HomeInfoListAdapter(getContext(),
                                homeDataResult.getData().getNews_list()));

            }
        });

        //触发一次获取网络数据接口
        requestHomeViewModel.touchOffHomeData();
    }

    public class ProxyClick{

        public void toLinkAction1() {
            Toast.makeText(mActivity, "即将发起进入跳转动作1...", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(getActivity(), DetailLinkActivity.class);
            intent.putExtra(AppConfigs.URL_KEY, homeViewModel.getLinkURL1().getValue());
            mActivity.startActivity(intent);
        }

        public void toLinkAction2() {
            Toast.makeText(mActivity, "即将发起进入跳转动作2...", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(getActivity(), DetailLinkActivity.class);
            intent.putExtra(AppConfigs.URL_KEY, homeViewModel.getLinkURL2().getValue());
            mActivity.startActivity(intent);
        }

    }

    public HomeFragment() {
        // Required empty public constructor
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.home_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.home_query://app跳转小程序，小程序跳回app
                String appId = "wxd930ea5d5a258f4f"; // 填应用AppId
                IWXAPI api = WXAPIFactory.createWXAPI(getContext(), appId);

                WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
                req.userName = "gh_45b51139a842"; // 填小程序原始id
//                req.path = path;                  ////拉起小程序页面的可带参路径，不填默认拉起小程序首页，对于小游戏，可以只传入 query 部分，来实现传参效果，如：传入 "?foo=bar"。
                req.miniprogramType = WXLaunchMiniProgram.Req.MINIPTOGRAM_TYPE_RELEASE;// 可选打开 开发版，体验版和正式版
                api.sendReq(req);
                break;
            case R.id.home_set:
                Toast.makeText(mActivity, "哈哈杀害", Toast.LENGTH_SHORT).show();
                break;
            case R.id.home_skin:
                Toast.makeText(mActivity, "哈哈杀害2", Toast.LENGTH_SHORT).show();

                break;
            case R.id.home_version:
                Toast.makeText(mActivity, "哈哈杀害3", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}