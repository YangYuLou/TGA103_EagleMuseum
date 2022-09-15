package com.prod.dao.sql;

public class ProductSQL {
	//全部查詢
	public static final String GET_ALL = "SELECT * FROM productlist";
	
	//商品名稱查詢
	public static final String GET_BY_Name = "SELECT * FROM eagle_museum.productlist where prodName = ?";
	
	//商品名稱查詢
	public static final String GET_BY_ID = "SELECT * FROM eagle_museum.productlist where prodName = ?";

	//新增商品
	public static final String Insert  =
			"INSERT INTO productlist(prodName, ProdTypeID, prodprice, prodDescription, creatTime) VALUES(?, ?, ?, ?, ?)";
	
//	productID, prodName, prodTypeID, prodPrice, discountID, prodDescription, prodStatus, creatTime, launchTime, sellQuantity, prodInStock, bestSeller, lastUpdateTime
	//更新商品
	public static final String Update  =
			"UPDATE productlist set prodName=? , prodTypeID=? , "
			+ "discountID=? , prodDescription=? , prodStatus=? , sellQuantity=? , prodInStock=? ,"
			+ " bestSeller=? , lastUpdateTime=NOW()";
}
