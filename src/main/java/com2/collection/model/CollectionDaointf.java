package com2.collection.model;

import java.util.*;

import com2.collection.model.CollectionVO;

public interface CollectionDaointf {
          public boolean insert(CollectionVO collectionVO);
          public boolean update(CollectionVO collectionVO);
          public boolean delete(Integer collectionVO);
          public CollectionVO findByPrimaryKey(Integer collectionVO);
          public List<CollectionVO> getAll();
//        public List<EmpVO> getAll(Map<String, String[]> map); 
}
