package com.comittedpeople.englishlearningweb.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Protected_ReminderProgram {
	
	@Id
	private Long id;
	
	private String name;
	
}
