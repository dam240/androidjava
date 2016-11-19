package com.cd.admin.service;

import java.util.List;

import com.cd.admin.model.admin_use;
import com.cd.admin.model.book;
import com.cd.admin.model.book_use;

public interface adim_ser {

	public admin_use load(String usename);
	public void saveA(book_use u);
	public void saveB(book_use u );
    public List<book_use>list(int pid);
	public List<book_use> qnull();
	public book_use get(int pid);
	public void save_book(book u);
    public void delete_one(int pid);
    public void up2(book_use u);
    public void up(book_use u);

    public List <book> all_book(int id);
    
    public book dan_book(int id);
    public void go_up(book p);
    public void delete_book(int pid);

}
