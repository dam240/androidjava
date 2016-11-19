package com.cd.action;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.cd.po.Info;
import com.cd.serveic.biservice;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Component("iu")
@Scope("prototype")
public class bishow extends ActionSupport {

	

	
	
	
	
	@Override
	public String execute() throws Exception {

		 Map<String, Object> se= ActionContext.getContext().getSession();
	       String username= (String) se.get("username");
		 Info in=  bu.load(username);
		


		 Map<String, Object> session= ActionContext.getContext().getSession();
		 session.put("blogtitle", in.getBlogtitle());
		 session.put("idiograph", in.getIdiograph());
		 
		 
		 
		return SUCCESS;
	}
	public biservice getBu() {
		return bu;
	}
	@Resource
	public void setBu(biservice bu) {
		this.bu = bu;
	}
	private biservice bu;
	
	
	
}
