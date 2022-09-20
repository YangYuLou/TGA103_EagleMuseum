package com.prod.service.impl;

import static com.prod.common.json2VO.json2Vo;

import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;
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
		try {
			String  ProdName = productVO.getProdName();
			int	ProdTypeID = productVO.getProdTypeID();
			int ProdPrice = productVO.getProdPrice();
			String  ProdDescription = productVO.getProdDescription();
			int  ProdInStock = productVO.getProdInStock();
//			
//			System.out.println(ProdName);
//			System.out.println(ProdTypeID);
//			System.out.println(ProdPrice);
//			System.out.println(ProdDescription);
//			System.out.println(ProdTypeID);
			if (ProdName != null && ProdTypeID != 0 && ProdInStock != 0 && ProdName != null && ProdDescription != null) {
				System.out.println(R.success(DAO.insert(productVO)));
				return R.success(DAO.insert(productVO));
			}else {
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return R.fail(e.toString());
		}
	}

	@Override
	public Result updateStatus(productVO productVO) {
		try {
			System.out.println(R.success(DAO.updateStatus(productVO)));
			return R.success(DAO.insert(productVO));
		} catch (Exception e) {
			e.printStackTrace();
			return R.fail(e.toString());
		}
	}
	

}
