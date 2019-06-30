package com.hydx.servlet;

import com.hydx.dao.impl.UserDaoImpl;
import com.hydx.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Access-Control-Allow-Origin", "*");
        String U_name = req.getParameter("username");
        String U_password = req.getParameter("password");
        UserDaoImpl userDao = new UserDaoImpl();
        //System.out.println(userDao.addUser(user));
    }
}
