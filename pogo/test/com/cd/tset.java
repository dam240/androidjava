package com.cd;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cd.action.allshow;
import com.cd.action.allshow2;
import com.cd.action.oneaction;
import com.cd.action.useall;
import com.cd.dao.atid;
import com.cd.dao.btdao;
import com.cd.dao.daouse;
import com.cd.dao.fy;
import com.cd.po.Info;
import com.cd.po.alluser;
import com.cd.po.ati;
import com.cd.po.tcp;
import com.cd.po.user;
import com.cd.serveic.atiservice;
import com.cd.serveic.biser;
import com.cd.serveic.useserve;

public class tset {

	@Test
	public void test()throws Exception {
		
		ApplicationContext c= new  ClassPathXmlApplicationContext("beans.xml");
		
		useserve h=(useserve)c.getBean("usee");
		 user us=new user();
		 us.setUsername("122000");
		 h.usesave(us);
		
		
	}

	

	@Test
	public void test1()throws Exception {
	
		ApplicationContext c= new  ClassPathXmlApplicationContext("beans.xml");
		btdao da=(btdao)c.getBean("bio");
		
		Info f=new Info();
		f.setUsername("ssss");
		f.setIdiograph("jjjjjj");
		f.setBlogtitle("jjjj");
	
	 System.out.println(		da.load("dameng").getUsername());	
	}



	@Test
	public void test2()throws Exception {
		
		ApplicationContext c= new  ClassPathXmlApplicationContext("beans.xml");
		
     atid h=(atid)c.getBean("at");
	
    System.out.println(h.allcou());
		
	}


	@Test
	public void test3()throws Exception {
		
		ApplicationContext c= new  ClassPathXmlApplicationContext("beans.xml");
		
     atid h=(atid)c.getBean("at");
	
     
        alluser sa=new alluser();
     
         h.allsave(sa);
         
		
	}

	
	
	

	@Test
	public void test5()throws Exception {
		
		ApplicationContext c= new  ClassPathXmlApplicationContext("beans.xml");
		
     atid h=(atid)c.getBean("at");
	
        tcp o=new tcp();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String stime = sdf.format(new Date());
		Date time = sdf.parse(stime);
        o.setIp("11");
		o.setTiem(stime);  
        
        
         h.addtiem(o);
         
		
	}

	



	@Test
	public void test6()throws Exception {
		
		ApplicationContext c= new  ClassPathXmlApplicationContext("beans.xml");
		
     fy h=(fy)c.getBean("ss");
	
        tcp o=new tcp();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String stime = sdf.format(new Date());
	
	
        o.setTiem(stime);  
        o.setIp("11");
        o.setAid(0);
    
     System.out.println(h.loadtiem(o));
         
		
	}

	

	@Test
	public void test7()throws Exception {
		
		ApplicationContext c= new  ClassPathXmlApplicationContext("beans.xml");
		
     useall h=(useall)c.getBean("dj");
	
    h.setId(2);
    System.out.println(h.execute());
         
		
	}
	
}

