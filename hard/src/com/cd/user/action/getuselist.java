package com.cd.user.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cd.user.po.Tools;
import com.cd.user.po.care;
import com.cd.user.po.care1;
import com.cd.user.po.tool;
import com.cd.user.po.tool2;
import com.cd.user.po.user;
import com.cd.user.service.user_ser;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
@Controller("usermode")
@Scope("prototype")
public class getuselist extends ActionSupport {

	
	private String user_id;
	private user_ser uservice;
	
	private File Fname;
         
	private String FnameFileName;
	
	private String user_name;
	
 private String card;
	
	private int now;
	
	


	public int getNow() {
		return now;
	}



	public void setNow(int now) {
		this.now = now;
	}



	public void load()throws Exception{
		
	
		
		HttpServletResponse sq=  ServletActionContext.getResponse(); 
		   sq.setCharacterEncoding("UTF-8");
		   sq.setContentType("text/json;charset=UTF-8");
	
	     user u=uservice.load(user_id);	 
	     Gson g=new Gson();
	     
	    String log= g.toJson(u);
	     
		 sq.getWriter().println(log);
		
	}
	
	
	
	public void useup()throws Exception{
		
		  HttpServletResponse  http=ServletActionContext.getResponse();
			http.setCharacterEncoding("utf-8");
			http.setContentType("text/html;charset=UTF-8");
			PrintWriter p =http.getWriter();
			 
			
			
		System.out.println(this.user_name);
		
		
		  
		if(this.user_id!=null&&!this.user_id.equals("")){
			
			
			 boolean b=this.uservice.userload(user_id);
			
			 if(b){
				 
				 
				 String path=this.user_id+"/";
				 
				  
				 
				 
		
				 
				if (this.Fname!=null){
				
					
					
					
					
			String ht= ServletActionContext.getServletContext().getRealPath("/");
					
				BufferedInputStream inp=new BufferedInputStream(new FileInputStream(this.Fname));
					
	                				
				
					File file=new File(ht+path+this.FnameFileName);
					
					if(!file.getParentFile().exists()){
						
						file.getParentFile().mkdirs();
						
					}
					
				    BufferedOutputStream out=new BufferedOutputStream(new FileOutputStream(file));	  
					
					
				    int i=0;
				    byte [] bs=new byte[1024];
				    
				    while((i=inp.read(bs))!=-1){
				    	
				    	 
				    	out.write(bs, 0, i);
				    	 
				    }
				    
				    
				    out.flush();
				    out.close();
				    inp.close();
				    
				    user u=new user();
				    u.setUser_id(user_id);
				    u.setUser_name(new String(user_name.getBytes(),"GBK"));
				    u.setCard(new String(card.getBytes(),"GBK"));
				    u.setPhoto(path+this.FnameFileName);
				    
				    this.uservice.upuser(u);
				    
					
				  p.print(true);
					
					
					
					
					
				}else{
					 
						p.println("上传失败");
				 }
				 
				 
				 
				 
				 
				 
			 }else{
				 
					p.println("用户不存在");
			 }
			 
			
		
		
		}else{
			
			
			p.println("用户不能为空 ");
		}
		
		
		
		p.close();
		
		
		
	}
	
	
	public void guang()throws Exception{
		
		  HttpServletResponse  http=ServletActionContext.getResponse();
			http.setCharacterEncoding("utf-8");
			http.setContentType("text/html;charset=UTF-8");
			PrintWriter p =http.getWriter();
			 
			

			if(this.user_id!=null&&!this.user_id.equals("")){
				
			            	boolean b=uservice.userload(user_id);
			
			            	if(b){
			            		
			           com.cd.user.po.guang g=new com.cd.user.po.guang();
			        		   
			        		   g.setMyG(uservice.countcare(user_id));
			            		g.setGmy(uservice.carecount(user_id));
			            		
			            		Gson ga=new Gson();
			            		String pa=ga.toJson(g);
			            		
			            		p.println(pa);
			            	}else{
			            		
			            		
			            		p.println("用户不存在");
			            	}
			            	
				
				
				
				
			}else{
				
				p.println("不能为空");
			}
			            	
			p.close();
		
	}
	
	
	
	
	public void U_care() throws Exception{
		
		  HttpServletResponse  http=ServletActionContext.getResponse();
			http.setCharacterEncoding("utf-8");
			http.setContentType("text/html;charset=UTF-8");
			PrintWriter p =http.getWriter();
			 
		
		if(this.user_id!=null&&!this.user_id.equals("")){
			
		            	boolean b=uservice.userload(user_id);
			
		            	if(b){
		            		
		            		 
		            		int count=uservice.countcare(user_id);
		            		  
		            		 int cout=Tools.countpage(count, Tools.size); 
		            		
                                int index =  Tools.page(now,Tools. size);		            		 
		            		 
                                tool t=new tool();
                                t.setId(user_id);
                                t.setIndex(index);
                                t.setSize(Tools. size);
		            		
                                List<user>list  = uservice.mycare(t);
                                
                                
                                Gson g=new Gson();
                               String s= g.toJson(list);
		            		 
                                       care c=new care();
                                       c.setCount(cout);
                                       c.setNow(now);
                              String d= g.toJson(c);
                               p.println(s);
                               p.println(d);
                               
                               
		            	}else{
		            		
		            		
		            		p.println("用户不存在");
		            	}
		            	
			
			
			
			
		}else{
			
			p.println("用户不能为空");
		}
		
		
		p.close();
		
	}
	
	
	
	
	
	
	
	

	public void care_U() throws Exception{
		
		  HttpServletResponse  http=ServletActionContext.getResponse();
			http.setCharacterEncoding("utf-8");
			http.setContentType("text/html;charset=UTF-8");
			PrintWriter p =http.getWriter();
			 
		
		if(this.user_id!=null&&!this.user_id.equals("")){
			
		            	boolean b=uservice.userload(user_id);
			
		            	if(b){
		            		
		            		 
		            		int count=uservice.countcare(user_id);
		            		  
		            		 int cout=Tools.countpage(count, Tools.size); 
		            		
                                int index =  Tools.page(now,Tools. size);		            		 
		            		 
                                tool t=new tool();
                                t.setId(user_id);
                                t.setIndex(index);
                                t.setSize(Tools. size);
		            		
                                List<user>list  = uservice.caremy(t);
                                
                                
                                Gson g=new Gson();
                               String s= g.toJson(list);
		            		 
                                       care c=new care();
                                       c.setCount(cout);
                                       c.setNow(now);
                              String d= g.toJson(c);
                               p.println(s);
                               p.println(d);
                               
                               
		            	}else{
		            		
		            		
		            		p.println("用户不存在");
		            	}
		            	
			
			
			
			
		}else{
			
			p.println("用户不能为空");
		}
		
		
		p.close();
		
	}
	
	
	
	
	

	public void selectuser() throws Exception{
		
		  HttpServletResponse  http=ServletActionContext.getResponse();
			http.setCharacterEncoding("utf-8");
			http.setContentType("text/html;charset=UTF-8");
			PrintWriter p =http.getWriter();
			 
		
		if(this.user_id!=null&&!this.user_id.equals("")&&this.user_name!=null&&!this.user_name.equals("")){
			
			boolean b=uservice.userload(user_id);
			
        	if(b){
		            		 tool2 to=new tool2();
		            		String id="%"+user_name+"%";
		            		String name="%"+user_name+"%";
		            		 to.setId(id);
		            		 to.setName(name);
		            		 
		            		int count=uservice.usercount(to);
		            		  
		            		 int cout=Tools.countpage(count, Tools.size); 
		            		
                                int index =  Tools.page(now,Tools. size);		            		 
		            		 
                                tool2 t=new tool2();
                                t.setId(id);
                                t.setName(name);
                                t.setIndex(index);
                                t.setSize(Tools. size);
		            		
                                List<user>list  = uservice.carelike(t);
                                
                                
                                Gson g=new Gson();
                               String s= g.toJson(list);
		            		 
                                       care c=new care();
                                       c.setCount(cout);
                                       c.setNow(now);
                              String d= g.toJson(c);
                               p.println(s);
                               p.println(d);
                               
                               
		            
			
        	}else{
        		
        		
        		p.println("用户不存在");
        	}
        	
			
			
		}else{
			
			p.println("用户不能为空");
		}
		
		
		p.close();
		
	}
	
	
	
	
	

	

	public void myand() throws Exception{
		
		  HttpServletResponse  http=ServletActionContext.getResponse();
			http.setCharacterEncoding("utf-8");
			http.setContentType("text/html;charset=UTF-8");
			PrintWriter p =http.getWriter();
	
		
		            	            		 
		            		 
                                tool2 t=new tool2();
                                t.setId(this.user_id);
                                t.setName(this.user_name);
                             
		            		     int i = this.uservice.myand(t);
                            
                                
                                Gson g=new Gson();
                             
                                care c=new care();
                                 c.setNow(i);
		                        String ui= g.toJson(c);
			
                                   p.println(ui);
			
	
		
		
		p.close();
		
	}
	
	
	
	
	
	
	
	

	

	public void insertmyg() throws Exception{
		
		  HttpServletResponse  http=ServletActionContext.getResponse();
			http.setCharacterEncoding("utf-8");
			http.setContentType("text/html;charset=UTF-8");
			PrintWriter p =http.getWriter();
			 
		
		if(this.user_id!=null&&!this.user_id.equals("")&&this.user_name!=null&&!this.user_name.equals("")){
			
			boolean b=uservice.userload(user_id);
			
        	if(b){
                               
		           
        		tool2 t=new tool2();
        		
        		t.setId(user_id);
        		t.setName(user_name);
			
        		  this.uservice.insertmyg(t);
        		
        		  p.println("成功");
        		  
        		
        	}else{
        		
        		
        		p.println("用户不存在");
        	}
        	
			
			
		}else{
			
			p.println("不能为空");
		}
		
		
		p.close();
		
	}
	
	
	
	
	
	
	

	
	

	public void deletecare() throws Exception{
		
		  HttpServletResponse  http=ServletActionContext.getResponse();
			http.setCharacterEncoding("utf-8");
			http.setContentType("text/html;charset=UTF-8");
			PrintWriter p =http.getWriter();
			 
		
		if(this.user_id!=null&&!this.user_id.equals("")&&this.user_name!=null&&!this.user_name.equals("")){
			
		            	boolean b=uservice.userload(user_id);
			
		            	if(b){
		            		
		            		 tool2 t=new tool2();
		            		  t.setId(user_id);
		            		  t.setName(user_name); 
		            		
		            		
		            		 this.uservice.deletecare(t);
		            		
                              p.println("成功");  
                               
                               
		            	}else{
		            		
		            		
		            		p.println("用户不存在");
		            	}
		            	
			
			
			
			
		}else{
			
			p.println("不能为空");
		}
		
		
		p.close();
		
	}
	
	
	
	
	
	public String getUser_name() {
		return user_name;
	}



	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}



	public String getCard() {
		return card;
	}



	public void setCard(String card) {
		this.card = card;
	}


	public File getFname() {
		return Fname;
	}



	public void setFname(File fname) {
		Fname = fname;
	}





	public String getFnameFileName() {
		return FnameFileName;
	}



	public void setFnameFileName(String fnameFileName) {
		FnameFileName = fnameFileName;
	}



	public user_ser getUservice() {
		return uservice;
	}



	@Resource
	public void setUservice(user_ser uservice) {
		this.uservice = uservice;
	}



	public String getUser_id() {
		return user_id;
	}



	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	

	

}
