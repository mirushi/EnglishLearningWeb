package com.comittedpeople.englishlearningweb.api.v1.mapper;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import com.comittedpeople.englishlearningweb.api.v1.model.ChatRoomMessageDTO;
import com.comittedpeople.englishlearningweb.domain.ChatRoomMessage;
import com.comittedpeople.englishlearningweb.domain.UserAccount;
import com.comittedpeople.englishlearningweb.repositories.UserAccountRepository;

@Mapper(componentModel = "spring", uses = { UserAccountRepository.class })
public interface ChatRoomMessageMapper {
	
	ChatRoomMessageMapper INSTANCE = Mappers.getMapper(ChatRoomMessageMapper.class);
	
	@Mapping(source = "id", target = "id")
	@Mapping(source = "chatContent", target = "content")
	@Mapping(source = "messageSentDate", target = "timeStamp")
	@Mapping(source = "userSentAccount", target = "userSentID", qualifiedByName = "userToUserID")
	@Mapping(source = "userSentAccount", target = "userSentName", qualifiedByName = "userToUsername")
	ChatRoomMessageDTO getDto (ChatRoomMessage chatRoomMessage);
	
	@Named("userToUserID")
	public static Long getUserID(UserAccount userAccount) {
		if (userAccount == null)
			return -1L;
		return userAccount.getId();
	}
	
	@Named("userToUsername")
	public static String getDisplayName(UserAccount userAccount) {
		if (userAccount == null)
			return "";
		return userAccount.getDisplayname();
	}
	
	@Mapping(source = "id", target = "id")
	@Mapping(source = "content", target = "chatContent")
	@Mapping(source = "timeStamp", target = "messageSentDate", qualifiedByName = "localDateTimeNow")
	@Mapping(source = "userSentID", target = "userSentAccount")
	ChatRoomMessage getEntityWithNowSentTime (ChatRoomMessageDTO chatRoomMessageDTO);
	
	@Mapping(source = "content", target = "chatContent")
	ChatRoomMessage getEntityContentOnly(ChatRoomMessageDTO chatRoomMessageDTO);
	
	@Named("localDateTimeNow")
	public static LocalDateTime localDateTimeNow(String timeStamp) {
		return LocalDateTime.now();
	}
}
