package com.hydx.dao;

import com.hydx.pojo.Conmodity;

import java.sql.ResultSet;

public interface ConmodityDao {
    public int addCon(Conmodity con);
    public int deleteCon(int C_id);
    public Conmodity getCon(int C_id);
    public int updateCon(Conmodity con);
    public ResultSet getAllCon();
}
