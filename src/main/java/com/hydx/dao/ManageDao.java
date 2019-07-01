package com.hydx.dao;

import com.hydx.pojo.Manage;

import java.sql.ResultSet;

public interface ManageDao {
    public int addManage(Manage manage);
    public Manage getManage(String M_name, String M_pwd);
    public int updateManage(Manage manage);
    public int deleteManage(int M_id);
    public ResultSet getAllManager();
}
