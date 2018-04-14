package com.zpark.util;

public class Page {
	private int pageIndex;
	private int pageCount;
	private long total;
	
	public Page(){
		
	}

	public Page(int pageIndex, int pageCount) {
		super();
		this.pageIndex = pageIndex;
		this.pageCount = pageCount;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public int getFirstResult(){
	  return (pageIndex-1)*pageCount+1;
	}
	
	public int getLastResult(){
	  return pageIndex*pageCount;
	}
}


  