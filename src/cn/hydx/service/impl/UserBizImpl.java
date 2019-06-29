package cn.hydx.service.impl;
import java.util.Scanner;

import cn.hydx.pojo.User;
import cn.hydx.dao.UserDao;
import cn.hydx.dao.impl.UserDaoImpl;
import cn.hydx.service.UserBiz;

public class UserBizImpl implements UserBiz{
	UserDao user = new UserDaoImpl();
	public boolean regist(){
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入用户名称");
		String U_name = sc.next();
		System.out.println("请输入手机号");
		String U_phone = sc.next();
		System.out.println("请输入用户密码");
		String U_password = sc.next();
		User user1 = new User();
		UserDao user = new UserDaoImpl();
		
		user1.setU_name(U_name);
		user1.setU_phone(U_phone);
		user1.setU_password(U_password);
		user.addUser(user1);
		System.out.println(" Sucess! ");
		return false;
	}
	public User Login(String U_name,String U_pwd){
		return null;
	}
}