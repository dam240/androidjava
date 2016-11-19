package com.cd.user.po;

public class Tools {

	
	public final static int size=5;
	
	public static int countpage(int count,int size){
		
	int i=0;
		
		   if(count%size==0){
			   
			
			   i=count/size;
			   
		   }else{
			   i=(count/size)+1;
			   
		   }
		
		
		
		
		return i;
	}
	
	
	public static int page(int index,int size){
		
		
		return index*size;
	}
	
}
