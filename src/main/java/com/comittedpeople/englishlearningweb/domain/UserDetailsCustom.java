package com.comittedpeople.englishlearningweb.domain;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsCustom implements UserDetails{

	UserAccount useraccount;
	
	public UserDetailsCustom (UserAccount useraccount) {
		this.useraccount = useraccount;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		//Trước mắt thì để là ROLE_USER trước.
		return Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return useraccount.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return useraccount.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public UserAccount getUseraccount() {
		return useraccount;
	}

	public void setUseraccount(UserAccount useraccount) {
		this.useraccount = useraccount;
	}
}
