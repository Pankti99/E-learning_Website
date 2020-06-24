package com.dao;

import java.sql.Timestamp;

import com.bean.ContactUsDetail;
import com.common.connection;
import com.mysql.jdbc.PreparedStatement;

public class ContactUsDao {

	public int saveContactUs(ContactUsDetail contactUsDetail) {
		int retrunValue = 0;

		try {
			String sql = "INSERT INTO tblcontact_us_detail(contact_us_detail_name, contact_us_detail_email, contact_us_detail_subject, contact_us_detail_message, contact_us_detail_answer, is_deleted, is_created) VALUES (?,?,?,?,?,?,?)";
			PreparedStatement ps = (PreparedStatement) connection.getConnection().prepareStatement(sql);

			ps.setString(1, contactUsDetail.getContact_us_detail_name());
			ps.setString(2, contactUsDetail.getContact_us_detail_email());
			ps.setString(3, contactUsDetail.getContact_us_detail_subject());
			ps.setString(4, contactUsDetail.getContact_us_detail_message());
			
			
			ps.setString(5, contactUsDetail.getContact_us_detail_answer());
			ps.setInt(6, 0);
			ps.setTimestamp(7, new Timestamp(new java.util.Date().getTime()));
			retrunValue = ps.executeUpdate();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return retrunValue;
	}

}
