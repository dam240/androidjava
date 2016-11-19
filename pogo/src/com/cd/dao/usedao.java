package com.cd.dao;

import java.util.List;

import com.cd.po.user;

public interface  usedao {

	

	public void save(user use);
	
	
	public void delete(user use);
	
	
	public void update(user use);
	
	
	public List queryAll();
	
	
	public user queryByID(String username);

}
