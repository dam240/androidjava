package com.cd.admin.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Component;

import com.cd.user.po.user;

@Component("adminda")
public class fenim implements fen {

	private SqlSessionTemplate sqlSession;
	

    @Resource
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	
	public List<user> getlist(int index, int szie) {
		// TODO Auto-generated method stub

		  RowBounds rowBounds=new RowBounds(index, szie);
		
		
		
		return  sqlSession.selectList("com.cd.admin.dao.adminL.getlist", null, rowBounds);
	
	}

}
