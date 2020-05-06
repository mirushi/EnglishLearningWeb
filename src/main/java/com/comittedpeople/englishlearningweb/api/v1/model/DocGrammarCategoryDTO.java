package com.comittedpeople.englishlearningweb.api.v1.model;

import java.util.List;

public class DocGrammarCategoryDTO {

	private Long id;
	private String title;
	private String description;
	
	private Long parentId;
		
	private List<DocGrammarCategoryDTO> childCategories;
	
	public Long getId() {
		return id;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentID) {
		this.parentId = parentID;
	}
	public List<DocGrammarCategoryDTO> getChildCategories() {
		return childCategories;
	}
	public void setChildCategories(List<DocGrammarCategoryDTO> childCategories) {
		this.childCategories = childCategories;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
