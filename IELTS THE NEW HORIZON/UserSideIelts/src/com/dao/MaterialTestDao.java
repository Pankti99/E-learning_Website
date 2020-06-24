package com.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.WrittingPessage;
import com.bean.WrittingPessageAnswer;
import com.common.connection;
import com.mysql.jdbc.PreparedStatement;

public class MaterialTestDao {

	public List<WrittingPessage> listWrittingPessage() {

		List<WrittingPessage> list = new ArrayList<WrittingPessage>();
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM tblwritting_pessage";
			PreparedStatement ps = (PreparedStatement) connection.getConnection().prepareStatement(sql);
			rs = ps.executeQuery();
			int i = 1;
			if (null != rs) {
				while (rs.next()) {
					WrittingPessage writtingPessage = new WrittingPessage();
					writtingPessage.setDisplay_wirtting_pessage_id(i);
					writtingPessage.setWirtting_pessage_id(rs.getInt("writting_pessage_id"));
					writtingPessage.setWirtting_pessage_name(rs.getString("writting_pessage_name"));
					list.add(writtingPessage);
					i++;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;

	}

	public List<WrittingPessage> listWrittingPessageMock(int id) {

		List<WrittingPessage> list = new ArrayList<WrittingPessage>();
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM tblwritting_pessage";
			PreparedStatement ps = (PreparedStatement) connection.getConnection().prepareStatement(sql);
			rs = ps.executeQuery();
			int i = 1,temp=0;
			if (null != rs) {
				while (rs.next()) {
					String sql1 = "SELECT count(*) as cnt FROM tblwritting_pessage_answer WHERE  DATE_FORMAT(now(), '%d-%m-%Y') = DATE_FORMAT(writting_pessage_date, '%d-%m-%Y') and user_detail_id = "+id;
					PreparedStatement ps1 = (PreparedStatement) connection.getConnection().prepareStatement(sql1);
					ResultSet rs1 = ps1.executeQuery();
					if (null != rs1) {
						while (rs1.next()) {
							temp = rs1.getInt("cnt");
						}
					}
					if(temp==0) {
						WrittingPessage writtingPessage = new WrittingPessage();
						writtingPessage.setDisplay_wirtting_pessage_id(i);
						writtingPessage.setWirtting_pessage_id(rs.getInt("writting_pessage_id"));
						writtingPessage.setWirtting_pessage_name(rs.getString("writting_pessage_name"));
						list.add(writtingPessage);
						i++;
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;

	}

	public String getWrittingPessageName(int id) {
		String writtingPessageName = "";
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM tblwritting_pessage where writting_pessage_id="+id;
			PreparedStatement ps = (PreparedStatement) connection.getConnection().prepareStatement(sql);
			rs = ps.executeQuery();
			if (null != rs) {
				while (rs.next()) {
					writtingPessageName = rs.getString("writting_pessage_name");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return writtingPessageName;
	}
	
	public int userAttendTest(int id) {
		int userAttendTest=0;
		ResultSet rs = null;
		try {
			String sql = "SELECT case when DATE_FORMAT(now(), '%d-%m-%Y') = DATE_FORMAT(writting_pessage_date, '%d-%m-%Y') then 1 else 2 end as mockTestAttend FROM tblwritting_pessage_answer WHERE practise_mock = 2 and user_detail_id ="+id;
			PreparedStatement ps = (PreparedStatement) connection.getConnection().prepareStatement(sql);
			rs = ps.executeQuery();
			if (null != rs) {
				while (rs.next()) {
					userAttendTest = rs.getInt("mockTestAttend");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return userAttendTest;
	}

	
	public int saveWrittingPessageAns(WrittingPessageAnswer pessageAnswer) {
		
		int retrunValue = 0;

		try {
			String sql = "";
			if(pessageAnswer.getIsMock() == 1) {
				sql = "INSERT INTO tblwritting_pessage_answer(writting_pessage_id,user_detail_id,writting_pessage_answer,writting_pessage_band,writting_pessage_date,practise_mock) VALUES (?,?,?,?,now(),2)";
			} else {
				sql = "INSERT INTO tblwritting_pessage_answer(writting_pessage_id,user_detail_id,writting_pessage_answer,writting_pessage_band,writting_pessage_date,practise_mock) VALUES (?,?,?,?,now(),1)";
			}
			PreparedStatement ps = (PreparedStatement) connection.getConnection().prepareStatement(sql);

			ps.setInt(1, pessageAnswer.getWritting_pessage_id());
			ps.setInt(2, pessageAnswer.getUser_detail_id());
			ps.setString(3, pessageAnswer.getWritting_pessage_answer());
			ps.setDouble(4, pessageAnswer.getWritting_pessage_band());
			retrunValue = ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return retrunValue;
	}
}
