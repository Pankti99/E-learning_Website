package com.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.bean.ListeningTest;
import com.bean.LoginInfo;
import com.bean.ParagraphTest;
import com.bean.ReadingPessageExam;
import com.bean.ReadingPessageExamResult;
import com.bean.ReadingPesssage;
import com.dao.ReadingPessageDao;

public class ReadingPessageAction {
	int paragraph_test_id, id, user_detail_id, reading_pessage_id, totalMarks;
	String paragraph_test_name, reading_pessage, paragraph_test_que, paragraph_test_ans, message;

	ReadingPessageDao readingPessageDao = new ReadingPessageDao();
	
	List<ParagraphTest> paragraphTestsList = new ArrayList<ParagraphTest>();
	List<ReadingPesssage> readingPesssagesList = new ArrayList<ReadingPesssage>();
	List<ReadingPessageExam> readingPessageExamsList = new ArrayList<ReadingPessageExam>();
	List<ReadingPessageExamResult> readingPessageExamsResultList = new ArrayList<ReadingPessageExamResult>();

	
	public List<ReadingPessageExamResult> getReadingPessageExamsResultList() {
		return readingPessageExamsResultList;
	}

	public void setReadingPessageExamsResultList(List<ReadingPessageExamResult> readingPessageExamsResultList) {
		this.readingPessageExamsResultList = readingPessageExamsResultList;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}

	public String getParagraph_test_que() {
		return paragraph_test_que;
	}

	public void setParagraph_test_que(String paragraph_test_que) {
		this.paragraph_test_que = paragraph_test_que;
	}

	public String getParagraph_test_ans() {
		return paragraph_test_ans;
	}

	public void setParagraph_test_ans(String paragraph_test_ans) {
		this.paragraph_test_ans = paragraph_test_ans;
	}

	public List<ReadingPessageExam> getReadingPessageExamsList() {
		return readingPessageExamsList;
	}

	public void setReadingPessageExamsList(List<ReadingPessageExam> readingPessageExamsList) {
		this.readingPessageExamsList = readingPessageExamsList;
	}

	public List<ReadingPesssage> getReadingPesssagesList() {
		return readingPesssagesList;
	}

	public void setReadingPesssagesList(List<ReadingPesssage> readingPesssagesList) {
		this.readingPesssagesList = readingPesssagesList;
	}

	public int getReading_pessage_id() {
		return reading_pessage_id;
	}

	public void setReading_pessage_id(int reading_pessage_id) {
		this.reading_pessage_id = reading_pessage_id;
	}

	public String getReading_pessage() {
		return reading_pessage;
	}

	public void setReading_pessage(String reading_pessage) {
		this.reading_pessage = reading_pessage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<ParagraphTest> getParagraphTestsList() {
		return paragraphTestsList;
	}

	public void setParagraphTestsList(List<ParagraphTest> paragraphTestsList) {
		this.paragraphTestsList = paragraphTestsList;
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

	public String getParagraph_test_name() {
		return paragraph_test_name;
	}

	public void setParagraph_test_name(String paragraph_test_name) {
		this.paragraph_test_name = paragraph_test_name;
	}

	

	public String readingPessageExam() {
		HttpServletRequest httpServletRequest = ServletActionContext.getRequest();
		HttpSession session = httpServletRequest.getSession(true);
		LoginInfo info = (LoginInfo)session.getAttribute("loginInfo");

		session.setAttribute("isMock", isMock);

		paragraphTestsList = readingPessageDao.listParagraphTest(isMock, info.getUser_detail_id());	
		
		readingPessageExamsList = readingPessageDao.listReadingPessageExam(paragraph_test_id);
		
		return "success";
	}

	public String showReadingPessageName() {
		System.out.println("Reading isMock : "+isMock);
		HttpServletRequest httpServletRequest = ServletActionContext.getRequest();
		HttpSession session = httpServletRequest.getSession(true);
		LoginInfo info = (LoginInfo)session.getAttribute("loginInfo");

		session.setAttribute("isMock", isMock);

		paragraphTestsList = readingPessageDao.listParagraphTest(isMock, info.getUser_detail_id());
		return "success";
	}

	Integer isMock;

	
	public Integer getIsMock() {
		return isMock;
	}

	public void setIsMock(Integer isMock) {
		this.isMock = isMock;
	}

	public String showReadingPessageNameMock() {
		System.out.println("Reading isMock : "+isMock);
		HttpServletRequest httpServletRequest = ServletActionContext.getRequest();
		HttpSession session = httpServletRequest.getSession(true);
		LoginInfo info = (LoginInfo)session.getAttribute("loginInfo");

		session.setAttribute("isMock", isMock);
		
		paragraphTestsList = readingPessageDao.listParagraphTest(isMock, info.getUser_detail_id());
		
		if(paragraphTestsList.size() == 0) {
			message = "You already attend the Mock Test Today.";
		}

		return "success";
	}

	public String showReadingPessageQuestion() {
		readingPesssagesList = readingPessageDao.showReadingPessageQuestion(paragraph_test_id);		
		readingPessageExamsList = readingPessageDao.listReadingPessageExam(paragraph_test_id);
		if(readingPesssagesList.size()>0) {
			paragraph_test_name = readingPesssagesList.get(0).getParagraph_test_name();
			paragraph_test_id = readingPesssagesList.get(0).getParagraph_test_id();
		}
			return "success";
	}

	public String saveReadingExamResult() {
		HttpServletRequest httpServletRequest = ServletActionContext.getRequest();
		HttpSession session = httpServletRequest.getSession(true);
		LoginInfo info = (LoginInfo)session.getAttribute("loginInfo");

		ReadingPessageExamResult pessageExamResult = new ReadingPessageExamResult();
		pessageExamResult.setIs_deleted(0);
		pessageExamResult.setParagraph_test_id(paragraph_test_id);
		pessageExamResult.setReading_pessage_score(totalMarks);
		pessageExamResult.setUser_detail_id(info.getUser_detail_id());
		pessageExamResult.setIsMock(Integer.parseInt(session.getAttribute("isMock").toString()));
		readingPessageDao.saveReadingPessageExamResult(pessageExamResult);
		
		message = "Reading Pessage Exam complete successfully.";
		return "success";
	}
	
	public String getReadingPessageResult() {
		HttpServletRequest httpServletRequest = ServletActionContext.getRequest();
		HttpSession session = httpServletRequest.getSession(true);
		LoginInfo info = (LoginInfo)session.getAttribute("loginInfo");
		readingPessageExamsResultList = readingPessageDao.listReadingPessageExamResult(info.getUser_detail_id());
		return "success";
	}
	
	public String showSpeakingResultList() {
		HttpServletRequest httpServletRequest = ServletActionContext.getRequest();
		HttpSession session = httpServletRequest.getSession(true);
		LoginInfo info = (LoginInfo)session.getAttribute("loginInfo");
		readingPessageExamsResultList = readingPessageDao.showSpeakingResultList(info.getUser_detail_id());
		return "success";
	}
	
	public String examCompleted() {
		
		return "success";
	}
	
}
