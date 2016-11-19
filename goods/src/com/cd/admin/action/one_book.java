package com.cd.admin.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.cd.admin.model.bean;
import com.cd.admin.model.book;
import com.cd.admin.model.book_use;
import com.cd.admin.service.adim_ser;
import com.opensymphony.xwork2.ActionSupport;

@Component("one")
@Scope("prototype")
public class one_book extends ActionSupport {

	private  String cname;
	private String desc;
   private adim_ser adm;
	public void setBid(int bid) {
	Bid = bid;
}



	private int pid;
	private int Bid;
	
   public void setPid(int pid) {
		this.pid = pid;
	}
@Resource
	public void setAdm(adim_ser adm) {
	this.adm = adm;
}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
	
		
		if(!cname.equals("")&&cname!=null&&!desc.equals("")&&desc!=null)
		   {
			System.out.println(cname);
			book_use u=new book_use();
			u.setBook_name(cname);
			u.setBook_log(desc);
			
			adm.saveA(u);
			return SUCCESS;
		   }
		
		return ERROR;
	}
	
	public String add(){
		
	
		HttpServletRequest sq  =ServletActionContext.getRequest();
		
		 List <book_use>li=adm.qnull();
		sq.setAttribute("li", li);
		
		
		return SUCCESS;
		
	}
	

	public String add2(){
		
		
		
		
            
		if(!cname.equals("")&&cname!=null&&!desc.equals("")&&desc!=null)
		   {
			System.out.println(pid);
			book_use u=new book_use();
			u.setBook_name(cname);
			u.setBook_log(desc);
			u.setB_id(pid);
			adm.saveB(u);
			return SUCCESS;
		   }
		
		return ERROR;
	}
	
	


	public String list(){
		
	
		HttpServletRequest sq  =ServletActionContext.getRequest();
		
		 List <book_use>li=adm.qnull();
		sq.setAttribute("li", li);
		
		
		return SUCCESS;
		
	}
	

	public String list2(){
		
	
		HttpServletRequest sq  =ServletActionContext.getRequest();
		
		book_use u=null;
		if(pid!=0){
			u=adm.get(pid);
		 List <book_use>li=adm.list(pid);
		 sq.setAttribute("ln", li);

		}else{
			HttpSession sw = sq.getSession();
			
			int id=(Integer) sw.getAttribute("pid");
			 
			u=adm.get(id);
			List <book_use>li=adm.list(id);
			 sq.setAttribute("ln", li);

			
		}
		
		
		sq.setAttribute("book", u);
		
		
		return SUCCESS;
	}
	
	
	
	public String delete1(){
		
		adm.delete_one(pid);
		
		return SUCCESS;
	}
	

	
	public String delete2(){
		
		HttpServletRequest sq  =ServletActionContext.getRequest();
		HttpSession sw=	sq.getSession();
		sw.setAttribute("pid", pid);
		adm.delete_one(Bid);
		
		return SUCCESS;
	}
	
	public String up(){
		
		HttpServletRequest sq  =ServletActionContext.getRequest();

         book_use u=adm.get(pid);

        
 		
              sq.setAttribute("ua", u);
         
		return SUCCESS;
	}
	
	
	public String cu(){
		
		System.out.println(pid+"----"+cname+desc);
		
		book_use u=new book_use();
		u.setA_id(pid);
		u.setBook_name(cname);
		u.setBook_log(desc);
		
		adm.up(u);
		return SUCCESS; 
	}
	
	
	

	public String up2(){
		
		HttpServletRequest sq  =ServletActionContext.getRequest();

         book_use u=adm.get(pid);
         List <book_use>li=adm.qnull();
 		sq.setAttribute("li", li);
 		
        
 		
              sq.setAttribute("ua", u);
         
		return SUCCESS;
	}
	
	
	
	
public String cu2(){
		
		System.out.println(pid+"----"+cname+desc+Bid);
		

		HttpServletRequest sq  =ServletActionContext.getRequest();
		HttpSession sw=	sq.getSession();
		sw.setAttribute("pid", Bid);
		
		book_use u=new book_use();
		u.setA_id(pid);
		u.setBook_name(cname);
		u.setBook_log(desc);
	    u.setB_id(Bid);
	    
	    adm.up2(u);
	    
		return SUCCESS; 
	}
	

public String fen(){
	

	HttpServletRequest sq  =ServletActionContext.getRequest();

	
    List<book_use> u=adm.qnull();
	  	List <List<bean>> ko	 =new ArrayList<List<bean>>();

		 for(book_use k:u){
			 
			List <book_use > l=adm.list(k.getA_id());
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
		   
sq.setAttribute("ko", ko);

		 
		 
	
	return SUCCESS;
}


public String book_list()throws Exception{
	
	HttpServletResponse sq  =ServletActionContext.getResponse();

	
    List<book_use> u=adm.list(pid);

    String json=toJson(u);
     sq.getWriter().print(json);
	
	return null;
}

private String toJson(book_use category) {
	StringBuilder sb = new StringBuilder("{");
	sb.append("\"cid\"").append(":").append("\"").append(category.getA_id()).append("\"");
	sb.append(",");
	sb.append("\"cname\"").append(":").append("\"").append(category.getBook_name()).append("\"");
	sb.append("}");
	return sb.toString();
}

// [{"cid":"fdsafdsa", "cname":"fdsafdas"}, {"cid":"fdsafdsa", "cname":"fdsafdas"}]
private String toJson(List<book_use> categoryList) {
	StringBuilder sb = new StringBuilder("[");
	for(int i = 0; i < categoryList.size(); i++) {
		sb.append(toJson(categoryList.get(i)));
		if(i < categoryList.size() - 1) {
			sb.append(",");
		}
	}
	sb.append("]");
	return sb.toString();
}

}
