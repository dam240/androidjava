package com.cd.dao;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import com.cd.po.Info;

@Component("bio")

public class btdaoimp implements btdao {

	
	
private  SessionFactory ses;
	

	public SessionFactory getSes() {
		return ses;
	}
@Resource

	public void setSes(SessionFactory ses) {
		this.ses = ses;
	}
	
	
	public void save(Info in) {
		
	Session s=ses.getCurrentSession();
		s.beginTransaction();
		s.saveOrUpdate(in);
		s.getTransaction().commit();
	}
	public Info load(String username) {
		
		
         
		Session s=ses.getCurrentSession();
			s.beginTransaction();
			Info in=(Info) s.get(Info.class, username);
			s.getTransaction().commit();
		
		return in;
	}
	
	
	

}
