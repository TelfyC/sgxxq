package cn.hydx.pojo;

public class Commodity {
	private int C_id;
	private String C_name;
	private int T_id;
	private int C_price;
	private String C_discripition;
	
	private int C_stock;
	public int getC_id() {
		return C_id;
	}
	@Override
	public String toString() {
		return "Commodity [C_id=" + C_id + ", C_name=" + C_name + ", T_id=" + T_id + ", C_price=" + C_price
				+ ", C_discripition=" + C_discripition + ", C_stock=" + C_stock + "]";
	}
	public void setC_id(int c_id) {
		C_id = c_id;
	}
	public String getC_name() {
		return C_name;
	}
	public void setC_name(String c_name) {
		C_name = c_name;
	}
	public int getT_id() {
		return T_id;
	}
	public void setT_id(int t_id) {
		T_id = t_id;
	}
	public int getC_price() {
		return C_price;
	}
	public void setC_price(int c_price) {
		C_price = c_price;
	}
	public String getC_discripition() {
		return C_discripition;
	}
	public void setC_discripition(String c_discripition) {
		C_discripition = c_discripition;
	}
	public int getC_stock() {
		return C_stock;
	}
	public void setC_stock(int c_stock) {
		C_stock = c_stock;
	}

}
