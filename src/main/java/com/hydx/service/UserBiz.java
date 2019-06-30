package com.hydx.service;

import com.hydx.pojo.User;

public interface UserBiz {
    public boolean regist();
    public User Login();
    public boolean deleteUser(int U_id);
}