package cn.hydx.dao;
import cn.hydx.pojo.User;

public interface UserDao {
	//�û�ע��
	public int addUser(User user);
	//�û���¼
	public User getUser(String U_name,String U_pwd);
	//�����û�
	public int updateUser(User user);
	
	public int deleteUser(User user);
}