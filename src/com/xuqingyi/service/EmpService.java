package com.xuqingyi.service;

import com.xuqingyi.Dao.IEmpDao;
import com.xuqingyi.Dao.Impl.EmpDaoImpl;
import com.xuqingyi.entry.Emp;
import com.xuqingyi.utils.PageBean;

public class EmpService implements IEmpService {
	
	IEmpDao empDao=new EmpDaoImpl();

	@Override
	public void getAll(PageBean<Emp> pb) {
		empDao.getAll(pb);
	}

}
