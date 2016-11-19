package com.cd.admin.dao;

import java.util.List;

import com.cd.admin.po.admin;
import com.cd.user.po.user;

public interface adminL {


	public admin load(String id);
	public void upadmin(admin m);
    public List<user> getlist();
    public  int getconut();  
    public void Adelte(String id);
    
}
