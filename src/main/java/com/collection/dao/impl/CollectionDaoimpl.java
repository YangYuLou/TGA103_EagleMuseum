package com.collection.dao.impl;

import java.util.*;
import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.collection.dao.intf.CollectionDaointf;
import com.collection.dao.sql.CollectDaoSQL;
import com.collection.vo.CollectionVO;

public class CollectionDaoimpl implements CollectionDaointf {

	private static CollectDaoSQL SQL = null;
	private static DataSource ds = null;

	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/EagleMuseum");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean insert(CollectionVO collectionVO) {

		int rowCount = 0;
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(SQL.INSERT_STMT);
			System.out.println("連線成功");

			pstmt.setString(1, collectionVO.getCollectionText());
			pstmt.setString(2, collectionVO.getCollectionMaterial());
			rowCount = pstmt.executeUpdate();
			// Handle any SQL errors
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowCount != 0;
		
	}

	@Override
	public boolean update(CollectionVO collectionVO) {

		int rowCount = 0;
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(SQL.UPDATE);
			System.out.println("連線成功");

			pstmt.setString(1, collectionVO.getCollectionText());
			pstmt.setBoolean(2, collectionVO.getCollectionStatus());
			pstmt.setString(3, collectionVO.getCollectionMaterial());
			
			rowCount = pstmt.executeUpdate();
			
			// Handle any SQL errors
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowCount != 0;
		
	}

	@Override
	public boolean delete(Integer collectionVO) {
		int rowCount = 0;
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(SQL.DELETE);
			System.out.println("連線成功");

			pstmt.setInt(1, collectionVO);
			rowCount = pstmt.executeUpdate();
			// Handle any SQL errors
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowCount != 0;
	}

	@Override
	public CollectionVO findByPrimaryKey(Integer collectionVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CollectionVO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}