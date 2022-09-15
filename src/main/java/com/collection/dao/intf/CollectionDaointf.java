package com.collection.dao.intf;

import java.util.*;

import com.collection.vo.CollectionVO;

public interface CollectionDaointf {
	public boolean insert(CollectionVO collectionVO);
	public boolean update(CollectionVO collectionVO);
	public boolean delete(Integer collectionID);
	public CollectionVO findByPrimaryKey(Integer collectionVO);
	public List<CollectionVO> getAll();
//        public List<EmpVO> getAll(Map<String, String[]> map); 
}
