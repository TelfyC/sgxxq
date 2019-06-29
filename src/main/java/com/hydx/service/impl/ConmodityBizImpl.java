package com.hydx.service.impl;

import com.hydx.dao.ConmodityDao;
import com.hydx.dao.UserDao;
import com.hydx.dao.impl.ConmodityDaoImpl;
import com.hydx.pojo.Conmodity;
import com.hydx.service.ConmodityBiz;

import java.util.List;
import java.util.Scanner;

public class ConmodityBizImpl implements ConmodityBiz {
    ConmodityDao user = new ConmodityDaoImpl();

    @Override
    public boolean regist() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入商品名；");
        String C_name = sc.next();
        System.out.println("请输入商品价格：");
        int C_price = sc.nextInt();
        System.out.println("请输入商品描述：");
        String C_discription = sc.next();
        System.out.println("请输入商品库存：");
        int C_stock = sc.nextInt();
        System.out.println("请输入商品类型id：");
        int T_id = sc.nextInt();
        Conmodity conmodity1 = new Conmodity(C_name, C_price, C_discription, C_stock, T_id);
        user.addCon(conmodity1);
        System.out.println("添加成功");
        return true;
    }


    public boolean deleteCon(int C_id) {
        ConmodityDao conmoditydao = new ConmodityDaoImpl();
        int count = conmoditydao.deleteCon(C_id);
        if (count > 0) {
            return true;
        } else
            return false;
    }
    public  void getAllCon()
    {
        ConmodityDao conmoditydao = new ConmodityDaoImpl();
        conmoditydao.getAllCon();
    }


}
