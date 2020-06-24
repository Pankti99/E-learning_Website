package com.bean;

public class ReadingPessageExamResult {
	int tblreading_pessage_exam_result_id, display_tblreading_pessage_exam_result_id, paragraph_test_id, user_detail_id,
			is_deleted, reading_pessage_score, isMock;
	String paragraph_test_name, exam_date;
	int readOListening;

	public int getIsMock() {
		return isMock;
	}

	public void setIsMock(int isMock) {
		this.isMock = isMock;
	}

	public int getReadOListening() {
		return readOListening;
	}

	public void setReadOListening(int readOListening) {
		this.readOListening = readOListening;
	}

	public String getExam_date() {
		return exam_date;
	}

	public void setExam_date(String exam_date) {
		this.exam_date = exam_date;
	}

	public int getDisplay_tblreading_pessage_exam_result_id() {
		return display_tblreading_pessage_exam_result_id;
	}

	public void setDisplay_tblreading_pessage_exam_result_id(int display_tblreading_pessage_exam_result_id) {
		this.display_tblreading_pessage_exam_result_id = display_tblreading_pessage_exam_result_id;
	}

	public String getParagraph_test_name() {
		return paragraph_test_name;
	}

	public void setParagraph_test_name(String paragraph_test_name) {
		this.paragraph_test_name = paragraph_test_name;
	}

	public int getReading_pessage_score() {
		return reading_pessage_score;
	}

	public void setReading_pessage_score(int reading_pessage_score) {
		this.reading_pessage_score = reading_pessage_score;
	}

	public int getTblreading_pessage_exam_result_id() {
		return tblreading_pessage_exam_result_id;
	}

	public void setTblreading_pessage_exam_result_id(int tblreading_pessage_exam_result_id) {
		this.tblreading_pessage_exam_result_id = tblreading_pessage_exam_result_id;
	}

	public int getParagraph_test_id() {
		return paragraph_test_id;
	}

	public void setParagraph_test_id(int paragraph_test_id) {
		this.paragraph_test_id = paragraph_test_id;
	}

	public int getUser_detail_id() {
		return user_detail_id;
	}

	public void setUser_detail_id(int user_detail_id) {
		this.user_detail_id = user_detail_id;
	}

	public int getIs_deleted() {
		return is_deleted;
	}

	public void setIs_deleted(int is_deleted) {
		this.is_deleted = is_deleted;
	}

}
