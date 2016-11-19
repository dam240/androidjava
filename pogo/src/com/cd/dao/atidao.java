package com.cd.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cd.po.alluser;
import com.cd.po.ati;
import com.cd.po.tcp;

@Component("at")
public class atidao  implements atid{

	
private	HibernateTemplate hi;

	
	public HibernateTemplate getHi() {
	return hi;
}

@Resource
public void setHi(HibernateTemplate hi) {
	this.hi = hi;
}


@Transactional
	public  void add(ati ai){
	
		hi.save(ai);
		
	}

public List<ati> load(String username) {
	
  List ja =hi.find("from ati u where u.username='"+username+"'");
	
	
	return ja;
}

public int cout(String username) {
	// TODO Auto-generated method stub
	
	List ja =hi.find("from ati u where u.username='"+username+"'");
	
	
	
	return ja.size();
}

public int allcou() {
	
	
	// TODO Auto-generated method stub
	
	
	List ja =hi.find("from ati ");
	
	
	return ja.size();
}

public ati get(int id) {
	// TODO Auto-generated method stub
	return (ati) hi.get(ati.class, id);
}

public void save(ati ai) {
	// TODO Auto-generated method stub
	
	hi.saveOrUpdate(ai);
}

@Transactional
public void addtiem(tcp a) {
	// TODO Auto-generated method stub

	hi.save(a);
	
}



@Transactional
public void allsave(alluser us) {
	// TODO Auto-generated method stub
	System.out.println(us.getUsername());
	hi.save(us);
	
}


	




	
	
}
