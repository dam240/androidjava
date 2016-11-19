package com.cd.user.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cd.user.dao.tweendao;
import com.cd.user.po.tool;
import com.cd.user.po.tween;

@Service("tweens")
public class tweenservice implements tweenser {

	private tweendao twdao;
	
	@Resource
	public void setTwdao(tweendao twdao) {
		this.twdao = twdao;
	}


	public void insert(tween t) {
		// TODO Auto-generated method stub

		
		this.twdao.insert(t);
		
		
	}


	public List<tween> mytween(tool t) {
		// TODO Auto-generated method stub
		return twdao.mytween(t);
	}


	public List<tween> tweenf(tool t) {
		// TODO Auto-generated method stub
		return twdao.tweenf(t);
	}


	public int count(String id) {
		// TODO Auto-generated method stub
		return twdao.count(id);
	}


	public int count2(String id) {
		// TODO Auto-generated method stub
		return twdao.count2(id);
	}


	public void updatete(tween t) {
		// TODO Auto-generated method stub
		twdao.updatete(t);
	}

}
