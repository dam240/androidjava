package com.cd.user.action;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cd.user.po.Tools;
import com.cd.user.po.page;
import com.cd.user.po.tool;
import com.cd.user.po.tween;
import com.cd.user.po.tweenM;
import com.cd.user.po.user;
import com.cd.user.service.tweenser;
import com.cd.user.service.user_ser;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.net.ssl.HttpsURLConnection;
@Controller("Twe")
@Scope("prototype")
public class TweenA extends ActionSupport implements ModelDriven<tween> {

	private tweenser tweens;
	private user_ser uservice;
	private String  Longitude;
	private String Latitude;
	private tween tw;
	private String id;
	private int now;
	
	
	 public void setId(String id) {
		this.id = id;
	}



	public void setNow(int now) {
		this.now = now;
	}



	public void setLongitude(String longitude) {
		Longitude = longitude;
	}



	public void setLatitude(String latitude) {
		Latitude = latitude;
	}



	public tween getTw() {
		return tw;
	}



	public void setTw(tween tw) {
		this.tw = tw;
	}



	public tween getModel() {
	        return tw;
	    }

	
	
	@Resource
	public void setUservice(user_ser uservice) {
		this.uservice = uservice;
	}


	@Resource
	public void setTweens(tweenser tweens) {
		this.tweens = tweens;
	}
	
	
	
	public void insert ()throws Exception{
		HttpServletResponse  http=ServletActionContext.getResponse();
		http.setCharacterEncoding("utf-8");
		http.setContentType("text/html;charset=UTF-8");
		PrintWriter p =http.getWriter();
		
		if(this.tw.getUse_id()!=null&&!this.tw.getUse_id().equals("")){
			
		    user u=uservice.load(tw.getUse_id());
		      if(u.getUser_id().equals(tw.getUse_id())){
			
		    	  
		    	  
		    	  
		    	  tween ui=this.tw;
		    	  
		    	  ui.setTiem(new Date().toLocaleString());
		    	  ui.setImage(u.getPhoto());
		    	   ui.setUse_name(u.getUser_name());
		    	   
		    	  this.tweens.insert(ui);  
		    	  
		    	  p.println("成功");
		    	  
		    	  
		      }else{
					p.println("用户id不对");
		      }
			
		}else{
			
			p.println("不能为空");
		}
		
		
		
		
		
		p.close();
		
	}
	
	
	public void mytween()throws Exception{
		
		HttpServletResponse  http=ServletActionContext.getResponse();
		http.setCharacterEncoding("utf-8");
		http.setContentType("text/html;charset=UTF-8");
		PrintWriter p =http.getWriter();
		
if(this.tw.getUse_id()!=null&&!this.tw.getUse_id().equals("")){
			
		    user u=uservice.load(tw.getUse_id());
		      if(u.getUser_id().equals(tw.getUse_id())){
		    	  
		    	  
		     	  tool t=new tool();
		           t.setId(tw.getUse_id());
		           
		    	   t.setSize(Tools.size);
		    	   
		    	  int c= tweens.count2(tw.getUse_id());
		    	   int cont= Tools.countpage(c, Tools.size);
		           if(now==0){
		    	     t.setIndex( Tools.page(now, Tools.size)); 
		           }else{
		        	   t.setIndex( Tools.page(now-1, Tools.size)); 
		        	   
		           }       
		    	      
		           
		           
		    	  
		    	    List<tween>list=tweens.mytween(t);
		    	  
		    	     for(tween ui:list){
		    	    	
		    	    	if(!u.getUser_name().equals(ui.getUse_name())||!u.getPhoto().equals(ui.getImage())){
		    	    		
		    	    		 tween o=new tween();
		    	    		 o.setId(ui.getId());
		    	    		o.setUse_id(tw.getUse_id());
		    	    		o.setUse_name(u.getUser_name());
		    	    		o.setImage(u.getPhoto());
		    	    		
		    	    		tweens.updatete(o);
		    	    		
		    	    		
		    	    			
		    	    			ui.setImage(u.getPhoto());
		    	    			ui.setUse_name(u.getUser_name());
		    	    		
		    	    	}
		    	     }
		    	    
		    	    
		    	    Gson g=new Gson();
		    	    
		    	    String li=g.toJson(list);
		    	    
		    	    p.println(li);
		    	  
		    	  
		      }else{
					p.println("用户不存在！");
		      }
		      

}else{
	
	p.println("用户id不能为空!");
}
p.close();
	}
	
	
	
	
	public void setlist()throws Exception{
		
		HttpServletResponse  http=ServletActionContext.getResponse();
		http.setCharacterEncoding("utf-8");
		http.setContentType("text/html;charset=UTF-8");
		PrintWriter p =http.getWriter();
	
			URL u=new URL("http://api.map.baidu.com/geocoder/v2/?ak=VwZ8IwRHQgDc8jiinrnG2GDsjtVcTM0p&callback=renderReverse&location="+this.Latitude+","+this.Longitude+"&output=json&pois=0"); 
		
		
	       
			HttpURLConnection h=   	  (HttpURLConnection) u.openConnection();
			
			h.setDoInput(true);
			h.setDoOutput(true);
			h.setConnectTimeout(100000);
			h.setReadTimeout(100000);
			h.setRequestProperty("Content-type", "text/json");
			   h.setRequestProperty("Accept-Charset", "UTF-8");
			   h.setRequestProperty("contentType", "UTF-8");
			    
			    h.setRequestProperty("content-type", "application/x-www-form-urlencoded;charset=UTF-8");
			h.setRequestMethod("POST");
			 /* h.setRequestProperty("Content-type", "text/json");
			   h.setRequestProperty("Accept-Charset", "UTF-8");
			   h.setRequestProperty("contentType", "UTF-8");*/
			    
			    //h.setRequestProperty("content-type", "application/x-www-form-urlencoded;charset=UTF-8");
                //h.setRequestProperty("Charset", "utf-8");
			h.connect();
			if(h.getResponseCode()==200){
				
				
				
				
				
          BufferedInputStream	bai=new BufferedInputStream(h.getInputStream());
          ByteArrayOutputStream baos=new ByteArrayOutputStream();

			int i= 0;	
            byte[] ba=new byte[512];
				while((i=bai.read(ba))!=-1){
				
					 baos.write(ba, 0, i);

				}
				
				bai.close();
				
				String s=baos.toString("utf-8");
				
				System.out.println(baos.toString("utf-8"));
				//System.out.println(s);
				
				p.println(s);
				
				
			}
			
			p.close();
		
		
		
		
	}
	
	
	
	
	public void  index()throws Exception{
		
		HttpServletResponse  http=ServletActionContext.getResponse();
		http.setCharacterEncoding("utf-8");
		http.setContentType("text/html;charset=UTF-8");
		PrintWriter p =http.getWriter();
	
		if(id!=null&&!id.equals("")){
			
			
		    user u=uservice.load(id);
		      if(u.getUser_id().equals(id)){
		    	  
		    	  
		    	  tool t=new tool();
		           t.setId(id);
		           
		    	   t.setSize(Tools.size);
		    	   
		    	  int c= tweens.count(id);
		    	   int cont= Tools.countpage(c, Tools.size);
		           if(now==0){
		    	     t.setIndex( Tools.page(now, Tools.size)); 
		           }else{
		        	   t.setIndex( Tools.page(now-1, Tools.size)); 
		        	   
		           }
		
		             		             List<tween>list=tweens.tweenf(t);
		           
		           Gson g=new Gson(); 
		      String  str=g.toJson(list);
		      
		      p.println(str);
		      
		      
		      
		      }else{
		    	  
					p.println("用户不存在！");

		      }
			
			
		}else{
			
			p.println("用户ID 不能为空！");
		}
		
		
		
		
		
		p.close();
	}
	
	
	
	public void  count()throws Exception{
		
		HttpServletResponse  http=ServletActionContext.getResponse();
		http.setCharacterEncoding("utf-8");
		http.setContentType("text/html;charset=UTF-8");
		PrintWriter p =http.getWriter();
	
		if(id!=null&&!id.equals("")){
			
			
		    user u=uservice.load(id);
		      if(u.getUser_id().equals(id)){
		    	  
		    	  
		    	  
		    	   
		    	  int c= tweens.count(id);
		    	   int cont= Tools.countpage(c, Tools.size);
		      
		
		             page pi=new page();
		             pi.setCount(cont);
		              pi.setNow(now);
		           
		           Gson g=new Gson(); 
		      
		      
		      p.println(g.toJson(pi));
		      
		      
		      }else{
		    	  
					p.println("用户不存在！");

		      }
			
			
		}else{
			
			p.println("用户ID 不能为空！");
		}
		
		
		
		
		
		p.close();
		
		
	}
	
	
	
public void  count2()throws Exception{
		
		HttpServletResponse  http=ServletActionContext.getResponse();
		http.setCharacterEncoding("utf-8");
		http.setContentType("text/html;charset=UTF-8");
		PrintWriter p =http.getWriter();
	
		if(id!=null&&!id.equals("")){
			
			
		    user u=uservice.load(id);
		      if(u.getUser_id().equals(id)){
		    	  
		    	  
		    	  
		    	   
		    	  int c= tweens.count2(id);
		    	   int cont= Tools.countpage(c, Tools.size);
		      
		
		             page pi=new page();
		             pi.setCount(cont);
		              pi.setNow(now);
		           
		           Gson g=new Gson(); 
		      
		      
		      p.println(g.toJson(pi));
		      
		      
		      }else{
		    	  
					p.println("用户不存在！");

		      }
			
			
		}else{
			
			p.println("用户ID 不能为空！");
		}
		
		
		
		
		
		p.close();
		
		
	}
}
