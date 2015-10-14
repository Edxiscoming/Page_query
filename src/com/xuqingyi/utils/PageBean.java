package com.xuqingyi.utils;

import java.util.List;

public class PageBean<T> {
	private int currentPage=1;
	private int pageDisplay=3;
	private int totalPage;
	private int totalData;
	private List<T> pageData;
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageDisplay() {
		return pageDisplay;
	}
	public void setPageDisplay(int pageDisplay) {
		this.pageDisplay = pageDisplay;
	}
	public int getTotalPage() {
		if(totalData%pageDisplay==0){
			totalPage=totalData/pageDisplay;
		}else{
			totalPage=totalData/pageDisplay+1;
		}
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalData() {
		return totalData;
	}
	public void setTotalData(int totalData) {
		this.totalData = totalData;
	}
	public List<T> getPageData() {
		return pageData;
	}
	public void setPageData(List<T> pageData) {
		this.pageData = pageData;
	}
	
	
	
	
	
}
