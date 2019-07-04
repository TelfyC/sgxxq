package com.hydx.servlet;

import com.hydx.dao.impl.UserDaoImpl;
import com.hydx.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Register extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Register");
        req.setCharacterEncoding("UTF-8");
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setCharacterEncoding( "UTF-8");
        String U_name = req.getParameter("username");
        String U_password = req.getParameter("password");
        String U_phone = req.getParameter("phone");
        User user = new User(U_name, U_phone, U_password);
        UserDaoImpl userDao = new UserDaoImpl();
        if(userDao.userExist(U_name)){
            resp.setStatus(418);
            return;
        }
        System.out.println(userDao.addUser(user));
        resp.setStatus(200);
    }
}
