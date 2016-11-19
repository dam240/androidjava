package com.cd.dao;

import java.util.List;

import com.cd.po.alluser;
import com.cd.po.ati;
import com.cd.po.tcp;

public interface atid {

	  
	public void addtiem(tcp a);
	
	public void add(ati ai);

	public void save(ati ai);
     public List<ati> load(String username);

     
     public int cout(String username);

    public int allcou();

    
    public ati get(int id);

    public void allsave(alluser us);
    
}
