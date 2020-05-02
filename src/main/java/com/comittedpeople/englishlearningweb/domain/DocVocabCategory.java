package com.comittedpeople.englishlearningweb.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class DocVocabCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	
	@Lob
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "parentCategory")
	private DocVocabCategory parentCategory;
	
	@OneToMany(mappedBy = "parentCategory", cascade = CascadeType.ALL)
	private Set<DocVocabCategory> subCategories;
	
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private Set<DocVocabContent> vocabs;
	
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<DocVocabLesson> vocabLessons;
	
	public DocVocabCategory() {
		
	}
	
	public DocVocabCategory(Long ID) {
		id = ID;
	}
	
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

	public DocVocabCategory getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(DocVocabCategory parentCategory) {
		this.parentCategory = parentCategory;
	}

	public Set<DocVocabCategory> getSubCategories() {
		return subCategories;
	}

	public void setSubCategories(Set<DocVocabCategory> subCategories) {
		this.subCategories = subCategories;
	}

	public Set<DocVocabContent> getVocabs() {
		return vocabs;
	}

	public void setVocabs(Set<DocVocabContent> vocabs) {
		this.vocabs = vocabs;
	}
}
