package cn.hydx.util;
import java.sql.*;

public class Demo1 {
	static String sql = null;
	static Dbutils db1 = null;
	static ResultSet ret = null;
	public static void main(String[] args) {
		sql = "select * from User";
		db1 = new Dbutils();
		ResultSet rs = Dbutils.excuteQuery(sql, null);
		try {
			ret = db1.ps.executeQuery();
			while(ret.next()) {
				int U_id = ret.getInt(1);
				String U_name = ret.getString(2);
				String U_phone = ret.getString(3);
				String U_password = ret.getString(4);
				int U_state = ret.getInt(5);
				System.out.println(U_id + " " + U_name + " " + U_phone + " " + U_password + " " + U_state);
			}
			ret.close();
			db1.closeAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}