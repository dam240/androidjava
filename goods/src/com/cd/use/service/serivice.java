package com.cd.use.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cd.admin.dao.bean_dao;
import com.cd.admin.model.book;
import com.cd.admin.model.book_use;
import com.cd.use.dao.useMapper;
import com.cd.use.model.car;
import com.cd.use.model.order;
import com.cd.use.model.use;

@Service("ser")
public class serivice implements seri {

	private useMapper usedao;
	private bean_dao dao;
	
	
	@Resource
	public void setDao(bean_dao dao) {
		this.dao = dao;
	}

	public useMapper getUsedao() {
		return usedao;
	}

    @Resource
	public void setUsedao(useMapper usedao) {
		this.usedao = usedao;
	}


	@Override
	public void save(use u) {
		// TODO Auto-generated method stub
      usedao.save(u);
	}

	@Override
	public boolean one(String usename) {
		// TODO Auto-generated method stub
		
		 boolean boo=true;
		
		 int i=usedao.one(usename);
		 if(i>0){
			 
			  boo =false;
		 }
		 
		 
		return boo;
	}

	@Override
	public boolean end(String email) {
		// TODO Auto-generated method stub
		
		

		 boolean boo=true;
		
		 int i=usedao.end(email);
		 if(i>0){
			 
			  boo =false;
		 }
		 
		 
		return boo;
	}

	@Override
	public boolean load(String usename, String psw) {
		// TODO Auto-generated method stub
		
		
		boolean bool=false;
			
	  use u=null;
	try {
		u = usedao.load(usename);
	boolean ji=	 u.getPsw().equals(psw);
 
         if(ji){
        	 
        	 bool=true;
         }
      
			
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		
		bool=false;
		
		
		e.printStackTrace();
	}
		
	


	

		
		return bool;
	}

	@Override
	public List<book_use> qnull() {
		// TODO Auto-generated method stub
		return usedao.qnull();
	}

	@Override
	public List<book_use> list(int pid) {
		// TODO Auto-generated method stub
		return usedao.list(pid);
	}

	@Override
	public int use_book_size(int id) {
		// TODO Auto-generated method stub
		return usedao.use_book_size(id);
	}

	@Override
	public book use_book(int id) {
		// TODO Auto-generated method stub
		return usedao.use_book(id);
	}

	@Override
	public List<book> use_list_use(String book_name,int index,int seve) {
		// TODO Auto-generated method stub
		return dao.use_ui(book_name, index, seve);
	}

	@Override
	public int book_count(String book_name) {
		// TODO Auto-generated method stub
		return dao.book_count(book_name);
	}

	@Override
	public void car_save(car p) {
		// TODO Auto-generated method stub
	usedao.car_save(p);
	}

	@Override
	public List<car> load_my(String usename) {
		// TODO Auto-generated method stub
		return usedao.load_my(usename);
	}

	@Override
	public void delete_car(int id) {
		// TODO Auto-generated method stub
		usedao.delete_car(id);
	}

	@Override
	public void up_car(car c) {
		// TODO Auto-generated method stub
		usedao.up_car(c);
	}

	@Override
	public void order_save(order o) {
		// TODO Auto-generated method stub
		usedao.order_save(o);
	}

	@Override
	public order look_order(String name) {
		// TODO Auto-generated method stub
		return usedao.look_order(name);
	}

	@Override
	public List<order> show_my(String use) {
		// TODO Auto-generated method stub
		return usedao.show_my(use);
	}

	@Override
	public List<car> show_p(String so) {
		// TODO Auto-generated method stub
		return usedao.show_p(so);
	}

	@Override
	public List<order> admin_fun() {
		// TODO Auto-generated method stub
		return usedao.admin_fun();
	}

	@Override
	public void up_fun(order o) {
		// TODO Auto-generated method stub
		usedao.up_fun(o);
	}

	@Override
	public void up_zhi_fu(order o) {
		// TODO Auto-generated method stub
		
		usedao.up_zhi_fu(o);
	}

	@Override
	public List<order> fun2() {
		// TODO Auto-generated method stub
		return usedao.fun2();
	}

	@Override
	public List<order> zhi_fu() {
		// TODO Auto-generated method stub
		return usedao.zhi_fu();
	}

	@Override
	public List<order> m_zhi_fu() {
		// TODO Auto-generated method stub
		return usedao.m_zhi_fu();
	}

	@Override
	public List<order> w_c() {
		// TODO Auto-generated method stub
		return usedao.w_c();
	}

	@Override
	public List<order> qi_s() {
		// TODO Auto-generated method stub
		return usedao.qi_s();
	}

}
