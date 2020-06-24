package com.bean;

public class VocabularyMaterial {
	int display_vocabulary_material_id, vocabulary_material_id, user_detail_id, vocabulary_category_id;
	String vocabulary_material_word, vocabulary_material_meaning, vocabulary_material_description,
			vocabulary_material_example, user_detail_name, vocabulary_category_name;

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

	public int getDisplay_vocabulary_material_id() {
		return display_vocabulary_material_id;
	}

	public void setDisplay_vocabulary_material_id(int display_vocabulary_material_id) {
		this.display_vocabulary_material_id = display_vocabulary_material_id;
	}

	public String getUser_detail_name() {
		return user_detail_name;
	}

	public void setUser_detail_name(String user_detail_name) {
		this.user_detail_name = user_detail_name;
	}

	public int getVocabulary_material_id() {
		return vocabulary_material_id;
	}

	public void setVocabulary_material_id(int vocabulary_material_id) {
		this.vocabulary_material_id = vocabulary_material_id;
	}

	public int getUser_detail_id() {
		return user_detail_id;
	}

	public void setUser_detail_id(int user_detail_id) {
		this.user_detail_id = user_detail_id;
	}

	public String getVocabulary_material_word() {
		return vocabulary_material_word;
	}

	public void setVocabulary_material_word(String vocabulary_material_word) {
		this.vocabulary_material_word = vocabulary_material_word;
	}

	public String getVocabulary_material_meaning() {
		return vocabulary_material_meaning;
	}

	public void setVocabulary_material_meaning(String vocabulary_material_meaning) {
		this.vocabulary_material_meaning = vocabulary_material_meaning;
	}

	public String getVocabulary_material_description() {
		return vocabulary_material_description;
	}

	public void setVocabulary_material_description(String vocabulary_material_description) {
		this.vocabulary_material_description = vocabulary_material_description;
	}

	public String getVocabulary_material_example() {
		return vocabulary_material_example;
	}

	public void setVocabulary_material_example(String vocabulary_material_example) {
		this.vocabulary_material_example = vocabulary_material_example;
	}

}
