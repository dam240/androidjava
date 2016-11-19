package com.cd.use.action;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.cd.use.model.car;
import com.cd.use.model.order;
import com.cd.use.service.seri;
import com.opensymphony.xwork2.ActionSupport;

@Component("order_io")
@Scope("prototype")
public class order_ac extends ActionSupport {

	
	private String commit;
	private String  order_id;
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public void setCommit(String commit) {
		this.commit = commit;
	}


	private seri ser;
private String address;


	public void setAddress(String address) {
	this.address = address;
}

	@Resource
	public void setSer(seri ser) {
		this.ser = ser;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		 HttpServletRequest  sq=	ServletActionContext.getRequest();
		
		 HttpSession sw=  sq.getSession();
		 
		  String total= (String) sw.getAttribute("total");
		  String name= (String) sw.getAttribute("usename");
		  String []ioc=  (String[]) sw.getAttribute("ioc");
		  
		  
		              
		       
		  
		  
		  
		  String str = "0123456789qwertyuiopasdfghjklzxcvbnm";

		  
		  
		  
		  
	        char[] rands = new char[4];

	        Random random = new Random();

	        for (int i = 0; i < 4; i++)
	        {
	            rands[i] = str.charAt(random.nextInt(36));
	        }

	       
		  String da=new String(rands);
		 System.out.println(total+address+da+name+ioc.length);
		   
		 String date=""+new Date();
		 order o=new order();
		 o.setAddr(this.address);
		 o.setJin(total);
		 o.setOrder_id(da);
		 o.setDate(date);
		 o.setUser_id(name);
		 ser.order_save(o);
		 
		   System.out.println(date);
		 for(int i=0;i<ioc.length;i++){
			  
			    int io=Integer.parseInt(ioc[i]);
			  
		  
		         
		 car c=new car();
		 c.setId(io);
		 c.setCommit_id(da);
		 ser.up_car(c);
		 
		 } 
		
		 sw.setAttribute("order_id", da);
		 
		 
		return super.execute();
	}
	
	
	public String look_order(){
		
		 HttpServletRequest  sq=	ServletActionContext.getRequest();
			
		 HttpSession sw=  sq.getSession();
		 
		  String order_id= (String) sw.getAttribute("order_id");
		
		 order oi =ser.look_order(order_id);
		  
		  
		  sq.setAttribute("ioc",oi);
		  
		  
		return SUCCESS;
	}
	
	
	
	public String  zhi_one(){
		
		
		HttpServletRequest  sq=	ServletActionContext.getRequest();
		
		 HttpSession sw=  sq.getSession();
		 
		  String order_id3= (String) sw.getAttribute("order_id");
		
		 order oi =ser.look_order(order_id3);
		  
		  
		  sq.setAttribute("ioc",oi);
		
		
		return SUCCESS;
		
	}
	
	
	public String show_my(){
		
		  
		HttpServletRequest  sq=	ServletActionContext.getRequest();
		
		 HttpSession sw=  sq.getSession();
		 
		  String use= (String) sw.getAttribute("usename");
		if(use!=null&&!use.equals("")){
		
			 
		  List<order> li =  ser.show_my(use);
			
			 
		  List <List<car>> pa=new ArrayList<List<car>>();
		  
		  for(order o:li){
			  
			  List<car> lo =  ser.show_p(o.getOrder_id());
			  
			
		    
				List <car> lu=new ArrayList<car>();
			  for(car c:lo){
		    	
		           lu.add(c);
		    	  
		    
		      }
		  pa.add(lu);
		  
		  }
		  
		  sq.setAttribute("li", li);
		  sq.setAttribute("car", pa);
		  
		  
		
		 
		
		return SUCCESS;
		
		}
		
		return ERROR;
	}
	
	
	public String show_list(){
		
		HttpServletRequest  sq=	ServletActionContext.getRequest();
		order o=ser.look_order(commit);
		  
		System.out.println(commit);
		
		List<car> li=ser.show_p(commit);
		
		sq.setAttribute("li", li);
	    sq.setAttribute("ioc", o);	
	
		return SUCCESS;
	}
	
	

	public String  zhi_two(){
		
		
		HttpServletRequest  sq=	ServletActionContext.getRequest();
		
		
		
		 order oi =ser.look_order(order_id);
		  
		  
		  sq.setAttribute("ioc",oi);
		
		
		return SUCCESS;
		
	}
	
	
	
}
