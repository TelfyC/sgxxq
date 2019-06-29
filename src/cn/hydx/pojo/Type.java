package cn.hydx.pojo;

public class Type {
	private int T_id;
	private String T_name;
	@Override
	public String toString() {
		return "Type [T_id=" + T_id + ", T_name=" + T_name + "]";
	}
	public int getT_id() {
		return T_id;
	}
	public void setT_id(int t_id) {
		T_id = t_id;
	}
	public String getT_name() {
		return T_name;
	}
	public void setT_name(String t_name) {
		T_name = t_name;
	}


}
