package com.pitang.sms.dto;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageDto {
	
	private Long messageId;
	private UserDto sender;
	private UserDto recipient;
	private String text;
	private Date messageDate;
	
	
	public MessageDto(Long messageId, UserDto sender, UserDto recipient, String text, Date messageDate) {
		super();
		this.messageId = messageId;
		this.sender = sender;
		this.recipient = recipient;
		this.text = text;
		this.messageDate = messageDate;
	}


	public Long getMessageId() {
		return messageId;
	}


	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}


	public UserDto getSender() {
		return sender;
	}


	public void setSender(UserDto sender) {
		this.sender = sender;
	}


	public UserDto getRecipient() {
		return recipient;
	}


	public void setRecipient(UserDto recipient) {
		this.recipient = recipient;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


	public Date getMessageDate() {
		return messageDate;
	}


	public void setMessageDate(Date messageDate) {
		this.messageDate = messageDate;
	}
	
	

}
