package com.pitang.sms.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.access.EjbAccessException;

import com.pitang.sms.exceptions.ExceptionBadRequest;
import com.pitang.sms.model.Message;
import com.pitang.sms.model.UserModel;
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
	
	private void validateMessage(Message message) {
		if (message == null) {
			throw new ExceptionBadRequest("Mensagem não informada.");
		}
		if (message.getSender()==null || message.getRecipient()==null) {
			throw new ExceptionBadRequest("Destinatário ou remetente não informado.");
		}
		if (message.getSender().getUserId() == message.getRecipient().getUserId()) {
			throw new ExceptionBadRequest ("Destinatário não pode ser próprio remetente.");
		}
		if (message.getText() ==null) {
			throw new ExceptionBadRequest ("Não há mensagem a ser enviada.");
		}
	}

	public  Message sendMessage (Message message) {
		validateMessage(message);
	
		return messageRepository.save(message);
	}
	public List<Message> listMessages (UserModel user1, UserModel user2){
		if(messageRepository.findAll().size()== 0) {
			return null;
		}
		
		List<Message>listMessages = messageRepository.findBySenderRecipient(user1, user2);
		listMessages.addAll(messageRepository.findBySenderRecipient(user2, user1));
		
		List <Message>sortedMessages= listMessages.stream()
				.sorted((o1, o2) -> o1.getMessageDate().compareTo(o2.getMessageDate()))
				.collect(Collectors.toList());
		
		return sortedMessages;
	}
	
}
