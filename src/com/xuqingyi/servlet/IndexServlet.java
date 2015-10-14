package com.xuqingyi.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xuqingyi.entry.Emp;
import com.xuqingyi.service.EmpService;
import com.xuqingyi.service.IEmpService;
import com.xuqingyi.utils.PageBean;

public class IndexServlet extends HttpServlet {
	IEmpService empService=new EmpService();
	String uri;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try{
		String currPage=req.getParameter("currentPage");
		if(currPage==null||"".equals(currPage)){
			currPage="1";
		}
		int currentPage=Integer.parseInt(currPage);
		
		PageBean<Emp> pb=new PageBean<Emp>();
		pb.setCurrentPage(currentPage);
		
		empService.getAll(pb);
		
		req.setAttribute("pageBean", pb);
		 uri = "/WEB-INF/list.jsp";
		}catch(Exception e){
			e.printStackTrace();
			uri = "/error/error.jsp";
		}
		req.getRequestDispatcher(uri).forward(req, resp);
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
	
	
}
