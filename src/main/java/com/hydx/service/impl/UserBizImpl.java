package com.hydx.service.impl;

import com.hydx.dao.UserDao;
import com.hydx.dao.impl.UserDaoImpl;
import com.hydx.pojo.User;
import com.hydx.service.UserBiz;

import java.util.List;
import java.util.Scanner;

public class UserBizImpl implements UserBiz {
    UserDao user = new UserDaoImpl();

    @Override
    public boolean regist() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String U_name = sc.next();
        System.out.println("请输入用户手机号：");
        String U_phone = sc.next();
        System.out.println("请输入用户密码：");
        String U_password = sc.next();
        User user1 = new User(U_name, U_phone, U_password);
        user.addUser(user1);
        System.out.println("注册成功");
        return true;
    }

    @Override
    public User Login() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String U_name = sc.next();
        System.out.println("请输入用户密码：");
        String U_password = sc.next();
        UserDaoImpl userDao = new UserDaoImpl();
        User user = userDao.getUser(U_name, U_password);
        return user;
    }

    public boolean deleteUser(int U_id)
    {
        UserDao userdao = new UserDaoImpl();
        int count = userdao.deleteUser(U_id);
        if(count>0)
        {
            return true;
        }
        else
            return false;
    }


}
