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
	@OneToMany(mappedBy = "docGrammarForm", cascade = CascadeType.ALL)
	private Set<DocGrammarExample> examples;
	
	//Một nhiêu đến các Note.
	@OneToMany(mappedBy = "docGrammarForm", cascade = CascadeType.ALL)
	private Set<DocGrammarNote> notes;

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

	public DocGrammar getDocGrammar() {
		return docGrammar;
	}

	public void setDocGrammar(DocGrammar docGrammar) {
		this.docGrammar = docGrammar;
	}

	public Set<DocGrammarExample> getExamples() {
		return examples;
	}

	public void setExamples(Set<DocGrammarExample> examples) {
		this.examples = examples;
	}

	public Set<DocGrammarNote> getNotes() {
		return notes;
	}

	public void setNotes(Set<DocGrammarNote> notes) {
		this.notes = notes;
	}
}
