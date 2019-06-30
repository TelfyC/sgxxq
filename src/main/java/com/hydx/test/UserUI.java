package com.hydx.test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.hydx.dao.ConmodityDao;
import com.hydx.dao.impl.ConmodityDaoImpl;
import com.hydx.pojo.Conmodity;
import com.hydx.pojo.Manage;
import com.hydx.pojo.User;
import com.hydx.service.*;
import com.hydx.service.impl.*;
import com.hydx.util.JwtUtils;
import io.jsonwebtoken.Jwts;

public class UserUI {
    Scanner sc = new Scanner(System.in);

    public void welcome() {
        System.out.println("---------------------------------");
        System.out.println("-------wxx 商城------------------");
        System.out.println("");
        System.out.println("--1.注册  2.delete 商品  3.delete 管理员  4.用户登录  5.管理员登录  6.查询商品 7.删除商品----");
        System.out.println("---- choose  --");
        String chooseNum = sc.next();
        switch (chooseNum) {
            case "1":
                UserBizImpl user = new UserBizImpl();
                user.regist();
                break;
            case "2":
                System.out.println("Please choose delete  Conmodity id");
                int C_id = sc.nextInt();
                ConmodityBiz conmodity1 = new ConmodityBizImpl();
                conmodity1.deleteCon(C_id);
                break;

            case "3":
                System.out.println("Please choose delete  Manager id");
                int M_id = sc.nextInt();
                ManageBiz manage1 = new ManageBizImpl();
                manage1.deleteManage(M_id);
                break;

            case "4":
                UserBizImpl userBiz = new UserBizImpl();
                User user1 = userBiz.Login();
                JwtUtils jwtUtils = new JwtUtils();
                jwtUtils.isVerify(jwtUtils.getToken(user1));
                break;
            case "6":
                System.out.println("show commodity");
                ConmodityDao conmodity2 = new ConmodityDaoImpl();
                ResultSet rs = conmodity2.getAllCon();
                try {
                    while (rs.next()) {
                        Conmodity c = new Conmodity(rs.getInt(1),
                                rs.getString(2),
                                rs.getInt(3),
                                rs.getString(4),
                                rs.getInt(5),
                                rs.getInt(6));
                        System.out.println(c.toString());
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    public static void main(String[] args) {
        UserUI u = new UserUI();
        u.welcome();
    }

}
