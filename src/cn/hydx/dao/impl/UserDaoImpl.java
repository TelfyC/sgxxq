package cn.hydx.dao.impl;

import cn.hydx.dao.UserDao;
import cn.hydx.pojo.User;
import cn.hydx.util.Dbutils;;

public class UserDaoImpl extends Dbutils implements UserDao{
	@Override
	public int addUser(User user){
		int count;
		String sql = "insert into User (U_name,U_phone,U_password,U_status) values (?,?,?,1)";
		Object[] obj = new Object[]{user.getU_name(),user.getU_phone(),user.getU_password()};
		count= super.executeUpdate(sql,obj);
		System.out.println("count"+count);
		return 0;
	}
	@Override
	public int updateUser(User user) {
		int count;
		String sql = "update User set U_phone = ? , U_password = ? where U_id="+user.getU_id();
		Object[] obj = new Object[]{user.getU_phone(),user.getU_password()};
		count= super.executeUpdate(sql,obj);
		System.out.println("count"+count);
		return 0;
	}
	@Override
	public int deleteUser(User user) {
		int count;
		String sql = "delete from User where U_id= " + user.getU_id();
		Object[] obj = new Object[]{user.getU_id()};
		count= super.executeUpdate(sql,obj);
		System.out.println("count"+count);
		return 0;
	}
	@Override
	public User getUser(String U_name,String U_pwd)
	{
		return null;
	}

}