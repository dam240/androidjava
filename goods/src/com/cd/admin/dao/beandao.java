package com.cd.admin.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.cd.admin.model.book;

@Repository("dao")
public class beandao implements bean_dao {

	private SqlSessionTemplate sqlSession;
	
	@Resource
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}


	@Override
	public List<book> listall( int index, int seve,int id) {
		// TODO Auto-generated method stub

		
		String k="com.cd.admin.dao.adminMapper.selectUserByPage";
		RowBounds rowBound=new RowBounds(index,seve);
		
		List<book> listall=sqlSession.selectList(k, id, rowBound);
		
		return listall;
	}

	
	

	@Override
	public List<book> look_book(book p,int index, int seve) {
		// TODO Auto-generated method stub
		
		String k="com.cd.admin.dao.adminMapper.look_book";
		RowBounds rowBound=new RowBounds(index,seve);
		List<book> listall=sqlSession.selectList(k, p,rowBound);
	
         
		return listall;
	}


	@Override
	public int look_size(book p) {
		// TODO Auto-generated method stub
		
		String k="com.cd.admin.dao.adminMapper.look_size";
		int o=sqlSession.selectOne(k, p);
		return o;
	}


	@Override
	public List<book> use_ui(String book_name,int index,int seve) {
		// TODO Auto-generated method stub
		
		
		book m=new book();
		m.setBook_name(book_name);
		RowBounds rowBound=new RowBounds(index,seve);
		String k="com.cd.admin.dao.adminMapper.look_conut";
		List<book> listall=sqlSession.selectList(k, m, rowBound);
		return listall;
	}


	@Override
	public int book_count(String book_name) {
		// TODO Auto-generated method stub
		
		String k="com.cd.admin.dao.adminMapper.look_use_ui";
		book m=new book();
		m.setBook_name(book_name);
		
		
		return sqlSession.selectOne(k,m);
	}



}
