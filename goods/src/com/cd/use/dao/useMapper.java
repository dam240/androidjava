package com.cd.use.dao;

import java.util.List;

import com.cd.admin.model.book;
import com.cd.admin.model.book_use;
import com.cd.use.model.car;
import com.cd.use.model.order;
import com.cd.use.model.use;

public interface useMapper {

	public void save(use u);
	
	public int one(String usename);
	
	public int end(String email);

	public use load(String usename);
	
	public List<book_use> qnull();
 
	public List<book_use> list(int pid);
	public int use_book_size(int id);
	
	public book use_book(int id);

	 public void car_save(car p);
	 
	 public List<car> load_my(String usename);
	 
	 
	 public void delete_car(int id);
	 
	 public void up_car(car c);
	 
	 public void  order_save(order o);
	 
	 public order look_order(String name);
	 
	 public List<car> show_p(String so);
	 
	 public List<order> show_my(String use);
    
	 public List<order> admin_fun();
   
    public void up_fun(order o);
    
    public void up_zhi_fu(order o);
    
	 public List<order> fun2();
	 
	 public List<order> zhi_fu();
	 
	 public List<order> m_zhi_fu();
	 public List<order> w_c();
	 
	 public List<order>  qi_s();
}


