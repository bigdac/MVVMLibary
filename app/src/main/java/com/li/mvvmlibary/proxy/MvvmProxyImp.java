package com.li.mvvmlibary.proxy;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

import com.li.mvvmlibary.MainActivityModel;
import com.li.mvvmlibary.R;
import com.li.mvvmlibary.Utils.Utils;
import com.li.mvvmlibary.base.BaseMVVMApplication;
import com.li.mvvmlibary.base.Mode;
import com.li.mvvmlibary.databinding.ActivityMainBinding;
import com.li.mvvmlibary.inject.BindLayout;
import com.li.mvvmlibary.inject.InjectViewModel;

import java.io.File;
import java.lang.reflect.Field;

/**
 * @author 版本：1.0
 * 创建日期：2020-12-04 08
 * 描述：
 */
public class MvvmProxyImp<M extends Mode> implements IMvvmProxy {
    private M mMode;
    private ViewGroup mContainer;

    public MvvmProxyImp(M mode) {
        this.mMode = mode;
    }

    public MvvmProxyImp(M mode, ViewGroup container) {
        this.mMode = mode;
        this.mContainer = container;
    }

    @Override
    public void bindContentViewAndCreatViewModel() {
        Field[] fields = mMode.getClass().getDeclaredFields();
        for (Field field : fields) {
            BindLayout bindLayout = field.getAnnotation(BindLayout.class);
            if (bindLayout != null) {
                try {
                    ViewDataBinding viewDataBinding = null;
                    if (mMode instanceof Activity) {
                        Log.e("TAG", "bindContentViewAndCreatViewModel: --->+Activity ");
                        viewDataBinding = DataBindingUtil.setContentView((Activity) mMode, bindLayout.value());
                    } else if (mMode instanceof Fragment) {
                        viewDataBinding = DataBindingUtil.inflate(((Fragment) mMode).getLayoutInflater(),
                                bindLayout.value(), mContainer, false);
                    }

                    field.setAccessible(true);
                    field.set(mMode, viewDataBinding);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            InjectViewModel injectViewModel = field.getAnnotation(InjectViewModel.class);
            if (injectViewModel != null) {
                ViewModelProvider.Factory factory = ViewModelProvider.AndroidViewModelFactory.getInstance(Utils.getCurApplication());
                ViewModelProvider viewModelProvider = new ViewModelProvider((ViewModelStoreOwner) mMode, factory);
                try {
                    Class<? extends ViewModel> presenterClazz = (Class<? extends ViewModel>) field.getType();
                    ViewModel viewModel = viewModelProvider.get(presenterClazz);
                    field.setAccessible(true);
                    field.set(mMode, viewModel);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
