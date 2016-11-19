package com.cd.file;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.HttpRequestHandler;

import net.fckeditor.requestcycle.UserPathBuilder;


public class myf implements UserPathBuilder {

	public String getUserFilesPath(HttpServletRequest arg0) {
		
HttpSession s = arg0.getSession();

    String username =(String) s.getAttribute("username");
		
		
	
		return "/userfiles/" + username;
	}

	

}
