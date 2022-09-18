package com.contactUs.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
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
	public List<QuestionContentVO> findByDate(String lastUpdateDate1, String lastUpdateDate2) {
		String sql = "select * from questionContent where date(lastUpdateTime) between ? and ? ";
		
		try (Connection connection = dataSource.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(sql);
				) {
				pstmt.setString(1, lastUpdateDate1);
				pstmt.setString(2, lastUpdateDate2);
				ResultSet ansrs = pstmt.executeQuery();
				List<QuestionContentVO> list = new ArrayList<QuestionContentVO>();
				while (ansrs.next()) {	
					QuestionContentVO quesCont = new QuestionContentVO();
					quesCont.setQuestionContentID(ansrs.getInt("questionContentID"));
					quesCont.setMemberId(ansrs.getInt("memberId"));
					quesCont.setQuestionTypeID(ansrs.getInt("questionTypeID"));
					quesCont.setQuestionContent(ansrs.getString("questionContent"));
					quesCont.setAnswerContent(ansrs.getString("answerContent"));
					quesCont.setAnswered(ansrs.getBoolean("answered"));
					quesCont.setLastUpdateTime(ansrs.getTimestamp("lastUpdateTime"));
					list.add(quesCont);
				}
				return list;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
	}
	
	@Override
	public List<QuestionContentVO> findByMemberId(Integer memberId) {
		String sql = "select * from questionContent where memberId=? ";
			
		try (Connection connection = dataSource.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(sql);
				) {
			
			pstmt.setInt(1, memberId);
			ResultSet ansrs = pstmt.executeQuery();
			List<QuestionContentVO> list = new ArrayList<QuestionContentVO>();
			while (ansrs.next()) {	
				QuestionContentVO quesCont = new QuestionContentVO();
				quesCont.setQuestionContentID(ansrs.getInt("questionContentID"));
				quesCont.setMemberId(ansrs.getInt("memberId"));
				quesCont.setQuestionTypeID(ansrs.getInt("questionTypeID"));
				quesCont.setQuestionContent(ansrs.getString("questionContent"));
				quesCont.setAnswerContent(ansrs.getString("answerContent"));
				quesCont.setAnswered(ansrs.getBoolean("answered"));
				quesCont.setLastUpdateTime(ansrs.getTimestamp("lastUpdateTime"));
				list.add(quesCont);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	@Override
	public void insertAns(QuestionContentVO questionContent) {
		String sql = "insert questionContent(answerContent, answered) "
				+ "values(?, ?)";
		try (Connection connection = dataSource.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(sql);) {
			
			pstmt.setString(1, questionContent.getAnswerContent());
			pstmt.setBoolean(2, questionContent.getAnswered());
			pstmt.executeUpdate();	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
				quesCont.setLastUpdateTime(rs.getTimestamp("lastUpdateTime"));
				list.add(quesCont);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	

	

	

}// class
