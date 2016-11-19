package com.cd.admin.dao;

import java.util.List;

import com.cd.admin.model.book;

public interface bean_dao {

	
   public List<book> listall(int index,int seve,int id);	

   public int look_size(book p);
   public List<book> look_book(book p,int index, int seve);
   public int book_count(String book_name);
   public List<book> use_ui(String book_name,int index,int seve);
   
}
