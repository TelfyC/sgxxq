package com.hydx.servlet;

import com.hydx.dao.impl.UserDaoImpl;
import com.hydx.util.JwtUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteUser extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("DeleteUser");
        resp.setHeader("Access-Control-Allow-Origin", "*");
        if (req.getParameter("token") != null && !JwtUtils.isVerify(req.getParameter("token"))) {
            resp.setStatus(401);
            return;
        }
        if(req.getParameter("userid") != null) {
            int U_id = Integer.parseInt(req.getParameter("userid"));
            UserDaoImpl userDao = new UserDaoImpl();
            if (userDao.deleteUser(U_id) != 0) {
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
