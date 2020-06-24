package com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.bean.LoginInfo;
import com.common.MailDetail;
import com.common.MailSend;
import com.dao.LoginDao;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	
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
	
	String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	MailSend mailSend = new MailSend();

	public String loginAsUser() {
		
		HttpServletRequest httpServletRequest = ServletActionContext.getRequest();
		HttpSession session = httpServletRequest.getSession(true);

		LoginInfo loginInfo = loginDao.loginAsUser(userName, password);
		if (null != loginInfo) {
			session.setAttribute("loginInfo", loginInfo);
			return "success";
		} else {
			message = "Enter Username And Password does not match.";
			return "Error";
		}

	}
	
	public String logout() {
		HttpServletRequest httpServletRequest = ServletActionContext.getRequest();
		HttpSession session = httpServletRequest.getSession(true);
		session.setAttribute("loginInfo", null);
		
		return "success";
	}
	
	public String ForgotPassword() {
		LoginInfo loginInfo  = loginDao.ForgotPassword(userName);
		System.out.println("username::"+ userName );
	
		if(null != loginInfo) {
			String bodyContent = "User Name : " + userName + "\n" ;
			bodyContent += "Password : " + loginInfo.getPassword();
      		mailSend.send(MailDetail.fromMail, MailDetail.fromPassword, userName, "Forgot Password", bodyContent);

			message = "* Password send to your E-mail. Please check your mailbox.";
		} else {
			message = "* Username does not exists.";
		}
		return "success";
	}
	public String ForgotUsername() {
		LoginInfo loginInfo  = loginDao.ForgotUsername(userName);
		if(null != loginInfo) {

			String bodyContent = "User Name : " + loginInfo.getContact() + "\n" ;
			bodyContent += "Password : " + loginInfo.getPassword();
			mailSend.send(MailDetail.fromMail, MailDetail.fromPassword, userName, "Forgot User Name", bodyContent);

			message = "* Username send to your E-mail. Please check your mailbox.";
		} else {
			message = "* User Contact number does not exists.";
		}
		
		return "success";
	}

	public String Materialwriting() {
		
		return "success";
	}
	
	public String MaterialReading() {
		
		return "success";
	}
	
	public String MaterialListening() {
		
		return "success";
	}
	
	public String MaterialSpeaking() {
		
		return "success";
	}
	
}
