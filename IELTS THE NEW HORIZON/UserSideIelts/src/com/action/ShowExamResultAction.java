package com.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.bean.LoginInfo;
import com.bean.VocabularyResult;
import com.bean.WrittingPessageAnswer;
import com.dao.ShowExamResultDao;

public class ShowExamResultAction {

	List<VocabularyResult> vocabularyResults = new ArrayList<VocabularyResult>();
	List<WrittingPessageAnswer> writtingPessageAnswer = new ArrayList<WrittingPessageAnswer>();

	public List<WrittingPessageAnswer> getWrittingPessageAnswer() {
		return writtingPessageAnswer;
	}

	public void setWrittingPessageAnswer(List<WrittingPessageAnswer> writtingPessageAnswer) {
		this.writtingPessageAnswer = writtingPessageAnswer;
	}

	public List<VocabularyResult> getVocabularyResults() {
		return vocabularyResults;
	}

	public void setVocabularyResults(List<VocabularyResult> vocabularyResults) {
		this.vocabularyResults = vocabularyResults;
	}

	ShowExamResultDao showExamResultDao = new ShowExamResultDao();

	public String showVocabularyResult() {
		HttpServletRequest httpServletRequest = ServletActionContext.getRequest();
		HttpSession session = httpServletRequest.getSession(true);
		LoginInfo info = (LoginInfo) session.getAttribute("loginInfo");

		vocabularyResults = showExamResultDao.getVocabularyList(info.getUserDetailId());
		return "success";
	}

	public String getWrittingPessageList() {
		HttpServletRequest httpServletRequest = ServletActionContext.getRequest();
		HttpSession session = httpServletRequest.getSession(true);
		LoginInfo info = (LoginInfo) session.getAttribute("loginInfo");

		writtingPessageAnswer = showExamResultDao.getWrittingPessageList(info.getUserDetailId());
		return "success";
	}

}
