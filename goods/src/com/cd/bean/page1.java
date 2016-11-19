package com.cd.bean;

public class page1 {

	
	private int index;//记录信息
    private int now;//现在在的页
    private int cunot;//总共多少页
    private int size;//设置多少页
    private boolean next;//还有没有下页
    private boolean up;//还有没有上页
    
    
    
    public page1(){
    	
    }
    
    
	public page1(int index, int now, int cunot, int size, boolean next,
			boolean up) {
		super();
		this.index = index;
		this.now = now;
		this.cunot = cunot;
		this.size = size;
		this.next = next;
		this.up = up;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getNow() {
		return now;
	}
	public void setNow(int now) {
		this.now = now;
	}
	public int getCunot() {
		return cunot;
	}
	public void setCunot(int cunot) {
		this.cunot = cunot;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public boolean isUp() {
		return up;
	}
	public void setUp(boolean up) {
		this.up = up;
	}

}
