package com.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.bean.GroupQuestionAnswer;
import com.common.connection;
import com.mysql.jdbc.PreparedStatement;

public class GroupChatDao {
	public List<GroupQuestionAnswer> listOfQuestion() {

		List<GroupQuestionAnswer> list = new ArrayList<GroupQuestionAnswer>();
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM tblgroup_question_answer where group_answer is null or group_answer = ''";
			PreparedStatement ps = (PreparedStatement) connection.getConnection().prepareStatement(sql);
			rs = ps.executeQuery();
			if (null != rs) {
				while (rs.next()) {
					GroupQuestionAnswer groupQuestionAnswer = new GroupQuestionAnswer();
					groupQuestionAnswer.setGroup_question(rs.getString("group_question"));
					groupQuestionAnswer.setGroup_question_answer_id(rs.getInt("group_question_answer_id"));
					
					list.add(groupQuestionAnswer);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;

	}

	public List<GroupQuestionAnswer> groupChatList() {

		List<GroupQuestionAnswer> list = new ArrayList<GroupQuestionAnswer>();
		ResultSet rs = null;
		try {
			String sql = "SELECT *,DATE_FORMAT(is_create_date, '%d-%m-%Y %H:%i') as question_date FROM tblgroup_question_answer";
			PreparedStatement ps = (PreparedStatement) connection.getConnection().prepareStatement(sql);
			rs = ps.executeQuery();
			if (null != rs) {
				while (rs.next()) {
					GroupQuestionAnswer groupQuestionAnswer = new GroupQuestionAnswer();
					groupQuestionAnswer.setGroup_question_answer_id(rs.getInt("group_question_answer_id"));
					groupQuestionAnswer.setGroup_question(rs.getString("group_question"));
					if(null != rs.getString("answer_user_detail_name") && rs.getString("answer_user_detail_name").length()>0) {
						groupQuestionAnswer.setAnswer_user_detail_name(rs.getString("answer_user_detail_name"));
					} else {
						groupQuestionAnswer.setAnswer_user_detail_name("--");
					}
					
					if(null != rs.getString("group_answer") && rs.getString("group_answer").length()>0) {
						groupQuestionAnswer.setGroup_answer(rs.getString("group_answer"));
					} else {
						groupQuestionAnswer.setGroup_answer("--");
					}
					groupQuestionAnswer.setQuestion_date(rs.getString("question_date"));
					groupQuestionAnswer.setQuestion_user_detail_name(rs.getString("question_user_detail_name"));
					
					list.add(groupQuestionAnswer);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}	
		
	public int saveGroupAnswer(GroupQuestionAnswer groupQuestionAnswer) {
		int retrunValue = 0;

		try {
			String sql = "INSERT INTO tblgroup_question_answer(group_question, question_user_detail_name, is_deleted, is_create_date, is_updated_date) VALUES (?,?,?,now(),now())";
			PreparedStatement ps = (PreparedStatement) connection.getConnection().prepareStatement(sql);

			ps.setString(1, groupQuestionAnswer.getGroup_question());
			ps.setString(2, groupQuestionAnswer.getQuestion_user_detail_name());
			ps.setInt(3, 0);
			retrunValue = ps.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return retrunValue;

	}

}
