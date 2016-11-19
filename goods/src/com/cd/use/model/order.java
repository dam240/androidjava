package com.cd.use.model;

public class order {

	private String order_id;
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	private String addr;
	private  String jin;
	private String date;
	private String user_id;
	private int fun;
	public int getFun() {
		return fun;
	}
	public void setFun(int fun) {
		this.fun = fun;
	}
	private int zhi_fu;
	

	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getJin() {
		return jin;
	}
	public void setJin(String jin) {
		this.jin = jin;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	public int getZhi_fu() {
		return zhi_fu;
	}
	public void setZhi_fu(int zhi_fu) {
		this.zhi_fu = zhi_fu;
	}
	
}
