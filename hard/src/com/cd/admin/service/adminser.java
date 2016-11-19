package com.cd.admin.service;

import java.util.List;

import com.cd.admin.po.admin;
import com.cd.admin.po.page;
import com.cd.user.po.user;

public interface adminser {

	public boolean  load(admin m);
	public admin use(String id);
	public void upadmin(admin m);
	 public List<user> getlist(page p);
	   public  int getconut();   
	   public void Adelte(String id);
}
