package com.hydx.service.impl;

import com.hydx.dao.ManageDao;
import com.hydx.dao.impl.ManageDaoImpl;
import com.hydx.pojo.Manage;
import com.hydx.service.ManageBiz;

import java.util.List;
import java.util.Scanner;

public class ManageBizImpl implements ManageBiz {
    ManageDao user = new ManageDaoImpl();

    @Override
    public boolean regist() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入管理员名：");
        String M_name = sc.next();
        System.out.println("请输入管理员密码：");
        String M_password = sc.next();
        Manage manage1 = new Manage(M_name,M_password);
        user.addManage(manage1);
        System.out.println("注册成功");
        return true;
    }

    @Override
    public Manage Login(String M_name, String M_password) {
        return null;
    }

    public boolean deleteManage(int M_id)
    {
        ManageDao managedao = new ManageDaoImpl();
        int count = managedao.deleteManage(M_id);
        if(count>0)
        {
            return true;
        }
        else
            return false;
    }


}
