package com.cd.user.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cd.user.po.chat;
import com.cd.user.po.user;
import com.cd.user.service.thatservice;
import com.cd.user.service.user_ser;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

@Controller("chatA")
@Scope("prototype")
public class chataction extends ActionSupport{

	private thatservice chatser;
	private String name;
	private String user_id;
	private String you;
	private String text;
	private File photo;
	private String  photoFileName;
	private user_ser uservice;
	private int id;
	
        
	
	public void setId(int id) {
		this.id = id;
	}



	@Resource
	public void setUservice(user_ser uservice) {
		this.uservice = uservice;
	}



	public void setName(String name) {
		this.name = name;
	}



	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}



	public void setYou(String you) {
		this.you = you;
	}



	public void setText(String text) {
		this.text = text;
	}



	public void setPhoto(File photo) {
		this.photo = photo;
	}



	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}



	@Resource
	public void setChatser(thatservice chatser) {
		this.chatser = chatser;
	}
	
	
	
	public void chatinsert()throws Exception{
		
		HttpServletResponse  http=ServletActionContext.getResponse();
		http.setCharacterEncoding("utf-8");
		http.setContentType("text/html;charset=UTF-8");
		PrintWriter p =http.getWriter();
		
		if(!this.user_id.equals("")&&this.user_id!=null&&!this.you.equals("")&&this.you!=null&&!this.name.equals("")&&this.name!=null)
		{
			          
	                  chat c=new chat();
	                  
	                  c.setName(name);
	                  c.setUser_id(user_id);
	                  c.setYou(you);
	                    Date d=new Date();
	                    DateFormat da=DateFormat.getDateInstance();
	                    
	                      c.setDate(da.format(d));
	                      
	                    
	                  
	                  if(this.text!=null&&!this.text.equals("")){
	                	  
	                	  c.setText(text);
	                  }else{
	                	  
	                	  c.setText("A");
	                  }
	                  
	                  if(this.photo!=null){
	                	  
	                	   String path=ServletActionContext.getServletContext().getRealPath("/");
	               
	                	   
	                	     BufferedInputStream bufferedInputStream=new BufferedInputStream(new FileInputStream(photo));
	                	   
	                	     
	                	     
	                	     
	                	   
	                	  String na=this.user_id+"/"+this.photoFileName;
	                	  
	                	  File file=new File(path+na);
	                	  
	                	  if(!file.exists()){
	                		  
	                		  file.getParentFile().mkdirs();
	                		  
	                		  
	                	  }
	                	  
	                	  
	                	  BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(new FileOutputStream(file));
	                	  
	                	  int i=0;
	                	  byte [] b=new byte[1024];
	                	  
	                	  while((i=bufferedInputStream.read(b))!=-1){
	                		  
	                		  bufferedOutputStream.write(b, 0, i);
	                		 
	                		  
	                	  }
	                	  
	                	  bufferedOutputStream.flush();
	                	  bufferedOutputStream.close();
	                	  bufferedInputStream.close();
	                	  
	                	  
	                	  c.setPhoto(na);
	                	  
	                  }else{
	                	  
	                	  c.setPhoto("A");
	                  }
	                  
	                  c.setBid("A");
	                  c.setTiem(d.toLocaleString());
	                  
			         chatser.insertchat(c);
			         p.println("成功");
			
		}else{
			
			p.println("用户不能为空");
			
		}
		
		
		
     p.close();
	}

	
	
	public void myinfo()throws Exception{
		
		
		HttpServletResponse  http=ServletActionContext.getResponse();
		http.setCharacterEncoding("utf-8");
		http.setContentType("text/html;charset=UTF-8");
		PrintWriter p =http.getWriter();
		
		if(!this.user_id.equals("")&&this.user_id!=null)
		{
			 
			    user u=uservice.load(user_id);
		      if(u.getUser_id().equals(user_id)){
		    	  
		    	     chat c=new chat();
		    	     c.setUser_id(user_id);
		    	     
		    	     Date d=new Date();
	                    DateFormat da=DateFormat.getDateInstance();
	                    
		    	     c.setDate(da.format(d));
		    	     c.setBid("A");
		    	     
		    	    List<chat>list=  this.chatser.myandchat(c);
		    	    
		    	      Gson g=new Gson();
                       String nia=g.toJson(list);
		    	      
                        p.println(nia);
		    	  
		    	  
		      }else{
		    	  
		    		p.println("用户不存在!");
		      }
			    
			
			
			
			
		
        }else{
			
			p.println("用户不能为空");
			
		}
		
		
		
     p.close();
	}
	
	
	
	public void up()throws Exception{
		
		HttpServletResponse  http=ServletActionContext.getResponse();
		http.setCharacterEncoding("utf-8");
		http.setContentType("text/html;charset=UTF-8");
		PrintWriter p =http.getWriter();
		if(this.id!=0){
			
			chat c=new chat();
			 c.setBid("B");
			 c.setId(id); 
			  chatser.up(c);
			  p.println("成功");
			 
			 
		}else{
			p.println("更新失败");
			
		}
		
		p.close();
		
	}
	
	
	
	public void luser() throws Exception{
		
		HttpServletResponse  http=ServletActionContext.getResponse();
		http.setCharacterEncoding("utf-8");
		http.setContentType("text/html;charset=UTF-8");
		PrintWriter p =http.getWriter();
		if(this.user_id!=null&&!this.user_id.equals("")){
			
			chat c=new chat();
			 
			 c.setUser_id(user_id);
			 
			 DateFormat da=DateFormat.getDateInstance();
             
    	     c.setDate(da.format(new Date()));
			List<user>list=this.chatser.luser(c);   

			         Gson g=new Gson();
			            String na= g.toJson(list);
			         
			              p.println(na);
			         
    	    // p.println("成功");
			 
			 
		}else{
			p.println("用户不存在！");
			
		}
		
		p.close();
		
		
		
		
		
}
	
	
	
}
