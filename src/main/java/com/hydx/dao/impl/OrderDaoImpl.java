package com.hydx.dao.impl;

import com.hydx.dao.OrderDao;
import com.hydx.pojo.Order;
import com.hydx.util.Dbutils;

import java.sql.ResultSet;
import java.util.Date;

public class OrderDaoImpl extends Dbutils implements OrderDao {

    @Override
    public int addOrder(Order order) {
        int count;
        String sql = "insert into `order`(U_id, C_id, O_time, O_money, O_amount, O_state) values (?,?,?,?,?,1)";
        Object[] obj = new Object[]{
                order.getU_id(), order.getC_id(), new Date(), order.getO_money(), order.getO_amount()};
        count = super.executeUpdate(sql, obj);
        System.out.println("count" + count);
        return count;
    }

    @Override
    public Order getOrder(int O_id) {
        return null;
    }

    @Override
    public ResultSet getOrders(int U_id) {
        String sql = "select * from `order` where U_id = ?";
        Object[] obj = new Object[]{U_id};
        ResultSet rs = super.excuteQuery(sql, obj);
        return rs;
    }

    @Override
    public int deleteOrder(int O_id) {
        //System.out.println("??");
        int count;
        String sql = "delete from `order` where O_id =" + O_id;
        count = super.executeUpdate(sql, null);
        System.out.println("count" + count);
        return count;
    }

    @Override
    public ResultSet getAllOrder() {
        String sql = "select * from `order`";
        ResultSet rs = super.excuteQuery(sql, null);
        return rs;
    }

    @Override
    public int changeState(int O_id, int O_state) {
        int count;
        String sql = "update `order` set O_state = ? where O_id = ?";
        Object[] obj = new Object[]{O_state, O_id};
        //System.out.println(O_state);
        count = super.executeUpdate(sql, obj);
        System.out.println("count" + count);
        return count;
    }
}
