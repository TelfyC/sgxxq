package com.hydx.servlet;

import com.hydx.dao.ManageDao;
import com.hydx.dao.impl.ManageDaoImpl;
import com.hydx.dao.impl.UserDaoImpl;
import com.hydx.pojo.Manage;
import com.hydx.pojo.User;
import com.hydx.util.JwtUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginA extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("LoginA");
        req.setCharacterEncoding("UTF-8");
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setCharacterEncoding("UTF-8");
        String U_name = req.getParameter("username");
        String U_password = req.getParameter("password");
        ManageDao manageDao = new ManageDaoImpl();
        Manage manage = manageDao.getManage(U_name, U_password);
        if (manage != null && manage.getM_id() != 0) {
            resp.setStatus(200);
            JwtUtils jwtUtils = new JwtUtils();
            resp.getWriter().write("{\"token\":\"" + jwtUtils.getToken(manage) + "\"," + manage.toString() + "}");
            //System.out.println();
        } else {
            resp.setStatus(401);
        }
    }
}
