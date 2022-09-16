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

@WebServlet("/questionContentGetAllServlet")
public class QuestionContentGetAllServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private QuestionContentService service;

	public void init() throws ServletException {
		try {
			service = new QuestionContentServiceImpl();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		super.init();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		final List<QuestionContentVO> list = service.findAllQs();
		req.setAttribute("questionList", list);
		req.getRequestDispatcher("/questionContent.jsp").forward(req, resp);		
	}

}// class
