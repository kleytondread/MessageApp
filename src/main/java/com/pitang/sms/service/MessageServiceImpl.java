package com.pitang.sms.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.pitang.sms.repository.ContactRepository;
import com.pitang.sms.repository.MessageRepository;
import com.pitang.sms.repository.UserProfileRepository;
import com.pitang.sms.repository.UserRepository;

public class MessageServiceImpl implements MessageServiceInterface{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserProfileRepository userProfileRepository;
	
	@Autowired
	private ContactRepository contactRepository;
	
	@Autowired
	private MessageRepository messageRepository;

}
