package com.cd;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cd.admin.model.book;
import com.cd.admin.model.book_use;
import com.cd.use.model.car;
import com.cd.use.model.order;
import com.cd.use.service.seri;

public class min {

	@Test
	public void test() {
		ApplicationContext  con=new ClassPathXmlApplicationContext("beans.xml");
		 seri  se= (seri) con.getBean("ser"); 
		 
		  List<book_use> li =se.qnull();
		  
		  for(book_use l:li){
			  
			  System.out.println(l.getBook_name());
		  }
		 
	}
	
	
	@Test
	public void test1() {
		ApplicationContext  con=new ClassPathXmlApplicationContext("beans.xml");
		 seri  se= (seri) con.getBean("ser"); 
		 
		System.out.println(se.use_book(3).getBook_name());
		 
	}

	@Test
	public void test2() {
		ApplicationContext  con=new ClassPathXmlApplicationContext("beans.xml");
		 seri  se= (seri) con.getBean("ser"); 
		 
		 
		 
		List<book> li =se.use_list_use("java", 0, 5);
		 
		for(book k:li){
			
			System.out.println(k.getBook_name());
		}
		  
		
		 
	}
	
	
	
	@Test
	public void test3() {
		ApplicationContext  con=new ClassPathXmlApplicationContext("beans.xml");
		 seri  se= (seri) con.getBean("ser"); 
		 
	  car c=new car();
	  
	  c.setBook_id(3);
	  c.setUser_id("1200");
	  c.setMout("40.0");
	  c.setDan_ji("70.0");
	  c.setXi_ji("200.0");
	  c.setBook_name("dgsgdagsdg");
	  c.setTu_B("dsdhdhdha");
	  se.car_save(c);
	  
		
		 
	}

	
	
	
	@Test
	public void test4() {
		ApplicationContext  con=new ClassPathXmlApplicationContext("beans.xml");
		 seri  se= (seri) con.getBean("ser"); 
		 
	
		  
		 List<car> li= se.load_my("1200");
	  

		 for(car c:li){
			 
			 System.out.println(c.getBook_name());
			 
		 }
		 
		
		 
	}

	
	@Test
	public void test5() {
		ApplicationContext  con=new ClassPathXmlApplicationContext("beans.xml");
		 seri  se= (seri) con.getBean("ser"); 
		 
	
		  
	   se.delete_car(5);
		
		 
	}

	
	
	@Test
	public void test6() {
		ApplicationContext  con=new ClassPathXmlApplicationContext("beans.xml");
		 seri  se= (seri) con.getBean("ser"); 
		 
	
		  order o=new order();
		  String fa=""+new Date();
		  o.setOrder_id("555555");
		  o.setDate(fa);
		  o.setJin("55800");
		  o.setAddr("fagdsfgsdgf");
		  o.setUser_id("1200");
	   
		  se.order_save(o);
		
		 
	}
	
	
	@Test
	public void test7() {
		ApplicationContext  con=new ClassPathXmlApplicationContext("beans.xml");
		 seri  se= (seri) con.getBean("ser"); 
		 
	
		  order o =se.look_order("la6j");
		 System.out.println(o.getDate());
		
		 
	}
	
	
	@Test
	public void test8() {
		ApplicationContext  con=new ClassPathXmlApplicationContext("beans.xml");
		 seri  se= (seri) con.getBean("ser"); 
		 
	  List<order> li =  se.show_my("1200");
		
	  for(order o:li){

	  System.out.println(o.getFun());
	  System.out.println(o.getZhi_fu());
	  }		 
	/*  List <List<car>> pa=new ArrayList<List<car>>();
	  
	  for(order o:li){
		  
		  List<car> lo =  se.show_p(o.getOrder_id());
		  
		
	    
			List <car> lu=new ArrayList<car>();
		  for(car c:lo){
	    	
	           lu.add(c);
	    	  
	    
	      }
	  pa.add(lu);
	  
	  }
	   int i=0;
	  
	  for(order o:li){
		
		   System.out.println(o.getOrder_id()+"111");
		  for(car c:pa.get(i)){
			  
			  System.out.println(c.getCommit_id());
			  
		  }
		  
		  i++;
		  
		  System.out.println(i);
	  }
	  
	  */
	  
	  
	  
	}
	
	
	
	
	@Test
	public void test9() {
		ApplicationContext  con=new ClassPathXmlApplicationContext("beans.xml");
		 seri  se= (seri) con.getBean("ser"); 
			
			
			List<order> li =se.admin_fun();
			
			 List <List<car>> pa=new ArrayList<List<car>>();
			  
			  for(order o:li){
				  
				  List<car> lo =  se.show_p(o.getOrder_id());
				  
				
			    
					List <car> lu=new ArrayList<car>();
				  for(car c:lo){
			    	
			           lu.add(c);
			    	  
			    
			      }
			  pa.add(lu);
			  
			  }
	    	
	     
			  int i=0;
			  
			  for(order o:li){
				
				   System.out.println(o.getOrder_id()+"111");
				  for(car c:pa.get(i)){
					  
					  System.out.println(c.getCommit_id());
					  
				  }
				  
				  i++;
				  
				  System.out.println(i);
			  }
	}
}
