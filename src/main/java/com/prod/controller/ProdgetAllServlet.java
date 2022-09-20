package com.prod.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.prod.common.setHeaders.*;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;
import com.prod.common.Result;
import com.prod.service.impl.ProductServicelm;
import com.prod.vo.productVO;


@WebServlet("/ProductGetAll")
public class ProdgetAllServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private Gson gson = new Gson();
	private ProductServicelm service = new ProductServicelm();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws  ServletException,IOException  {
		setHeaders(response);
		try {
			Result R  = service.getAll();
			response.getWriter().print(gson.toJson(R));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		setHeaders(resp);
	}
	
}
