package com.prod.controller;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.prod.common.setHeaders.*;
import static com.prod.common.json2VO.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.prod.common.Result;
import com.prod.service.impl.ProductServicelm;
import com.prod.vo.productVO;
@WebServlet("/ProdStatusUpdate")
public class ProdStUpdateServlet extends HttpServlet{

		private static final long serialVersionUID = 1L;
		private Gson gson = new Gson();
		public static final Gson GSON = new GsonBuilder().create();
		private ProductServicelm service = new ProductServicelm();
			
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			setHeaders(response);
			request.setCharacterEncoding("UTF-8");
			productVO productVO = json2Vo(request, productVO.class);	
			System.out.println(productVO);
			Result R  = service.updateStatus(productVO);
		
		}
		
		protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			setHeaders(resp);
		}
	
}
