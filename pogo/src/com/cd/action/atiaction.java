package com.cd.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.cd.model.atibean;
import com.cd.po.ati;
import com.cd.po.fyin;
import com.cd.po.page;
import com.cd.serveic.atiservice;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Component("atiac")
@Scope("prototype")
public class atiaction extends ActionSupport {

	
    private int id;	
	private int curr;
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getCurr() {
		return curr;
	}


	public void setCurr(int curr) {
		this.curr = curr;
	}
	private String title;
	private String content;
	private atiservice ac;
	
	
	
	
	
	
	
	@Override
	public String execute() throws Exception {

		  HttpServletRequest R=ServletActionContext.getRequest();
	        Map<String, Object> se= ActionContext.getContext().getSession();
	       String username= (String) se.get("username");
		
		
	       ati a=new ati();
	       a.setUsername(username);
	       a.setContent(content);
	       a.setTitle(title);
	       a.setDate(new Date());
	       
	       ac.add(a);
	       
	       R.setAttribute("ue", "发布成功");
		return SUCCESS;
	}

	
	public String add(){
		
	
		
		

		  HttpServletRequest R=ServletActionContext.getRequest();
	        Map<String, Object> se= ActionContext.getContext().getSession();
	       String username= (String) se.get("username");
     
		  page y=new page();
		  
		  y.setCurrentPage(this.getCurr());
		  y.setEveryPage(3);
		
		  atibean h=ac.li(y, username);
		  
		  List li=h.getGo();
		  
		  page b=h.getHi();
		    
		  
		  
	      R.setAttribute("all", li);
	      

	      R.setAttribute("page", b);
		
		return "list";
	}
	
	

	
	
	
	public String all(){
		
	
		
		  

		  HttpServletRequest R=ServletActionContext.getRequest();
	    

		  page y=new page();
		  
		 
		
		  y.setCurrentPage(this.getCurr());
		  y.setEveryPage(3);
		
		  atibean h=ac.lia(y);
		  
		  List li=h.getGo();
		  
		  page b=h.getHi();
		    
		  
		  
	      R.setAttribute("all", li);
	      

	      R.setAttribute("page", b);
		
		return "all";
	}
	
	
	
	public atiservice getAc() {
		return ac;
	}
	@Resource
	public void setAc(atiservice ac) {
		this.ac = ac;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	
	
}
