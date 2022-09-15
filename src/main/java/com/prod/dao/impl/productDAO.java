package com.prod.dao.impl;

import java.util.*;
import java.sql.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.prod.vo.productVO;
import com.prod.dao.sql.*;

public class productDAO implements com.prod.dao.intf.productDAO_interface {
	
	//獲取DS使用連線池
		private static DataSource ds = null;
		static {
			try {
				Context ctx = new InitialContext();
				ds = (DataSource) ctx.lookup("java:comp/env/jdbc/eaglemuseum_schema");
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}
		
		//查詢商品
		public List<productVO> getAll() throws Exception {
			List<productVO> list = new ArrayList<productVO>();
//			try with resources

			try (Connection con = ds.getConnection();
			PreparedStatement pstmt = con.prepareStatement(ProductSQL.GET_ALL);) {
				System.out.println("有連線喽");
				try (ResultSet rs = pstmt.executeQuery()) {
					while (rs.next()) {
						productVO productVO = new productVO();	
						productVO.setProductID(rs.getInt("productID"));
						productVO.setProdName(rs.getString("prodName"));
						productVO.setProdTypeID(rs.getInt("prodTypeID"));
						productVO.setProdPrice(rs.getInt("prodPrice"));
						productVO.setDiscountID(rs.getInt("discountID"));
						productVO.setProdDescription(rs.getString("prodDescription"));
						productVO.setProdStatus(rs.getInt("prodStatus"));
						productVO.setCreatTime(rs.getDate("creatTime"));
						productVO.setLaunchTime(rs.getDate("launchTime"));
						productVO.setSellQuantity(rs.getInt("sellQuantity"));
						productVO.setProdInStock(rs.getInt("prodInStock"));
						productVO.setBestSeller(rs.getInt("bestSeller"));
						productVO.setLastUpdateTime(rs.getDate("lastUpdateTime"));
						list.add(productVO); // Store the row in the list
					}
				}
				return list;
			}
		}
		


		//新增商品 還沒加判斷
		@Override
		public void insert(productVO productVO) throws Exception {
			// TODO Auto-generated method stub
			try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(ProductSQL.Insert);) {
					System.out.println("有連線喽");
					try (ResultSet rs = pstmt.executeQuery()){
						
//	"INSERT INTO productlist(prodName, ProdTypeID, prodprice, prodDescription, creatTime) VALUES(?, ?, ?, ?, NOW())";
						pstmt.setString(1,productVO.getProdName());
						pstmt.setInt(2,productVO.getProdTypeID());
						pstmt.setInt(3,productVO.getProdPrice());
						pstmt.setString(4,productVO.getProdDescription());
						pstmt.executeUpdate();	
					}	
				}
		}	

		//更新商品資訊
		@Override
		public void update(productVO productVO) throws Exception {
			// TODO Auto-generated method stub
			try (Connection con = ds.getConnection();
					PreparedStatement pstmt = con.prepareStatement(ProductSQL.Update);) {
						System.out.println("有連線喽");
						try (ResultSet rs = pstmt.executeQuery()){
							
//			"UPDATE productlist set prodName=? , prodTypeID=? , "
//			+ "discountID=? , prodDescription=? , prodStatus=? , sellQuantity=? , prodInStock=? ,"
//			+ " bestSeller=? , lastUpdateTime=NOW()";
							
							pstmt.setString(1,productVO.getProdName());
							pstmt.setInt(2,productVO.getProdTypeID());
							pstmt.setInt(3,productVO.getDiscountID());
							pstmt.setString(4,productVO.getProdDescription());
							pstmt.setInt(5,productVO.getProdStatus());
							pstmt.setInt(6,productVO.getSellQuantity());
							pstmt.setInt(7,productVO.getProdInStock());
							pstmt.setInt(8,productVO.getBestSeller());
					
							
							pstmt.executeUpdate();	
						}	
					}
		}

		
		//根據商品名稱查詢
		@Override
		public List<productVO> getByName(String productName) throws SQLException {
			// TODO Auto-generated method stub
			List<productVO> list = new ArrayList<productVO>();
			try (Connection con = ds.getConnection();
					PreparedStatement pstmt = con.prepareStatement(ProductSQL.GET_BY_Name);) {
						System.out.println("有連線喽");
						try (ResultSet rs = pstmt.executeQuery()) {
							while (rs.next()) {
								productVO productVO = new productVO();	
								productVO.setProductID(rs.getInt("ProductID"));
								productVO.setProdTypeID(rs.getInt("prodTypeID"));
								productVO.setProdPrice(rs.getInt("prodPrice"));
								productVO.setDiscountID(rs.getInt("discountID"));
								productVO.setProdDescription(rs.getString("prodDescription"));
								productVO.setProdStatus(rs.getInt("prodStatus"));
								productVO.setCreatTime(rs.getDate("creatTime"));
								productVO.setLaunchTime(rs.getDate("launchTime"));
								productVO.setSellQuantity(rs.getInt("sellQuantity"));
								productVO.setProdInStock(rs.getInt("prodInStock"));
								productVO.setBestSeller(rs.getInt("bestSeller"));
								productVO.setLastUpdateTime(rs.getDate("lastUpdateTime"));
								list.add(productVO); // Store the row in the list
							}
						}
						return list;
					}
		}



		@Override
		public List<productVO> getByProductID(String productID) throws SQLException {
			// TODO Auto-generated method stub
			List<productVO> list = new ArrayList<productVO>();
			try (Connection con = ds.getConnection();
					PreparedStatement pstmt = con.prepareStatement(ProductSQL.GET_BY_ID);) {
						System.out.println("有連線喽");
						try (ResultSet rs = pstmt.executeQuery()) {
							while (rs.next()) {
								productVO productVO = new productVO();	
								productVO.setProdName(rs.getString("ProductName"));
								productVO.setProdTypeID(rs.getInt("prodTypeID"));
								productVO.setProdPrice(rs.getInt("prodPrice"));
								productVO.setDiscountID(rs.getInt("discountID"));
								productVO.setProdDescription(rs.getString("prodDescription"));
								productVO.setProdStatus(rs.getInt("prodStatus"));
								productVO.setCreatTime(rs.getDate("creatTime"));
								productVO.setLaunchTime(rs.getDate("launchTime"));
								productVO.setSellQuantity(rs.getInt("sellQuantity"));
								productVO.setProdInStock(rs.getInt("prodInStock"));
								productVO.setBestSeller(rs.getInt("bestSeller"));
								productVO.setLastUpdateTime(rs.getDate("lastUpdateTime"));
								list.add(productVO); // Store the row in the list
							}
						}
						return list;
					}
		}	
				
				
		





}
