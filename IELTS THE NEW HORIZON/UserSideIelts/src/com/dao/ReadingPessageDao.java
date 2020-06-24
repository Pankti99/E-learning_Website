package com.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.ParagraphTest;
import com.bean.ReadingPessageExam;
import com.bean.ReadingPessageExamResult;
import com.bean.ReadingPesssage;
import com.common.connection;
import com.mysql.jdbc.PreparedStatement;

public class ReadingPessageDao {
	public List<ParagraphTest> listParagraphTest(int isMock,int userId) {

		List<ParagraphTest> list = new ArrayList<ParagraphTest>();
		ResultSet rs = null;
		try {
			int temp = 0;
			String sql1 = "SELECT count(*) as cnt FROM tblreading_pessage_exam_result WHERE DATE_FORMAT(now(), '%d-%m-%Y') = DATE_FORMAT(created_date, '%d-%m-%Y') and practise_mock = 2 and read_or_listening = 1 and user_detail_id = "+userId;
			PreparedStatement ps1 = (PreparedStatement) connection.getConnection().prepareStatement(sql1);
			ResultSet rs1 = ps1.executeQuery();
			if (null != rs1) {
				while (rs1.next()) {
					temp = rs1.getInt("cnt");
				}
			}
			
			if(temp==0) {
				String sql = "SELECT distinct(t.paragraph_test_id) FROM tblparagraph_test t, tblreading_pessage t1, tblreading_pessage_exam t2 WHERE t.paragraph_test_id = t1.paragraph_test_id and t.paragraph_test_id = t2.paragraph_test_id and t.is_deleted=0 and t1.is_deleted=0 and t1.is_deleted=0";
				PreparedStatement ps = (PreparedStatement) connection.getConnection().prepareStatement(sql);
				rs = ps.executeQuery();
				int i = 1;
				if (null != rs) {
					while (rs.next()) {
						int id = rs.getInt("paragraph_test_id");
						String sql2 = "SELECT * FROM tblparagraph_test t where t.is_deleted=0 and paragraph_test_id="+id;
						PreparedStatement ps2 = (PreparedStatement) connection.getConnection().prepareStatement(sql2);
						ResultSet result = ps2.executeQuery();
						
						if(null != result) {
							while(result.next()) {
								ParagraphTest paragraphTest = new ParagraphTest();
								paragraphTest.setDisplay_paragraph_test_id(i);
								paragraphTest.setParagraph_test_id(result.getInt("paragraph_test_id"));
								paragraphTest.setParagraph_test_name(result.getString("paragraph_test_name"));
								list.add(paragraphTest);
								i++;
							}
						}
					}
				}	
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	

	public List<ReadingPesssage> showReadingPessageQuestion(int id) {

		List<ReadingPesssage> list = new ArrayList<ReadingPesssage>();
		ResultSet rs = null;
		try {
			String sql = "SELECT t.*, t1.paragraph_test_name FROM tblreading_pessage t, tblparagraph_test t1 WHERE t.paragraph_test_id=t1.paragraph_test_id and t.is_deleted = 0 and t1.is_deleted = 0 and t.paragraph_test_id=?";
			PreparedStatement ps = (PreparedStatement) connection.getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			int i = 1;
			if (null != rs) {
				while (rs.next()) {
					ReadingPesssage readingPesssage = new ReadingPesssage();
					readingPesssage.setDisplay_reading_pessage_id(i);
					readingPesssage.setReading_pessage(rs.getString("reading_pessage"));
					readingPesssage.setReading_pessage_id(rs.getInt("reading_pessage_id"));
					readingPesssage.setParagraph_test_name(rs.getString("paragraph_test_name"));
					readingPesssage.setParagraph_test_id(rs.getInt("paragraph_test_id"));
					list.add(readingPesssage);
					i++;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	
	public List<ReadingPessageExam> listReadingPessageExam(int id) {

		List<ReadingPessageExam> list = new ArrayList<ReadingPessageExam>();
		ResultSet rs = null;
		try {
			String sql = "SELECT t.*,t1.paragraph_test_name FROM tblreading_pessage_exam t, tblparagraph_test t1 WHERE t.paragraph_test_id = t1.paragraph_test_id and t.is_deleted = 0 and t1.is_deleted = 0 and t1.paragraph_test_id = ?";
			PreparedStatement ps = (PreparedStatement) connection.getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			int i = 1;
			if (null != rs) {
				while (rs.next()) {
					ReadingPessageExam readingPessageExam = new ReadingPessageExam();
					readingPessageExam.setDisplay_reading_pessage_exam_id(i);
					readingPessageExam.setParagraph_test_name(rs.getString("paragraph_test_name"));
					readingPessageExam.setParagraph_test_ans(rs.getString("paragraph_test_ans"));
					readingPessageExam.setParagraph_test_que(rs.getString("paragraph_test_que"));
					readingPessageExam.setReading_pessage_exam_id(rs.getInt("paragraph_exam_id"));
					list.add(readingPessageExam);
					i++;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	
	public List<ReadingPessageExamResult> listReadingPessageExamResult(int id) {

		List<ReadingPessageExamResult> list = new ArrayList<ReadingPessageExamResult>();
		ResultSet rs = null;
		try {
			String sql = "SELECT DATE_FORMAT(t.created_date, '%d-%m-%Y %H:%i') as exam_result_date,t.*,t1.paragraph_test_name FROM tblreading_pessage_exam_result t,tblparagraph_test t1 WHERE t.paragraph_test_id=t1.paragraph_test_id and t.read_or_listening = 1 and t.user_detail_id = ?";
			PreparedStatement ps = (PreparedStatement) connection.getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			int i = 1;
			if (null != rs) {
				while (rs.next()) {
					ReadingPessageExamResult readingPessageExamResult = new ReadingPessageExamResult();
					readingPessageExamResult.setDisplay_tblreading_pessage_exam_result_id(i);
					readingPessageExamResult.setParagraph_test_name(rs.getString("paragraph_test_name"));
					readingPessageExamResult.setReading_pessage_score(rs.getInt("reading_pessage_score"));
					readingPessageExamResult.setExam_date(rs.getString("exam_result_date"));
					list.add(readingPessageExamResult);
					i++;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}	
	
	public List<ReadingPessageExamResult> showSpeakingResultList(int id) {

		List<ReadingPessageExamResult> list = new ArrayList<ReadingPessageExamResult>();
		ResultSet rs = null;
		try {
			String sql = "SELECT DATE_FORMAT(t.created_date, '%d-%m-%Y %H:%i') as exam_result_date,t.*,t1.paragraph_test_name FROM tblreading_pessage_exam_result t,tblparagraph_test t1 WHERE t.paragraph_test_id=t1.paragraph_test_id and t.read_or_listening = 3 and t.user_detail_id = ?";
			PreparedStatement ps = (PreparedStatement) connection.getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			int i = 1;
			if (null != rs) {
				while (rs.next()) {
					ReadingPessageExamResult readingPessageExamResult = new ReadingPessageExamResult();
					readingPessageExamResult.setDisplay_tblreading_pessage_exam_result_id(i);
					readingPessageExamResult.setParagraph_test_name(rs.getString("speaking_test_name"));
					readingPessageExamResult.setReading_pessage_score(rs.getInt("reading_pessage_score"));
					readingPessageExamResult.setExam_date(rs.getString("exam_result_date"));
					list.add(readingPessageExamResult);
					i++;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}		
	
	public int saveReadingPessageExamResult(ReadingPessageExamResult pessageExamResult) {
		int retrunValue = 0;
		pessageExamResult.setReadOListening(1);
		try {
			String sql = "";
			if(pessageExamResult.getIsMock() == 1) {
				sql = "INSERT INTO tblreading_pessage_exam_result(paragraph_test_id, reading_pessage_score, user_detail_id, is_deleted, created_date, read_or_listening,practise_mock) VALUES (?,?,?,?,now(),1,2)";
			} else {
				sql = "INSERT INTO tblreading_pessage_exam_result(paragraph_test_id, reading_pessage_score, user_detail_id, is_deleted, created_date, read_or_listening,practise_mock) VALUES (?,?,?,?,now(),1,1)";
			}
			PreparedStatement ps = (PreparedStatement) connection.getConnection().prepareStatement(sql);
			ps.setInt(1, pessageExamResult.getParagraph_test_id());
			ps.setInt(2, pessageExamResult.getReading_pessage_score());
			ps.setInt(3, pessageExamResult.getUser_detail_id());
			ps.setInt(4, pessageExamResult.getIs_deleted());
			retrunValue = ps.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return retrunValue;
	}
	
}
