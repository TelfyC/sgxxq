package com.hydx.servlet;

import com.hydx.dao.ManageDao;
import com.hydx.dao.impl.ManageDaoImpl;
import com.hydx.util.JwtUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteManager extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("DeleteManager");
        req.setCharacterEncoding("UTF-8");
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setCharacterEncoding("UTF-8");
        if (req.getParameter("token") != null && !JwtUtils.isVerify(req.getParameter("token")) || !JwtUtils.isAdmin(req.getParameter("token"))) {
            resp.setStatus(401);
            return;
        }
        if (req.getParameter("M_id") != null) {
            int M_id = Integer.parseInt(req.getParameter("M_id"));
            ManageDao manageDao = new ManageDaoImpl();
            if (manageDao.deleteManage(M_id) != 0) {
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
