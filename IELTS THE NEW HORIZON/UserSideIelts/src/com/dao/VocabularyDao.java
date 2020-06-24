package com.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.VocabularyMaterial;
import com.bean.VocabularyTest;
import com.bean.WrittingPessageAnswer;
import com.common.connection;
import com.mysql.jdbc.PreparedStatement;

public class VocabularyDao {
	public List<VocabularyMaterial> listVocabulary(){
		
		List<VocabularyMaterial> list = new ArrayList<VocabularyMaterial>();
		
		ResultSet rs = null;
		try {
			String sql = "SELECT tv.*,tu.user_detail_name FROM tblvocabulary_material tv, tbluser_detail tu WHERE tv.user_detail_id=tu.user_detail_id and tv.is_deleted=0 and tu.is_deleted=0";
			PreparedStatement ps = (PreparedStatement) connection.getConnection().prepareStatement(sql);
			rs = ps.executeQuery();
			int i =1;
			if(null != rs) {
				while(rs.next()) {

					VocabularyMaterial vocabularyMaterial = new VocabularyMaterial();
					vocabularyMaterial.setUser_detail_id(rs.getInt("user_detail_id"));
					vocabularyMaterial.setVocabulary_material_description(rs.getString("vocabulary_material_description"));
					vocabularyMaterial.setVocabulary_material_example(rs.getString("vocabulary_material_example"));
					vocabularyMaterial.setDisplay_vocabulary_material_id(i);
					vocabularyMaterial.setVocabulary_material_id(rs.getInt("vocabulary_material_id"));
					vocabularyMaterial.setVocabulary_material_meaning(rs.getString("vocabulary_material_meaning"));
					vocabularyMaterial.setVocabulary_material_word(rs.getString("vocabulary_material_word"));
					vocabularyMaterial.setUser_detail_name(rs.getString("user_detail_name"));
					
					list.add(vocabularyMaterial);
					i++;
				}
			}
			

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	public List<VocabularyTest> showExamQuestion(int ids[]){
		
		List<VocabularyTest> list = new ArrayList<VocabularyTest>();
		
		ResultSet rs = null;
		try {
			String sql = "	SELECT t.*,t1.vocabulary_material_word FROM tblvocabulary_test t,tblvocabulary_material t1 WHERE t.vocabulary_material_id = t1.vocabulary_material_id and vocabulary_test_id in (?,?,?,?,?)";
			PreparedStatement ps = (PreparedStatement) connection.getConnection().prepareStatement(sql);
			ps.setInt(1, ids[0]);
			ps.setInt(2, ids[1]);
			ps.setInt(3, ids[2]);
			ps.setInt(4, ids[3]);
			ps.setInt(5, ids[4]);
			rs = ps.executeQuery();
			int i =1;
			if(null != rs) {
				while(rs.next()) {

					VocabularyTest vocabularyTest = new VocabularyTest();
					vocabularyTest.setCorrect_answer(rs.getInt("correct_answer")); 
					vocabularyTest.setOption1(rs.getString("option1"));
					vocabularyTest.setOption2(rs.getString("option2"));
					vocabularyTest.setOption3(rs.getString("option3"));
					vocabularyTest.setOption4(rs.getString("option4"));
					vocabularyTest.setVocabulary_material_word(rs.getString("vocabulary_material_word"));
					vocabularyTest.setVocabulary_test_id(rs.getInt("vocabulary_test_id"));
					vocabularyTest.setDispaly_vocabulary_test_id(i);
					list.add(vocabularyTest);
					i++;
				}
			}
			

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	
	public int submitResult(int marks, int userId) {
		
		int retrunValue = 0;

		try {
			String sql = "INSERT INTO tblvocabulary_result(total_marks, user_detail_id, exam_date) VALUES (?,?,now())";
			PreparedStatement ps = (PreparedStatement) connection.getConnection().prepareStatement(sql);

			ps.setInt(1, marks);
			ps.setInt(2, userId);
			retrunValue = ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return retrunValue;
	}

	
}