package com.cd;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cd.admin.dao.adminMapper;
import com.cd.admin.dao.bean_dao;
import com.cd.admin.model.admin_use;
import com.cd.admin.model.bean;
import com.cd.admin.model.book;
import com.cd.admin.model.book_use;
import com.cd.admin.service.adim_ser;
import com.cd.admin.service.book_service;
import com.cd.bean.broy;
import com.cd.bean.fyin;
import com.cd.bean.page;
import com.cd.bean.page1;
import com.cd.use.dao.useMapper;
import com.cd.use.model.use;
import com.cd.use.service.seri;

public class test {

	@Test
	public void test() {

		ApplicationContext  con=new ClassPathXmlApplicationContext("beans.xml");
		 seri  se= (seri) con.getBean("ser"); 
		  use u=new use();
		  
		  u.setUsename("133");
		  u.setPsw("dameng");
		  u.setEmail("24006@qq.com");
		 se.save(u);
		 
		
	}


	@Test
	public void test1() {

		ApplicationContext  con=new ClassPathXmlApplicationContext("beans.xml");
		 seri  da=  (seri) con.getBean("ser"); 
		  use u=new use();
		  
		  u.setUsename("130");
		  u.setPsw("dameng");
		  u.setEmail("24006@qq.com");

	         
		  
		  System.out.println(da.end(u.getEmail()));
		 
		
	}


	

	@Test
	public void test2() {

		ApplicationContext  con=new ClassPathXmlApplicationContext("beans.xml");
		 seri  da=  (seri) con.getBean("ser"); 
		  use u=new use();
		  
		  u.setUsename("130");
		  u.setPsw("dameng");
		  u.setEmail("24006@qq.com");

	         
		  
		  System.out.println(da.load(u.getUsename(), u.getPsw()));
		 
		
	}


	
	

	@Test
	public void test3() {

		ApplicationContext  con=new ClassPathXmlApplicationContext("beans.xml");
		 adim_ser  da=  (adim_ser) con.getBean("adm"); 
		 
		   
		
		 System.out.println(da.load("1100").getName());
		
	}
	


	@Test
	public void test4() {

		ApplicationContext  con=new ClassPathXmlApplicationContext("beans.xml");
		 adim_ser da=   (adim_ser) con.getBean("adm"); 
		 
		   book_use u=new book_use();
		
		   u.setBook_name("程序设计");
		   u.setBook_log("程序设计相关分类");
		   
	da.saveA(u);
		
		   
	}
	

	
	

	@Test
	public void test5() {

		ApplicationContext  con=new ClassPathXmlApplicationContext("beans.xml");
		 adim_ser da=   (adim_ser) con.getBean("adm"); 
		 
		   
		
		 
	     List <book_use>li=  da.qnull();	 
	
	  
	    	 
	    	 
	    	 System.out.println(li.size());
	    
		
		   
	}
	


	@Test
	public void test6() {

		ApplicationContext  con=new ClassPathXmlApplicationContext("beans.xml");
		 adim_ser da=   (adim_ser) con.getBean("adm"); 
        
	 book_use u=da.get(2);
		 
	 System.out.println(u.getBook_name());
		
		   
	}
	
	
	@Test
	public void test7() {

		ApplicationContext  con=new ClassPathXmlApplicationContext("beans.xml");
		 adim_ser da=   (adim_ser) con.getBean("adm"); 
        
           book_use u=new book_use();
           u.setA_id(33);
           u.setBook_name("hhhhh");
           u.setBook_log("hhshhs");
           da.up(u);
		 
		 
		 
		   
	}
	
	
	

	@Test
	public void test8() {

		ApplicationContext  con=new ClassPathXmlApplicationContext("beans.xml");
		 adim_ser da=   (adim_ser) con.getBean("adm"); 
        
           List<book_use> u=da.qnull();
	  	List <List<bean>> ko	 =new ArrayList<List<bean>>();

		 for(book_use k:u){
			 
			List <book_use > l= da.list(k.getA_id());
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
		   
		
		 
		
			 
			for(int y=0;y<ko.size();y++)
			 for(bean n: ko.get(y)){
				 
				 System.out.println(n.getA_name()+"--"+n.getBook_name());
			 }
			 
		 
		 
		 
		 
		 
		 
	}
	
	
	
	
	
	@Test
	public void test9() {

		ApplicationContext  con=new ClassPathXmlApplicationContext("beans.xml");
		 adim_ser da=   (adim_ser) con.getBean("adm"); 
        
           book k=new book();
		 k.setA_id(2);
	
		 k.setBan_one("1.0");
		 k.setBook_name("JSP");
		 k.setChu("广州出版");
		 k.setChu_tiem("2016.1.6");
		 k.setD_ji("68");
		 k.setNow_ji("50");
		 k.setK_b("16");
		 k.setPage("650");
		 k.setTu_A("d:/");
		 k.setTu_B("f:/");
		 k.setZhe("6.5");
		  k.setZhi_shu("500000");
		  k.setZi_zhang("80");
		  k.setZuo("立是");
		  k.setYi_tiem("2015.6.1");
		   da.save_book(k);
	}



	@Test
	public void test10() {

		ApplicationContext  con=new ClassPathXmlApplicationContext("beans.xml");
		 adim_ser da=   (adim_ser) con.getBean("adm"); 
        
           List <book> li=da.all_book(3);
           
           for(book i:li){
        	   
        	   System.out.println(i.getBook_name());
           }
           
	}
           @Test
       	public void test11() {
        	   ApplicationContext  con=new ClassPathXmlApplicationContext("beans.xml");
        	   adim_ser m=   (adim_ser) con.getBean("adm"); 
        	    bean_dao bw=  (bean_dao) con.getBean("dao"); 
                 int i =m.all_book(3).size();
                 System.out.println(i);
          	   page1 p=new page1();    
        	  
        	   p.setSize(5);
        	   p.setNow(0);
        	    page1 ha=broy.io(p, i);
        	    System.out.println("---"+ha.getCunot());
        	    
	    
	    List <book> li=bw.listall(ha.getIndex(), ha.getSize(),3);
      
	    System.out.println(li.size());
	    
	    
	    for(book k:li){
	    
	    	System.out.println(k.getA_id());
	    	System.out.println(k.getBook_id());
	    	System.out.println(k.getBook_name());
	    }
	}

           
           @Test
           public void test12(){
        	   
        	   page1 p=new page1();
        	   
        	  p.setSize(5);
        	  p.setNow(1);
        	page1 l =broy.io(p, 17);
        	   
        	System.out.println(l.isUp());
        	   System.out.println(l.getIndex());
        	   System.out.println(l.getCunot());
        	   System.out.println(l.getNow());

           
           }

           
           
           
           @Test
           public void test13(){
        	   
        	   ApplicationContext  con=new ClassPathXmlApplicationContext("beans.xml");
        	   adim_ser m=   (adim_ser) con.getBean("adm"); 
        	   
        	      book ome=m.dan_book(2);
           
        	      
        	      System.out.println(ome.getBook_id());
           }

           
           
           
           @Test
           public void test15(){
        	   
        	   ApplicationContext  con=new ClassPathXmlApplicationContext("beans.xml");
        	   adim_ser m=   (adim_ser) con.getBean("adm"); 
        	   
        	   book k=new book();
        		  k.setBook_id(15);
        	      k.setPage("450");
        	      k.setA_id(3);
        	      k.setBook_name("数据结构与算法分析Java语言描述 第2版");
        	  
        	      k.setChu_tiem("2014-06-12");
        	      k.setYi_tiem("2014-06-05");
        	      k.setK_b("1");
        	      k.setZi_zhang("胶版纸");
        	      k.setZhi_shu("15000");
        	      k.setBan_one("1");
        	      k.setChu("机械工业出版社 ");
        	      k.setZuo("韦斯");
        	      k.setZhe("6.9");
        	      k.setD_ji("90.0");
        	      k.setNow_ji("65.0");
        	     m.go_up(k);  
        	    
           }

           
           
       	@Test
    	public void test16() {

       	   ApplicationContext  con=new ClassPathXmlApplicationContext("beans.xml");
       	book_service da=    (book_service) con.getBean("book_size"); 
    	   
    		book k=new book();
    		k.setBook_name("java");
    		k.setChu("");
    		k.setZuo("");
    	  List<book> li=da.look_book(k, 5, 5);
    	
    	  for(book l:li){
    		  
    		  System.out.println(l.getBook_id());
    	  }
    		 
    	
    
    	
    		
    		   
    	}
    	
}
