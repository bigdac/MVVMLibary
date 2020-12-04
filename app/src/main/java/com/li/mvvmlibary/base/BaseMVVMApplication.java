package com.li.mvvmlibary.base;

import android.app.Application;

import androidx.lifecycle.ViewModelProvider;

/**
 * @author li
 * 版本：1.0
 * 创建日期：2020-12-04 09
 * 描述：
 */
public class BaseMVVMApplication extends Application {
    private static BaseMVVMApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static ViewModelProvider.Factory getViewModeFactory() {
        return ViewModelProvider.AndroidViewModelFactory.getInstance(instance);
    }
}
