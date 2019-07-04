package com.hydx.servlet;

import com.hydx.dao.ConmodityDao;
import com.hydx.dao.impl.ConmodityDaoImpl;
import com.hydx.util.Dbutils;
import com.hydx.util.JwtUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetAllGoods extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("GetAllGoods");
        req.setCharacterEncoding("UTF-8");
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setCharacterEncoding("UTF-8");
        if (!JwtUtils.isVerify(req.getParameter("token"))) {
            resp.setStatus(401);
            return;
        }
        ConmodityDao conmodityDao = new ConmodityDaoImpl();
        ResultSet rs = conmodityDao.getAllCon();
        String res = "[";
        try {
            while (rs.next()) {
                res += "{\"C_id\":\"";
                res += rs.getInt(1);
                res += "\",\"T_id\":\"";
                res += rs.getInt(6);
                res += "\",\"C_name\":\"";
                res += rs.getString(2);
                res += "\",\"C_price\":\"";
                res += rs.getDouble(3);
                res += "\",\"C_stock\":\"";
                res += rs.getInt(5);
                res += "\",\"C_disc\":\"";
                res += rs.getString(4);
                res += "\"},";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            resp.setStatus(500);
        }finally {
            Dbutils.closeAll();
        }
        res += "]";
        //res = res.substring(0, res.length()-1);
        //System.out.println(res);
        resp.setStatus(200);
        resp.getWriter().write(res);
    }
}
