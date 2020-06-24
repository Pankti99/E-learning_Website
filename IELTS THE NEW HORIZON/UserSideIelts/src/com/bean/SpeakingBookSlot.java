package com.bean;

import java.util.Date;

public class SpeakingBookSlot {
	int display_id, speaking_book_slot_id, is_mock, user_detail_id, faculty_id, speaking_test_id;
	Date speaking_date;
	String faculty_name, speaking_test_name, display_speaking_date;

	
	public int getIs_mock() {
		return is_mock;
	}

	public void setIs_mock(int is_mock) {
		this.is_mock = is_mock;
	}

	public int getDisplay_id() {
		return display_id;
	}

	public void setDisplay_id(int display_id) {
		this.display_id = display_id;
	}

	public String getDisplay_speaking_date() {
		return display_speaking_date;
	}

	public void setDisplay_speaking_date(String display_speaking_date) {
		this.display_speaking_date = display_speaking_date;
	}

	public String getFaculty_name() {
		return faculty_name;
	}

	public void setFaculty_name(String faculty_name) {
		this.faculty_name = faculty_name;
	}

	public String getSpeaking_test_name() {
		return speaking_test_name;
	}

	public void setSpeaking_test_name(String speaking_test_name) {
		this.speaking_test_name = speaking_test_name;
	}

	public int getSpeaking_test_id() {
		return speaking_test_id;
	}

	public void setSpeaking_test_id(int speaking_test_id) {
		this.speaking_test_id = speaking_test_id;
	}

	public int getSpeaking_book_slot_id() {
		return speaking_book_slot_id;
	}

	public void setSpeaking_book_slot_id(int speaking_book_slot_id) {
		this.speaking_book_slot_id = speaking_book_slot_id;
	}

	public int getUser_detail_id() {
		return user_detail_id;
	}

	public void setUser_detail_id(int user_detail_id) {
		this.user_detail_id = user_detail_id;
	}

	public int getFaculty_id() {
		return faculty_id;
	}

	public void setFaculty_id(int faculty_id) {
		this.faculty_id = faculty_id;
	}

	public Date getSpeaking_date() {
		return speaking_date;
	}

	public void setSpeaking_date(Date speaking_date) {
		this.speaking_date = speaking_date;
	}

}
