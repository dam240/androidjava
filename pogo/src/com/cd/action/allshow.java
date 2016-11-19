package com.cd.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.cd.po.alluser;
import com.cd.po.ati;
import com.cd.po.tcp;
import com.cd.serveic.atiser;
import com.cd.serveic.atiservice;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Component("shoee")
@Scope("prototype")
public class allshow extends ActionSupport {

	  private int id;
	
	  private atiservice ac;
	  
		private String content;
	  
	public String getContent() {
			return content;
		}


		public void setContent(String content) {
			this.content = content;
		}


	public int getId() {
		return id;
	}


	public atiservice getAc() {
		return ac;
	}

    @Resource
	public void setAc(atiservice ac) {
		this.ac = ac;
	}


	public void setId(int id) {
		this.id = id;
	}


	
	public String execute() throws Exception {

	//ActionContext.getContext().get("Request");
		//HttpServletRequest R=ServletActionContext.getRequest();
		Map<String, Object> se= ActionContext.getContext().getSession();
				 
		Map Request=(Map) ActionContext.getContext().get("Request");
			     
		 String username= (String) se.get("username");
				 /*
		HttpSession su=R.getSession();
		
		 String username=(String) su.getAttribute("username");*/
		 
		 //String ip=R.getRemoteAddr();
	
			alluser hi=new alluser();

		
			System.out.println(id);
			hi.setAid(id);
              hi.setContent(content);
              hi.setUsername(username);

            if(!content.equals("")||content!=null){
            ac.allsave(hi);
            }
              tcp c=new tcp();
		  
		    c.setAid(id);
		    c.setIp("0");
		   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String time = sdf.format(new Date());
		
		c.setTiem(time);

		List go =ac.goalluse(id);  
          
		ati ai=ac.get(id);
	
		if(ac.pan(c)){
	        
			
			ai.setHiate(ai.getHiate()+1);
	    ac.saveand(c);
		
			
		}
		

		
		
		
		ac.save(ai);
		
		
		
		
		//R.setAttribute("article", ai);
         //R.setAttribute("allCri", go);
		
         Request.put("article", ai);
         Request.put("allCri", go); 
		
		return SUCCESS;
	}
	
	
	
	
	

}
