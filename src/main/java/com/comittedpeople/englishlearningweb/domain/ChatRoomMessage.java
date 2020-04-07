package com.comittedpeople.englishlearningweb.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class ChatRoomMessage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//Một Message chỉ đc gửi bởi 1 người. Một người có thể gửi nhiều Message.
	@ManyToOne
	@JoinColumn(name = "userSent")
	private UserAccount userSentAccount;
	
	@Lob
	private String chatContent;
	
	private LocalDateTime messageSentDate;
}
