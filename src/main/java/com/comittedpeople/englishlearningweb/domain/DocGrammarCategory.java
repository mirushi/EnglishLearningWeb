package com.comittedpeople.englishlearningweb.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class DocGrammarCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	
	@Lob
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "parentCategory")
	@JsonBackReference
	private DocGrammarCategory parentCategory;
	
	@OneToMany(mappedBy = "parentCategory", cascade = CascadeType.ALL)
	@JsonManagedReference
	private Set<DocGrammarCategory> subCategories;
	
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	@JsonManagedReference
	private Set<DocGrammar> grammars;

	public Long getId() {
		return id;
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

	public DocGrammarCategory getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(DocGrammarCategory parentCategory) {
		this.parentCategory = parentCategory;
	}

	public Set<DocGrammarCategory> getSubCategories() {
		return subCategories;
	}

	public void setSubCategories(Set<DocGrammarCategory> subCategories) {
		this.subCategories = subCategories;
	}

	public Set<DocGrammar> getGrammars() {
		return grammars;
	}

	public void setGrammars(Set<DocGrammar> grammars) {
		this.grammars = grammars;
	}
}
