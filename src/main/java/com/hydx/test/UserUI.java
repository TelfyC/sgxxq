package com.hydx.test;

import java.util.Scanner;

import com.hydx.pojo.Conmodity;
import com.hydx.pojo.Manage;
import com.hydx.service.*;
import com.hydx.service.impl.*;

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

            case "6":
                System.out.println("show conmodity");
                ConmodityBiz conmodity2 = new ConmodityBizImpl();
                conmodity2.getAllCon();
                break;
        }
    }

    public static void main(String[] args) {
        UserUI u = new UserUI();
        u.welcome();
    }

}
