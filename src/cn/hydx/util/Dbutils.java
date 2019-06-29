package cn.hydx.util;
import java.sql.*;

import cn.hydx.pojo.User;
public class Dbutils {
	protected static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
protected static final String UNAME = "root";
protected static final String UPWD = "123";
protected static final String URL
	="jdbc:mysql://localhost:3307/shopping";
	protected static Connection con = null;
	protected static PreparedStatement ps = null;
	protected static ResultSet rs = null;
	static {
		try {
			Class.forName(DRIVER_CLASS);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	protected static void getConnection() {
		try {
			con = DriverManager.getConnection(URL,UNAME,UPWD);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	protected static int  executeUpdate(String sql,Object[] obj) {
		getConnection();
		int count = 0;
		try {
			ps = con.prepareStatement(sql);
			if(null!=obj) {
				for(int i=0;i<obj.length;i++) {
					ps.setObject(i+1,obj[i]);
				}
							
			}
			count = ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return count;	
	}


protected static void closeAll() {
	if(null!=rs) {
		try {
			rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	if(null!=ps) {
		try {
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	if(null!=con) {
		try {
			con.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}

protected static ResultSet excuteQuery(String sql,Object[] obj) {
	getConnection();
	try {
		ps=con.prepareStatement(sql);
		if(null!=obj) {
			for(int i=0;i<obj.length;i++) {
				ps.setObject(i+1,obj[i]);
			}
		}
		rs=ps.executeQuery();
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return rs;
	}
public User getUser(String U_name, String U_pwd) {
	// TODO Auto-generated method stub
	return null;
}
}