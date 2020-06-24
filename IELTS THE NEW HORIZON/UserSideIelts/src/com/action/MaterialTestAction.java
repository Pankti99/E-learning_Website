package com.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.bean.LoginInfo;
import com.bean.WrittingPessage;
import com.bean.WrittingPessageAnswer;
import com.dao.MaterialTestDao;

public class MaterialTestAction {
	int writting_pessage_id, id;
	String writting_pessage_name, writtingPessageAns;

	MaterialTestDao materialTestDao = new MaterialTestDao();

	List<WrittingPessage> list = new ArrayList<WrittingPessage>();

	public String getWrittingPessageAns() {
		return writtingPessageAns;
	}

	public void setWrittingPessageAns(String writtingPessageAns) {
		this.writtingPessageAns = writtingPessageAns;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getWritting_pessage_id() {
		return writting_pessage_id;
	}

	public void setWritting_pessage_id(int writting_pessage_id) {
		this.writting_pessage_id = writting_pessage_id;
	}

	public String getWritting_pessage_name() {
		return writting_pessage_name;
	}

	public void setWritting_pessage_name(String writting_pessage_name) {
		this.writting_pessage_name = writting_pessage_name;
	}

	public List<WrittingPessage> getList() {
		return list;
	}

	public void setList(List<WrittingPessage> list) {
		this.list = list;
	}

	public String showWrittingList() {
		System.out.println("isMock : "+isMock);
		HttpServletRequest httpServletRequest = ServletActionContext.getRequest();
		HttpSession session = httpServletRequest.getSession(true);

		session.setAttribute("isMock", isMock);
		
		list = materialTestDao.listWrittingPessage();
		return "success";
	}

	String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String showWrittingListMock() {
		System.out.println("isMock : "+isMock);
		HttpServletRequest httpServletRequest = ServletActionContext.getRequest();
		HttpSession session = httpServletRequest.getSession(true);

		LoginInfo info = (LoginInfo)session.getAttribute("loginInfo");

		session.setAttribute("isMock", isMock);
//		int userAttendTest = materialTestDao.userAttendTest(info.getUser_detail_id());
		//1-Mock Attend 2- Not Attend
		

		list = materialTestDao.listWrittingPessageMock(info.getUser_detail_id());
		if(list.size() == 0) {
			message = "You already attend the Mock Test Today.";
		}
		return "success";
	}

	Integer isMock;
	
	public Integer getIsMock() {
		return isMock;
	}

	public void setIsMock(Integer isMock) {
		this.isMock = isMock;
	}

	String msg;
	
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String showWrittingPessage() {
			HttpServletRequest httpServletRequest = ServletActionContext.getRequest();
			HttpSession session = httpServletRequest.getSession(true);
			LoginInfo info = (LoginInfo)session.getAttribute("loginInfo");

			int userAttendTest = 2;
			//1-Mock Attend 2- Not Attend
			
			if(session.getAttribute("isMock").toString().equalsIgnoreCase("1")) {
				userAttendTest = materialTestDao.userAttendTest(info.getUser_detail_id());
			}
				writting_pessage_id = id;
				writting_pessage_name = materialTestDao.getWrittingPessageName(id);

			
			return "success";
	}

	public String saveWirttingPessageAns() {
		HttpServletRequest httpServletRequest = ServletActionContext.getRequest();
		HttpSession session = httpServletRequest.getSession(true);
		LoginInfo info = (LoginInfo) session.getAttribute("loginInfo");

		WrittingPessageAnswer pessageAnswer = new WrittingPessageAnswer();
		
		System.out.println("User Id : "+info.getUserDetailId());
		pessageAnswer.setUser_detail_id(info.getUserDetailId());
		pessageAnswer.setWritting_pessage_answer(writtingPessageAns);
		pessageAnswer.setWritting_pessage_band(0.0);
		pessageAnswer.setIsMock(Integer.parseInt(session.getAttribute("isMock").toString()));
		pessageAnswer.setWritting_pessage_id(writting_pessage_id);
	    materialTestDao.saveWrittingPessageAns(pessageAnswer);
		return "success";
	}
}
