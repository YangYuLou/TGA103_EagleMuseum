package com.prod.service.inft;

import com.prod.common.Result;
import com.prod.vo.productVO;

public interface ProductServicein {
	
	public Result getAll() throws Exception;
	
	public Result getByname(String prodName);
	
	public Result insert(productVO productVO);
	
	public Result update(productVO productVO);

}
