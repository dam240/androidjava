package com.cd.go;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cd.admin.po.admin;
import com.cd.admin.po.page;
import com.cd.admin.po.toolpage;
import com.cd.admin.service.adminser;
import com.cd.user.dao.chatdao;
import com.cd.user.dao.userMapper;

import com.cd.user.po.Tools;
import com.cd.user.po.care;
import com.cd.user.po.care1;
import com.cd.user.po.chat;
import com.cd.user.po.friend;
import com.cd.user.po.tool;
import com.cd.user.po.tool2;
import com.cd.user.po.tween;
import com.cd.user.po.user;
import com.cd.user.service.thatservice;
import com.cd.user.service.tweenser;
import com.cd.user.service.user_ser;
import com.cd.user.service.user_service;

public class test {

	@Test
	public void test() {
		
		// user_ser se=new user_service();
		
	//boolean  b=	 se.userload("123");
		 
	System.out.println(Tools.countpage(2, 5));

		  
	System.out.println(Tools.page(0, 5));
		 
	}

	
	@Test
	public void test1(){
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");   
	adminser amd=	(adminser) context.getBean("adminS");
		
	  
	     
	 /* for(user u:amd.getlist(2,2)){
		  
		  System.out.println(u.getUser_name());
		  
	  }*/
	
	
	
	
	}
	
	@Test
	public void test2(){
		
	ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");   
	//	 user_ser s=	  (user_ser) context.getBean("uservice");
         userMapper u=	(userMapper) context.getBean("usedao");
		
         
    friend f=new friend();
      f.setMy("100086");
      f.setYou("da10010");
      f.setDate(new Date().toLocaleString());
      f.setAcctp(1);
		
      u.insertfriend(f);
         
         
         
          /* List<user> li=u.seeF("100086");
       
         System.out.println(li.size());*/
         
         
      
	}
	
	
	
	
	@Test
	public void test3(){
		
	ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");   
	//	 user_ser s=	  (user_ser) context.getBean("uservice");
	chatdao u=	(chatdao) context.getBean("chatdao");
		
         
	  chat c=new chat();
	
      /* c.setDate(new Date().toString());
        c.setUser_id("100086");
        c.setYou("100010");
        c.setText("he"); 
         Date d=new Date();
         DateFormat D= DateFormat.getDateInstance();
         c.setDate(D.format(d));
         c.setTiem(d.toLocaleString()); */
     
/*         u.insertchat(c);
*/     // Date e    =new Date("2016-10-15 16:45:08");
   /*   if(d.toLocaleString()e.toLocaleString()){
    	  
    	  System.out.println((e.toLocaleString());
      }*/
      
	  
	  
	  List<chat>li=u.test();
	  
	  for(chat i:li){
		  
		  u.delete(i.getId());
	  }
	  
	  
	  
	}
	
	@Test
	public void test5(){
		
	ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");   
	//	 user_ser s=	  (user_ser) context.getBean("uservice");
	chatdao u=	(chatdao) context.getBean("chatdao");
		
	chat c=new chat();
	
	c.setUser_id("100086");
	c.setName("������");
	 Date d=new Date();
     DateFormat D= DateFormat.getDateInstance();
	c.setDate(D.format(d));
     c.setTiem(new Date().toLocaleString());  
      c.setYou("100010");
      c.setPhoto("A");
      c.setText("�� �� ��");
     c.setBid("A");
     
     u.insertchat(c);
     
     
	}
	
	@Test
	public void test6(){
		
	ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");   
	//	 user_ser s=	  (user_ser) context.getBean("uservice");
	chatdao u=	(chatdao) context.getBean("chatdao");
		
	chat c=new chat();
	
	c.setUser_id("100086");
	
	c.setDate("2016-10-17");
     c.setBid("A");
     

     List<user>li=u.luser(c);    
    
     System.out.println(li.size());
     
     
	}
	
	
	
	@Test
	public void test7(){
		
	ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");   
	//	 user_ser s=	  (user_ser) context.getBean("uservice");
	thatservice u=	(thatservice) context.getBean("chatser");
		
	chat c=new chat();
	
	c.setUser_id("100086");
	
	c.setDate("2016-10-17");
     c.setBid("A");
     
      List<user>li=u.luser(c);    
     
      System.out.println(li.get(0).getUser_id());
     
     
	}
	
	
	@Test
	public void test8(){
		
		ApplicationContext  applicationContext=new ClassPathXmlApplicationContext("beans.xml");
		
		            tweenser s= (tweenser) applicationContext.getBean("tweens");
		
		            
		            tween t=new tween();
		            
		            
		            t.setUse_id("100086");
		            t.setUse_name("�Һܺã�");
		            t.setText("hello worid!");
		            t.setTiem(new Date().toLocaleString());
		            s.insert(t);
		
		
	}
	
	
	
	
	@Test
	public void test9()throws Exception{
		
		ApplicationContext  applicationContext=new ClassPathXmlApplicationContext("beans.xml");
		
		            tweenser s= (tweenser) applicationContext.getBean("tweens");
		
		            
		            List<tween> list=s.mytween("100086");
		            
		      
		            for(tween t:list){
		            	
		                // Date d=new Date(t.getTiem());
		            	DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		                Date d=df.parse(t.getTiem());
		            	
		            	  Date h=new Date();
		            	
		            	  
		            	  if(d.getYear()==h.getYear()){
		            	  
		            		  if(d.getMonth()==h.getMonth()){
		    
		            			  
		            			  
		            			  
		            			  if(d.getDay()==h.getDay()){
		            			  
		            			  
		            			  
		            			  
		            			  if(h.getHours()==d.getHours()){
		            				  
		            				   if(h.getMinutes()==d.getMinutes()){
		            					   
		            					      int i=h.getSeconds()-d.getSeconds();  
		            					     
		            					   
		            					   System.out.println(i+"��");
		            					   
		            					   
		            				   }else{
		            					   
		            					   
		            					   int i=h.getMinutes()-d.getMinutes();  
					            			  
		          			             System.out.println(i+"����");
		            				   }
		            				  
		            				  
			            			  
		     			           //  System.out.println(i);
		            				  
		            			  }else{
		            				  
                        int i=h.getHours()-d.getHours();  
			            			  
			             System.out.println(i+"Сʱ");
		            			  }
		            			  
		            			  
		            			  
		            			  }else{
		            				  
		            				  
		            				  int i=h.getDay()-d.getDay();
			            			  System.out.println(i+"��");
		            			  }
		            			  
		            		  }else{
		            			  
		            			  int i=h.getMonth()-d.getMonth();
		            			  System.out.println(i+"��");
		            		  }
		            		  
		            		  
		            		  
		            	
		            	  
		            	 
		            	 
		            	 
		            	
		            	  }else{
		            		  
		            		  int i=h.getYear()-d.getYear();
		            		  System.out.println(i);
		            		  
		            		  
		            	  }
		            	  
		            	  
		            	  
		            }
		            
		            
		            
		            
		          
		
		
	}
	
	
	
}
