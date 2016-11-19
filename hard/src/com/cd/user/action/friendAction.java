package com.cd.user.action;

import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cd.user.po.Tools;
import com.cd.user.po.care;
import com.cd.user.po.friend;
import com.cd.user.po.tool2;
import com.cd.user.po.user;
import com.cd.user.service.user_ser;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
@Controller("friendA")
@Scope("prototype")
public class friendAction extends ActionSupport {
	
	private user_ser uservice;
	 private String user_id;
	 private String you;

	 
	 
	
	
@Resource
	public void setUservice(user_ser uservice) {
		this.uservice = uservice;
	}




	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}



	public void setYou(String you) {
		this.you = you;
	}







	public void insertF()throws Exception{
		HttpServletResponse  http=ServletActionContext.getResponse();
		http.setCharacterEncoding("utf-8");
		http.setContentType("text/html;charset=UTF-8");
		PrintWriter p =http.getWriter();
		

		if(this.user_id!=null&&!this.user_id.equals("")&&this.you!=null&&!this.you.equals("")){
			
			boolean b=uservice.userload(user_id);
			
        	if(b){
		            		
                              
        		  friend f=new friend();
        		  f.setMy(user_id);
        		  f.setYou(you);
        		  f.setAcctp(1);
        		  f.setDate(new Date().toLocaleString());
        		    
        		  uservice.insertfriend(f);
        		  
        		  p.println("申请好友");
        		  
			
        	}else{
        		
        		
        		p.println("用户id不对！");
        	}
        	
			
			
		}else{
			
			p.println("用户不为空");
		}
		
		
		
		
	p.close();
		
	}
	 
	
	
	
	
	public void seeMYF()throws Exception{
		HttpServletResponse  http=ServletActionContext.getResponse();
		http.setCharacterEncoding("utf-8");
		http.setContentType("text/html;charset=UTF-8");
		PrintWriter p =http.getWriter();
		

		if(this.user_id!=null&&!this.user_id.equals("")&&this.you!=null&&!this.you.equals("")){
			
			boolean b=uservice.userload(user_id);
			
        	if(b){
		            		
        		   friend f=new friend();
        		    f.setMy(user_id);
        		    f.setYou(you);
        		    
                user li=uservice.seeMYF(f);                 
        	
                   Gson g=new Gson();
                   String text  = g.toJson(li); 
        		  
			         p.println(text);
                   
                   
        	}else{
        		
        		
        		p.println("用户id不对！");
        	}
        	
			
			
		}else{
			
			p.println("用户不为空");
		}
		
		
		
		
	p.close();
		
	}
	


	
	
	public void seelistF()throws Exception{
		HttpServletResponse  http=ServletActionContext.getResponse();
		http.setCharacterEncoding("utf-8");
		http.setContentType("text/html;charset=UTF-8");
		PrintWriter p =http.getWriter();
		

		if(this.user_id!=null&&!this.user_id.equals("")){
			
			boolean b=uservice.userload(user_id);
			
        	if(b){
		            		
        		
        		    
                List<user> li=uservice.seelistF(user_id);                 
        	
                   Gson g=new Gson();
                   String text  = g.toJson(li); 
        		  
			         p.println(text);
                   
                   
        	}else{
        		
        		
        		p.println("用户id不对！");
        	}
        	
			
			
		}else{
			
			p.println("用户不为空");
		}
		
		
		
		
	p.close();
		
	}
	

	
	
	public void failF()throws Exception{
		HttpServletResponse  http=ServletActionContext.getResponse();
		http.setCharacterEncoding("utf-8");
		http.setContentType("text/html;charset=UTF-8");
		PrintWriter p =http.getWriter();
		

		if(this.user_id!=null&&!this.user_id.equals("")){
			
			boolean b=uservice.userload(user_id);
			
        	if(b){
		            		
        		
        		    
                List<user> li=uservice.failF(user_id);                 
        	
                   Gson g=new Gson();
                   String text  = g.toJson(li); 
        		  
			         p.println(text);
                   
                   
        	}else{
        		
        		
        		p.println("用户id不对！");
        	}
        	
			
			
		}else{
			
			p.println("用户不为空");
		}
		
		
		
		
	p.close();
		
	}
	
	

	
	public void seeF()throws Exception{
		HttpServletResponse  http=ServletActionContext.getResponse();
		http.setCharacterEncoding("utf-8");
		http.setContentType("text/html;charset=UTF-8");
		PrintWriter p =http.getWriter();
		

		if(this.user_id!=null&&!this.user_id.equals("")){
			
			boolean b=uservice.userload(user_id);
			
        	if(b){
		            		
        		
        		    
                List<user> li=uservice.seeF(user_id);                 
        	
                   Gson g=new Gson();
                   String text  = g.toJson(li); 
        		  
			         p.println(text);
                   
			         care c=new care();
			          c.setNow(1);
			         
			          String now=g.toJson(c);
			          
			            p.println(now);
			          
                   
        	}else{
        		
        		
        		p.println("用户id不对！");
        	}
        	
			
			
		}else{
			
			p.println("用户不为空");
		}
		
		
		
		
	p.close();
		
	}
	
	



	public void upfriend()throws Exception{
		HttpServletResponse  http=ServletActionContext.getResponse();
		http.setCharacterEncoding("utf-8");
		http.setContentType("text/html;charset=UTF-8");
		PrintWriter p =http.getWriter();
		

		if(this.user_id!=null&&!this.user_id.equals("")&&this.you!=null&&!this.you.equals("")){
			
			boolean b=uservice.userload(user_id);
			
        	if(b){
		            		
                              
        		  friend f=new friend();
        		  f.setMy(user_id);
        		  f.setYou(you);
        		  f.setAcctp(2);
        	
        		  
        		  
        		    
        		  uservice.upfriend(f);
        		  
        		  friend f1=new friend();
        		  f1.setMy(user_id);
        		  f1.setYou(you);
        		  f1.setAcctp(2);
        		  f1.setDate(new Date().toLocaleString());
        		    
        		  uservice.insertfriend(f1);
        		  
        		  p.println("申请好友");
        		  
			
        	}else{
        		
        		
        		p.println("用户id不对！");
        	}
        	
			
			
		}else{
			
			p.println("用户不为空");
		}
		
		
		
		
	p.close();
		
	}
	 
	
	
	



	public void jiefriend()throws Exception{
		HttpServletResponse  http=ServletActionContext.getResponse();
		http.setCharacterEncoding("utf-8");
		http.setContentType("text/html;charset=UTF-8");
		PrintWriter p =http.getWriter();
		

		if(this.user_id!=null&&!this.user_id.equals("")&&this.you!=null&&!this.you.equals("")){
			
			boolean b=uservice.userload(user_id);
			
        	if(b){
		            		
                              
        		  friend f=new friend();
        		  f.setMy(user_id);
        		  f.setYou(you);
        		  f.setAcctp(3);
        	
        		  
        		  
        		    
        		  uservice.upfriend(f);
        		  
        		 
        		  
        		  p.println("拒绝好友");
        		  
			
        	}else{
        		
        		
        		p.println("用户id不对！");
        	}
        	
			
			
		}else{
			
			p.println("用户不为空");
		}
		
		
		
		
	p.close();
		
	}
	 
	
	
	

	public void deleteF()throws Exception{
		HttpServletResponse  http=ServletActionContext.getResponse();
		http.setCharacterEncoding("utf-8");
		http.setContentType("text/html;charset=UTF-8");
		PrintWriter p =http.getWriter();
		

		if(this.user_id!=null&&!this.user_id.equals("")&&this.you!=null&&!this.you.equals("")){
			
			boolean b=uservice.userload(user_id);
			
        	if(b){
		            		
                              
        		  friend f=new friend();
        		  f.setMy(user_id);
        		  f.setYou(you);
        	
        	
        		    
        		  uservice.deleteF(f);
        		  
        		  p.println("申请好友");
        		  
			
        	}else{
        		
        		
        		p.println("用户id不对！");
        	}
        	
			
			
		}else{
			
			p.println("用户不为空");
		}
		
		
		
		
	p.close();
		
	}
	 
	
	
	
}
