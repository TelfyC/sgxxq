package com.hydx.servlet;

import com.hydx.dao.impl.UserDaoImpl;
import com.hydx.pojo.User;
import com.hydx.util.JwtUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Login");
        req.setCharacterEncoding("UTF-8");
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setCharacterEncoding( "UTF-8");
        String U_name = req.getParameter("username");
        String U_password = req.getParameter("password");
        UserDaoImpl userDao = new UserDaoImpl();
        User user = userDao.getUser(U_name, U_password);
        if (user != null && user.getU_id() != 0) {
            resp.setStatus(200);
            JwtUtils jwtUtils = new JwtUtils();
            resp.getWriter().write("{\"token\":\"" + jwtUtils.getToken(user) + "\"," + user.toString() + "}");
        } else {
            resp.setStatus(401);
        }
    }
}
