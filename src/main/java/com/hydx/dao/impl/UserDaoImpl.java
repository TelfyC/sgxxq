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
        String sql = "delete from user where U_id =" + U_id;
        count = super.executeUpdate(sql, null);
        System.out.println("count" + count);
        return count;
    }

    @Override
    public ResultSet getAllUser() {
        String sql = "select * from user";
        ResultSet rs = super.excuteQuery(sql, null);
        //super.closeAll();
        return rs;
    }

    @Override
    public int changeState(int U_id, int U_state) {
        int count;
        String sql = "update user set U_status = ? where U_id = ?";
        Object[] obj = new Object[]{U_state, U_id};
        count = super.executeUpdate(sql, obj);
        //super.closeAll();
        System.out.println("count" + count);
        return count;
    }

    @Override
    public User getUser(int U_id) {
        String sql = "select * from user where U_id = ?";
        Object[] obj = new Object[]{U_id};
        ResultSet ret = super.excuteQuery(sql, obj);
        if (ret != null) {
            try {
                ret.next();
                return new User(ret.getInt(1), ret.getString(2), ret.getString(3),
                        ret.getString(4), ret.getInt(5));
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                Dbutils.closeAll();
            }
        }
        return null;
    }


    @Override
    public int updateUser(User user) {
        int count;
        String sql = "update user set U_phone = ?, U_password = ? where U_id = " + user.getU_id();
        Object[] obj = new Object[]{user.getU_phone(), user.getU_password()};
        count = super.executeUpdate(sql, obj);
        System.out.println("count" + count);
        return count;
    }

    @Override
    public boolean userExist(String U_name) {
        String sql = "select * from user where U_name = ?";
        Object[] obj = new Object[]{U_name};
        ResultSet ret = super.excuteQuery(sql, obj);
        boolean flag = true;
        try {
            ret.last();
            flag = (ret.getRow() == 0)?false:true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            super.closeAll();
        }
        return flag;
    }

    @Override
    public User getUser(String U_name, String U_pwd) {
        String sql = "select * from user where U_name = ? and U_password = ?";
        Object[] obj = new Object[]{U_name, U_pwd};
        ResultSet ret = super.excuteQuery(sql, obj);
        if (ret != null) {
            try {
                if (ret.next()) {
                    return new User(ret.getInt(1), ret.getString(2), ret.getString(3),
                            ret.getString(4), ret.getInt(5));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                Dbutils.closeAll();
            }
        }
        return null;
    }
}
