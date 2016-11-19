package com.cd.admin.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cd.admin.dao.adminMapper;
import com.cd.admin.model.admin_use;
import com.cd.admin.model.book;
import com.cd.admin.model.book_use;


@Service("adm")
public class ad_service implements adim_ser {

	private adminMapper admin_dao;
	
	@Resource
	public void setAdmin_dao(adminMapper admin_dao) {
		this.admin_dao = admin_dao;
	}

	@Override
	public admin_use load(String usename) {
		// TODO Auto-generated method stub
		
		return admin_dao.load(usename);
	}

	@Override
	public void saveA(book_use u) {
		// TODO Auto-generated method stub
		admin_dao.saveA(u);
	}

	@Override
	public List <book_use> qnull() {
		// TODO Auto-generated method stub
		return admin_dao.qnull();
	}

	@Override
	public void saveB(book_use u) {
		// TODO Auto-generated method stub

		admin_dao.saveB(u);
	}

	@Override
	public List<book_use> list(int pid) {
		// TODO Auto-generated method stub
		return admin_dao.list(pid);
	}

	@Override
	public book_use get(int pid) {
		// TODO Auto-generated method stub
		return admin_dao.get(pid);
	}

	@Override
	public void delete_one(int pid) {
		// TODO Auto-generated method stub
		admin_dao.delete_one(pid);
	}

	@Override
	public void up(book_use u) {
		// TODO Auto-generated method stub

		admin_dao.up(u);
	}

	@Override
	public void up2(book_use u) {
		// TODO Auto-generated method stub
		admin_dao.up2(u);
	}

	@Override
	public void save_book(book u) {
		// TODO Auto-generated method stub
		admin_dao.save_book(u);
	}

	@Override
	public List<book> all_book(int id) {
		// TODO Auto-generated method stub
		return admin_dao.all_book(id);
	}

	@Override
	public book dan_book(int id) {
		// TODO Auto-generated method stub
		return admin_dao.dan_book(id);
	}

	@Override
	public void go_up(book p) {
		// TODO Auto-generated method stub
		admin_dao.go_up(p);
	}

	@Override
	public void delete_book(int pid) {
		// TODO Auto-generated method stub
		
		  admin_dao.delete_book(pid);
	}



}
