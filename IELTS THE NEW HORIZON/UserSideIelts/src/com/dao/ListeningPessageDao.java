package com.dao;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.bean.ListeningPessageExam;
import com.bean.ListeningTest;
import com.bean.MockTestResult;
import com.bean.ParagraphTest;
import com.bean.ReadingPessageExamResult;
import com.bean.SpeakingBookSlot;
import com.common.connection;
import com.mysql.jdbc.PreparedStatement;

public class ListeningPessageDao {

	public List<ListeningPessageExam> showListeningPessageQuestion(int id) {

		List<ListeningPessageExam> list = new ArrayList<ListeningPessageExam>();
		ResultSet rs = null;
		try {
			String sql = "SELECT t.*, t1.listening_test_name FROM tbllistening_pessage_exam t, tbllistening_test t1 WHERE t.listening_test_id=t1.listening_test_id and t.is_deleted = 0 and t1.is_deleted = 0 and t.listening_test_id=?";
			PreparedStatement ps = (PreparedStatement) connection.getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			int i = 1;
			if (null != rs) {
				while (rs.next()) {
					ListeningPessageExam listeningPesssage = new ListeningPessageExam();
					listeningPesssage.setDisplay_listening_pessage_exam_id(i);
					listeningPesssage.setParagraph_test_que(rs.getString("listening_test_que"));
					listeningPesssage.setParagraph_test_ans(rs.getString("listening_test_ans"));
					listeningPesssage.setParagraph_test_name(rs.getString("listening_test_name"));
					listeningPesssage.setParagraph_test_id(rs.getInt("listening_test_id"));
					list.add(listeningPesssage);
					i++;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	
	public int saveListeningPessageExamResult(ReadingPessageExamResult pessageExamResult) {
		int retrunValue = 0;
		pessageExamResult.setReadOListening(2);
		try {
			String sql = "";
			if(pessageExamResult.getIsMock() == 1) {
				sql = "INSERT INTO tblreading_pessage_exam_result(paragraph_test_id, reading_pessage_score, user_detail_id, is_deleted, created_date, read_or_listening, practise_mock) VALUES (?,?,?,?,now(),2,2)";
			} else {
				sql = "INSERT INTO tblreading_pessage_exam_result(paragraph_test_id, reading_pessage_score, user_detail_id, is_deleted, created_date, read_or_listening, practise_mock) VALUES (?,?,?,?,now(),2,1)";
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
	
	public List<ReadingPessageExamResult> listListeningPessageExamResult(int id) {

		List<ReadingPessageExamResult> list = new ArrayList<ReadingPessageExamResult>();
		ResultSet rs = null;
		try {
			String sql = "SELECT DATE_FORMAT(t.created_date, '%d-%m-%Y %H:%i') as exam_result_date,t.*,t1.listening_test_name FROM tblreading_pessage_exam_result t,tbllistening_test t1 WHERE t.paragraph_test_id=t1.listening_test_id and t.read_or_listening = 2 and t.user_detail_id = ?";
			PreparedStatement ps = (PreparedStatement) connection.getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			int i = 1;
			if (null != rs) {
				while (rs.next()) {
					ReadingPessageExamResult readingPessageExamResult = new ReadingPessageExamResult();
					readingPessageExamResult.setDisplay_tblreading_pessage_exam_result_id(i);
					readingPessageExamResult.setParagraph_test_name(rs.getString("listening_test_name"));
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

	public List<SpeakingBookSlot> showSpeakingSlotList(int id) {

		List<SpeakingBookSlot> list = new ArrayList<SpeakingBookSlot>();
		ResultSet rs = null;
		try {
			String sql = "SELECT t.*,t1.speaking_test_name,DATE_FORMAT(t.speaking_date, '%d-%m-%Y') as display_speaking_date FROM tblspeaking_book_slot t,tblspeaking_test t1 WHERE t.speaking_test_id = t1.speaking_test_id and speaking_date <= now() and (speaking_date + interval 1 hour) >= now() and t.user_detail_id="+id;
			System.out.println("sql : "+sql);
			PreparedStatement ps = (PreparedStatement) connection.getConnection().prepareStatement(sql);
			rs = ps.executeQuery();
			int i = 1;
			System.out.println("RS : "+rs);
			if (null != rs) {
				while (rs.next()) {
					System.out.println("inside");
					SpeakingBookSlot speakingBookSlot = new SpeakingBookSlot();
					speakingBookSlot.setDisplay_id(i);
					System.out.println("1");
					speakingBookSlot.setDisplay_speaking_date(rs.getString("display_speaking_date"));
					String sdate=rs.getString("display_speaking_date");
					System.out.println("sdate:"+sdate);
					System.out.println("checking");
					speakingBookSlot.setSpeaking_test_name(rs.getString("speaking_test_name"));
					System.out.println("2");
					speakingBookSlot.setSpeaking_book_slot_id(rs.getInt("speaking_book_slot_id"));
					int fid = rs.getInt("faculty_id");
					System.out.println("3");
					String sql1 = "SELECT * from tbluser_detail where user_detail_id="+fid;
					System.out.println("sql1 : "+sql1);
					PreparedStatement ps1 = (PreparedStatement) connection.getConnection().prepareStatement(sql1);
					ResultSet rs1 = ps1.executeQuery();
					if (null != rs1) {
						while (rs1.next()) {
							System.out.println("RS :...............: "+rs1);
							speakingBookSlot.setFaculty_name(rs1.getString("user_detail_name"));
						}
					}
					
					
					list.add(speakingBookSlot);
					i++;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}	
	

	public List<MockTestResult> showMockResultList(int id) {

		System.out.println("Come in DAO :-------------------> "+id);
		List<MockTestResult> list = new ArrayList<MockTestResult>();
		ResultSet rs = null;
		try {
			String sql = "SELECT *,DATE_FORMAT(created_date, '%d-%m-%Y') as mock_date FROM tblreading_pessage_exam_result WHERE practise_mock = 2 and user_detail_id=?  group by(DATE_FORMAT(created_date, '%d-%m-%Y'))";
			PreparedStatement ps = (PreparedStatement) connection.getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			System.out.println("Result Set : ---> Outer : "+rs);
			int i = 1;
			String mockDate="";
			if (null != rs) {
				while (rs.next()) {
					MockTestResult mockTestResult = new MockTestResult(); 
					mockTestResult.setDisplay_id(i);
					mockTestResult.setDisplay_date(rs.getString("mock_date"));
					
					mockDate = rs.getString("mock_date");
					String sql1 = "SELECT * FROM tblreading_pessage_exam_result WHERE user_detail_id = "+id+" and DATE_FORMAT(created_date, '%d-%m-%Y') = '"+mockDate+"'";
					System.out.println("SQL : "+sql1);
					PreparedStatement ps1 = (PreparedStatement) connection.getConnection().prepareStatement(sql1);
					ResultSet rs1 = ps1.executeQuery();
					if (null != rs1) {
						while (rs1.next()) {
							
							System.out.println("Read Or Listening : "+rs1.getInt("read_or_listening"));
							if(rs1.getInt("read_or_listening")==1) {
								mockTestResult.setR_band(String.valueOf(rs1.getInt("reading_pessage_score")));
							}
							if(rs1.getInt("read_or_listening")==2) {
								mockTestResult.setL_band(String.valueOf(rs1.getInt("reading_pessage_score")));
							}
							if(rs1.getInt("read_or_listening")==3) {
								mockTestResult.setS_band(String.valueOf(rs1.getInt("reading_pessage_score")));
							}
							if(rs1.getInt("read_or_listening")==4) {
								mockTestResult.setW_band(String.valueOf(rs1.getInt("reading_pessage_score")));
							}
						}
						int na = 0;
						if(null == mockTestResult.getR_band()) {
							mockTestResult.setR_band("N/A");
							na++;
						}
						if(null==mockTestResult.getL_band()) {
							mockTestResult.setL_band("N/A");
							na++;
						}
						if(null==mockTestResult.getS_band()) {
							mockTestResult.setS_band("N/A");
							na++;
						}
						if(null==mockTestResult.getW_band()) {
							mockTestResult.setW_band("N/A");
							na++;
						}
						
						if(na==0) {
							int total = Integer.parseInt(mockTestResult.getR_band()) + Integer.parseInt(mockTestResult.getL_band()) + Integer.parseInt(mockTestResult.getS_band()) + Integer.parseInt(mockTestResult.getW_band());  
							double finalBand = total / 4;
							mockTestResult.setTotal(String.valueOf(finalBand));
						} else {
							mockTestResult.setTotal("Absent");
						}
						list.add(mockTestResult);

					}
					i++;

				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}	

	public List<ListeningTest> listSpeakingTest() {

		List<ListeningTest> list = new ArrayList<ListeningTest>();
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM tblspeaking_test WHERE is_deleted=0";
			PreparedStatement ps = (PreparedStatement) connection.getConnection().prepareStatement(sql);
			rs = ps.executeQuery();
			if (null != rs) {
				while (rs.next()) {
					ListeningTest listeningTest = new ListeningTest();
					listeningTest.setListening_test_id(rs.getInt("speaking_test_id"));
					listeningTest.setListening_test_name(rs.getString("speaking_test_name"));
					list.add(listeningTest);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}	

	public List<ListeningTest> listListeningPessage(int isMock,int userId) {

		List<ListeningTest> list = new ArrayList<ListeningTest>();
		ResultSet rs = null;
		try {
			
			int temp = 0;
			String sql1 = "SELECT count(*) as cnt FROM tblreading_pessage_exam_result WHERE DATE_FORMAT(now(), '%d-%m-%Y') = DATE_FORMAT(created_date, '%d-%m-%Y') and practise_mock = 2 and read_or_listening = 2 and user_detail_id = "+userId;
			PreparedStatement ps1 = (PreparedStatement) connection.getConnection().prepareStatement(sql1);
			ResultSet rs1 = ps1.executeQuery();
			if (null != rs1) {
				while (rs1.next()) {
					temp = rs1.getInt("cnt");
				}
			}

			if(temp == 0) {
				String sql = "SELECT distinct(t.listening_test_id) FROM tbllistening_pessage_exam t,tbllistening_test t1 WHERE t.listening_test_id = t1.listening_test_id and t.is_deleted = 0";
				PreparedStatement ps = (PreparedStatement) connection.getConnection().prepareStatement(sql);
				rs = ps.executeQuery();
				if (null != rs) {
					while (rs.next()) {
						int id = rs.getInt("listening_test_id");
						String sql2 = "SELECT * FROM tbllistening_test WHERE listening_test_id = "+id;
						PreparedStatement ps2 = (PreparedStatement) connection.getConnection().prepareStatement(sql2);
						ResultSet result = ps2.executeQuery();
						
						if(null != result) {
							while(result.next()) {
								ListeningTest listeningTest = new ListeningTest();
								
								listeningTest.setListening_test_id(result.getInt("listening_test_id"));
								listeningTest.setListening_test_name(result.getString("listening_test_name"));
								list.add(listeningTest);
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

	public int getFacultyId() {
		int facultyId = 0;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM tbluser_detail WHERE is_deleted = 0 and user_type_id = 3 limit 0,1";
			PreparedStatement ps = (PreparedStatement) connection.getConnection().prepareStatement(sql);
			rs = ps.executeQuery();
			if (null != rs) {
				while (rs.next()) {
					facultyId = rs.getInt("user_detail_id");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return facultyId;
	}	

	public int saveSpeakingBookSlot(SpeakingBookSlot speakingBookSlot) {
		int retrunValue = 0;
		try {
			String sql = "INSERT INTO tblspeaking_book_slot(user_detail_id, faculty_id, speaking_date, speaking_test_id, is_mock) VALUES (?,?,?,?,?)";
			PreparedStatement ps = (PreparedStatement) connection.getConnection().prepareStatement(sql);
			ps.setInt(1, speakingBookSlot.getUser_detail_id());
			ps.setInt(2, speakingBookSlot.getFaculty_id());
		
			java.util.Date date1 = new java.util.Date();
			date1 = speakingBookSlot.getSpeaking_date();
			//System.out.println("date1 in DAO::"+date1);
			java.sql.Date bdate = new java.sql.Date(date1.getTime());

			
			ps.setTimestamp(3,new Timestamp(bdate.getTime()));
			ps.setInt(4, speakingBookSlot.getSpeaking_test_id());
			if(speakingBookSlot.getIs_mock() == 1) {
				ps.setInt(5, 2);
			} else {
				ps.setInt(5, 1);
			}
			retrunValue = ps.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return retrunValue;
	}

	public List<SpeakingBookSlot> listSpeakingBookSlot(int id) {

		List<SpeakingBookSlot> list = new ArrayList<SpeakingBookSlot>();
		ResultSet rs = null;
		try {
			String sql = "SELECT DATE_FORMAT(t.speaking_date, '%d-%m-%Y %H:%i') as speaking_date, t.*,t2.speaking_test_name FROM tblspeaking_book_slot t, tbluser_detail t1, tblspeaking_test t2 WHERE t.user_detail_id = t1.user_detail_id and t.speaking_test_id = t2.speaking_test_id and t.user_detail_id = "+id;
			PreparedStatement ps = (PreparedStatement) connection.getConnection().prepareStatement(sql);
			rs = ps.executeQuery();
			if (null != rs) {
				while (rs.next()) {
					SpeakingBookSlot speakingBookSlot = new SpeakingBookSlot();
					speakingBookSlot.setSpeaking_test_name(rs.getString("speaking_test_name"));
					speakingBookSlot.setDisplay_speaking_date(rs.getString("speaking_date"));
					
					String sql1 = "select * from tbluser_detail t where t.user_detail_id = "+id;
					PreparedStatement ps1 = (PreparedStatement) connection.getConnection().prepareStatement(sql1);
					ResultSet rs1 = ps1.executeQuery();
					if (null != rs1) {
						while (rs1.next()) {
							speakingBookSlot.setFaculty_name(rs1.getString("user_detail_name"));
						}
					}
					speakingBookSlot.setSpeaking_book_slot_id(rs.getInt("speaking_book_slot_id"));
					
					
					list.add(speakingBookSlot);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}	

}
