package com.hydx.pojo;

public class Order {
    private int O_id;
    private int U_id;
    private int C_id;
    private String O_time;
    private int O_status;
    private int O_number;
    private double O_money;

    @Override
    public String toString() {
        return "Order{" +
                "O_id=" + O_id +
                ", U_id=" + U_id +
                ", C_id=" + C_id +
                ", O_time='" + O_time + '\'' +
                ", O_status=" + O_status +
                ", O_number=" + O_number +
                ", O_money=" + O_money +
                '}';
    }

    public int getO_id() {
        return O_id;
    }

    public void setO_id(int o_id) {
        O_id = o_id;
    }

    public int getU_id() {
        return U_id;
    }

    public void setU_id(int u_id) {
        U_id = u_id;
    }

    public int getC_id() {
        return C_id;
    }

    public void setC_id(int c_id) {
        C_id = c_id;
    }

    public String getO_time() {
        return O_time;
    }

    public void setO_time(String o_time) {
        O_time = o_time;
    }

    public int getO_status() {
        return O_status;
    }

    public void setO_status(int o_status) {
        O_status = o_status;
    }

    public int getO_number() {
        return O_number;
    }

    public void setO_number(int o_number) {
        O_number = o_number;
    }

    public double getO_money() {
        return O_money;
    }

    public void setO_money(double o_money) {
        O_money = o_money;
    }
}
