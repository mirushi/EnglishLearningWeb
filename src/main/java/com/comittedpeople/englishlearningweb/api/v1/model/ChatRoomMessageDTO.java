package com.comittedpeople.englishlearningweb.api.v1.model;

import java.time.LocalDateTime;

public class ChatRoomMessageDTO {

	private Long id;
	
	private String content;
	
	private LocalDateTime timeStamp;
	
	private Long userSentID;
	
	private Long userSentName;

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

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Long getUserSentID() {
		return userSentID;
	}

	public void setUserSentID(Long userSentID) {
		this.userSentID = userSentID;
	}

	public Long getUserSentName() {
		return userSentName;
	}

	public void setUserSentName(Long userSentName) {
		this.userSentName = userSentName;
	}
}
