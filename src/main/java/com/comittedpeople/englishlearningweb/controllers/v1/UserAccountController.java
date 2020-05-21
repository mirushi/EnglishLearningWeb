package com.comittedpeople.englishlearningweb.controllers.v1;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.comittedpeople.englishlearningweb.api.v1.model.UserAccountDTO;
import com.comittedpeople.englishlearningweb.services.UserAccountService;

@Controller
@RequestMapping("/api/v1/users")
public class UserAccountController {
	
	@Autowired
	private UserAccountService userAccountService;
	
	@GetMapping("{userID}")
	public ResponseEntity<UserAccountDTO> getUserAccount (@PathVariable Long userID){
		UserAccountDTO returnDTO = userAccountService.getUserByID(userID);
		if (returnDTO == null)
			return new ResponseEntity<UserAccountDTO>(returnDTO, HttpStatus.NOT_FOUND);
		else 
			return new ResponseEntity<UserAccountDTO>(returnDTO, HttpStatus.OK);
		
	}
	
	@PatchMapping("{userID}")
	public ResponseEntity<UserAccountDTO> patchUserAccount(@PathVariable Long userID, 
			@Valid @RequestBody UserAccountDTO accountDTO){
		
		UserAccountDTO returnDTO = userAccountService.patchUserByID(userID, accountDTO);
		
		if (returnDTO == null)
			return new ResponseEntity<UserAccountDTO>(returnDTO, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<UserAccountDTO>(returnDTO, HttpStatus.OK);
	}
	
}
