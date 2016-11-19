package com.cd.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.cd.po.ati;
import com.cd.po.page;
import com.cd.po.tcp;

@Component("ss")
public class fy {

	private SessionFactory ses;

	public SessionFactory getSes() {
		return ses;
	}

	@Resource
	public void setSes(SessionFactory ses) {
		this.ses = ses;
	}
	

	
	public List<ati>  li (page  u,  String us){
		
		Session s=ses.getCurrentSession();
		s.beginTransaction();
		 
		 Query f=	s.createQuery("from ati u where u.username=?").setParameter(0, us);
		
		 f.setFirstResult(u.getBeginIndex());
		 f.setMaxResults(u.getEveryPage());
		 List <ati>d=f.list();
		s.getTransaction().commit();
		

  return d;	
  
	}
	
	
	

	
	

	
	public List<ati>  alluser (page  u){
		
		Session s=ses.getCurrentSession();
		s.beginTransaction();
		 
		 Query f=	s.createQuery("from ati");
		
		 f.setFirstResult(u.getBeginIndex());
		 f.setMaxResults(u.getEveryPage());
		 List <ati>d=f.list();
		s.getTransaction().commit();
		

  return d;	
  
	}
	
	
	

	
	
	
public boolean loadtiem(tcp a) {
	// TODO Auto-generated method stub
    

	Session s=ses.getCurrentSession();
	s.beginTransaction();
	 
	 Query f=	s.createQuery("from tcp");
	
	 List <tcp>d=f.list();
	s.getTransaction().commit();
	
	
	
	for(tcp c:d){
		if(c.getAid()==a.getAid()&&c.getIp().equals(a.getIp())&&c.getTiem().equals(a.getTiem())){
			return false;
		}
	}
	
	
	   
	
	
	
	return true;
}
	


public List<com.cd.po.alluser>  allus (int aid){
	
	Session s=ses.getCurrentSession();
	s.beginTransaction();
	 
	 Query f=	s.createQuery("from alluser u where  u.aid=?").setParameter(0, aid);
	
	 List <com.cd.po.alluser>d=f.list();
	s.getTransaction().commit();
	

return d;	

}
}

