package com.pitang.sms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pitang.sms.model.Message;
import com.pitang.sms.model.UserModel;

public interface MessageRepository extends JpaRepository <Message, Long> {
	List<Message> findBySender (UserModel sender);
	List<Message> findByRecipient (UserModel recipient);
	List<Message> findBySenderRecipient(UserModel sender, UserModel recipient);

}
