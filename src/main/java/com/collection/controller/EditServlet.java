package com.collection.controller;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

import com.collection.dao.intf.CollectionDaointf;
import com.collection.serverice.CollectionService;
import com.collection.serverice.CollectionServiceImpl.CollectionServiceImpl;
import com.collection.vo.CollectionVO;
import com.google.gson.Gson;

import comment.Result;


@WebServlet("/collection/collectionAll")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1;
	private CollectionService service = new CollectionServiceImpl();
	private Gson gson = new Gson();

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<CollectionVO> r = service.getAll();
			response.getWriter().print(gson.toJson(r));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setHeaders(response);
		
		
		
	}

	private void setHeaders(HttpServletResponse response) {
		response.setContentType("application/json;charset=UTF-8"); // 重要
		response.setHeader("Cache-control", "no-cache, no-store");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "-1");

		response.addHeader("Access-Control-Allow-Origin", "*"); // 重要
		response.addHeader("Access-Control-Allow-Methods", "*");
		response.addHeader("Access-Control-Allow-Headers", "*");
		response.addHeader("Access-Control-Max-Age", "86400");		
	}
	
}
