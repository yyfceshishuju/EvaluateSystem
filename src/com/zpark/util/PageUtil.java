package com.zpark.util;

public class PageUtil {
	private static final ThreadLocal<Page> tl = new ThreadLocal<Page>();

	public static Page getPage(){
		return tl.get();
	}
	
	public static int getFirstResult(){
		return tl.get().getFirstResult();
	}
	
	public static int getLastResult(){
		return tl.get().getLastResult();
	}
	
	public static void setTotal(long total){
	    tl.get().setTotal(total);
	}
	
	public static long getTotal(){
	   return tl.get().getTotal();
	}
	
	public static void setPage(int pageIndex,int pageCount){
	   Page page = new Page(pageIndex, pageCount);	
	   tl.set(page);
	}
}
