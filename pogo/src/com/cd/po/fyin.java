package com.cd.po;

public class fyin {

	public static page io(page u,int count){
		
		int everyPage = getEveryPage(u.getEveryPage());//5
		int currentPage = getCurrentPage(u.getCurrentPage());//1
		int totalPage = getTotalPage(everyPage, count);//3
		int beginIndex = getBeginIndex(everyPage, currentPage);//0
		boolean hasPrePage = getHasPrePage(currentPage);//
		boolean hasNextPage = getHasNextPage(totalPage, currentPage);
		return new page(everyPage, count, totalPage, currentPage,
				beginIndex, hasPrePage,  hasNextPage);
		
		
	
	}
	
	
	
	//设置每页显示记录数
		public static int getEveryPage(int everyPage) {
			return everyPage == 0 ? 10 : everyPage;
		}
		
		//设置当前页
		public static int getCurrentPage(int currentPage) {
			return currentPage == 0 ? 1 : currentPage;
		}
		
		//设置总页数,需要总记录数，每页显示多少
		public static int getTotalPage(int everyPage,int totalCount) {
			int totalPage = 0;
			if(totalCount % everyPage == 0) {
				totalPage = totalCount / everyPage;
			} else {
				totalPage = totalCount / everyPage + 1;
			}
			return totalPage;
		}
		
		//设置起始点，需要每页显示多少，当前页
		public static int getBeginIndex(int everyPage,int currentPage) {
			return (currentPage - 1) * everyPage;
		}
		
		//设置是否有上一页，需要当前页
		public static boolean getHasPrePage(int currentPage) {
			return currentPage == 1 ? false : true;
		}
		
		//设置是否有下一个，需要总页数和当前页
		public static boolean getHasNextPage(int totalPage, int currentPage) {
			return currentPage == totalPage || totalPage == 0 ? false : true;
		}
}
