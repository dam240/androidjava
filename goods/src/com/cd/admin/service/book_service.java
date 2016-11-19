package com.cd.admin.service;

import java.util.List;

import com.cd.admin.model.book;

public interface book_service {

	public List<book>  listall(int index, int seve,int id);
	
	 public int look_size(book p);
	public List<book> look_book(book p,int index, int seve);
	
}
