package com.hydx.dao;

import com.hydx.pojo.Conmodity;

public interface ConmodityDao {
    public int addCon(Conmodity con);
    public int deleteCon(Conmodity con);
    public Conmodity getCon(int C_id);
    public int updateCon(Conmodity con);
}
