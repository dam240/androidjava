package com.cd.admin.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.cd.admin.dao.adminMapper;
import com.cd.admin.dao.bean_dao;
import com.cd.admin.model.book;

@Service("book_size")
public class book_size_list implements book_service {

	
	private bean_dao dao;



	@Resource
	public void setDao(bean_dao dao) {
		this.dao = dao;
	}



	@Override
	public List<book> listall(int index, int seve, int id) {
		// TODO Auto-generated method stub
		return dao.listall(index, seve, id);
	}



	@Override
	public List<book> look_book(book p,int index, int seve) {
		// TODO Auto-generated method stub
		return dao.look_book(p,index,seve);
	}



	@Override
	public int look_size(book p) {
		// TODO Auto-generated method stub
		return dao.look_size(p);
	}



	

}
