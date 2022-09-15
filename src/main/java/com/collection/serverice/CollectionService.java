package com.collection.serverice;

import java.util.*;
import com.collection.vo.CollectionVO;

public interface CollectionService {
	CollectionVO add(CollectionVO collection);
	CollectionVO edit(CollectionVO collection);
//	CollectionVO remove(Integer collection);
    CollectionVO findByPrimaryKey(Integer collectionVO);
	public List<CollectionVO> getAll();
//        public List<EmpVO> getAll(Map<String, String[]> map); 
}
