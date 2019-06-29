package cn.hydx.pojo;

public class Manage {
	private int M_id;
	private int M_grade;
	private String M_name;
	private String M_password;
	public int getM_id() {
		return M_id;
	}
	public void setM_id(int m_id) {
		M_id = m_id;
	}
	public int getM_grade() {
		return M_grade;
	}
	public void setM_grade(int m_grade) {
		M_grade = m_grade;
	}
	public String getM_name() {
		return M_name;
	}
	public void setM_name(String m_name) {
		M_name = m_name;
	}
	public String getM_password() {
		return M_password;
	}
	public void setM_password(String m_password) {
		M_password = m_password;
	}
	public int getT_state() {
		return T_state;
	}
	public void setT_state(int t_state) {
		T_state = t_state;
	}
	@Override
	public String toString() {
		return "Manage [M_id=" + M_id + ", M_grade=" + M_grade + ", M_name=" + M_name + ", M_password=" + M_password
				+ ", T_state=" + T_state + "]";
	}
	private int T_state;

}
