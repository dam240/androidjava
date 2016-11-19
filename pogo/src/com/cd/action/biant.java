package com.cd.action;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.cd.po.Info;
import com.cd.serveic.biservice;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@Component("bto")
@Scope("prototype")
public class biant extends ActionSupport {

	
	private String blogtitle;
	private String idiograph;
	private biservice bu;
	
	
	
	public biservice getBu() {
		return bu;
	}

	@Resource
	public void setBu(biservice bu) {
		this.bu = bu;
	}

	@Override
	public String execute() throws Exception {
		

		   HttpServletRequest R=ServletActionContext.getRequest();
        Map<String, Object> se= ActionContext.getContext().getSession();
       String username= (String) se.get("username");
		Info in =new Info();
		in.setUsername(username);
		 in.setBlogtitle(blogtitle);
		 in.setIdiograph(idiograph);
		
		if(bu.saveandupdate(in)){
       	 R.setAttribute("ue", "设置成功");

			return SUCCESS;
		}
		
		 R.setAttribute("ue", "设置失败成功");
	  	 R.setAttribute("ul", "login.jsp"); 
		return ERROR;
	}
	
	public String getBlogtitle() {
		return blogtitle;
	}
	public void setBlogtitle(String blogtitle) {
		this.blogtitle = blogtitle;
	}
	public String getIdiograph() {
		return idiograph;
	}
	public void setIdiograph(String idiograph) {
		this.idiograph = idiograph;
	}

	
	
}
