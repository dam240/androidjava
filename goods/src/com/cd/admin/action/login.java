package com.cd.admin.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.cd.admin.model.admin_use;
import com.cd.admin.service.adim_ser;
import com.opensymphony.xwork2.ActionSupport;

@Component("login")
@Scope("prototype")
public class login extends ActionSupport {

	private String adminname;
	private String adminpwd;
	private adim_ser adm;
	
	@Resource
	public void setAdm(adim_ser adm) {
		this.adm = adm;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	public void setAdminpwd(String adminpwd) {
		this.adminpwd = adminpwd;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		 HttpServletRequest ht=ServletActionContext.getRequest();
		 
		 String hi=ERROR;
		 
		admin_use u=null;
		
		
		try {
			u=	adm.load(adminname);
			         
			
			if(this.adminpwd.equals(u.getPsw())){
			
				 HttpSession ses=  ht.getSession();
				
				 ses.setAttribute("name", u.getName());
				return SUCCESS;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		         
		
		
		
		return hi;
	}
	
	
	
	
	
}
