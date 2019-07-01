package com.hydx.service;

import com.hydx.pojo.Manage;

public interface ManageBiz {
    public boolean regist();
    public Manage Login(String M_name, String M_password);
    public boolean deleteManage(int M_id);

}