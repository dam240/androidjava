package com.cd.use.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.cd.admin.model.bean;
import com.cd.admin.model.book;
import com.cd.admin.model.book_use;
import com.cd.admin.service.book_service;
import com.cd.bean.broy;
import com.cd.bean.mode;
import com.cd.bean.page1;
import com.cd.use.service.seri;
import com.opensymphony.xwork2.ActionSupport;
@Component("dogo")
@Scope("prototype")
public class list_book extends ActionSupport {

	private seri ser;

	private int pid;
	private int now;
	
	private String bname;
	private String author;
	private String press;
	
	@Resource
	private  book_service book_size;  
	
	
	
	public void setBook_size(book_service book_size) {
		this.book_size = book_size;
	}

	public void setNow(int now) {
		this.now = now;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	@Resource
	public void setSer(seri ser) {
		this.ser = ser;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
       
		

		HttpServletRequest sq  =ServletActionContext.getRequest();

		
	    List<book_use> u=ser.qnull();
		  	List <List<bean>> ko	 =new ArrayList<List<bean>>();

			 for(book_use k:u){
				 
				List <book_use > l=ser.list(k.getA_id());
		  		List < bean > li=new ArrayList<bean>();
				for(book_use i:l){
					   
					   bean o=new bean();
					   o.setA_name(k.getBook_name());
					   o.setB_id(i.getB_id());
					   o.setA_id(i.getA_id());
					   o.setBook_log(i.getBook_log());
					   o.setBook_name(i.getBook_name());
					   li.add(o);
				}
				ko.add(li);
				
			 }
			   
	sq.setAttribute("ko", ko);

		
		return super.execute();
	}
	
	
	
	public String  use_list_book()
	{
		

		HttpServletRequest sq=  ServletActionContext.getRequest();
		HttpSession s=sq.getSession();
		 int count=ser.use_book_size(pid);
		   
		 page1 p=new page1();    
		   p.setNow(now);
		   p.setSize(5);
		   System.out.println("use"+count);
		    page1 ha=broy.io(p, count);
		    
		    List<book> li =this.book_size.listall(ha.getIndex(), ha.getSize(), pid);
		        System.out.println("666"+ha.getCunot());
		  
		        
		        
		     sq.setAttribute("page",ha);
	      sq.setAttribute("li",li);	    
		   s.setAttribute("id", pid);  
		
		
		return SUCCESS;
	}
	
	
	

	public String book_valuse(){
		

		 HttpServletRequest sq= ServletActionContext.getRequest();
			HttpSession s=sq.getSession();
			int id=(Integer) s.getAttribute("id");
		   int count=ser.use_book_size(id);
		   page1 p=new page1();    
		   p.setNow(now);
		   p.setSize(5);
		    page1 ha=broy.io(p, count);
		    System.out.println("--------"+now);
		    List<book> li =this.book_size.listall(ha.getIndex(), ha.getSize(), id);
		    System.out.println("666"+ha.getCunot());
		     sq.setAttribute("page",ha);
	        sq.setAttribute("li",li);	    
		   
		   
		   
		
		
		
		return SUCCESS;
	}
	
	
	public String  use_book(){
		
		 HttpServletRequest sq= ServletActionContext.getRequest();
		    
		  book use=ser.use_book(pid);
		 
		  sq.setAttribute("book", use);
		 
		
		
		return SUCCESS;
	}
	
	
	public String use_log(){
		
		HttpServletRequest sq=ServletActionContext.getRequest();
		HttpSession sw=  sq.getSession();
		    book k=new book();
		    k.setBook_name(bname);
		    k.setChu(press);
		    k.setZuo(author);
		      mode me=new mode(); 
		      me.setAuthor(author);
		      me.setBname(bname);
		      me.setPress(press);
		    System.out.println("22"+bname+press+author);
		    int count=book_size.look_size(k);
			   
			 page1 p=new page1();    
			   p.setNow(now);
			   p.setSize(5);
			   System.out.println("11111"+count);
			    page1 ha=broy.io(p, count);
			    
		   List <book> li=book_size.look_book(k,ha.getIndex(), ha.getSize());
		   System.out.println("66666"+bname+press+author);
		   
		   sw.setAttribute("b1", bname);
		   sw.setAttribute("b2", press);
		   sw.setAttribute("b3", author);
          
		  sq.setAttribute("li", li);
		
		  sq.setAttribute("page", ha);
		  
		return SUCCESS;
	}
	
	
	
	
	public void setBname(String bname) {
		this.bname = bname;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setPress(String press) {
		this.press = press;
	}

	public String name()
	{
		
		
		
		HttpServletRequest sq=ServletActionContext.getRequest();
		HttpSession sw=  sq.getSession();

	  String b1= (String) sw.getAttribute("b1"); 
	  String b2= (String) sw.getAttribute("b2"); 
	  String b3= (String) sw.getAttribute("b3"); 
	 
		    book k=new book();
		    k.setBook_name(b1);
		    k.setChu(b2);
		    k.setZuo(b3);
		    System.out.println("1lllhdhdhsahdhh");
		  
		    System.out.println("3333"+b1+b2+b3);
		    int count=book_size.look_size(k);
			   
			 page1 p=new page1();    
			   p.setNow(now);
			   p.setSize(5);
			
			    page1 ha=broy.io(p, count);
			    
		   List <book> li=book_size.look_book(k,ha.getIndex(), ha.getSize());

		   
		     
		  sq.setAttribute("li", li);
		
		  sq.setAttribute("page", ha);
		return SUCCESS;
	}
	
	
	
}
