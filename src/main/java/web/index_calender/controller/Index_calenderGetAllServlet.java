package web.index_calender.controller;

import java.io.IOException;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.index_calender.service.Index_calenderService;
import web.index_calender.service.impl.Index_calenderServiceImpl;
import web.index_calender.vo.Index_calender;


@WebServlet("/index_calender/getAll")
public class Index_calenderGetAllServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private Index_calenderService; 
		
	
	@Override
	public void init() throws ServletException {
		try {
			service = new Index_calenderServiceImpl();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		final List<Index_calender> list = service.findAllMembers();
		req.setAttribute("Index_calender", list);
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
	
		
}
