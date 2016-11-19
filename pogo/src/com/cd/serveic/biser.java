package com.cd.serveic;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.cd.dao.btdao;
import com.cd.po.Info;
@Component("bu")
public class biser implements biservice {

	 private btdao bio;
	
	

	public btdao getBio() {
		return bio;
	}


    @Resource
	public void setBio(btdao bio) {
		this.bio = bio;
	}



	public boolean saveandupdate(Info in) {
		            try {
						bio.save(in);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						return  false;
					
					}
		return true;
	}

	

	public Info load(String username) {
		          
		
		
		return bio.load(username);
		}
	
	
	
	
}
