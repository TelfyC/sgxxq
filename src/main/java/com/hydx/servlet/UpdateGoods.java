package com.hydx.servlet;

import com.hydx.dao.ConmodityDao;
import com.hydx.dao.impl.ConmodityDaoImpl;
import com.hydx.pojo.Conmodity;
import com.hydx.util.JwtUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateGoods extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("UpdateGoods");
        req.setCharacterEncoding("UTF-8");
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setCharacterEncoding("UTF-8");
        if (req.getParameter("token") != null && !JwtUtils.isVerify(req.getParameter("token")) || !JwtUtils.isAdmin(req.getParameter("token"))) {
            resp.setStatus(401);
            return;
        }
        if (req.getParameter("C_id") != null) {
            int C_id = Integer.parseInt(req.getParameter("C_id"));
            String C_name = req.getParameter("C_name");
            String C_disc = req.getParameter("C_disc");
            double C_price = Double.parseDouble(req.getParameter("C_price"));
            int C_stock = Integer.parseInt(req.getParameter("C_stock"));
            int T_id = Integer.parseInt(req.getParameter("T_id"));
            if(C_stock<0){
                resp.setStatus(400);
                return;
            }
            Conmodity conmodity = new Conmodity(C_id, C_name, C_price, C_disc, C_stock, T_id);
            ConmodityDao conmodityDao = new ConmodityDaoImpl();
            //System.out.println(conmodityDao.toString());
            if (conmodityDao.updateCon(conmodity) != 0) {
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
