package com.cd.user.service;

import java.util.List;

import com.cd.user.po.chat;
import com.cd.user.po.user;

public interface thatservice {

	
	public void insertchat(chat c);
	
	public List<chat> myandchat(chat c);
	public void up(chat c);
	public List<user> luser(chat c);

}
