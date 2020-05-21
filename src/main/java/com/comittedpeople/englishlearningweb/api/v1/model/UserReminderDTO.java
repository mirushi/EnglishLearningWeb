package com.comittedpeople.englishlearningweb.api.v1.model;

public class UserReminderDTO {

	private Integer days;

	public UserReminderDTO () {
		this.days = -1;
	}
	
	public UserReminderDTO (Integer days) {
		this.days = days;
	}
	
	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}
}
