package com.dao;

import java.sql.ResultSet;

import com.bean.LoginInfo;
import com.common.connection;
import com.mysql.jdbc.PreparedStatement;

public class LoginDao {

	public LoginInfo loginAsUser(String userName, String password) {
		
		LoginInfo loginInfo = new LoginInfo();
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM tbluser_detail where user_detail_email= ? and user_detail_password= ? and is_deleted=0";
			PreparedStatement ps = (PreparedStatement) connection.getConnection().prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, password);
			rs = ps.executeQuery();
			int i = 0;
			if (null != rs) {
				while (rs.next()) {
					i = 1;
					loginInfo.setUser_detail_id(rs.getInt("user_detail_id"));
					loginInfo.setUserDetailId(rs.getInt("user_detail_id"));
					loginInfo.setContact(rs.getString("user_detail_contact"));
					loginInfo.setEmailId(rs.getString("user_detail_email"));
					loginInfo.setPassword(rs.getString("user_detail_password"));
					loginInfo.setUserName(rs.getString("user_detail_name"));
					loginInfo.setUserType(rs.getInt("user_type_id"));
				}
			}
			if(i==0) {
				loginInfo = null;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return loginInfo;

	}

	public LoginInfo ForgotPassword(String userName) {
		
		LoginInfo loginInfo = new LoginInfo();
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM tbluser_detail where user_detail_email= ? and is_deleted=0 and user_type_id = 4";
			PreparedStatement ps = (PreparedStatement) connection.getConnection().prepareStatement(sql);
			ps.setString(1, userName);
			rs = ps.executeQuery();
			int i = 0;
			if (null != rs) {
				while (rs.next()) {
					i = 1;
					loginInfo.setUser_detail_id(rs.getInt("user_detail_id"));
					loginInfo.setUserDetailId(rs.getInt("user_detail_id"));
					loginInfo.setContact(rs.getString("user_detail_contact"));
					loginInfo.setEmailId(rs.getString("user_detail_email"));
					loginInfo.setPassword(rs.getString("user_detail_password"));
					loginInfo.setUserName(rs.getString("user_detail_name"));
					loginInfo.setUserType(rs.getInt("user_type_id"));
				}
			}
			if(i==0) {
				loginInfo = null;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return loginInfo;
	}

	public LoginInfo ForgotUsername(String userName) {
		System.out.println("userName : "+userName);
		LoginInfo loginInfo = new LoginInfo();
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM tbluser_detail where user_detail_contact = ? and is_deleted=0 and user_type_id = 4";
			PreparedStatement ps = (PreparedStatement) connection.getConnection().prepareStatement(sql);
			ps.setString(1, userName);
			rs = ps.executeQuery();
			int i = 0;
			if (null != rs) {
				while (rs.next()) {
					i = 1;
					loginInfo.setUser_detail_id(rs.getInt("user_detail_id"));
					loginInfo.setUserDetailId(rs.getInt("user_detail_id"));
					loginInfo.setContact(rs.getString("user_detail_contact"));
					loginInfo.setEmailId(rs.getString("user_detail_email"));
					loginInfo.setPassword(rs.getString("user_detail_password"));
					loginInfo.setUserName(rs.getString("user_detail_name"));
					loginInfo.setUserType(rs.getInt("user_type_id"));
				}
			}
			if(i==0) {
				loginInfo = null;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("loginInfo : "+loginInfo);
		return loginInfo;
	}

}
