package com.hydx.dao;

import com.hydx.pojo.User;

import java.util.List;

public interface UserDao {
    public int addUser(User user);
    public User getUser(String U_name, String U_pwd);
    public int updateUser(User user);
    public int deleteUser(User user);
    //public List<User> selectAllUser();
}
