package com.li.mvvmlibary;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.li.mvvmlibary.base.BaseMvvmActvity;
import com.li.mvvmlibary.databinding.ActivityMainBinding;
import com.li.mvvmlibary.inject.BindLayout;
import com.li.mvvmlibary.inject.InjectViewModel;

public class MainActivity extends BaseMvvmActvity {
    @BindLayout(R.layout.activity_main)
    ActivityMainBinding activityMainBinding;
    @InjectViewModel
    MainActivityModel mainActivityModel;

    Handler handler = new Handler(Looper.getMainLooper());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        final User u = new User("123","1234");
//        mainActivityModel.setUser(u);
//        activityMainBinding.setViewMode(mainActivityModel);
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                u.setName("DDDDDD");
//            }
//        },2000);
        MainFragment mainFragment=new MainFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.li_main, mainFragment, "f1")
                .addToBackStack(MainFragment.class.getSimpleName())
                .commit();
    }
}
