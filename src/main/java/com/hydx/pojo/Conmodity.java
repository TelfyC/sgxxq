package com.hydx.pojo;

public class Conmodity {
    private int C_id;
    private String C_name;
    private double C_price;
    private String C_discription;
    private int C_stock;
    private int T_id;

    public Conmodity(int c_id, String c_name, double c_price, String c_discription, int c_stock, int t_id) {
        C_id = c_id;
        C_name = c_name;
        C_price = c_price;
        C_discription = c_discription;
        C_stock = c_stock;
        T_id = t_id;
    }

    public Conmodity(String c_name, double c_price, String c_discription, int c_stock, int t_id) {
        C_name = c_name;
        C_price = c_price;
        C_discription = c_discription;
        C_stock = c_stock;
        T_id = t_id;
    }

    @Override
    public String toString() {
        return "Conmodity{" +
                "C_id=" + C_id +
                ", C_name='" + C_name + '\'' +
                ", T_id=" + T_id +
                ", C_price=" + C_price +
                ", C_discription='" + C_discription + '\'' +
                ", C_stock=" + C_stock +
                '}';
    }

    public int getC_id() {
        return C_id;
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

    public double getC_price() {
        return C_price;
    }

    public void setC_price(double c_price) {
        C_price = c_price;
    }

    public String getC_discription() {
        return C_discription;
    }

    public void setC_discription(String c_discription) {
        C_discription = c_discription;
    }

    public int getC_stock() {
        return C_stock;
    }

    public void setC_stock(int c_stock) {
        C_stock = c_stock;
    }
}
