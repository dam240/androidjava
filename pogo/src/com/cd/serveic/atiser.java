package com.cd.serveic;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.cd.dao.atid;
import com.cd.dao.fy;
import com.cd.model.atibean;
import com.cd.po.alluser;
import com.cd.po.ati;
import com.cd.po.fyin;
import com.cd.po.page;
import com.cd.po.tcp;
@Component("ac")
public class atiser implements atiservice {

	
	private atid at;
	private fy ss;
	
	public fy getSs() {
		return ss;
	}

	@Resource
	public void setSs(fy ss) {
		this.ss = ss;
	}

	public atid getAt() {
		return at;
	}

@Resource
	public void setAt(atid at) {
		this.at = at;
	}


	public void add(ati a) {
		// TODO Auto-generated method stub

		
		at.add(a);
		
	}

	public List<ati> load(String username) {
		// TODO Auto-generated method stub
		return at.load(username);
	}

	
	
	
	

	public atibean li(page u, String username) {
	
		         u=fyin.io(u, at.cout(username));
		     List s=ss.li(u, username);
              atibean f=new atibean();
              f.setHi(u);
              f.setGo(s);
		       
		     
		     
		return f;
	}

	public atibean lia(page u) {
		// TODO Auto-generated method stub
	
		  u= fyin.io(u, at.allcou());
		  List s = ss.alluser(u);
		  
		  atibean f=new atibean();
          f.setHi(u);
          f.setGo(s);
		  
		return f;
	}

	public ati get(int id) {
		// TODO Auto-generated method stub
		return at.get(id);
	}

	public void save(ati a) {
		// TODO Auto-generated method stub
		
		
		at.save(a);
	}

	public boolean pan(tcp p) {
		// TODO Auto-generated method stub
		
		
	if(ss.loadtiem(p)){
	
		return true;
		
	}
		
	return false;
	}

	public void saveand(tcp p) {
		// TODO Auto-generated method stub
	
		at.addtiem(p);
		
	}

	public void allsave(alluser us) {
		// TODO Auto-generated method stub
		System.out.println("aaaaaaaaaaaaa");
		at.allsave(us);
	}

	public List<alluser> goalluse(int aid) {
		// TODO Auto-generated method stub
		return ss.allus(aid);
	}

	
	
	
}
