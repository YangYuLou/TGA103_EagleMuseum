package com.prod.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.prod.common.Result;
import static com.prod.common.json2VO.*;
import static com.prod.common.setHeaders.*;
import com.prod.service.impl.ProductServicelm;
import com.prod.vo.productVO;


@WebServlet("/ProductGetName")
public class Prodgetinfname extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private Gson gson = new Gson();
	public static final Gson GSON = new GsonBuilder().create();
	private ProductServicelm service = new ProductServicelm();
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setHeaders(response);	
		String ProdName = json2Vo(request, productVO.class).getProdName();
		ProdName = "%" + ProdName + "%";
		System.out.println(ProdName);
		Result R  = service.getByName(ProdName);
		response.getWriter().print(gson.toJson(R));	
	}

	protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		setHeaders(resp);
	}



}
