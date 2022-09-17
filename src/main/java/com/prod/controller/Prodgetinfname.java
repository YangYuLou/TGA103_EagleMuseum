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
		request.setCharacterEncoding("UTF-8");
		
		String ProdName = json2VO(request, productVO.class).getProdName();
		ProdName = "%" + ProdName + "%";
		System.out.println(ProdName);
		Result R  = service.getByName(ProdName);
		response.getWriter().print(gson.toJson(R));
//		System.out.println(R);
				
	}
	
	public static <P> P json2VO(HttpServletRequest request, Class<P> classOfVO) {
		try (BufferedReader br = request.getReader()) {
			return GSON.fromJson(br, classOfVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}



	protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		setHeaders(resp);

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
