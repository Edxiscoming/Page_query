package com.xuqingyi.Dao.Impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.xuqingyi.Dao.IEmpDao;
import com.xuqingyi.entry.Emp;
import com.xuqingyi.utils.JdbcUtil;
import com.xuqingyi.utils.PageBean;

public class EmpDaoImpl implements IEmpDao {

	@Override
	public void getAll(PageBean pb) {
		String sql="select * from emp limit ?,?";
		int totalData=this.getTotalCount();
		pb.setTotalData(totalData);
		
		int index=(pb.getCurrentPage()-1)*pb.getPageDisplay();
		int end=pb.getPageDisplay();
		
		
		try {
			QueryRunner qr=JdbcUtil.getQueryRunner();
			List<Emp> pageData=qr.query(sql, new BeanListHandler<Emp>(Emp.class), index,end);
			pb.setPageData(pageData);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

	@Override
	public int getTotalCount() {
		String sql="select count(*) from emp";
		
		try {
			QueryRunner qr=JdbcUtil.getQueryRunner();
			Long count=qr.query(sql, new ScalarHandler<Long>());
		return count.intValue();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}

}
