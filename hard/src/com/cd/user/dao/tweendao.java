package com.cd.user.dao;

import java.util.List;

import com.cd.user.po.tool;
import com.cd.user.po.tween;

public interface tweendao {
	
	public void insert(tween t);
	public List<tween>mytween(tool t);
     public List<tween>tweenf(tool t);
     
     public int count(String id);
     
     public int count2(String id);

      public void updatete(tween t);
}
