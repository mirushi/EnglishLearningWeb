package com.comittedpeople.englishlearningweb.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class DocGrammarForm {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	
	@ManyToOne
	@JoinColumn(name = "docgrammar")
	private DocGrammar docGrammar;
	
	//Một nhiều đến các Example.
	@OneToMany(mappedBy = "docgrammarform", cascade = CascadeType.ALL)
	private Set<DocGrammarExample> examples;
	
	//Một nhiêu đến các Note.
	@OneToMany(mappedBy = "docgrammarform", cascade = CascadeType.ALL)
	private Set<DocGrammarNote> notes;
}
