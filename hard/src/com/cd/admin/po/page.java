package com.cd.admin.po;

public class page {

	private int index;
	private int size;
	private int count;
	private int nowpage;
    private boolean up;
    private boolean next;
    
    
    
	public page(int index, int size, int count, int nowpage, boolean up,
			boolean next) {
		super();
		this.index = index;
		this.size = size;
		this.count = count;
		this.nowpage = nowpage;
		this.up = up;
		this.next = next;
	}
	
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getNowpage() {
		return nowpage;
	}
	public void setNowpage(int nowpage) {
		this.nowpage = nowpage;
	}
	public boolean isUp() {
		return up;
	}
	public void setUp(boolean up) {
		this.up = up;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	
	
}
