package com.li.mvvmlibary;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

/**
 * @author 版本：1.0
 * 创建日期：2020-12-03 12
 * 描述：
 */
public class User extends BaseObservable {
    private String name;

    private String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }
    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
    }
}
