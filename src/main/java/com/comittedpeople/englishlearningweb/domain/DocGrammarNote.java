package com.comittedpeople.englishlearningweb.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class DocGrammarNote {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Lob
	private String content;
	
	@ManyToOne
	@JoinColumn(name = "docGrammarForm")
	private DocGrammarForm docGrammarForm;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public DocGrammarForm getDocGrammarForm() {
		return docGrammarForm;
	}

	public void setDocGrammarForm(DocGrammarForm docGrammarForm) {
		this.docGrammarForm = docGrammarForm;
	}
}
