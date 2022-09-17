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
	public Result getByName(String prodName) {
		try {
			System.out.println(R.success(DAO.getByName(prodName)));
			return R.success(DAO.getByName(prodName));
		} catch (Exception e) {
			e.printStackTrace();
			return R.fail(e.toString());
		}
	}


	@Override
	public Result update(productVO productVO) {
		try {
			return R.success(DAO.update(productVO));
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

	@Override
	public Result updateStatus(productVO productVO) {
		try {
			System.out.println(R.success(DAO.updateStatus(productVO)));
//			return R.success(DAO.updateStatus(productVO));
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return R.fail(e.toString());
		}
	}
	

}
