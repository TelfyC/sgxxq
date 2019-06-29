package cn.hydx.dao;
import cn.hydx.pojo.User;

public interface UserDao {
	//用户注册
	public int addUser(User user);
	//用户登录
	public User getUser(String U_name,String U_pwd);
	//更新用户
	public int updateUser(User user);
	
	public int deleteUser(User user);
}