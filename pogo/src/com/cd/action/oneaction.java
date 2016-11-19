package com.cd.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.cd.po.user;
import com.cd.serveic.serveic;
import com.cd.serveic.useserve;
import com.opensymphony.xwork2.ActionSupport;
@Component("u")
@Scope("prototype")
public class oneaction extends ActionSupport {

	private String username;

	private String password;
	private String password2;
    
	private serveic use;
	
	public serveic getUse() {
		return use;
	}

	@Resource
	public void setUse(serveic use) {
		this.use = use;
	}

	@Override
	public String execute() throws Exception {
		
	   user u=new user();
	   System.out.println(username);
	   u.setAnswer(answer);
	   u.setNickname(nickname);
	   u.setPassword(password);
	   u.setQuestion(question);
	   u.setUsername(username);
	   HttpServletRequest R=ServletActionContext.getRequest();
	  if(use.usesave(u)){
			 R.setAttribute("ue", "×¢²áÊ§°Ü");
          	 R.setAttribute("ul", "register.jsp"); 
        	 
		  return"error";
	  }
	  
		 R.setAttribute("ue", "×¢²á³É¹¦");
      	 R.setAttribute("ul", "login.jsp"); 
    	 
	   return "success";
	}

	
	



	private String  nickname;
	
	private String question;

	private String answer;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
}
