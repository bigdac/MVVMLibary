package com.li.mvvmlibary.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.li.mvvmlibary.proxy.MVVMFragmentImp;
import com.li.mvvmlibary.proxy.MvvmActvityImp;

/**
 * @author 版本：1.0
 * 创建日期：2020-12-04 12
 * 描述：
 */
public abstract class BaseMVVMFragment extends Fragment implements Mode{
    private MVVMFragmentImp mMvvmFragmentImp;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mMvvmFragmentImp = createMVVMFragmentImp(container);
        return setCreateView() ;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initAllConfig();
    }

    public abstract void initAllConfig() ;
    public abstract View setCreateView() ;
    private MVVMFragmentImp createMVVMFragmentImp(ViewGroup container ) {
        if (mMvvmFragmentImp==null){
            mMvvmFragmentImp = new MVVMFragmentImp(this,container);
            mMvvmFragmentImp.bindContentViewAndCreatViewModel();

        }
        return mMvvmFragmentImp;
    }
}
