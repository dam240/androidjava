package com.cd.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Component("dj")
@Scope("prototype")
public class useall extends ActionSupport {

	
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		 
		//Map Request=(Map) ActionContext.getContext().get("request");
			   //  Map<String, Object> se= ActionContext.getContext().getSession();
		
		HttpServletRequest R=ServletActionContext.getRequest();
		
		
		R.setAttribute("dd", "ddd");
		
		return super.execute();
	}
	
}
