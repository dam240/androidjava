package com.cd.dao;

import com.cd.po.Info;

public interface btdao {

	
	public void save(Info in);

	
	public Info load(String username); 
}
