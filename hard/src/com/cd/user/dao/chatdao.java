package com.cd.user.dao;

import java.util.List;

import com.cd.user.po.chat;
import com.cd.user.po.user;

public interface chatdao {

	
	public void insertchat(chat c);
	
	public List<chat> myandchat(chat c);
	public List<chat> test();
	public void up(chat c);
	public void delete(int id);
	 public List<user> luser(chat c);
}
