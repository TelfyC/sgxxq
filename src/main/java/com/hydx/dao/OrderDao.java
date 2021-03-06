package com.hydx.dao;


import com.hydx.pojo.Order;

import java.sql.ResultSet;

public interface OrderDao {
    public int addOrder(Order order);

    public Order getOrder(int O_id);
    public ResultSet getOrders(int U_id);
    public int deleteOrder(int O_id);

    public ResultSet getAllOrder();
    public boolean UserOrderExist(int U_id);
    public int changeState(int O_id, int O_state);
}
