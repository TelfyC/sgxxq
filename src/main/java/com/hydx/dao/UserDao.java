package com.hydx.dao;

import com.hydx.pojo.User;

import java.sql.ResultSet;

public interface UserDao {
    public int addUser(User user);
    public User getUser(String U_name, String U_pwd);
    public User getUser(int U_id);
    public int updateUser(User user);
    public int deleteUser(int U_id);
    public ResultSet getAllUser();
    public int changeState(int U_id, int U_state);
    public boolean userExist(String U_name);
}
