package com.cd.serveic;

import java.util.List;

import com.cd.model.atibean;
import com.cd.po.alluser;
import com.cd.po.ati;
import com.cd.po.page;
import com.cd.po.tcp;

public interface atiservice {

	public void add(ati a);

	public void save(ati a);
	  public List<ati> load(String username);

	     
	     public atibean li(page u,String username);
	     

	     public atibean lia(page u);
	     
	     
	     public ati get(int id);
	     
	    
	     public boolean pan(tcp p);
	     
	    

	     public void saveand(tcp p);

	     public void allsave(alluser us);
	     
	     public List <alluser> goalluse(int aid);
}
