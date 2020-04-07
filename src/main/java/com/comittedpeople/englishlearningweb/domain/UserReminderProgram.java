package com.comittedpeople.englishlearningweb.domain;

import javax.persistence.Id;

public class UserReminderProgram {
	@Id
	private UserAccount user;
	
	@Id
	private Protected_ReminderProgram reminderProgram;
}
