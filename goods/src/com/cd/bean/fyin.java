package com.cd.bean;
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
	
	
	
	//����ÿҳ��ʾ��¼��
		public static int getEveryPage(int everyPage) {
			return everyPage == 0 ? 10 : everyPage;
		}
		
		//���õ�ǰҳ
		public static int getCurrentPage(int currentPage) {
			return currentPage == 0 ? 1 : currentPage;
		}
		
		//������ҳ��,��Ҫ�ܼ�¼����ÿҳ��ʾ����
		public static int getTotalPage(int everyPage,int totalCount) {
			int totalPage = 0;
			if(totalCount % everyPage == 0) {
				totalPage = totalCount / everyPage;
			} else {
				totalPage = totalCount / everyPage + 1;
			}
			return totalPage;
		}
		
		//������ʼ�㣬��Ҫÿҳ��ʾ���٣���ǰҳ
		public static int getBeginIndex(int everyPage,int currentPage) {
			return (currentPage - 1) * everyPage;
		}
		
		//�����Ƿ�����һҳ����Ҫ��ǰҳ
		public static boolean getHasPrePage(int currentPage) {
			return currentPage == 1 ? false : true;
		}
		
		//�����Ƿ�����һ������Ҫ��ҳ���͵�ǰҳ
		public static boolean getHasNextPage(int totalPage, int currentPage) {
			return currentPage == totalPage || totalPage == 0 ? false : true;
		}
}
