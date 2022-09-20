package web.index_calender.service.impl;

import java.util.List;

import javax.naming.NamingException;

import web.index_calender.dao.Index_calenderDao;
import web.index_calender.dao.impl.Index_calenderDaoImpl;
import web.index_calender.service.Index_calenderService;
import web.index_calender.vo.Index_calender;

public class Index_calenderServiceImpl implements Index_calenderService {
	private Index_calenderDao dao;

	public Index_calenderServiceImpl() throws NamingException {
		dao = new Index_calenderDaoImpl();
	}

	@Override
	public List<Index_calender> findAllMembers() {
		return dao.selectAll();
	}
}
