package com.li.mvvmlibary.proxy;

import android.view.ViewGroup;

import com.li.mvvmlibary.base.Mode;

/**
 * @author 版本：1.0
 * 创建日期：2020-12-04 08
 * 描述：
 */
public class MVVMFragmentImp extends MvvmProxyImp implements FragmentProxyImp {
    public MVVMFragmentImp(Mode mode, ViewGroup container) {
        super(mode,container);
    }
}
