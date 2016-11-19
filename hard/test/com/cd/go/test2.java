package com.cd.go;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cd.user.po.Tools;
import com.cd.user.po.tool;
import com.cd.user.po.tween;
import com.cd.user.service.tweenser;

public class test2 {

	@Test
	public void test() {
		ApplicationContext  applicationContext=new ClassPathXmlApplicationContext("beans.xml");
		
        tweenser s= (tweenser) applicationContext.getBean("tweens");
	
	  
          tool t=new tool();
           t.setId("100086");
           int j=1;
          
          t.setSize(3);
          
         int cout= Tools.countpage(s.count("100086"), 3);
         
                     t.setIndex( Tools.page(j, 3)); 
                     
      List<tween>li=s.tweenf(t);
          
      for(tween i:li){
    	  
    	  System.out.println(i.getId());
      }
      
      
	}

}
