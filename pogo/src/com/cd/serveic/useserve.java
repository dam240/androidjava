package com.cd.serveic;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cd.dao.usedao;
import com.cd.po.user;
@Component("use")
public class useserve implements serveic {

	private usedao dao;
	
	public usedao getDao() {
		return dao;
	}
	@Resource
	public void setDao(usedao dao) {
		this.dao = dao;
	}
	@Transactional(readOnly=false)
	public boolean usesave(user use) {
		
		
		user r=dao.queryByID(use.getUsername());
		
		if(r!=null){
		
			 System.out.println("dddd");
			 return true;
		}
		
			dao.save(use);
			 System.out.println("aaaa");
	
		
		return false;
	}
	public boolean log(user u) {
		
		user r=dao.queryByID(u.getUsername());
		if(r!=null&&r.getPassword().equals(u.getPassword())){
			
			System.out.println(r.getUsername());
			return true;
		}
		    
			
		return false;
		
		}

}
