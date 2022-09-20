package com.prod.controller;

import static com.prod.common.json2VO.json2Vo;
import static com.prod.common.setHeaders.setHeaders;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.prod.common.Result;
import com.prod.service.impl.ProductServicelm;
import com.prod.vo.productVO;

@WebServlet("/ProdInsert")
public class Prodinsert extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private Gson gson = new Gson();
	public static final Gson GSON = new GsonBuilder().create();
	private ProductServicelm service = new ProductServicelm();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setHeaders(response);
		request.setCharacterEncoding("UTF-8");
//		PrintWriter out = response.getWriter();
//		// Read POST
//		BufferedReader read = request.getReader();
//		// 存字串
//		String json = read.readLine();
//		System.out.println(json);
		
		productVO productVO = json2Vo(request, productVO.class);	
		Result R  = service.insert(productVO);
	
	}

	protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		setHeaders(resp);
	}
}
