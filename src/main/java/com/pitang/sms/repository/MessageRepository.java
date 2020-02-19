package com.pitang.sms.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pitang.sms.model.Message;
import com.pitang.sms.model.UserModel;

public interface MessageRepository extends JpaRepository <Message, Long> {
	ArrayList<Message> findBySenderRecipient (UserModel sender, UserModel recipient);

}
