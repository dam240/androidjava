package com.cd.use.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.cd.admin.model.book;
import com.cd.bean.broy;
import com.cd.bean.page1;
import com.cd.use.model.car;
import com.cd.use.service.seri;
import com.opensymphony.xwork2.ActionSupport;


@Component("min_book")
@Scope("prototype")
public class admin_book extends ActionSupport {

	private seri ser;
  private String bname;
	private int now;
	private String dan_ji;
	private String book_name;
	private String tu_B;
	private int pid;
	private  int cartItemIdArray;
     
	private String hiddenTotal;
	 private String    cartItemIds;
	


	public void setCartItemIdArray(int cartItemIdArray) {
		this.cartItemIdArray = cartItemIdArray;
	}



	public void setHiddenTotal(String hiddenTotal) {
		this.hiddenTotal = hiddenTotal;
	}



	public void setCartItemIds(String cartItemIds) {
		this.cartItemIds = cartItemIds;
	}



	public void setPid(int pid) {
		this.pid = pid;
	}



	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}



	public void setTu_B(String tu_B) {
		this.tu_B = tu_B;
	}



	public void setDan_ji(String dan_ji) {
		this.dan_ji = dan_ji;
	}



	public void setMout(String mout) {
		this.mout = mout;
	}


	private  String mout;
	public seri getSer() {
		return ser;
	}



	public String getBname() {
		return bname;
	}



	public int getNow() {
		return now;
	}



	public String getMout() {
		return mout;
	}



	public int getBook_id() {
		return book_id;
	}


	private int book_id;
	
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	

	public void setNow(int now) {
		this.now = now;
	}

	public void setBname(String bname) {
	this.bname = bname;
}

	@Resource
	public void setSer(seri ser) {
		this.ser = ser;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		HttpServletRequest  sq	=ServletActionContext.getRequest();
		HttpSession s=sq.getSession();
		 int count=ser.book_count(bname);
		 
		   
		 page1 p=new page1();    
		   p.setNow(now);
		   p.setSize(5);
		   System.out.println("use"+count);
		    page1 ha=broy.io(p, count);
	  System.out.println("ggggg");
		List<book> li=ser.use_list_use(bname,ha.getIndex(),ha.getSize());
		
		sq.setAttribute("li", li);
		sq.setAttribute("page", ha);
	   s.setAttribute("bname", bname);
		
		return super.execute();
	}
	
	
	public String  list_op(){
		
		
		HttpServletRequest  sq	=ServletActionContext.getRequest();
		HttpSession s=sq.getSession();
		
		String name=(String) s.getAttribute("bname");
		 int count=ser.book_count(name);
		 page1 p=new page1();    
		   p.setNow(now);
		   p.setSize(5);
		   System.out.println("use"+count);
		    page1 ha=broy.io(p, count);
	
		List<book> li=ser.use_list_use(name,ha.getIndex(),ha.getSize());
		
		sq.setAttribute("li", li);
		sq.setAttribute("page", ha);
	   s.setAttribute("bname", bname);
		
		return SUCCESS;
	}
	
	
	public String car_ini(){
		
		
	
		
		
		HttpServletRequest  sq=ServletActionContext.getRequest();
		HttpSession  sw=  sq.getSession();
	    String name=(String) sw.getAttribute("usename");
		
	    if(name!=null&&!name.equals("")){
	      float dan=Float.parseFloat(dan_ji);
	      float mo=Float.parseFloat(mout);
	     
	      float i=dan*mo;
	      
	     car c=new car();
	     c.setBook_id(book_id);
	     c.setUser_id(name);
	     c.setMout(mout);
	     c.setDan_ji(dan_ji);
	     c.setBook_name(book_name);
	     c.setTu_B(tu_B);
	   c.setXi_ji(""+i);
	     
	     System.out.println("|"+i+"|");
	     System.out.println(name+"|"+dan_ji+"|"+mout+book_name+tu_B);
	     ser.car_save(c);
	       
	    
	     
	
	   
	   
		return SUCCESS;
		
	    }
	    else{
	    	
	    	return ERROR;
	    }
	    
	}
	
	
	
	public String load_my(){
		
		
		HttpServletRequest  sq=ServletActionContext.getRequest();
		
		HttpSession  sw=  sq.getSession();
	    String name=(String) sw.getAttribute("usename");
	    if(name!=null&&!name.equals("")){
		   List<car> li = ser.load_my(name);
		     
		   String ui="";
		   
			  if(li.size()>0){
				  
				 ui="usename";
				  
			  }
			     
			  
			  sq.setAttribute("li", li);
			  sq.setAttribute("bool", ui);
			   
		
		
		return SUCCESS;
		
	    }
	    
	    return ERROR;
	    
	}
	
	

	
	public String load_ku(){
		
	    System.out.println(this.cartItemIds +"-----"+this.hiddenTotal);
		HttpServletRequest  sq=ServletActionContext.getRequest();
		
		HttpSession  sw=  sq.getSession();
	    String name=(String) sw.getAttribute("usename");
	     System.out.println(name);
		   List<car> li = ser.load_my(name);
		  
			int j=0; 
			int l=li.size();
			String  [] i= new String [l];
			for(car c:li){
			
				
				
				i[j]=""+c.getId();
					j++;
			}
		   
		   
			  sq.setAttribute("li", li);
			   sw.setAttribute("total", hiddenTotal);
			   
			   sw.setAttribute("ioc",i );
		
		return SUCCESS;
		
	  
	    
	}
	
	

	
	
	public String delete_car(){
		
		
		System.out.println(pid);
	 ser.delete_car(pid);
		
		
		return SUCCESS;
	}
	
	
	public String delete_carLIST(){
		
		
		System.out.println("---dhhhhhhhhhhhhhhhhhhhhh-");
		
		String ji[]=bname.split(",");
		
		
	for(int i=0;i<ji.length;i++){
			
		int o=Integer.parseInt(ji[i]);
		
			
			 ser.delete_car(o);  
			 
		}
		
		
		
System.out.println("---||cartItemIdArray.length|||---"+ji.length);
		
		
		return SUCCESS;
	}
	
	
	
	
	
}
