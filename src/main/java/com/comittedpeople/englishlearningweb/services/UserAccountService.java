package com.comittedpeople.englishlearningweb.services;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.comittedpeople.englishlearningweb.domain.AccountAuthority;
import com.comittedpeople.englishlearningweb.domain.UserAccount;
import com.comittedpeople.englishlearningweb.payload.RegisterRequestDTO;
import com.comittedpeople.englishlearningweb.repositories.AccountAuthorityRepository;
import com.comittedpeople.englishlearningweb.repositories.UserAccountRepository;

@Service
public class UserAccountService {

	@Autowired
	UserAccountRepository userAccountRepository;
	
	@Autowired
	AccountAuthorityRepository accountAuthorityRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	public UserAccountService(UserAccountRepository userAccountRepository) {
		super();
		this.userAccountRepository = userAccountRepository;
	}

	public UserAccount createUserAccount(RegisterRequestDTO registerRequest) {
		//Tạo mới tài khoản.
		AccountAuthority user = accountAuthorityRepository.findByName("ROLE_USER");
		return createAccount(registerRequest, new HashSet<AccountAuthority>(Arrays.asList(user)));
	}
	
	public UserAccount createAdminAccount(RegisterRequestDTO registerRequest) {
		AccountAuthority user = accountAuthorityRepository.findByName("ROLE_USER");
		AccountAuthority admin = accountAuthorityRepository.findByName("ROLE_ADMIN");
		
		return createAccount(registerRequest, new HashSet<AccountAuthority>(Arrays.asList(user,admin)));
	}
	
	private UserAccount createAccount(RegisterRequestDTO registerRequest, Set<AccountAuthority> authorities) {
		String username = registerRequest.getUsername();
		String password = registerRequest.getPassword();
		String email = registerRequest.getEmail();
		String displayname = registerRequest.getDisplayname();
		
		UserAccount account = userAccountRepository.findByUsernameOrEmail(username, email);
		
		//Tài khoản khác null tức là đã tồn tại tài khoản trong hệ thống.
		//Vì vậy không có tài khoản mới nào được tạo. Trực tiếp trả về null.
		if (account != null) 
			return null;
		
		account = new UserAccount();
		account.setUsername(username);
		account.setPassword(passwordEncoder.encode(password));
		account.setEmail(email);
		account.setDisplayname(displayname);
		account.setAuthorities(authorities);
		account.setEnabled(true);
		
		account = userAccountRepository.save(account);
		
		//Cập nhật hai chiều cho cả authority luôn.
		for (AccountAuthority auth : authorities) {
			auth.getUsers().add(account);
		}
		
		return account;
	}
	
}
