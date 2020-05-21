package com.comittedpeople.englishlearningweb.services;

import com.comittedpeople.englishlearningweb.api.v1.model.UserAccountDTO;
import com.comittedpeople.englishlearningweb.api.v1.model.UserReminderDTO;
import com.comittedpeople.englishlearningweb.domain.UserAccount;
import com.comittedpeople.englishlearningweb.payload.RegisterRequestDTO;

public interface UserAccountService {

	UserAccount createUserAccount(RegisterRequestDTO registerRequest);

	UserAccount createAdminAccount(RegisterRequestDTO registerRequest);
	
	UserAccountDTO getUserByID (Long userID);
	
	UserAccountDTO patchUserByID (Long userID, UserAccountDTO userAccount);
	
	UserAccountDTO putUserReminder (Long userID, UserReminderDTO reminder);

}