package cn.hydx.service;
import cn.hydx.pojo.User;

public interface UserBiz {
	public boolean regist();
	public User Login(String U_name,String U_password);
}