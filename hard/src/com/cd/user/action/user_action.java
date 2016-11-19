package com.cd.user.action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;

import com.cd.user.po.user;
import com.cd.user.service.user_ser;
import com.opensymphony.xwork2.ActionSupport;


@Controller("user")
@Scope("prototype")
public class user_action extends ActionSupport {

	
	private String user_id;
	private String user_name;
	private String passwod;
	private user_ser uservice;
	


	

	public String getUser_id() {
		return user_id;
	}
	@Resource
	public void setUservice(user_ser uservice) {
	this.uservice = uservice;
}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPasswod() {
		return passwod;
	}

	public void setPasswod(String passwod) {
		this.passwod = passwod;
	}






	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
	
		
		
		
		return super.execute();
	}
	
	
	
	
	
	public  void index()throws Exception{
		
		
		HttpServletResponse  http=ServletActionContext.getResponse();
		http.setCharacterEncoding("utf-8");
		http.setContentType("text/html;charset=UTF-8");
		PrintWriter p =http.getWriter();
		
		
		  System.out.println(user_name);
		
	 if(this.user_id!=null&&!this.user_id.equals("")&&this.user_name!=null&&!this.user_name.equals("")&&this.passwod!=null&&!this.passwod.equals("")){
		   
		boolean u= uservice.userload(user_id);
		 
		    if(!u){
		    	
		    	String image="image/ic.png";
		    	String card="hello";
		    	
		      user use=new user();
		      use.setUser_id(user_id);
		      use.setUser_name(user_name);
		      use.setPassword(passwod);
		      SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
		      java.util.Date date=new java.util.Date();  
		      String str=sdf.format(date); 
		      use.setAge(str);
		      use.setCard(card);
		      use.setPhoto(image);
		    uservice.save(use);
		    	
		    	p.println("成功");
		    	
		    }else{
				 
		    	p.println("用户不对!");
		    		 
		    	 }
		
		 
		 
		 
		 
	 }else{
		 
		 p.println("不能为空!");
		 
	 }
		

		p.close();
		
	}
	
	
	
	public void load()throws Exception{
		
		
		HttpServletResponse  http=ServletActionContext.getResponse();
		http.setCharacterEncoding("utf-8");
		http.setContentType("text/html;charset=UTF-8");
		PrintWriter p =http.getWriter();
		
		
		System.out.println(user_id+passwod);
		if(this.user_id!=null&&!this.user_id.equals("")&&this.passwod!=null&&!this.passwod.equals(""))
			   {
			
			  user N=new user();
			  N.setUser_id(user_id);
			  N.setPassword(passwod);
			
			
			boolean u= uservice.login(N);
			 
		    if(u){
		    	p.print(true);
					 
		    }else{
		    	
		    p.println("用户不存在!");
		    }
				 
				 
			 }else{
				 
				 p.println("不能为空！");
				 
			 }
	
		p.close();
		
	}
	
	
	
	
}
