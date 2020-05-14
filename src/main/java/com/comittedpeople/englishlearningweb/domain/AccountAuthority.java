package com.comittedpeople.englishlearningweb.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class AccountAuthority {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	Long id;
	
	@Column(unique = true)
	String name;
	
	@ManyToMany(mappedBy = "authorities")
	private Set<UserAccount> users = new HashSet<UserAccount>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<UserAccount> getUsers() {
		return users;
	}

	public void setUsers(Set<UserAccount> users) {
		this.users = users;
	}
	
}
