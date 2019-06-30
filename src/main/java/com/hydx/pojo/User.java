package com.hydx.pojo;


public class User {
    private int U_id;
    private String U_name;
    private String U_phone;
    private String U_password;
    private int U_state;

    @Override
    public String toString() {
        return "\"User\":{" +
                "\"U_id\":\"" + U_id +
                "\", \"U_name\":\"" + U_name + "\"" +
                ", \"U_phone\":\"" + U_phone + "\"" +
                ", \"U_state\":\"" + U_state +
                "\"}";
    }

    public int getU_id() {
        return U_id;
    }

    public void setU_id(int u_id) {
        U_id = u_id;
    }

    public String getU_name() {
        return U_name;
    }

    public void setU_name(String u_name) {
        U_name = u_name;
    }

    public String getU_phone() {
        return U_phone;
    }

    public void setU_phone(String u_phone) {
        U_phone = u_phone;
    }

    public String getU_password() {
        return U_password;
    }

    public void setU_password(String u_password) {
        U_password = u_password;
    }

    public int getU_state() {
        return U_state;
    }

    public void setU_state(int u_state) {
        U_state = u_state;
    }

    public User(String u_name, String u_phone, String u_password) {
        U_name = u_name;
        U_phone = u_phone;
        U_password = u_password;
    }

    public User() {
    }

    public User(int u_id, String u_name, String u_phone, String u_password, int u_state) {
        U_id = u_id;
        U_name = u_name;
        U_phone = u_phone;
        U_password = u_password;
        U_state = u_state;
    }
}
