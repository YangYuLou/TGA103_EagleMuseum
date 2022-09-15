package com.prod.service.impl;

import com.prod.common.Result;
import com.prod.dao.impl.productDAO;
import com.prod.service.inft.ProductServicein;
import com.prod.vo.productVO;

public class ProductServicelm implements ProductServicein {

	private productDAO DAO;
	private Result R;
	
	public ProductServicelm() {
		DAO = new productDAO();
		R = new Result();
	}
	
	@Override
	public Result getAll() throws Exception {
		try {
			return R.success(DAO.getAll());
		} catch (Exception e) {
			e.printStackTrace();
			return R.fail(e.toString());
		}
	}

	@Override
	public Result getByname(String prodName) {
		try {
			return R.success(DAO.getAll());
		} catch (Exception e) {
			e.printStackTrace();
			return R.fail(e.toString());
		}
	}


	@Override
	public Result update(productVO productVO) {
		try {
			return R.success(DAO.getAll());
		} catch (Exception e) {
			e.printStackTrace();
			return R.fail(e.toString());
		}
	}

	@Override
	public Result insert(productVO productVO) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
