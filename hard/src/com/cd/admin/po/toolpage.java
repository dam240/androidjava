package com.cd.admin.po;

public class toolpage {

	
	
	public static int getindex(int index){
			
		return index==0?1:index;
	}
	
	public static int getcont(int szie,int count){
		int i=0;
	   if(count%szie==0){
		   
		   i=  count/szie;
		   
	   }else{
		   
		   i=(count/szie)+1;
		   
	   }
		
		
		
		return i;
	}
	
	

	   public static page ret(int index ,int size,int count){
		   
		   int now =getindex(index);
		   int  cout=getcont(size,count);    
		    int index1=    mal(now,size);
		   boolean next= next(now,cout);
		   boolean up=up(now,cout);
		   
		   
		   
		   return new page(index1,size,cout,now,up,next);
	   }
	
	
	
	public static boolean next(int index,int count){
		
		
		
		return index==count?false:true;
	}
	
	
	public static boolean up(int index,int count){
		
		
		
		return index==1?false:true;
	}
	
	
	public static int mal(int index,int size){
		
		
		return  (index-1)*size;
		
	}
}
