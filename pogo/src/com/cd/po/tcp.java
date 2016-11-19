package com.cd.po;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class tcp {


	private int id;
   
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String tiem;
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	private int Aid;
   private String ip;
	
	public String getTiem() {
		return tiem;
	}
	public void setTiem(String tiem) {
		this.tiem = tiem;
	}
	public int getAid() {
		return Aid;
	}
	public void setAid(int aid) {
		Aid = aid;
	}
	
	
	
	
   
   
   
	
}
