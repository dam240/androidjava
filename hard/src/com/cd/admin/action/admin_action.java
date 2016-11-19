package com.cd.admin.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cd.admin.po.admin;
import com.cd.admin.service.adminser;
import com.opensymphony.xwork2.ActionSupport;



@Controller("admin")
@Scope("prototype")
public class admin_action  extends ActionSupport {

	private String id;
	private String password;
	
	private admin use;
	private adminser adminS;
 





	public admin getUse() {
		return use;
	}

	public void setUse(admin use) {
		this.use = use;
	}

	@Resource
	public void setAdminS(adminser adminS) {
		this.adminS = adminS;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
	
	
		HttpServletRequest re   =	ServletActionContext.getRequest();
		HttpServletResponse http	=ServletActionContext.getResponse();
		Cookie [] co= 	 re.getCookies();
		
			
		if(co!=null){
			
			for(Cookie ioc:co){
				
				
				
				if(ioc.getName().equals("id")){
					
					
				String name=ioc.getValue();
				 ioc.setMaxAge(0);
				   http.addCookie(ioc); 
			     HttpSession so=   re.getSession();
   
				      
				System.out.println(name);
				
				so.setAttribute("admin", name);
				
			this.use=adminS.use(name);
				
				
				return SUCCESS;
				}
			}
			
			
			
		}
		
			
			
			
	
		
		
		return LOGIN;
	}
	
	
	
	
	public void login()throws Exception{
		
		  
		HttpServletRequest re   =	ServletActionContext.getRequest();
			HttpServletResponse  http=ServletActionContext.getResponse();
			http.setCharacterEncoding("utf-8");
			http.setContentType("text/html;charset=UTF-8");
		PrintWriter p =http.getWriter();
			
			if(this.id!=null&&this.password!=null&&!this.id.equals("")&&!this.password.equals(""))
			{
				    admin m=new admin(); 
				     m.setId(id);
				     m.setPassword(password);
				
				     boolean b=adminS.load(m);
				
				     if(b){
				    	 
				 Cookie [] co= 	 re.getCookies();
				    	 
				    
				   
				   if(co==null){
					   
					   
					  Cookie com=new Cookie("id", id);
					  com.setMaxAge(100);
					  
					   http.addCookie(com); 
					   
					   
				   }else{
					   
					   
					   for(Cookie ioc:co){
						   
						   
						   if(!ioc.getName().equals("id")){
							   
							  ioc.setMaxAge(0);
							   http.addCookie(ioc); 
							   
						   Cookie com=new Cookie("id", id);
							  com.setMaxAge(300000);
							  
							   http.addCookie(com); 
						   }
							  
							   
						   
						   
					   }
					   
					   
					   
					   
					   
				   }
				   
				    	p.print(true);
			
				    	 
				    	 
				     }else{
				    	 
				    	 
				    	 p.println("用户或者密码错误!");
				    	 
				     }
				     
				     
				     
				
			}else{
			
				
				 p.println("内容不能为空！");
			}
			p.close();   
	}
	
	
	
	
	
	
}
