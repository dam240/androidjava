package com.cd.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cd.po.user;
@Component("dao")
public class daouse implements usedao {

	
	public HibernateTemplate getHi() {
		return hi;
	}
    @Resource
	public void setHi(HibernateTemplate hi) {
		this.hi = hi;
	}

	private HibernateTemplate hi;
	
	/*
	private  SessionFactory ses;
	

	public SessionFactory getSes() {
		return ses;
	}
@Resource
	public void setSes(SessionFactory ses) {
		this.ses = ses;
	}
	
	*/
	public void save(user use) {
	
		/*
		Session s=ses.openSession();
		s.beginTransaction();
		System.out.println(use.getUsername());
		s.save(use);

		s.getTransaction().commit();

	*/
		
		hi.save(use);
	}

	public void delete(user use) {
		// TODO Auto-generated method stseub

	}

	public void update(user use) {
		// TODO Auto-generated method stub

	}

	public List queryAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public user queryByID(String username) {

		    user j=(user) hi.get(user.class, username);
		     
	if(j==null){
		System.out.println("aaaaaa");
	}
		  
		     
		return j;
	}

}
