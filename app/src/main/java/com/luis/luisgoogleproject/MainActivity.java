package com.luis.luisgoogleproject;

import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.luis.luisgoogleproject.base.BaseActivity;
import com.luis.luisgoogleproject.change.MainActivityViewModel;
import com.luis.luisgoogleproject.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity {

    private MainActivityViewModel mMainActivityViewModel;
    private ActivityMainBinding mActivityMainBinding;

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

    }

}