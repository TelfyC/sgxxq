package com.hydx.servlet;

import com.hydx.dao.impl.UserDaoImpl;
import com.hydx.util.JwtUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetAllUser extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("getAlluser");
        req.setCharacterEncoding("UTF-8");
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setCharacterEncoding( "UTF-8");
        //System.out.println(req.getParameter("token"));
        //System.out.println(JwtUtils.isVerify(req.getParameter("token")));
        if (!JwtUtils.isVerify(req.getParameter("token"))|| !JwtUtils.isAdmin(req.getParameter("token"))) {
            resp.setStatus(401);
            return;
        }
        UserDaoImpl userDao = new UserDaoImpl();
        ResultSet rs = userDao.getAllUser();
        String res = "[";
        try {
            while (rs.next()) {
                res += "{\"userid\":\"";
                res += rs.getInt(1);
                res += "\",\"username\":\"";
                res += rs.getString(2);
                res += "\",\"userphone\":\"";
                res += rs.getString(3);
                res += "\",\"userstate\":\"";
                res += rs.getInt(5);
                res += "\"},";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        res += "]";
        //res = res.substring(0, res.length()-1);
        //System.out.println(res);
        resp.setStatus(200);
        resp.getWriter().write(res);
    }
}
