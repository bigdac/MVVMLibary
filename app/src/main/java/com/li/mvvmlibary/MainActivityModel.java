package com.li.mvvmlibary;

import androidx.lifecycle.ViewModel;

/**
 * @author 版本：1.0
 * 创建日期：2020-12-03 12
 * 描述：
 */
public class MainActivityModel extends ViewModel {
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
