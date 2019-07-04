package com.hydx.servlet;

import com.hydx.dao.ConmodityDao;
import com.hydx.dao.OrderDao;
import com.hydx.dao.impl.ConmodityDaoImpl;
import com.hydx.dao.impl.OrderDaoImpl;
import com.hydx.util.Dbutils;
import com.hydx.util.JwtUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetOrders extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("GetOrders");
        req.setCharacterEncoding("UTF-8");
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setCharacterEncoding("UTF-8");
        if (!JwtUtils.isVerify(req.getParameter("token"))) {
            resp.setStatus(401);
            return;
        }
        int U_id = JwtUtils.getUid(req.getParameter("token"));
        OrderDao orderDao = new OrderDaoImpl();
        ResultSet rs = orderDao.getOrders(U_id);
        String res = "[";
        ConmodityDao conmodityDao = new ConmodityDaoImpl();
        try {
            while(rs.next()){
                res += "{\"O_id\":\"";
                res += rs.getInt(1);
                res += "\",\"O_time\":\"";
                res += rs.getString(4);
                res += "\",\"C_name\":\"";
                int C_id = rs.getInt(3);
                res += conmodityDao.getCon(C_id).getC_name();
                res += "\",\"O_amount\":\"";
                res += rs.getInt(7);
                res += "\",\"O_state\":\"";
                res += rs.getInt(6);
                res += "\",\"O_money\":\"";
                res += rs.getDouble(5);
                res += "\"},";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            resp.setStatus(500);
        }finally {
            Dbutils.closeAll();
        }
        res += "]";
        resp.setStatus(200);
        resp.getWriter().write(res);
    }
}
