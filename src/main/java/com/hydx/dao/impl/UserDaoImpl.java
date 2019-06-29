package com.hydx.dao.impl;

import com.hydx.dao.UserDao;
import com.hydx.pojo.User;
import com.hydx.util.Dbutils;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl extends Dbutils implements UserDao {
    @Override
    public int addUser(User user) {
        int count;
        String sql = "insert into user(U_name, U_phone, U_password, U_status) values (?,?,?,1)";
        Object[] obj = new Object[]{
                user.getU_name(), user.getU_phone(), user.getU_password()
        };
        count = super.executeUpdate(sql, obj);
        System.out.println("count" + count);
        return count;
    }

    @Override
    public int deleteUser(int U_id) {
        int count;
        String sql = "delete from user where U_id ="+U_id;
        count = super.executeUpdate(sql,null);
        System.out.println("count" + count);
        return count;
    }

    @Override
    public int updateUser(User user) {
        int count;
        String sql = "update user set U_phone = ?, U_password = ? where U_id = " + user.getU_id();
        Object[] obj = new Object[]{user.getU_phone(), user.getU_password()};
        count      = super.executeUpdate(sql, obj);
        System.out.println("count" + count);
        return count;
    }

    @Override
    public User getUser(String U_name, String U_pwd) {
        String sql = "select * from user where U_name = " + U_name + " and U_pwd = " + U_pwd;
        ResultSet ret = super.excuteQuery(sql, null);
        try {
            return new User(ret.getInt(1), ret.getString(2), ret.getString(3),
                    ret.getString(4), ret.getInt(5));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



}
