package com.cd.admin.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.cd.use.model.car;
import com.cd.use.model.order;
import com.cd.use.service.seri;
import com.opensymphony.xwork2.ActionSupport;

@Component("admin_list")
@Scope("prototype")
public class admin_order extends ActionSupport {

	private seri ser;
     private String commit;
	
	public void setCommit(String commit) {
		this.commit = commit;
	}

	@Resource
	public void setSer(seri ser) {
		this.ser = ser;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		HttpServletRequest sq	 =ServletActionContext.getRequest();
		
		List<order> li =ser.admin_fun();
		
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
        sq.setAttribute("car",pa);
		  
		
		
		
		return super.execute();
	}
	

	public String  order_ht()
	{
		

		HttpServletRequest  sq=	ServletActionContext.getRequest();
		order o=ser.look_order(commit);
		  
		System.out.println(commit);
		
		List<car> li=ser.show_p(commit);
		
		sq.setAttribute("li", li);
	    sq.setAttribute("ioc", o);	
	
		return SUCCESS;
	}
	
	
	public String fun1(){
		
		
		
		

		HttpServletRequest  sq=	ServletActionContext.getRequest();
		order o=ser.look_order(commit);
		  
		System.out.println(commit);
		
		List<car> li=ser.show_p(commit);
		
		sq.setAttribute("li", li);
	    sq.setAttribute("ioc", o);	
	
		
		
		
		return SUCCESS;
		
	}
	
	
	public String fun2(){
		
		
		order o=new order();
		o.setOrder_id(commit);
		o.setFun(1);
		
	   ser.up_fun(o);
		
		
		return SUCCESS;
	}
	
	public String zhi_fu(){
		
		
		order o=new order();
		o.setOrder_id(commit);
		o.setZhi_fu(1);
		
	   ser.up_zhi_fu(o);
		
		
		return SUCCESS;
	}
	
public String gei_w(){
		
		
		order o=new order();
		o.setOrder_id(commit);
		o.setFun(2);
		
		   ser.up_fun(o);		
		
		return SUCCESS;
	}
	
	
public String tu_h(){
	
	
	order o=new order();
	o.setOrder_id(commit);
	o.setZhi_fu(3);
	
   ser.up_zhi_fu(o);
	
	
	return SUCCESS;
}


	public String w_c(){
		
		
		
		HttpServletRequest sq	 =ServletActionContext.getRequest();
		
		List<order> li =ser.w_c();
		
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
        sq.setAttribute("car",pa);
		  
		
		return SUCCESS;
	}
	
	
	
public String qi_s(){
		
		
		
		HttpServletRequest sq	 =ServletActionContext.getRequest();
		
		List<order> li =ser.qi_s();
		
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
        sq.setAttribute("car",pa);
		  
		
		return SUCCESS;
	}
	
public String q_r(){
		
		
		order o=new order();
		o.setOrder_id(commit);
		o.setFun(2);
		
	   ser.up_fun(o);
		
		
		return SUCCESS;
	}
	
	
	
	
	
	
	public String yj_fun(){
		
	
			
			HttpServletRequest sq	 =ServletActionContext.getRequest();
			
			List<order> li =ser.fun2();
			
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
	        sq.setAttribute("car",pa);
			  
			
			
		
		return SUCCESS;
	}
	
	
	
	
	public String yj_zhi(){
		
	
			
		HttpServletRequest sq	 =ServletActionContext.getRequest();
		
		List<order> li =ser.zhi_fu();
		
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
        sq.setAttribute("car",pa);
		  
		
			
		
		return SUCCESS;
	}
	
	
	
	public String m_zhi(){
		
	
			
			HttpServletRequest sq	 =ServletActionContext.getRequest();
			
			List<order> li =ser.m_zhi_fu();
			
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
	        sq.setAttribute("car",pa);
			  
			
			
		
		return SUCCESS;
	}
	
	
	
}
