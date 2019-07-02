package com.hydx.servlet;

import com.hydx.dao.impl.UserDaoImpl;
import com.hydx.util.JwtUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChangeUserState extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ChangeUserState");
        req.setCharacterEncoding("UTF-8");
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setCharacterEncoding( "UTF-8");
        if (req.getParameter("token") != null && !JwtUtils.isVerify(req.getParameter("token"))|| !JwtUtils.isAdmin(req.getParameter("token"))) {
            resp.setStatus(401);
            return;
        }
        if (req.getParameter("userid") != null) {
            int U_id = Integer.parseInt(req.getParameter("userid"));
            int U_state = Integer.parseInt(req.getParameter("userstate"));
            UserDaoImpl userDao = new UserDaoImpl();
            if (userDao.changeState(U_id, U_state) != 0) {
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
