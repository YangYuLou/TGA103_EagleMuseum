package com.collection.serverice.CollectionServiceImpl;

import java.util.List;

import com.collection.dao.impl.CollectionDaoimpl;
import com.collection.dao.intf.CollectionDaointf;
import com.collection.serverice.CollectionService;
import com.collection.vo.CollectionVO;

public class CollectionServiceImpl implements CollectionService {
	private CollectionDaointf dao;
	
	public CollectionServiceImpl() {
		dao = new CollectionDaoimpl();
	}
	
	@Override
	public CollectionVO add(CollectionVO collection) {
		
		if (collection.getCollectionText() == null) {
			collection.setMessage("說明未輸入");
			collection.setSuccessful(false);
			return collection;
		}
		
		if (collection.getCollectionStatus() == null) {
			collection.setMessage("狀態未輸入");
			collection.setSuccessful(false);
			return collection;
		}
		
		collection.setMessage("新增成功");
		collection.setSuccessful(true);
		return collection;
	}

	
	@Override
	public CollectionVO edit(CollectionVO collection) {
		final CollectionVO oMember = dao.update(collection.getCollectionText());
		return null;
	}

	@Override
	public CollectionVO remove(Integer collection) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CollectionVO findByPrimaryKey(Integer collectionVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CollectionVO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}