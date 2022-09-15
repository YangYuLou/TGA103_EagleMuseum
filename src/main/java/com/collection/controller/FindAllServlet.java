package com.collection.controller;

import java.awt.print.Printable;
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
import com.google.gson.GsonBuilder;

import comment.Result;

@WebServlet("/collectionAll")
public class FindAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1;
	private CollectionService service = new CollectionServiceImpl();
	private Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		try {
			List<CollectionVO> findCollectuins = service.getAll();
			response.getWriter().print(gson.toJson(findCollectuins));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
