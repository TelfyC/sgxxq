package com.hydx.dao;

import com.hydx.pojo.Manage;

public interface ManageDao {
    public int addManage(Manage manage);
    public Manage getManage(String M_name, String M_pwd);
    public int updateManage(Manage manage);
    public int deleteManage(Manage manage);
}
