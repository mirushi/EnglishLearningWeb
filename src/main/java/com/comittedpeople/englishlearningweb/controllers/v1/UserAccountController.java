package com.comittedpeople.englishlearningweb.controllers.v1;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comittedpeople.englishlearningweb.domain.UserDetailsCustom;
import com.comittedpeople.englishlearningweb.jwt.JwtTokenProvider;
import com.comittedpeople.englishlearningweb.payload.LoginRequestDTO;
import com.comittedpeople.englishlearningweb.payload.LoginResponseDTO;

@RestController
@RequestMapping("/api/v1/auth")
public class UserAccountController {

	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenProvider tokenProvider;
	
	@PostMapping("/login")
	public LoginResponseDTO authenticateUser (@Valid @RequestBody LoginRequestDTO loginRequest) {
		
		//Xác thực username và password.
		Authentication authentication = authenticationManager.authenticate(
			new UsernamePasswordAuthenticationToken(
					loginRequest.getUsername(),
					loginRequest.getPassword()
			)
		);
		
		//Nếu không xảy ra exception tức là thông tin hợp lệ.
		//Set thông tin authentication vào Security Context.
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		//Trả về JWT cho người dùng.
		String jwt = tokenProvider.generateToken((UserDetailsCustom) authentication.getPrincipal());
		
		return new LoginResponseDTO(jwt);
	}
	
}
