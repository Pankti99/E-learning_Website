package com.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.*;
import org.apache.struts2.ServletActionContext;

import com.bean.ListeningPessageExam;
import com.bean.ListeningTest;
import com.bean.LoginInfo;
import com.bean.MockTestResult;
import com.bean.ReadingPessageExamResult;
import com.bean.SpeakingBookSlot;
import com.common.ConvertDateTime;
import com.common.MailDetail;
import com.common.MailSend;
import com.dao.ListeningPessageDao;
import com.dao.LoginDao;


public class ListeningPessageAction {

	int paragraph_test_id, id, user_detail_id, listening_pessage_id, totalMarks, speaking_test_id;
	String paragraph_test_name, spekingDate;

	String userName, password;
    LoginDao loginDao = new LoginDao();
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	MailSend mailSend = new MailSend();
	
	
	public String getSpekingDate() {
		return spekingDate;
	}

	public void setSpekingDate(String spekingDate) {
		this.spekingDate = spekingDate;
	}

	List<ListeningPessageExam> listeningPessageExamList = new ArrayList<ListeningPessageExam>();
	List<ReadingPessageExamResult> readingPessageExamsResultList = new ArrayList<ReadingPessageExamResult>();
	List<MockTestResult> mockTestResultList = new ArrayList<MockTestResult>();
	
	
	public List<MockTestResult> getMockTestResultList() {
		return mockTestResultList;
	}

	public void setMockTestResultList(List<MockTestResult> mockTestResultList) {
		this.mockTestResultList = mockTestResultList;
	}

	ListeningPessageDao pessageDao = new ListeningPessageDao();
	List<ListeningTest> listeningTest = new ArrayList<ListeningTest>();
	
	
	public int getSpeaking_test_id() {
		return speaking_test_id;
	}

	public void setSpeaking_test_id(int speaking_test_id) {
		this.speaking_test_id = speaking_test_id;
	}

	public List<ListeningTest> getListeningTest() {
		return listeningTest;
	}

	public void setListeningTest(List<ListeningTest> listeningTest) {
		this.listeningTest = listeningTest;
	}

	public String getParagraph_test_name() {
		return paragraph_test_name;
	}

	public void setParagraph_test_name(String paragraph_test_name) {
		this.paragraph_test_name = paragraph_test_name;
	}

	public int getListening_pessage_id() {
		return listening_pessage_id;
	}

	public void setListening_pessage_id(int listening_pessage_id) {
		this.listening_pessage_id = listening_pessage_id;
	}

	public int getParagraph_test_id() {
		return paragraph_test_id;
	}

	public void setParagraph_test_id(int paragraph_test_id) {
		this.paragraph_test_id = paragraph_test_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_detail_id() {
		return user_detail_id;
	}

	public void setUser_detail_id(int user_detail_id) {
		this.user_detail_id = user_detail_id;
	}

	public int getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}

	public List<ListeningPessageExam> getListeningPessageExamList() {
		return listeningPessageExamList;
	}

	public void setListeningPessageExamList(List<ListeningPessageExam> listeningPessageExamList) {
		this.listeningPessageExamList = listeningPessageExamList;
	}

	public List<ReadingPessageExamResult> getReadingPessageExamsResultList() {
		return readingPessageExamsResultList;
	}

	public void setReadingPessageExamsResultList(List<ReadingPessageExamResult> readingPessageExamsResultList) {
		this.readingPessageExamsResultList = readingPessageExamsResultList;
	}

	public String showListeningQuestion() {
		listeningPessageExamList = pessageDao.showListeningPessageQuestion(paragraph_test_id);
		if(listeningPessageExamList.size()>0) {
			paragraph_test_name = listeningPessageExamList.get(0).getParagraph_test_name();
			paragraph_test_id = listeningPessageExamList.get(0).getParagraph_test_id();
		}

		return "success";
	}

	String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String saveListeningExamResult() {
		HttpServletRequest httpServletRequest = ServletActionContext.getRequest();
		HttpSession session = httpServletRequest.getSession(true);
		LoginInfo info = (LoginInfo)session.getAttribute("loginInfo");

		ReadingPessageExamResult pessageExamResult = new ReadingPessageExamResult();
		pessageExamResult.setIs_deleted(0);
		pessageExamResult.setParagraph_test_id(paragraph_test_id);
		pessageExamResult.setReading_pessage_score(totalMarks);
		pessageExamResult.setUser_detail_id(info.getUser_detail_id());
		pessageExamResult.setIsMock(Integer.parseInt(session.getAttribute("isMock").toString()));
		pessageDao.saveListeningPessageExamResult(pessageExamResult);
		
		message = "Listening Pessage Exam complete successfully.";
		return "success";
	}

	public String getReadingPessageResult() {
		HttpServletRequest httpServletRequest = ServletActionContext.getRequest();
		HttpSession session = httpServletRequest.getSession(true);
		LoginInfo info = (LoginInfo)session.getAttribute("loginInfo");
		readingPessageExamsResultList = pessageDao.listListeningPessageExamResult(info.getUser_detail_id());
		return "success";
	}
	
	public String showSpeakingResultList() {
		
		return "success";
	}
	public String showSpeakingTest() {
		System.out.println("Speaking isMock : "+isMock);
		HttpServletRequest httpServletRequest = ServletActionContext.getRequest();
		HttpSession session = httpServletRequest.getSession(true);

		session.setAttribute("isMock", isMock);
		listeningTest = pessageDao.listSpeakingTest();
		return "success";
	}
	
	public String showSpeakingTestMock() {
		System.out.println("Speaking isMock : "+isMock);
		HttpServletRequest httpServletRequest = ServletActionContext.getRequest();
		HttpSession session = httpServletRequest.getSession(true);

		session.setAttribute("isMock", isMock);
		listeningTest = pessageDao.listSpeakingTest();
		return "message";
	}


	public String showListeningName() {
		System.out.println("Listening isMock : "+isMock);
		HttpServletRequest httpServletRequest = ServletActionContext.getRequest();
		HttpSession session = httpServletRequest.getSession(true);
		LoginInfo info = (LoginInfo)session.getAttribute("loginInfo");

		session.setAttribute("isMock", isMock);
		listeningTest = pessageDao.listListeningPessage(isMock,info.getUser_detail_id());
		return "success";
	}

	Integer isMock;

	
	public Integer getIsMock() {
		return isMock;
	}

	public void setIsMock(Integer isMock) {
		this.isMock = isMock;
	}

	public String showListeningNameMock() {
		System.out.println("Listening isMock : "+isMock);
		HttpServletRequest httpServletRequest = ServletActionContext.getRequest();
		HttpSession session = httpServletRequest.getSession(true);
		LoginInfo info = (LoginInfo)session.getAttribute("loginInfo");

		session.setAttribute("isMock", isMock);
		listeningTest = pessageDao.listListeningPessage(isMock,info.getUser_detail_id());
		if(listeningTest.size() == 0) {
			message = "You already attend the Mock Test Today.";
		}
	
		
		return "success";
	}

	public String bookSlotForSpeaking() {
		HttpServletRequest httpServletRequest = ServletActionContext.getRequest();
		HttpSession session = httpServletRequest.getSession(true);
		LoginInfo info = (LoginInfo)session.getAttribute("loginInfo");
		
		System.out.println("spekingDate : "+spekingDate);
		
		
		
		
	/*	Date td=new Date();
		SimpleDateFormat df=new SimpleDateFormat ("mm");
		System.out.println("timing:"+df.format(td));
		
		

	
		SimpleDateFormat df1=new SimpleDateFormat ("mm");
		System.out.println("timing booked is:"+df1.format(spekingDate));
			
		*/
		
		SpeakingBookSlot speakingBookSlot = new SpeakingBookSlot();
		speakingBookSlot.setSpeaking_test_id(speaking_test_id);
		speakingBookSlot.setUser_detail_id(info.getUser_detail_id());
		int facultyId = pessageDao.getFacultyId();

		speakingBookSlot.setSpeaking_date(ConvertDateTime.convertDateTime(spekingDate));
		speakingBookSlot.setFaculty_id(facultyId);
		speakingBookSlot.setIs_mock(Integer.parseInt(session.getAttribute("isMock").toString()));
		
		pessageDao.saveSpeakingBookSlot(speakingBookSlot);
	
		if(null != info) {
			String bodyContent = "Date and time for booked speaking slot is"+spekingDate +"by"+info.getUserName()+" kindly inform the faculty whoever available" ;
			String m="fpankti@gmail.com";
      		mailSend.send(MailDetail.fromMail, MailDetail.fromPassword, m, "Bookslot for Speaking", bodyContent);
			message = "Please check your mailbox.";
		} 
		
		return "success";
	}
	List<SpeakingBookSlot> bookSlots = new ArrayList<SpeakingBookSlot>();
	
	public List<SpeakingBookSlot> getBookSlots() {
		return bookSlots;
	}

	public void setBookSlots(List<SpeakingBookSlot> bookSlots) {
		this.bookSlots = bookSlots;
	}

	public String showSpeakingSlotList() {
		HttpServletRequest httpServletRequest = ServletActionContext.getRequest();
		HttpSession session = httpServletRequest.getSession(true);
		LoginInfo info = (LoginInfo)session.getAttribute("loginInfo");
		bookSlots = pessageDao.showSpeakingSlotList(info.getUser_detail_id());
		return "success";
	}

	public String showMockResultList() {
		System.out.println("Come In Action..............");
		HttpServletRequest httpServletRequest = ServletActionContext.getRequest();
		HttpSession session = httpServletRequest.getSession(true);
		LoginInfo info = (LoginInfo)session.getAttribute("loginInfo");
		mockTestResultList = pessageDao.showMockResultList(info.getUser_detail_id());
		 System.out.println("mockTestResultList:"+	mockTestResultList.size());
		
		return "success";
	}
	
	public String showChat() {
		
		return "success";
	}
}
