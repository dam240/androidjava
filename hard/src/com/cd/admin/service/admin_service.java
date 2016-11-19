package com.cd.admin.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.cd.admin.dao.adminL;
import com.cd.admin.dao.fen;
import com.cd.admin.po.admin;
import com.cd.admin.po.page;
import com.cd.user.po.user;

@Service("adminS")
public class admin_service implements adminser{

	
	private adminL admindao;
	private fen adminda;


    @Resource
	public void setAdminda(fen adminda) {
		this.adminda = adminda;
	}


	@Resource
	public void setAdmindao(adminL admindao) {
		this.admindao = admindao;
	}


	public boolean load(admin m) {
		// TODO Auto-generated method stub
		
		
		boolean b=false;
		admin mi = null;
		 try {
			 
			 
		if(mi==null){
			mi= admindao.load(m.getId());
			
			 }
			  if(mi!=null){
				  
				  if(mi.getId().equals(m.getId())&&mi.getPassword().equals(m.getPassword())){
					  
					   
					  
					  b=true;
					  
				  }
				  
				  
			  }
			 
			 
			
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
			b=false;
		}
		
		
		
		
		return b;
	}


	public admin use(String id) {
		// TODO Auto-generated method stub
		
		   	return  admindao.load(id);
	}


	public void upadmin(admin m) {
		// TODO Auto-generated method stub
		
		admindao.upadmin(m);
	}


	public List<user> getlist(page p) {
		// TODO Auto-generated method stub
		return adminda.getlist(p.getIndex(), p.getSize());
	}


	public int getconut() {
		// TODO Auto-generated method stub
		return admindao.getconut();
	}


	public void Adelte(String id) {
		// TODO Auto-generated method stub
		admindao.Adelte(id);
	}


}
