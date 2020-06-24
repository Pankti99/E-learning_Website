package com.bean;

public class GroupQuestionAnswer {

	int group_question_answer_id;
	String group_question, question_user_detail_name, group_answer, answer_user_detail_name,question_date;

	
	public String getQuestion_date() {
		return question_date;
	}

	public void setQuestion_date(String question_date) {
		this.question_date = question_date;
	}

	public int getGroup_question_answer_id() {
		return group_question_answer_id;
	}

	public void setGroup_question_answer_id(int group_question_answer_id) {
		this.group_question_answer_id = group_question_answer_id;
	}

	public String getGroup_question() {
		return group_question;
	}

	public void setGroup_question(String group_question) {
		this.group_question = group_question;
	}

	public String getQuestion_user_detail_name() {
		return question_user_detail_name;
	}

	public void setQuestion_user_detail_name(String question_user_detail_name) {
		this.question_user_detail_name = question_user_detail_name;
	}

	public String getGroup_answer() {
		return group_answer;
	}

	public void setGroup_answer(String group_answer) {
		this.group_answer = group_answer;
	}

	public String getAnswer_user_detail_name() {
		return answer_user_detail_name;
	}

	public void setAnswer_user_detail_name(String answer_user_detail_name) {
		this.answer_user_detail_name = answer_user_detail_name;
	}

}
