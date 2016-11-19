package com.cd.admin.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cd.admin.po.admin;
import com.cd.admin.po.page;
import com.cd.admin.po.toolpage;
import com.cd.admin.service.adminser;
import com.cd.user.po.user;
import com.opensymphony.xwork2.ActionSupport;
@Controller("AIDUS")
@Scope("prototype")
public class Aupdate extends ActionSupport{

	private String id;
	private String name;
	private List<user> list;
	private page pa;
	
	
	public page getPa() {
		return pa;
	}

	public void setPa(page pa) {
		this.pa = pa;
	}

	public List<user> getList() {
		return list;
	}

	public void setList(List<user> list) {
		this.list = list;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}
    private  int now ; 
      
    
	public int getNow() {
		return now;
	}

	public void setNow(int now) {
		this.now = now;
	}
	private String card;

	private File pot;
	private String potFileName;
	private adminser adminS;
	@Resource
	public void setAdminS(adminser adminS) {
		this.adminS = adminS;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub

		  String boo=LOGIN;
		
		HttpServletRequest re   =	ServletActionContext.getRequest();
   
		HttpSession so=   re.getSession();
		
	
		
		  
		
		
		     String unam= (String) so.getAttribute("admin");
		               admin d= adminS.use(unam);
		     if(unam!=null&&unam.equals(d.getId())){
		String img=id+"/";

		 if(pot!=null){
			 BufferedInputStream on=new BufferedInputStream(new FileInputStream(pot));
		
		
		
		  if(on!=null){
		        
			 String path= ServletActionContext.getServletContext().getRealPath("/");
			 System.out.println(path);
			 if(potFileName!=null){
				 
				 System.out.println(potFileName);
				 
			 }
			  
			byte [] b=new byte[512]; 
			  
			  int i=0;
			  File fli=new File(path+img,potFileName);
			  
			  if(!fli.getParentFile().exists()){
				  
				  fli.getParentFile().mkdirs();
				  
			  }
			   BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(new FileOutputStream(fli));
			   
			   
			   while ((i=on.read(b))!=-1) {
				  bufferedOutputStream.write(b, 0, i);
				   
				
			}
			   
			  
			
			   bufferedOutputStream.flush();
			   bufferedOutputStream.close();
			   
			   on.close();
			   
			   admin m=new admin();
			   m.setId(id);
			   m.setCard(card);
			   m.setName(name);
			   m.setPhoto(img+potFileName);
			  
			   adminS.upadmin(m);
			  
			  
			  
		  }
		
		 }
		 
		     
		 boo=SUCCESS;
		     }
		 
		 
		
		
		
		 return boo;
	}

	public File getPot() {
		return pot;
	}

	public void setPot(File pot) {
		this.pot = pot;
	}

	public String getPotFileName() {
		return potFileName;
	}

	public void setPotFileName(String potFileName) {
		this.potFileName = potFileName;
	}


	public String  getlist()throws Exception{
		
		 
		HttpServletRequest re   =	ServletActionContext.getRequest();
		   
		HttpSession so=   re.getSession();
		
		
		     String unam= (String) so.getAttribute("admin");
		     admin d= adminS.use(unam);
		     if(unam!=null&&unam.equals(d.getId())){
		
	          page p=toolpage.ret(now, 2, adminS.getconut());	
		          list=adminS.getlist(p);
		     
		        pa=p;
		        
				return SUCCESS;
		     }
return LOGIN;
	}
	
	
	
	public String  Adetele()throws Exception{
		
		
		HttpServletRequest re   =	ServletActionContext.getRequest();
		   
		HttpSession so=   re.getSession();
		
		
		     String unam= (String) so.getAttribute("admin");
		
		     admin d= adminS.use(unam);
		     
		     if(unam!=null&&unam.equals(d.getId())){
		 		
		    	     adminS.Adelte(id);
		    	 
		    	 	return SUCCESS;
		     }
		     
		return LOGIN;
	
	}
	
	
}
