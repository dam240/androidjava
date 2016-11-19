package com.cd.user.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cd.user.dao.userMapper;

import com.cd.user.po.care;
import com.cd.user.po.care1;
import com.cd.user.po.friend;
import com.cd.user.po.tool;
import com.cd.user.po.tool2;
import com.cd.user.po.user;


@Service("uservice")
public class user_service implements user_ser{

	
	private userMapper usedao; 
	


	public void save(user u) {
		// TODO Auto-generated method stub
		usedao.save(u);
	}

	@Resource
	public void setUsedao(userMapper usedao) {
		this.usedao = usedao;
	}

	public boolean userload(String id) {
		// TODO Auto-generated method stub
		
		
		boolean b=false;
		
		try{
   user u=usedao.userload(id);

   if(u!=null){
	 String ua=u.getUser_id();
	   if(ua!=null&&!ua.equals("")){
		  	
		  b=true;
		   
		   
		   }
      }
   
		}catch (Exception e) {
			// TODO: handle exception
			
			b=false;
			e.printStackTrace();
			
			
		}
   
	
	return b;
	
	}

	public boolean login(user u) {
		// TODO Auto-generated method stub

		boolean b=false;
		
		try{
   user myou=usedao.userload(u.getUser_id());

   if(myou!=null){
	 String ua=myou.getUser_id();
	   if(ua!=null&&!ua.equals("")){
		  
		   if(myou.getPassword().equals(u.getPassword())){
			   
			   
			   b=true;
			   
		   }
		   
		   
		   }
      }
   
		}catch (Exception e) {
			// TODO: handle exception
			
			b=false;
			e.printStackTrace();
			
			
		}
   
	
	return b;
	}

	public user load(String id) {
		// TODO Auto-generated method stub
		return usedao.userload(id);
	}

	public void upuser(user u) {
		// TODO Auto-generated method stub
		usedao.upuser(u);
	}

	public List<user> mycare(tool t) {
		// TODO Auto-generated method stub
		return usedao.mycare(t);
	}

	public int countcare(String id) {
		// TODO Auto-generated method stub
		return usedao.countcare(id);
	}

	public int carecount(String id) {
		// TODO Auto-generated method stub
		return usedao.carecount(id);
	}

	public List<user> caremy(tool t) {
		// TODO Auto-generated method stub
		return usedao.caremy(t);
	}

	public List<user> carelike(tool2 t) {
		// TODO Auto-generated method stub
		return usedao.selectlike(t);
	}

	public int usercount(tool2 t) {
		// TODO Auto-generated method stub
		return usedao.usercount(t);
	}

	public int myand(tool2 t) {
		// TODO Auto-generated method stub
		return usedao.myand(t);
	}

	public void insertmyg(tool2 t) {
		// TODO Auto-generated method stub
		
		usedao.insertmyg(t);
		
	}

	public void deletecare(tool2 id) {
		// TODO Auto-generated method stub
		usedao.deletecare(id);
	}

	public void insertfriend(friend f) {
		// TODO Auto-generated method stub
		usedao.insertfriend(f);
	}

	public List<user> seeF(String id) {
		// TODO Auto-generated method stub
		return usedao.seeF(id);
	}

	public void upfriend(friend f) {
		// TODO Auto-generated method stub
		usedao.upfriend(f);
	}

	public void deleteF(friend f) {
		// TODO Auto-generated method stub
	
		usedao.deleteF(f);
		
	}

	public user seeMYF(friend f) {
		// TODO Auto-generated method stub
		return usedao.seeMYF(f);
	}

	public List<user> seelistF(String id) {
		// TODO Auto-generated method stub
		return usedao.seelistF(id);
	}

	public List<user> failF(String id) {
		// TODO Auto-generated method stub
		return usedao.failF(id);
	}

}
