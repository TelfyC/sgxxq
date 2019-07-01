package com.hydx.servlet;

import com.hydx.dao.ConmodityDao;
import com.hydx.dao.impl.ConmodityDaoImpl;
import com.hydx.dao.impl.UserDaoImpl;
import com.hydx.util.JwtUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteGoods extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("DeleteGoods");
        req.setCharacterEncoding("UTF-8");
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setCharacterEncoding("UTF-8");
        if (req.getParameter("token") != null && !JwtUtils.isVerify(req.getParameter("token"))) {
            resp.setStatus(401);
            return;
        }
        if (req.getParameter("goodsid") != null) {
            int C_id = Integer.parseInt(req.getParameter("goodsid"));
            ConmodityDao conmodityDao = new ConmodityDaoImpl();
            if (conmodityDao.deleteCon(C_id) != 0) {
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
