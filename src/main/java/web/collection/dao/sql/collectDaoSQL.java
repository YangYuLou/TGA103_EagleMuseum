package web.collection.dao.sql;

public class collectDaoSQL {
	public static final String INSERT_STMT = "INSERT INTO collection (collectionText, collectionMaterial) VALUES (?, ?)";
	public static final String GET_ALL_STMT = "SELECT collectionID, collectionText, collectionMaterial, collectionStatus, lastUpdateTime FROM emp2 order by collectionID";
	public static final String GET_ONE_STMT = "SELECT collectionID, collectionText, collectionMaterial, collectionStatus, lastUpdateTime FROM emp2 where collectionID = ?";
	public static final String DELETE = "DELETE FROM collection where collectionID = ?";
	public static final String UPDATE = "UPDATE collection set collectionText=?, collectionStatus=?, collectionMaterial=?";
}