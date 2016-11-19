package com.cd.user.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cd.user.po.chat;
import com.cd.user.po.user;
@Service("chatser")
public class chatser implements thatservice {
	
	
	private com.cd.user.dao.chatdao chatdao;
	
    @Resource
	public void setChatdao(com.cd.user.dao.chatdao chatdao) {
		this.chatdao = chatdao;
	}

	public void insertchat(chat c) {
		// TODO Auto-generated method stub

		chatdao.insertchat(c);
		
	}

	public List<chat> myandchat(chat c) {
		// TODO Auto-generated method stub
		return chatdao.myandchat(c);
	}

	public void up(chat c) {
		// TODO Auto-generated method stub
		chatdao.up(c);
	}

	public List<user> luser(chat c) {
		// TODO Auto-generated method stub
		return chatdao.luser(c);
	}

}
