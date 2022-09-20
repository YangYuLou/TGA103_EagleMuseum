package web.index_calender.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import web.index_calender.dao.Index_calenderDao;
import web.index_calender.vo.Index_calender;


public class Index_calenderDaoImpl implements Index_calenderDao {
	private DataSource dataSource;
	
	public Index_calenderDaoImpl() throws NamingException {
		dataSource = (DataSource) 
				new InitialContext().lookup("java:comp/env/jdbc/javaFramework");	
	}

	@Override
	public List<Index_calender> selectAll() {
		try (
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from Index_calender");
			ResultSet rs = pstmt.executeQuery()		
		) {
			List<Index_calender> list = new ArrayList<>();
			while (rs.next()) {
				Index_calender index_calender = new Index_calender();
				index_calender.setExhibitionID(rs.getInt("EXHIBITIONID"));
				index_calender.setExhibitionName(rs.getString("EXHIBITIONNAME"));
				index_calender.setExhibitionStartDate(rs.getTimestamp("EXHIBITIONSTARTDATE"));
				index_calender.setExhibitionEndDate(rs.getTimestamp("EXHIBITIONENDDATE"));
				index_calender.setExhibitionStatus(rs.getInt("EXHIBITIONSTATUS"));
				index_calender.setBusinessstatus(rs.getInt("BUSINESSSTATUS"));
				list.add(index_calender);
			}
			return list;	
		} catch (Exception e) {
			e.printStackTrace();
			return null;		
		}
	}	
} 
