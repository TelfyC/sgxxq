package com.hydx.servlet;

import com.hydx.dao.OrderDao;
import com.hydx.dao.impl.OrderDaoImpl;
import com.hydx.dao.impl.UserDaoImpl;
import com.hydx.util.JwtUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChangeOrderState extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ChangeOrderState");
        req.setCharacterEncoding("UTF-8");
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setCharacterEncoding("UTF-8");
        if (req.getParameter("token") != null && !JwtUtils.isVerify(req.getParameter("token")) || !JwtUtils.isAdmin(req.getParameter("token"))) {
            resp.setStatus(401);
            return;
        }
        if (req.getParameter("orderid") != null) {
            int O_id = Integer.parseInt(req.getParameter("orderid"));
            int O_state = Integer.parseInt(req.getParameter("orderstate"));
            OrderDao orderDao = new OrderDaoImpl();
            if (orderDao.changeState(O_id, O_state) != 0) {
                resp.setStatus(200);
                return;
            } else {
                resp.setStatus(400);
                return;
            }
        }
        resp.setStatus(500);
    }
}
