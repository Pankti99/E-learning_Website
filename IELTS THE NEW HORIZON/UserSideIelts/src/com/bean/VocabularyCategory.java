package com.bean;

public class VocabularyCategory {
	int vocabulary_category_id,display_vocabulary_category_id;
	String vocabulary_category_name;

	
	public int getDisplay_vocabulary_category_id() {
		return display_vocabulary_category_id;
	}

	public void setDisplay_vocabulary_category_id(int display_vocabulary_category_id) {
		this.display_vocabulary_category_id = display_vocabulary_category_id;
	}

	public int getVocabulary_category_id() {
		return vocabulary_category_id;
	}

	public void setVocabulary_category_id(int vocabulary_category_id) {
		this.vocabulary_category_id = vocabulary_category_id;
	}

	public String getVocabulary_category_name() {
		return vocabulary_category_name;
	}

	public void setVocabulary_category_name(String vocabulary_category_name) {
		this.vocabulary_category_name = vocabulary_category_name;
	}

}
