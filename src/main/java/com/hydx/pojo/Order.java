package com.hydx.pojo;

public class Order {
    private int O_id;
    private int U_id;
    private int C_id;
    private String O_time;
    private int O_state;
    private int O_amount;
    private int O_money;

    public Order(int u_id, int c_id, int o_amount, int o_money) {
        U_id = u_id;
        C_id = c_id;
        O_amount = o_amount;
        O_money = o_money;
    }

    @Override
    public String toString() {
        return "\"Order\":{" +
                "\"O_id\":\"" + O_id +
                "\", \"U_id\":\"" + U_id +
                "\", \"C_id\":\"" + C_id +
                "\", \"O_time\":\"" + O_time +
                "\", \"O_state\":\"" + O_state +
                "\", \"O_amount\":\"" + O_amount +
                "\", \"O_money\":\"" + O_money +
                "\"}";
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

    public int getO_state() {
        return O_state;
    }

    public void setO_state(int o_state) {
        O_state = o_state;
    }

    public int getO_amount() {
        return O_amount;
    }

    public void setO_amount(int o_amount) {
        O_amount = o_amount;
    }

    public int getO_money() {
        return O_money;
    }

    public void setO_money(int o_money) {
        O_money = o_money;
    }
}
