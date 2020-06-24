package com.action;

import com.bean.ContactUsDetail;
import com.dao.ContactUsDao;

public class ContactUsAction {

	String contact_us_detail_name, contact_us_detail_subject, contact_us_detail_email, contact_us_detail_message,
			contact_us_detail_answer;

	ContactUsDao contactUsDao = new ContactUsDao();

	public String getContact_us_detail_subject() {
		return contact_us_detail_subject;
	}

	public void setContact_us_detail_subject(String contact_us_detail_subject) {
		this.contact_us_detail_subject = contact_us_detail_subject;
	}

	public String getContact_us_detail_name() {
		return contact_us_detail_name;
	}

	public void setContact_us_detail_name(String contact_us_detail_name) {
		this.contact_us_detail_name = contact_us_detail_name;
	}

	public String getContact_us_detail_email() {
		return contact_us_detail_email;
	}

	public void setContact_us_detail_email(String contact_us_detail_email) {
		this.contact_us_detail_email = contact_us_detail_email;
	}

	public String getContact_us_detail_message() {
		return contact_us_detail_message;
	}

	public void setContact_us_detail_message(String contact_us_detail_message) {
		this.contact_us_detail_message = contact_us_detail_message;
	}

	public String getContact_us_detail_answer() {
		return contact_us_detail_answer;
	}

	public void setContact_us_detail_answer(String contact_us_detail_answer) {
		this.contact_us_detail_answer = contact_us_detail_answer;
	}

	public String saveContactUs() {

		ContactUsDetail contactUsDetail = new ContactUsDetail();
		contactUsDetail.setContact_us_detail_answer("");
		contactUsDetail.setContact_us_detail_email(contact_us_detail_email);
		contactUsDetail.setContact_us_detail_message(contact_us_detail_message);
		contactUsDetail.setContact_us_detail_name(contact_us_detail_name);
		contactUsDetail.setContact_us_detail_subject(contact_us_detail_subject);
		
		int i = contactUsDao.saveContactUs(contactUsDetail);
		return "success";
	}
}
