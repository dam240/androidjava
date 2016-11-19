package com.cd.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cd.admin.model.admin_use;
import com.cd.admin.model.book;
import com.cd.admin.model.book_use;
import com.cd.bean.page;

public interface adminMapper {

	public admin_use load(String usename);
	public void saveA(book_use u );

	public List <book_use> list(int pid);
	public void saveB(book_use u );

	public book_use get(int pid);
	public List<book_use> qnull();

	public void save_book(book u);
    public void delete_one(int pid);

    public void up(book_use u);
    public void up2(book_use u);
    public List <book> all_book(int id);
    public int count(int id);
    
    public book dan_book(int id);
    public void go_up(book p);
    public void delete_book(int pid);


    
    
}
