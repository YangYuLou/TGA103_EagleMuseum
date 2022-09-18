package com.collection.service;

import java.util.*;
import com.collection.vo.CollectionVO;

public interface CollectionService {
	CollectionVO add(CollectionVO collection);
	CollectionVO edit(CollectionVO collection);
    CollectionVO findByPrimaryKey(Integer collection);
	public List<CollectionVO> getAll();
}
