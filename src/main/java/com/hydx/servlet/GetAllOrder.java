package com.hydx.servlet;

import com.hydx.dao.ConmodityDao;
import com.hydx.dao.OrderDao;
import com.hydx.dao.UserDao;
import com.hydx.dao.impl.ConmodityDaoImpl;
import com.hydx.dao.impl.OrderDaoImpl;
import com.hydx.dao.impl.UserDaoImpl;
import com.hydx.pojo.Conmodity;
import com.hydx.pojo.User;
import com.hydx.util.Dbutils;
import com.hydx.util.JwtUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetAllOrder extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("GetAllOrder");
        req.setCharacterEncoding("UTF-8");
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setCharacterEncoding("UTF-8");
        if (!JwtUtils.isVerify(req.getParameter("token"))|| !JwtUtils.isAdmin(req.getParameter("token"))) {
            resp.setStatus(401);
            return;
        }
        OrderDao orderDao = new OrderDaoImpl();
        ResultSet rs = orderDao.getAllOrder();
        UserDao userDao = new UserDaoImpl();
        ConmodityDao conmodityDao = new ConmodityDaoImpl();
        String res = "[";
        try {
            while (rs.next()) {
                User user = userDao.getUser(rs.getInt(2));
                Conmodity conmodity = conmodityDao.getCon(rs.getInt(3));
                res += "{\"orderid\":\"";
                res += rs.getInt(1);
                res += "\",\"time\":\"";
                res += rs.getString(4);
                res += "\",\"userid\":\"";
                res += rs.getInt(2);
                res += "\",\"username\":\""+user.getU_name();
                res += "\",\"goodsid\":\"";
                res += rs.getInt(3);
                res += "\",\"goodsname\":\""+conmodity.getC_name();
                res += "\",\"goodsnumber\":\"";
                res += rs.getInt(7);
                res += "\",\"orderstate\":\"";
                res += rs.getInt(6);
                res += "\",\"paymoney\":\"";
                res += rs.getDouble(5);
                res += "\"},";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Dbutils.closeAll();
        }
        res += "]";
        resp.setStatus(200);
        resp.getWriter().write(res);
    }
}
