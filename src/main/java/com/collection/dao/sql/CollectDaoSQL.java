package com.collection.dao.sql;

public class CollectDaoSQL {
	public static final String INSERT_STMT = "INSERT INTO collection (collectionText, collectionMaterial) VALUES (?, ?)";
	public static final String GET_ALL = "SELECT collectionID, collectionText, collectionMaterial, collectionStatus, lastUpdateTime FROM collection order by collectionID";
	public static final String GET_ONE = "SELECT collectionID, collectionText, collectionMaterial, collectionStatus, lastUpdateTime FROM collection where collectionID = ?";
	public static final String DELETE = "DELETE FROM collection where collectionID = ?";
	public static final String UPDATE = "UPDATE collection set collectionText=?, collectionStatus=?, collectionMaterial=?";
}