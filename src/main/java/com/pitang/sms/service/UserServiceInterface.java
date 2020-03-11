package com.pitang.sms.service;

import java.util.List;

import com.pitang.sms.model.Contact;
import com.pitang.sms.model.UserModel;


public interface UserServiceInterface {
	
	public List<UserModel> listUsers();
	
	public UserModel findUserById (Long id);

	public UserModel findUserByUsername(String userName);
	
	public UserModel findUserByEmail(String email);
	
	public UserModel addUser(UserModel user);

	public UserModel updateUser(UserModel user);

	public void deleteUser(Long id);

	public void addUserProfile(UserModel user);

	public void updateUserProfile(UserModel user);

	public void addContact(Contact contact, Long id);

	public void updateContact(Contact contact);

	public void addProfilePicture(UserModel userModel);

	void deleteContact(Long id);
}

