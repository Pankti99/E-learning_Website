package com.action;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.bean.GroupQuestionAnswer;
import com.bean.LoginInfo;
import com.dao.GroupChatDao;

public class GroupChatAction {

	int group_question_answer_id;
	String group_question;
	
	List<GroupQuestionAnswer> groupChat = new ArrayList<GroupQuestionAnswer>();
	List<GroupQuestionAnswer> groupChatList = new ArrayList<GroupQuestionAnswer>();

	GroupChatDao groupChatDao = new GroupChatDao();
	
	public List<GroupQuestionAnswer> getGroupChatList() {
		return groupChatList;
	}

	public void setGroupChatList(List<GroupQuestionAnswer> groupChatList) {
		this.groupChatList = groupChatList;
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

	public List<GroupQuestionAnswer> getGroupChat() {
		return groupChat;
	}

	public void setGroupChat(List<GroupQuestionAnswer> groupChat) {
		this.groupChat = groupChat;
	}

	public String showChat() {
		groupChat = groupChatDao.listOfQuestion();
		groupChatList = groupChatDao.groupChatList();
		return "success";
	}
	
	public String submitAnswer() {
		HttpServletRequest httpServletRequest = ServletActionContext.getRequest();
		HttpSession session = httpServletRequest.getSession(true);
 		LoginInfo loginInfo = (LoginInfo)session.getAttribute("loginInfo");

		GroupQuestionAnswer groupQuestionAnswer = new GroupQuestionAnswer();
		groupQuestionAnswer.setQuestion_user_detail_name(loginInfo.getUserName());
		groupQuestionAnswer.setGroup_question(group_question);
		
		groupChatDao.saveGroupAnswer(groupQuestionAnswer);
		return "success";
	}
}
