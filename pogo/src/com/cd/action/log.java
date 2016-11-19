package com.cd.action;

import java.util.Map;

import javax.annotation.Resource;

import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.cd.po.user;
import com.cd.serveic.serveic;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.xml.internal.ws.client.RequestContext;

@Component("log")
@Scope("prototype")
public class log extends ActionSupport {

     private serveic use;
	public serveic getUse() {
		return use;
	}

	@Resource
	public void setUse(serveic use) {
		this.use = use;
	}

	private String username;

	private String password;

	
	
	
	
	
	 
	@Override
	public String execute() throws Exception {
	
	       user u=new user();
	       u.setUsername(username);
	       u.setPassword(password);
   HttpServletRequest R=ServletActionContext.getRequest();
   
	         if(use.log(u)){
	        	 R.setAttribute("ue", "µÇÂ½³É¹¦");
	        	 R.setAttribute("ul", "hio.action");
                    Map<String, Object> se= ActionContext.getContext().getSession();
	        	 se.put("username", username);
                    return "success";
	         }
	         else{
	        	 R.setAttribute("ue", "µÇÂ½Ê§°Ü");
	          	 R.setAttribute("ul", "login.jsp"); 
	        	 
	        	 return "error";
	
		
	         }
	         }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
