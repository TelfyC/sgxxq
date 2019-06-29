package com.hydx.dao.impl;

import com.hydx.dao.ManageDao;
import com.hydx.pojo.Manage;
import com.hydx.util.Dbutils;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ManageDaoImpl extends Dbutils implements ManageDao {
    @Override
    public int addManage(Manage manage) {
        int count;
        String sql = "insert into manage(M_name, M_password, M_status) values (?,?,1)";
        Object[] obj = new Object[]{
                manage.getM_name(), manage.getM_password()
        };
        count = super.executeUpdate(sql, obj);
        System.out.println("count" + count);
        return count;
    }

    @Override
    public int deleteManage(int M_id) {
        int count;
        String sql = "delete from manage where M_id = " +M_id;
        count = super.executeUpdate(sql, null);
        System.out.println("count" + count);
        return count;
    }

    @Override
    public int updateManage(Manage manage) {
        int count;
        String sql = "update manage set  M_password = ? where M_id = " + manage.getM_id();
        Object[] obj = new Object[]{manage.getM_password()};
        count = super.executeUpdate(sql, obj);
        System.out.println("count" + count);
        return count;
    }

    @Override
    public Manage getManage(String M_name, String M_pwd) {
        String sql = "select * from user where M_name = " + M_name + " and M_pwd = " + M_pwd;
        ResultSet ret = super.excuteQuery(sql, null);
        try {
            return new Manage(ret.getInt(1), ret.getString(2),
                    ret.getString(3),ret.getString(4),ret.getInt(5));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
