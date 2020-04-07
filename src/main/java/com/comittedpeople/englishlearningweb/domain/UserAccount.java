package com.comittedpeople.englishlearningweb.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class UserAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String userName;
	private String displayName;
	
	private String email;
	
	private String password;
	
	private Boolean enabled;
	
	@OneToMany(mappedBy = "userSentAccount")
	private Set<ChatRoomMessage> chatRoomMessages;
	
}
