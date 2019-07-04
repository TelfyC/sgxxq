package com.hydx.servlet;

import com.hydx.dao.ConmodityDao;
import com.hydx.dao.OrderDao;
import com.hydx.dao.impl.ConmodityDaoImpl;
import com.hydx.dao.impl.OrderDaoImpl;
import com.hydx.pojo.Conmodity;
import com.hydx.pojo.Order;
import com.hydx.util.JwtUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Purchase extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Purchase");
        req.setCharacterEncoding("UTF-8");
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setCharacterEncoding("UTF-8");
        if (!JwtUtils.isVerify(req.getParameter("token"))) {
            resp.setStatus(401);
            return;
        }
        int U_id = JwtUtils.getUid(req.getParameter("token"));
        String ts = req.getParameter("goods[0][C_id]");
        int C_id = Integer.parseInt(ts != null ? ts : "-1");
        ts = req.getParameter("goods[0][C_number]");
        int C_amount = Integer.parseInt(ts != null ? ts : "-1");
        int i = 1;
        OrderDao orderDao = new OrderDaoImpl();
        //System.out.println(C_id);
        while (C_id != -1) {
            ConmodityDao conmodityDao = new ConmodityDaoImpl();
            Conmodity conmodity = conmodityDao.getCon(C_id);
            double money = conmodity.getC_price();
            System.out.println(money);
            Order order = new Order(U_id, C_id, C_amount, money * C_amount);
            //System.out.println(money*C_amount);
            if(conmodity.getC_stock() < 0 || conmodity.getC_stock() - C_amount<0){
                resp.setStatus(400);
                return;
            }
            conmodity.setC_stock(conmodity.getC_stock() - C_amount);
            conmodityDao.updateCon(conmodity);
            System.out.println(order);
            orderDao.addOrder(order);
            ts = req.getParameter("goods[" + i + "][C_id]");
            C_id = Integer.parseInt(ts != null ? ts : "-1");
            ts = req.getParameter("goods[" + i + "][C_number]");
            C_amount = Integer.parseInt(ts != null ? ts : "-1");
            i++;
        }
        resp.setStatus(200);
    }
}
