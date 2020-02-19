package com.pitang.sms.service;

import java.util.ArrayList;
import java.util.List;

import com.pitang.sms.model.Contact;
import com.pitang.sms.model.UserModel;


public interface UserServiceInterface {
	
	public List<UserModel> listUsers();

	public UserModel findUserByUsername(String userName);
	
	public UserModel findUserByEmail(String email);
	
	public UserModel addUser(UserModel user);

	public UserModel updateUser(UserModel user);

	public void deleteUser(Long id);

	public void addUserProfile(UserModel user);

	public void updateUserProfile(UserModel user);

	public void addSingleContact(Contact contact, UserModel user);

	public void addContactsList(ArrayList<Contact> contacts, UserModel user);

	void updateContact(Contact contact);
}

