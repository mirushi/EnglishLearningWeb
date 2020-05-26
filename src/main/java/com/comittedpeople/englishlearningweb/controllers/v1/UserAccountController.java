package com.comittedpeople.englishlearningweb.controllers.v1;

import static org.hamcrest.CoreMatchers.instanceOf;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.comittedpeople.englishlearningweb.api.v1.model.UserAccountDTO;
import com.comittedpeople.englishlearningweb.api.v1.model.UserReminderDTO;
import com.comittedpeople.englishlearningweb.domain.UserDetailsCustom;
import com.comittedpeople.englishlearningweb.services.UserAccountService;

@Controller
@RequestMapping("/api/v1/users")
public class UserAccountController {

	@Autowired
	private UserAccountService userAccountService;

	@GetMapping("{userID}")
	public ResponseEntity<UserAccountDTO> getUserAccount(@PathVariable Long userID) {
		UserAccountDTO returnDTO = userAccountService.getUserByID(userID);
		if (returnDTO == null)
			return new ResponseEntity<UserAccountDTO>(returnDTO, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<UserAccountDTO>(returnDTO, HttpStatus.OK);

	}

	@GetMapping("{userID}/reminders")
	public ResponseEntity<UserReminderDTO> getUserReminders(@PathVariable Long userID) {
		Long currentUserID = getCurrentUserID();
		
		//Nếu thông tin reminder mà user yêu cầu là của người khác, không cho xem.
		if (currentUserID != userID) {
			return new ResponseEntity<UserReminderDTO>(new UserReminderDTO(), HttpStatus.FORBIDDEN);
		}
		
		UserAccountDTO userDTO = userAccountService.getUserByID(userID);
		if (userDTO == null)
			return new ResponseEntity<UserReminderDTO>(new UserReminderDTO(), HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<UserReminderDTO>(new UserReminderDTO(userDTO.getReminder()), HttpStatus.OK);
	}

	@PutMapping("{userID}/reminders")
	public ResponseEntity<UserReminderDTO> putUserReminders(@PathVariable Long userID,
			@Valid @RequestBody UserReminderDTO reminderDays) {

		System.out.println("Reminder days : " + reminderDays.toString());

		UserAccountDTO userDTO = userAccountService.putUserReminder(userID, reminderDays);
		if (userDTO == null)
			return new ResponseEntity<UserReminderDTO>(new UserReminderDTO(), HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<UserReminderDTO>(new UserReminderDTO(userDTO.getReminder()), HttpStatus.OK);
	}

	@PatchMapping("{userID}")
	public ResponseEntity<UserAccountDTO> patchUserAccount(@PathVariable Long userID,
			@Valid @RequestBody UserAccountDTO accountDTO) {

		UserAccountDTO returnDTO = userAccountService.patchUserByID(userID, accountDTO);

		if (returnDTO == null)
			return new ResponseEntity<UserAccountDTO>(returnDTO, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<UserAccountDTO>(returnDTO, HttpStatus.OK);
	}

	private String getCurrentUsername() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		// Kiểm tra xem principle hiện tại có đúng dạng chưa.
		if (principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		} else {
			return principal.toString();
		}
	}

	private Long getCurrentUserID() {
		Object principle = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		// Kiểm tra xem principle hiện tại có đúng dạng chưa.
		if (principle instanceof UserDetailsCustom) {
			return ((UserDetailsCustom) principle).getUseraccount().getId();
		} else {
			return -1L;
		}
	}
}
