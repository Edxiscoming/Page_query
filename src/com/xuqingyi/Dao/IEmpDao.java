package com.xuqingyi.Dao;

import com.xuqingyi.utils.PageBean;

public interface IEmpDao {

	public void getAll(PageBean pb);
	
	public int getTotalCount();
}
