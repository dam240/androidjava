package com.cd.admin.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.cd.admin.model.book;
import com.cd.admin.model.book_use;
import com.cd.admin.service.adim_ser;
import com.cd.admin.service.book_service;
import com.cd.bean.broy;
import com.cd.bean.mode;
import com.cd.bean.page;
import com.cd.bean.page1;
import com.opensymphony.xwork2.ActionSupport;


@Component("dan")
@Scope("prototype")
public class book_list extends ActionSupport {

private adim_ser adm;
private book_service book_size;
private int now;

private String bname;
private String author;
private String press;
public void setBname(String bname) {
	this.bname = bname;
}
public void setAuthor(String author) {
	this.author = author;
}
public void setPress(String press) {
	this.press = press;
}
public void setNow(int now) {
	this.now = now;
}
@Resource
public void setBook_size(book_service book_size) {
	this.book_size = book_size;
}


private int pid;
@Resource
public void setAdm(adim_ser adm) {
	this.adm = adm;
}
public void setPid(int pid) {
	this.pid = pid;
}
@Override
public String execute() throws Exception {
	// TODO Auto-generated method stub
	
	HttpServletRequest sq=  ServletActionContext.getRequest();
	HttpSession s=sq.getSession();
	 int count=adm.all_book(pid).size();
	   
	 page1 p=new page1();    
	   p.setNow(now);
	   p.setSize(5);
	   System.out.println("11111"+count);
	    page1 ha=broy.io(p, count);
	    
	    List<book> li =this.book_size.listall(ha.getIndex(), ha.getSize(), pid);
	        System.out.println("999"+ha.getCunot());
	     sq.setAttribute("page",ha);
      sq.setAttribute("li",li);	    
	   s.setAttribute("id", pid);  
	   
	  
	return super.execute();
}


public String size_list(){
	
	
	 HttpServletRequest sq= ServletActionContext.getRequest();
		HttpSession s=sq.getSession();
		int id=(Integer) s.getAttribute("id");
	   int count=adm.all_book(id).size();
	   page1 p=new page1();    
	   p.setNow(now);
	   p.setSize(5);
	    page1 ha=broy.io(p, count);
	    System.out.println("--------"+now);
	    List<book> li =this.book_size.listall(ha.getIndex(), ha.getSize(), id);
	    System.out.println("666"+ha.getCunot());
	     sq.setAttribute("page",ha);
        sq.setAttribute("li",li);	    
	   
	   
	   
	
	return SUCCESS;
}


public String  dan_book()
{
	HttpServletRequest sq= ServletActionContext.getRequest(); 
    	 book li=adm.dan_book(pid);
        System.out.println("ssssssssss");

		 List <book_use>go=adm.qnull();
		sq.setAttribute("li", go);
	   sq.setAttribute("book", li);
	
	return SUCCESS;
}



public String min(){
	
	HttpServletRequest sq=ServletActionContext.getRequest();
	HttpSession sw=  sq.getSession();
	    book k=new book();
	    k.setBook_name(bname);
	    k.setChu(press);
	    k.setZuo(author);
	      mode me=new mode(); 
	      me.setAuthor(author);
	      me.setBname(bname);
	      me.setPress(press);
	    System.out.println("22"+bname+press+author);
	    int count=book_size.look_size(k);
		   
		 page1 p=new page1();    
		   p.setNow(now);
		   p.setSize(5);
		   System.out.println("11111"+count);
		    page1 ha=broy.io(p, count);
		    
	   List <book> li=book_size.look_book(k,ha.getIndex(), ha.getSize());

	   
	   sw.setAttribute("b1", bname);
	   sw.setAttribute("b2", press);
	   sw.setAttribute("b3", author);

	  sq.setAttribute("li", li);
	
	  sq.setAttribute("page", ha);
	 
	return SUCCESS;
}

public String tuo(){

  
	HttpServletRequest sq=ServletActionContext.getRequest();
	HttpSession sw=  sq.getSession();

  String b1= (String) sw.getAttribute("b1"); 
  String b2= (String) sw.getAttribute("b2"); 
  String b3= (String) sw.getAttribute("b3"); 
 
	    book k=new book();
	    k.setBook_name(b1);
	    k.setChu(b2);
	    k.setZuo(b3);
	    System.out.println("1lllhdhdhsahdhh");
	  
	    System.out.println("3333"+b1+b2+b3);
	    int count=book_size.look_size(k);
		   
		 page1 p=new page1();    
		   p.setNow(now);
		   p.setSize(5);
		
		    page1 ha=broy.io(p, count);
		    
	   List <book> li=book_size.look_book(k,ha.getIndex(), ha.getSize());

	   
	     
	  sq.setAttribute("li", li);
	
	  sq.setAttribute("page", ha);

	return SUCCESS;
}


}
