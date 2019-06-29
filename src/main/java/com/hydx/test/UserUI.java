package com.hydx.test;

import java.util.Scanner;
import com.hydx.service.impl.UserBizImpl;

public class UserUI {
    Scanner sc = new Scanner(System.in);

    public void welcome() {
        System.out.println("---------------------------------");
        System.out.println("-------wxx 商城------------------");
        System.out.println("");
        System.out.println("--1.注册    2.登录     3.退出----");
        System.out.println("----choose---");
        String chooseNum = sc.next();
        switch (chooseNum) {
            case "1":
                UserBizImpl user = new UserBizImpl();
                user.regist();
                break;
            case "2":
                ;
            case "3":
                ;
        }
    }

    public static void main(String[] args) {
        UserUI u = new UserUI();
        u.welcome();
    }

}
