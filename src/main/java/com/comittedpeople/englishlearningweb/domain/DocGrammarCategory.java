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
	private DocGrammarCategory parentCategory;
	
	@OneToMany(mappedBy = "parentCategory", cascade = CascadeType.ALL)
	private Set<DocGrammarCategory> subCategories;
	
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private Set<DocGrammar> grammars;
	
}
