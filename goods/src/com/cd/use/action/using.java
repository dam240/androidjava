package com.cd.use.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.cd.use.model.use;
import com.cd.use.service.seri;
import com.opensymphony.xwork2.ActionSupport;


@Component("using")
@Scope("prototype")
public class using extends ActionSupport {

	
	

private String reloginpass;
private String loginpass;

private String loginname;
private String email;

public void setReloginpass(String reloginpass) {
	this.reloginpass = reloginpass;
}

private String verifyCode;
private seri ser;



@Resource
public void setSer(seri ser) {
	this.ser = ser;
}



public void setEmail(String email) {
	this.email = email;
}

public void setVerifyCode(String verifyCode) {
	this.verifyCode = verifyCode;
}



public void setLoginname(String loginname) {
	this.loginname = loginname;
}

@Override
public String execute() throws Exception {
	// TODO Auto-generated method stub
	
	
	    HttpServletRequest sq=ServletActionContext.getRequest();                        

	          HttpSession ses= sq.getSession();
	    
	         String sess= (String) ses.getAttribute("checkCode");
	    
	
		
	    if(this.verifyCode.equals(sess))
		 {
			use u=new use();
	    	
			u.setUsename(loginname);
            u.setPsw(reloginpass);
            u.setEmail(email);
	    	
	    	ser.save(u);
			
	    	return SUCCESS;
		 }
	
	
	
	
	
	return ERROR;
}


public void setLoginpass(String loginpass) {
	this.loginpass = loginpass;
}



public String ing()
{
	
	  HttpServletRequest sq=ServletActionContext.getRequest();                        

      HttpSession ses= sq.getSession();

     String sess= (String) ses.getAttribute("checkCode12");
    String su=ERROR;
     
     try {
		if(this.verifyCode.equals(sess))
		 {
			 
			 if(ser.load(loginname, loginpass))
			 {
				 ses.setAttribute("usename",this.loginname );
				 su= SUCCESS;
			 }
			 
			 
		 }
	} catch (Exception e) {
		// TODO Auto-generated catch block
		su=ERROR;
		e.printStackTrace();
	}
	
	return su;
	
}





public String logname()throws Exception
{

    HttpServletResponse my=	 ServletActionContext.getResponse();
   

    
    
    boolean bouu=false;
	
    if(ser.one(loginname))
	 {
		 bouu=true;
		 
	 }
	
	 my.getWriter().print(bouu);
	
	return null;

}

public String email()throws Exception{
	
    HttpServletResponse my=	 ServletActionContext.getResponse();
   

    
    
    boolean bouu=false;
	
    if(ser.end(email))
	 {
		 bouu=true;
		 
	 }
	
	 my.getWriter().print(bouu);
	
	return null;

}


public String jio() throws Exception{
	
    HttpServletResponse my=	 ServletActionContext.getResponse();
    HttpServletRequest sq=ServletActionContext.getRequest();                        

          HttpSession ses= sq.getSession();
    
         String sess= (String) ses.getAttribute("checkCode");
    
    boolean bouu=false;
	
    if(this.verifyCode.equals(sess))
	 {
		 bouu=true;
		 
	 }
	
	 my.getWriter().print(bouu);
	
	return null;

}

public String zhu() throws Exception
{
	
	
    HttpServletResponse my=	 ServletActionContext.getResponse();
    HttpServletRequest sq=ServletActionContext.getRequest();                        

          HttpSession ses= sq.getSession();
    
         String sess= (String) ses.getAttribute("checkCode12");
    
    boolean bouu=false;
   
	System.out.println("dhasdhsahdah");
   
    if(this.verifyCode.equals(sess))
	 {
		 bouu=true;
		 
	 }
	
	 my.getWriter().print(bouu);
	
return null;	
}



}
