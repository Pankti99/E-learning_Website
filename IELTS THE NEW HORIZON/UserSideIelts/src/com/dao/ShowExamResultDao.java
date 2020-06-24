package com.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.VocabularyResult;
import com.bean.WrittingPessageAnswer;
import com.common.connection;
import com.mysql.jdbc.PreparedStatement;

public class ShowExamResultDao {

	public List<VocabularyResult> getVocabularyList(int id){

		List<VocabularyResult> list = new ArrayList<VocabularyResult>();
		ResultSet rs = null;
		try {
			String sql = "SELECT t.*,t2.user_detail_name,DATE_FORMAT(t.exam_date, '%d-%m-%Y %H:%i') as exam_result_date FROM tblvocabulary_result t,tbluser_detail t2 WHERE t.user_detail_id = t2.user_detail_id and t.user_detail_id = "+id;
			PreparedStatement ps = (PreparedStatement) connection.getConnection().prepareStatement(sql);
			rs = ps.executeQuery();
			int i = 1;
			if (null != rs) {
				while (rs.next()) {
					VocabularyResult VocabularyResult = new VocabularyResult();
					VocabularyResult.setDisplay_vocabulary_result_id(i);
					VocabularyResult.setTotal_marks(rs.getInt("total_marks"));
					VocabularyResult.setUser_detail_name(rs.getString("user_detail_name"));
					VocabularyResult.setExam_result_date(rs.getString("exam_result_date"));
					list.add(VocabularyResult);
					i++;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	public List<WrittingPessageAnswer> getWrittingPessageList(int id){

		List<WrittingPessageAnswer> list = new ArrayList<WrittingPessageAnswer>();
		ResultSet rs = null;
		try {
			String sql = "SELECT t.*,t1.writting_pessage_name,t2.user_detail_name,DATE_FORMAT(t.writting_pessage_date, '%d-%m-%Y %H:%i') as writting_date FROM tblwritting_pessage_answer t,tblwritting_pessage t1, tbluser_detail t2 WHERE t.writting_pessage_id=t1.writting_pessage_id and t.user_detail_id = t2.user_detail_id and t.user_detail_id = "+id;
			PreparedStatement ps = (PreparedStatement) connection.getConnection().prepareStatement(sql);
			rs = ps.executeQuery();
			int i = 1;
			if (null != rs) {
				while (rs.next()) {
					WrittingPessageAnswer writtingPessageAnswer = new WrittingPessageAnswer();
					writtingPessageAnswer.setWritting_pessage_answer_id(i);
					writtingPessageAnswer.setUser_detail_name(rs.getString("user_detail_name"));
					writtingPessageAnswer.setWritting_pessage_band(rs.getDouble("writting_pessage_band"));
					writtingPessageAnswer.setWritting_pessage_name(rs.getString("writting_pessage_name"));
					writtingPessageAnswer.setWritting_pessage_date(rs.getString("writting_date"));
					list.add(writtingPessageAnswer);
					i++;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	

	
}
