package com.comittedpeople.englishlearningweb.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class DocGrammarExample {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Lob
	private String content;
	
	@ManyToOne
	@JoinColumn(name = "docGrammarForm")
	private DocGrammarForm docGrammarForm;
}
