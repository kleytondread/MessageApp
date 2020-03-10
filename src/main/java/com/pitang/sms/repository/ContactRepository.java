package com.pitang.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pitang.sms.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {
	Contact findByUserName (String userName);
	//Contact findByUserNameUserUserId (String userName, Long id);

}
