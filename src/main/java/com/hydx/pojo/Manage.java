package com.hydx.pojo;

import java.security.PrivateKey;

public class Manage {
    private int M_id;
    private String M_name;
    private String M_grade;//权限等级
    private String M_password;
    private int M_status;

    @Override
    public String toString() {
        return "\"Manage\":{" +
                "\"M_id\":\"" + M_id +
                "\", \"M_name\":\"" + M_name +
                "\", \"M_grade\":\"" + M_grade +
                "\"}";
    }

    public Manage(int m_id, String m_name, String m_grade, String m_password, int m_status) {
        M_id = m_id;
        M_name = m_name;
        M_grade = m_grade;
        M_password = m_password;
        M_status = m_status;
    }

    public Manage(String m_name, String m_password) {
        M_name = m_name;
        M_password = m_password;
    }

    public int getM_id() {
        return M_id;
    }

    public void setM_id(int m_id) {
        M_id = m_id;
    }

    public String getM_name() {
        return M_name;
    }

    public void setM_name(String m_name) {
        M_name = m_name;
    }

    public String getM_grade() {
        return M_grade;
    }

    public void setM_grade(String m_grade) {
        M_grade = m_grade;
    }

    public String getM_password() {
        return M_password;
    }

    public void setM_password(String m_password) {
        M_password = m_password;
    }

    public int getM_status() {
        return M_status;
    }

    public void setM_status(int m_status) {
        M_status = m_status;
    }
}
