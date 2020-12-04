package com.li.mvvmlibary;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;

import com.li.mvvmlibary.base.BaseMVVMFragment;
import com.li.mvvmlibary.base.BaseMvvmActvity;
import com.li.mvvmlibary.databinding.ActivityMainBinding;
import com.li.mvvmlibary.inject.BindLayout;
import com.li.mvvmlibary.inject.InjectViewModel;

public class MainFragment extends BaseMVVMFragment {
    @BindLayout(R.layout.activity_main)
    ActivityMainBinding activityMainBinding;
    @InjectViewModel
    MainActivityModel mainActivityModel;

    Handler handler = new Handler(Looper.getMainLooper());


    @Override
    public void initAllConfig() {
        final User u = new User("123","1234");
        mainActivityModel.setUser(u);
        activityMainBinding.setViewMode(mainActivityModel);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                u.setName("DDDDDD");
            }
        },2000);
    }

    @Override
    public View setCreateView() {
        return activityMainBinding.getRoot();
    }
}
