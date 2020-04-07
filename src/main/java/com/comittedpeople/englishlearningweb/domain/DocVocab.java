package com.comittedpeople.englishlearningweb.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class DocVocab {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String content;
	
	private String spelling;
	
	@Lob
	private String spellingAudioURL;
	
	@Lob
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "category")
	private DocVocabCategory category;
	
}
