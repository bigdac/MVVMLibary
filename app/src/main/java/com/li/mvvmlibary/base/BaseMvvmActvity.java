package com.li.mvvmlibary.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.li.mvvmlibary.proxy.MvvmActvityImp;

/**
 * @author 版本：1.0
 * 创建日期：2020-12-04 08
 * 描述：
 */
public class BaseMvvmActvity extends AppCompatActivity implements Mode {
    private MvvmActvityImp mMvvmActvityImp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMvvmActvityImp = createMVVMActivityImp();
    }

    private MvvmActvityImp createMVVMActivityImp() {
        if (mMvvmActvityImp==null){
            mMvvmActvityImp = new MvvmActvityImp(this);
            mMvvmActvityImp.bindContentViewAndCreatViewModel();

        }
        return mMvvmActvityImp;
    }
}
