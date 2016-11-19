package com.cd.user.dao;

import java.util.List;

import com.cd.user.po.care;
import com.cd.user.po.care1;
import com.cd.user.po.friend;
import com.cd.user.po.tool;
import com.cd.user.po.tool2;
import com.cd.user.po.user;

public interface userMapper {

	
	public void save(user u);
	
	public user userload(String id);
	
	public void upuser(user u);
	
	
	public List<user> mycare(tool t);
	
	public int countcare(String id);
	public int carecount(String id);
	
	public List<user>caremy(tool t);
	public List<user> selectlike(tool2 t);
	
	public int usercount(tool2 t);
	
	public int myand(tool2 t);
	
	public void insertmyg(tool2 t);
	public void deletecare(tool2 t);
	
	public void insertfriend(friend f);
	
	public List<user>seeF(String id);
	
	public void upfriend(friend f);
	public void deleteF(friend f);
	
	public user seeMYF(friend f);
	
	public List<user>failF(String id);
	
	public List<user> seelistF(String id);
}
