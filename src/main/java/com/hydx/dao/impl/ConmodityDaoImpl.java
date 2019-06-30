package com.hydx.dao.impl;

import com.hydx.dao.ConmodityDao;
import com.hydx.pojo.Conmodity;
import com.hydx.util.Dbutils;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ConmodityDaoImpl extends Dbutils implements ConmodityDao {
    @Override
    public int addCon(Conmodity con) {
        int count;
        String sql = "insert into user(C_name, C_price, C_discription, C_stock, T_id) values (?,?,?,?,?,?)";
        Object[] obj = new Object[]{
                con.getC_name(), con.getC_price(), con.getC_price(), con.getC_discription(), con.getC_stock(), con.getT_id()
        };
        count = super.executeUpdate(sql, obj);
        System.out.println("count" + count);
        return count;
    }

    @Override
    public int deleteCon(int C_id) {
        int count;
        String sql = "delete from conmodity where C_id = " + C_id;
        count = super.executeUpdate(sql, null);
        System.out.println("count" + count);
        return count;
    }

    @Override
    public Conmodity getCon(int C_id) {
        String sql = "select * from conmodity where C_id = " + C_id;
        ResultSet ret = super.excuteQuery(sql, null);
        try {
            return new Conmodity(ret.getInt(1), ret.getString(2), ret.getInt(3),
                    ret.getString(4), ret.getInt(5), ret.getInt(6));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ResultSet getAllCon() {
        String sql = "select * from conmodity";
        ResultSet ret = super.excuteQuery(sql, null);
        return ret;
    }


    @Override
    public int updateCon(Conmodity con) {
        int count;
        String sql = "update conmodity set C_name = ?, C_price = ?, C_discription = ?, C_stock = ?, T_id = ? where C_id = " + con.getC_id();
        Object[] obj = new Object[]{con.getC_name(), con.getC_price(), con.getC_discription(), con.getC_stock(), con.getT_id()};
        count = super.executeUpdate(sql, obj);
        System.out.println("count" + count);
        return count;
    }
}
