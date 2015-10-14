package com.xuqingyi.service;

import com.xuqingyi.entry.Emp;
import com.xuqingyi.utils.PageBean;

public interface IEmpService {
	public void getAll(PageBean<Emp> pb);
}
