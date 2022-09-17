package com.contactUs.controller;

import java.io.IOException;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.contactUs.model.QuestionContentService;
import com.contactUs.model.QuestionContentServiceImpl;
import com.contactUs.model.QuestionContentVO;
import com.mysql.cj.util.StringUtils;

@WebServlet("/questionAns")
public class QuestionAnsServlet extends HttpServlet{
	
	private QuestionContentService service;
	
	public void init() throws ServletException{
		try {
			service = new QuestionContentServiceImpl();
		} catch(NamingException e){
			e.printStackTrace();
		}
		super.init();
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		final String memberIdStr = req.getParameter("memberId");
		//第一次進入此頁，使用者尚未選擇memberId，故先不進行字串轉Int
		Integer memberId = null;
		if(!StringUtils.isNullOrEmpty(memberIdStr)) {
			memberId = Integer.parseInt(memberIdStr);
			final List<QuestionContentVO> list = service.getByMemberId(memberId);
			req.setAttribute("questionList", list);
		}
		
		req.getRequestDispatcher("/questionAnswer.jsp").forward(req, resp);
	}



}//class
