package com.action;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.bean.LoginInfo;
import com.bean.UserDetail;
import com.bean.VocabularyCategory;
import com.bean.VocabularyMaterial;
import com.bean.VocabularyTest;
import com.dao.VocabularyDao;

public class VocabularyAction {

	VocabularyDao vocabularyDao = new VocabularyDao();
	List<VocabularyMaterial> vocabularyMaterialsList = new ArrayList<VocabularyMaterial>();
	List<UserDetail> userDetailsList = new ArrayList<UserDetail>();
	List<VocabularyCategory> vocabularyCategory = new ArrayList<VocabularyCategory>();
	List<VocabularyTest> tests = new ArrayList<VocabularyTest>();
	
	
	public List<VocabularyTest> getTests() {
		return tests;
	}

	public void setTests(List<VocabularyTest> tests) {
		this.tests = tests;
	}

	public List<VocabularyMaterial> getVocabularyMaterialsList() {
		return vocabularyMaterialsList;
	}

	public void setVocabularyMaterialsList(List<VocabularyMaterial> vocabularyMaterialsList) {
		this.vocabularyMaterialsList = vocabularyMaterialsList;
	}

	public List<UserDetail> getUserDetailsList() {
		return userDetailsList;
	}

	public void setUserDetailsList(List<UserDetail> userDetailsList) {
		this.userDetailsList = userDetailsList;
	}

	public List<VocabularyCategory> getVocabularyCategory() {
		return vocabularyCategory;
	}

	public void setVocabularyCategory(List<VocabularyCategory> vocabularyCategory) {
		this.vocabularyCategory = vocabularyCategory;
	}

	public String showVocabulary() {

		return "success";
	}

	public String showVocabularyList() {
		vocabularyMaterialsList = vocabularyDao.listVocabulary();
		return "success";
	}

	public String showExamQuestion() {
		Set<Integer> set = new HashSet<Integer>();
		int ran = 0;
		for (int j = 0; j < 5; j++) {
			ran = (int) (Math.random() * 10);
			if(ran > 0) {
				set.add(ran);
			}
		}
		String str = "";
		for (Integer integer : set) {
			str += ""+ integer + ",";
		}
		
		int rem = 5 - set.size();
		int temp = 0;
		ran = 0;
		int i = 0;
		while(i < 5) {
			if(temp == rem) {
				break;
			} else {
				ran = (int) (Math.random() * 10);
				if(ran > 0) {
					set.add(ran);
					temp++;
					i++;
				}
			}
		}

		
		
		int exam_id[] = new int[5];
		int x=0;
		for (Integer j : set) {
			exam_id[x] = j;
			x++;
		}
		
		
		tests = vocabularyDao.showExamQuestion(exam_id);
		
		
		return "success";
	}
	int totalMarks;
	
	public int getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}

	public String submitResult() {
		HttpServletRequest httpServletRequest = ServletActionContext.getRequest();
		HttpSession session = httpServletRequest.getSession(true);
		LoginInfo info = (LoginInfo) session.getAttribute("loginInfo");

		vocabularyDao.submitResult(totalMarks, info.getUserDetailId());
		return "success";
	}
}
