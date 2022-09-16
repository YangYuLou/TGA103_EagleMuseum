package com.contactUs.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class QuestionContentDaoImpl implements QuestionContentDao {

	private DataSource dataSource;

	public QuestionContentDaoImpl() throws NamingException {
		dataSource = (DataSource) new InitialContext().lookup("java:comp/env/jdbc/eaglemuseum");
	}

	@Override
	public Integer insert(QuestionContentVO questionContent) {
		String sql = "insert questionContent(memberId, questionTypeID, questionContent, answerContent) "
				+ "values(?, ?, ?, ?)";
		try (Connection connection = dataSource.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(sql, new String[] { "questionContentID" });) {
			// 假裝從session取得memberid
			int memberId = 1;
//			pstmt.setInt(1, questionContent.getMemberId());
			pstmt.setInt(1, memberId);
			pstmt.setInt(2, questionContent.getQuestionTypeID());
			pstmt.setString(3, questionContent.getQuestionContent());
			pstmt.setString(4, questionContent.getAnswerContent());
			pstmt.executeUpdate();
			try (ResultSet rs = pstmt.getGeneratedKeys()) {
				if (rs.next()) {
					Integer id = rs.getInt(1);
					return id;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<QuestionContentVO> selectAll() {
		String sql = "select * from questionContent";
		try (Connection connection = dataSource.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {
			List<QuestionContentVO> list = new ArrayList<>();
			while (rs.next()) {
				QuestionContentVO quesCont = new QuestionContentVO();
				quesCont.setQuestionContentID(rs.getInt("questionContentID"));
				quesCont.setMemberId(rs.getInt("memberId"));
				quesCont.setQuestionTypeID(rs.getInt("questionTypeID"));
				quesCont.setQuestionContent(rs.getString("questionContent"));
				quesCont.setAnswerContent(rs.getString("answerContent"));
				quesCont.setAnswered(rs.getBoolean("answered"));
				quesCont.setLastUpdateTime(rs.getDate("lastUpdateTime"));
				list.add(quesCont);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}// class
