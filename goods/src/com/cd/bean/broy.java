package com.cd.bean;

public class broy {

	
	 public static page1 io(page1 pa ,int count){
		 
		   int now=now(pa.getNow()); 
		   
		    int size=size(pa.getSize());
		    int index=index(now,size);
		    int count1=count(size,count);
		    boolean up=up(now);  
		    boolean next=next(now,count1);
		    
		    
		 return new page1(index,now,count1,size,next,up);
		 
	 }
	 
	 
	 public static int now (int now)
	 {
		 
		 return now ==0?1:now;
	 }
	 
	
	 
	 public static int size(int size){
		 
		 return size==0?10:size;
	 }
	 
	 public static int  index(int now,int size){
		 
		 return (now-1)*size;
	 }
	 
	 
	 public static int  count(int size,int count){
		 int i=0;
		 if(count%size==0){
			 i=count/size;
		 }else{
			 i=count/size+1;
			 
		 }
		 
		 return i;
	 }
	 
	 
	 public static boolean up(int index){
		 
		 return index==1?false:true;
	 }
	 
	 public static boolean next(int count,int index){
		 System.out.println(count);
		 System.out.println(index);
		 return index == count || count == 0 ? false : true;
	 }
}
